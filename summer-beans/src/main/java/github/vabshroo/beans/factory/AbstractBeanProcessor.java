package github.vabshroo.beans.factory;

import com.alibaba.fastjson.JSONObject;
import github.vabshroo.beans.entity.Bean;
import github.vabshroo.beans.entity.PropertyValue;
import github.vabshroo.beans.exception.BeanException;
import github.vabshroo.beans.exception.NoSuchBeanException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Create by IntelliJ IDEA
 * Abstract implementation of BeanProcessor.
 *
 * @Author chenlei
 * @DateTime 2017/10/11 16:11
 * @Description AbstractBeanProcessor
 */
public abstract class AbstractBeanProcessor implements BeanProcessor {

    /** All instance */
    private final Map<String,Object> instanceMap = new HashMap<>();

    private final Logger LOGGER = LoggerFactory.getLogger(AbstractBeanProcessor.class);

    public void beforeProcess(Bean bean) {
        LOGGER.info("Get bean : {}", JSONObject.toJSONString(bean));
    }

    /**
     * Always singleton here.
     * Prototype or others scope ignored.
     *
     * @param bean
     * @param <T>
     * @return
     * @throws BeanException
     */
    public <T> T createBean(Bean bean) throws Exception {
        if(!instanceMap.containsKey(bean.getId())){
            initBean(bean);
        }
        return (T) instanceMap.get(bean.getId());
    }

    protected void initBean(Bean bean) throws Exception {
        Object o = bean.getClazz().newInstance();

        if(bean.getPropertyValues() != null && !bean.getPropertyValues().isEmpty()){
            HashSet<PropertyValue> propertyValues = bean.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues) {
                Field field = o.getClass().getDeclaredField(propertyValue.getName());
                field.setAccessible(true);
                Object value = propertyValue.getValue();
                if(value instanceof Bean){
                    value = createBean(bean);
                }
                field.set(o,value);
            }
        }

        instanceMap.put(bean.getId(),o);
    }

    public void afterProcess(Bean bean) {
        LOGGER.info("Get bean finished.");
    }
}
