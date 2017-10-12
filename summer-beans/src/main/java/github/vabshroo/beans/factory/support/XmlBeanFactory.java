package github.vabshroo.beans.factory.support;

import github.vabshroo.beans.entity.Bean;
import github.vabshroo.beans.entity.PropertyValue;
import github.vabshroo.beans.exception.DuplicatedBeanNameException;
import github.vabshroo.beans.factory.AbstractBeanFactory;
import github.vabshroo.core.io.support.XmlResource;
import github.vabshroo.core.io.support.XmlResourceReader;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.*;

/**
 * Create by IntelliJ IDEA
 * Init BeanFactory by reading xml configuration.
 *
 * @Author chenlei
 * @DateTime 2017/10/12 10:25
 * @Description XmlBeanFactory
 */
public class XmlBeanFactory extends AbstractBeanFactory {

    private final static Logger LOGGER = LoggerFactory.getLogger(XmlBeanFactory.class);

    private String[] resources;

    public XmlBeanFactory(String[] resources){
        this.resources = resources;
        this.refresh();
    }

    @Override
    protected boolean refresh() {

        if(resources != null && resources.length > 0){

            Map<String,Element> beanNodes = new HashMap<>();

            for (String resource : resources) {
                File file = new File(this.getClass().getClassLoader().getResource(resource).getFile());
                XmlResourceReader resourceReader = new XmlResourceReader(new XmlResource(file));
                try {
                    resourceReader.initDoc();
                } catch (Exception e){
                    LOGGER.error("Xml error!",e);
                }

                Elements beans = resourceReader.getElementsByTag("bean");

                if(beans != null && !beans.isEmpty()){
                    beans.forEach(element -> beanNodes.put(element.attr("id"),element));
                }

            }

            beanNodes.forEach((key,value) -> {
                Bean bean = initBeanDefine(beanNodes,value);

                try {
                    registerBean(bean);
                } catch (Exception e) {
                    LOGGER.error("register bean error!",e);
                }
            });
        }
        return true;
    }

    private Bean initBeanDefine(Map<String, Element> beanNodes, Element eleBean) {
        Bean bean = new Bean();
        bean.setId(eleBean.attr("id"));
        bean.setClassName(eleBean.attr("class"));
        try {
            bean.setClazz(Class.forName(bean.getClassName()));
        } catch (ClassNotFoundException e) {
            LOGGER.error("register bean error!",e);
        }

        Elements properties = eleBean.getElementsByTag("property");
        if(properties != null && !properties.isEmpty()){
            bean.setPropertyValues(new HashSet<>());
            properties.forEach(element -> {
                PropertyValue propertyValue = new PropertyValue().setName(element.attr("name"));
                if(element.hasAttr("value")){
                    propertyValue.setValue(element.attr("value"));
                }else if(element.hasAttr("ref")){
                    propertyValue.setValue(initBeanDefine(beanNodes, beanNodes.get(element.attr("ref"))));
                }
                bean.getPropertyValues().add(propertyValue);
            });
        }
        return bean;
    }

    @Override
    public boolean registerBean(Bean bean) throws Exception {
        if(beanNamesMap.containsKey(bean.getId())){
            throw new DuplicatedBeanNameException(bean.getId());
        }

        beanNamesMap.put(bean.getId(),bean);
        if(!beanTypesMap.containsKey(bean.getClazz())){
            beanTypesMap.put(bean.getClazz(),new HashSet<>());
        }
        beanTypesMap.get(bean.getClazz()).add(bean.getId());

        return true;
    }

    @Override
    public boolean removeBean(Bean bean) throws Exception {

        String beanName = bean.getId();
        Class clazz = bean.getClazz();

        if(StringUtils.isBlank(beanName) && clazz == null){
            LOGGER.warn("Null bean to remove!");
        }

        if(!beanNamesMap.containsKey(beanName)){
            LOGGER.warn("No bean named {} defined,nothing removed!",beanName);
        }

        removeBean(beanName,clazz);

        return true;
    }

    private void removeBean(String beanName, Class clazz) {
        if(StringUtils.isNotBlank(beanName)){
            if(clazz == null){
                clazz = beanNamesMap.get(beanName).getClazz();
            }

            beanNamesMap.remove(beanName);
            beanTypesMap.get(clazz).remove(beanName);
            if(beanTypesMap.get(clazz).size() == 0){
                beanTypesMap.remove(clazz);
            }
        }else{
            Set<String> beanNames = beanTypesMap.get(clazz);
            beanNames.forEach(beanNamesMap::remove);
            beanTypesMap.remove(clazz);
        }
    }
}
