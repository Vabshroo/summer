package github.vabshroo.context;

import github.vabshroo.beans.factory.BeanFactory;

import java.util.Date;

/**
 * Create by IntelliJ IDEA
 *
 * @Author chenlei
 * @DateTime 2017/10/12 9:37
 * @Description ApplicationContext
 */
public interface ApplicationContext extends BeanFactory {

    /**
     * Startup time
     * @return
     */
    Date getStartupTime();

    /**
     * BeanFactory of this context
     * @return
     */
    BeanFactory getBeanFactory();

}
