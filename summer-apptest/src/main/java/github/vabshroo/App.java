package github.vabshroo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public class App {

    private final static Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        System.out.println("Hello World!");
        LOGGER.info("info");
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.debug("debug");
    }
}
