package github.vabshroo.beans.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * Create by IntelliJ IDEA
 * Exception throw when get a bean by type but multi beans of this type found.
 *
 * @Author chenlei
 * @DateTime 2017/10/11 15:12
 * @Description MultiBeansFoundException
 */
public class MultiBeansFoundException extends BeanException {

    private Class beanClass;

    public MultiBeansFoundException(Class beanClass) {
        super("one bean required but multi found");
        this.beanClass = beanClass;
    }

    @Override
    public String getMessage() {

        StringBuilder stringBuilder = new StringBuilder("[");

        String message = super.getMessage();
        if(StringUtils.isNotBlank(message)){
            stringBuilder.append(message).append(",");
        }

        if(beanClass != null){
            stringBuilder.append("bean class : ").append(beanClass.getName());
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
