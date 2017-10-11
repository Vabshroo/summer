package github.vabshroo.beans.factory;

import github.vabshroo.beans.entity.Bean;
import github.vabshroo.beans.exception.BeanException;

/**
 * Create by IntelliJ IDEA
 * Interface for bean processor
 *
 * @Author chenlei
 * @DateTime 2017/10/11 16:08
 * @Description BeanProcessor
 */
public interface BeanProcessor {

    /**
     * Method invoked before bean creation.
     * @param bean
     */
    void beforeProcess(Bean bean);

    /**
     * Return bean instance
     * @param bean
     * @param <T>
     * @return
     * @throws BeanException
     */
    <T> T createBean(Bean bean) throws Exception;

    /**
     * Method invoked after bean creation.
     * @param bean
     */
    void afterProcess(Bean bean);

}
