package github.vabshroo.beans.entity;

import java.util.HashSet;

/**
 * Create by IntelliJ IDEA
 *
 * @Author chenlei
 * @DateTime 2017/10/11 11:56
 * @Description Bean
 */
public class Bean {

    private String id;
    private String className;
    private Class clazz;
    private HashSet<PropertyValue> propertyValues;

    public String getId() {
        return id;
    }

    public Bean setId(String id) {
        this.id = id;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public Bean setClassName(String className) {
        this.className = className;
        return this;
    }

    public Class getClazz() {
        return clazz;
    }

    public Bean setClazz(Class clazz) {
        this.clazz = clazz;
        return this;
    }

    public HashSet<PropertyValue> getPropertyValues() {
        return propertyValues;
    }

    public Bean setPropertyValues(HashSet<PropertyValue> propertyValues) {
        this.propertyValues = propertyValues;
        return this;
    }
}
