package github.vabshroo.context.support;

import github.vabshroo.beans.factory.BeanFactory;
import github.vabshroo.beans.factory.support.XmlBeanFactory;
import github.vabshroo.context.AbstractApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Create by IntelliJ IDEA
 *
 * @Author chenlei
 * @DateTime 2017/10/12 9:51
 * @Description ClassPathXmlApplicationContext
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private final static Logger LOGGER = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);

    /** Application xml location */
    private String[] resources;

    /** BeanFactory of this application. */
    private BeanFactory beanFactory;


    public ClassPathXmlApplicationContext(String... resources) {
        super(new Date());
        this.resources = resources;
        refresh();
    }

    private static BeanFactory initBeanFactory(String[] resources) {
        return null;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    protected boolean refresh() {
        beanFactory = new XmlBeanFactory(resources);
        return false;
    }

    @Override
    public Object getBean(String beanName) throws Exception {
        return beanFactory.getBean(beanName);
    }

    @Override
    public <T> T getBean(Class<T> beanClass) throws Exception {
        return beanFactory.getBean(beanClass);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) throws Exception {
        return beanFactory.getBean(beanName,beanClass);
    }

    @Override
    public boolean containsBean(String beanName) {
        return beanFactory.containsBean(beanName);
    }
}
