package github.vabshroo.context;

import github.vabshroo.beans.factory.BeanFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Create by IntelliJ IDEA
 *
 * @Author chenlei
 * @DateTime 2017/10/12 9:47
 * @Description AbstractApplicationContext
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    private final static Logger LOGGER = LoggerFactory.getLogger(AbstractApplicationContext.class);

    /** Application startup time */
    private Date startupTime;

    protected AbstractApplicationContext(Date startupTime) {
        this.startupTime = startupTime;
    }

    public Date getStartupTime() {
        return startupTime;
    }

    public abstract BeanFactory getBeanFactory();

    /**
     * Init application context.
     * @return
     */
    protected abstract boolean refresh();
}
