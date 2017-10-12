package github.vabshroo;

import github.vabshroo.context.ApplicationContext;
import github.vabshroo.context.support.ClassPathXmlApplicationContext;
import github.vabshroo.service.HelloService;
import github.vabshroo.service.impl.HelloServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public class App {

    private final static Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        //base();
        //singleton();
        //repeatRegister();
        reference();
    }

    /**
     * Reference test
     * @throws Exception
     */
    private static void reference() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        HelloServiceImpl helloService = (HelloServiceImpl) context.getBean("helloService");
        helloService.hello();
        helloService.getReferenceService().reference();


    }

    /**
     * Base test
     * @throws Exception
     */
    private static void base() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        HelloService helloService = (HelloService) context.getBean("helloService");
        helloService.hello();
    }

    /**
     * Singleton test
     * Get bean by Class
     * @throws Exception
     */
    private static void singleton() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        HelloService helloService = (HelloService) context.getBean("helloService");
        HelloService helloService2 = context.getBean(HelloServiceImpl.class);
        helloService.hello();
        LOGGER.info("singleton : {}",helloService == helloService2);
    }

    /**
     * Repeat register test
     * @throws Exception
     */
    private static void repeatRegister() throws Exception {
        // Will throw DuplicatedBeanNameException
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml", "ApplicationContext2.xml");
        HelloService helloService = (HelloService) context.getBean("helloService");
        helloService.hello();
    }
}
