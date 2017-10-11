package github.vabshroo.beans.entity;

/**
 * Create by IntelliJ IDEA
 *
 * @Author chenlei
 * @DateTime 2017/10/11 11:58
 * @Description PropertyValue
 */
public class PropertyValue {

    private String name;
    private Object value;

    public String getName() {
        return name;
    }

    public PropertyValue setName(String name) {
        this.name = name;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public PropertyValue setValue(Object value) {
        this.value = value;
        return this;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return ((PropertyValue)obj).getName().equals(name);
    }
}
