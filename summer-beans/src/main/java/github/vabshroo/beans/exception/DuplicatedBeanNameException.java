package github.vabshroo.beans.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * Create by IntelliJ IDEA
 * Exception throw when register a beanName already exist.
 *
 * @Author chenlei
 * @DateTime 2017/10/12 10:12
 * @Description DuplicatedBeanNameException
 */
public class DuplicatedBeanNameException extends BeanException {

    private String beanName;

    public DuplicatedBeanNameException(String beanName) {
        this(beanName,"Duplicated bean name!");
    }

    public DuplicatedBeanNameException(String beanName,String message){
        super(message);
        this.beanName = beanName;
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

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
