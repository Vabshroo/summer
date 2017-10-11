package github.vabshroo.beans.factory;

import github.vabshroo.beans.exception.BeanException;

/**
 * Create by IntelliJ IDEA
 * Root interface of summer container.
 *
 * @Author chenlei
 * @DateTime 2017/10/11 15:14
 * @Description BeanFactory
 */
public interface BeanFactory {

    /**
     * Return the bean named 'beanName'
     * @param beanName
     * @return
     * @throws github.vabshroo.beans.exception.NoSuchBeanException if there is no bean named 'beanName'
     */
    Object getBean(String beanName) throws Exception;

    /**
     * Return the bean with type 'beanClass'
     * @param beanClass
     * @param <T>
     * @return
     * @throws github.vabshroo.beans.exception.NoSuchBeanException if there is no be with type 'beanClass'
     * @throws github.vabshroo.beans.exception.MultiBeansFoundException if more than one bean found
     */
    <T> T getBean(Class<T> beanClass) throws Exception;

    /**
     * Return the bean named 'beanName' and type is 'beanClass'
     * @param beanName
     * @param beanClass
     * @param <T>
     * @return
     * @throws github.vabshroo.beans.exception.NoSuchBeanException if there is no be with type 'beanClass'
     * @throws github.vabshroo.beans.exception.MultiBeansFoundException if more than one bean found
     */
    <T> T getBean(String beanName,Class<T> beanClass) throws Exception;

    /**
     * Return true if bean factory contains bean named 'beanName'
     * @param beanName
     * @return
     */
    boolean containsBean(String beanName);

}
