package github.vabshroo.beans.exception;

/**
 * Create by IntelliJ IDEA
 * Abstract super class of all bean exceptions.
 *
 * @Author chenlei
 * @DateTime 2017/10/11 15:20
 * @Description BeanException
 */
public abstract class BeanException extends Exception {

    public BeanException(String message){
        super(message);
    }
}
