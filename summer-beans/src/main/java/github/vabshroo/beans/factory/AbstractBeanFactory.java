package github.vabshroo.beans.factory;

import github.vabshroo.beans.entity.Bean;
import github.vabshroo.beans.exception.BeanException;
import github.vabshroo.beans.exception.MultiBeansFoundException;
import github.vabshroo.beans.exception.NoSuchBeanException;
import github.vabshroo.core.util.CollectionUtil;

import java.util.*;

/**
 * Create by IntelliJ IDEA
 * Abstract implementation of BeanFactory
 *
 * @Author chenlei
 * @DateTime 2017/10/11 15:36
 * @Description AbstractBeanFactory
 */
public abstract class AbstractBeanFactory extends AbstractBeanProcessor implements BeanFactory {

    /** All beans map,keyed by bean name */
    private final Map<String,Bean> beanNamesMap = new HashMap<>();

    /** All beans map,keyed by bean type */
    private final Map<Class<?>,Set<String>> beanTypesMap = new HashMap<>();

    public Object getBean(String beanName) throws Exception {
        if(!beanTypesMap.containsKey(beanName)){
            throw new NoSuchBeanException(beanName);
        }
        return createBean(beanNamesMap.get(beanName));
    }

    public <T> T getBean(Class<T> beanClass) throws Exception {
        if(!beanTypesMap.containsKey(beanClass)){
            throw new NoSuchBeanException(beanClass);
        }else if(beanTypesMap.get(beanClass).size() > 1){
            throw new MultiBeansFoundException(beanClass);
        }
        return createBean(beanNamesMap.get(new ArrayList<>(beanTypesMap.get(beanClass)).get(0)));
    }

    public <T> T getBean(String beanName, Class<T> beanClass) throws Exception {
        if(!beanNamesMap.containsKey(beanName)){
            throw new NoSuchBeanException(beanName);
        }else if(!beanTypesMap.containsKey(beanClass)){
            throw new NoSuchBeanException(beanClass);
        }else if(!beanTypesMap.get(beanClass).contains(beanName) || !CollectionUtil.containsAnyKey(beanNamesMap,beanTypesMap.get(beanName))){
            throw new NoSuchBeanException(beanName,beanClass);
        }
        return createBean(beanNamesMap.get(beanName));
    }

    public boolean containsBean(String beanName) {
        return beanTypesMap.containsKey(beanName);
    }
}
