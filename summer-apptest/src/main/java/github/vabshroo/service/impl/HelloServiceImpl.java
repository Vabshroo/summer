package github.vabshroo.service.impl;

import github.vabshroo.service.HelloService;
import github.vabshroo.service.ReferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Create by IntelliJ IDEA
 *
 * @Author chenlei
 * @DateTime 2017/10/12 14:07
 * @Description HelloServiceImpl
 */
public class HelloServiceImpl implements HelloService {

    private final static Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

    private String message;

    private ReferenceService referenceService;

    public String getMessage() {
        return message;
    }

    public HelloServiceImpl setMessage(String message) {
        this.message = message;
        return this;
    }

    public ReferenceService getReferenceService() {
        return referenceService;
    }

    public HelloServiceImpl setReferenceService(ReferenceService referenceService) {
        this.referenceService = referenceService;
        return this;
    }

    @Override
    public void hello() {
        LOGGER.info("Hello summer!Your message : {}",message);
    }
}
