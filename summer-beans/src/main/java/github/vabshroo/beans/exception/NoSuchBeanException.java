package github.vabshroo.beans.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * Create by IntelliJ IDEA
 * Exceptions throw when ask for a instance which cannot found in bean factory.
 *
 * @Author chenlei
 * @DateTime 2017/10/11 14:53
 * @Description NoSuchBeanException
 */
public class NoSuchBeanException extends BeanException {

    private String beanName;
    private Class beanClass;

    public NoSuchBeanException(String message){
        super(message);
    }

    public NoSuchBeanException(Class beanClass) {
        super("No such bean defined!");
        this.beanClass = beanClass;
    }

    public NoSuchBeanException(String beanName,Class beanClass) {
        super("No such bean defined!");
        this.beanName = beanName;
        this.beanClass = beanClass;
    }

    @Override
    public String getMessage() {

        StringBuilder stringBuilder = new StringBuilder("[");

        String message = super.getMessage();
        if(StringUtils.isNotBlank(message)){
            stringBuilder.append(message).append(",");
        }

        if(StringUtils.isNotBlank(beanName)){
            stringBuilder.append("bean name : ").append(beanName).append(",");
        }

        if(beanClass != null){
            stringBuilder.append("bean class : ").append(beanClass.getName());
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
