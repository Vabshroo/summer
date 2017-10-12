package github.vabshroo.service.impl;

import github.vabshroo.service.ReferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Create by IntelliJ IDEA
 *
 * @Author chenlei
 * @DateTime 2017/10/12 15:48
 * @Description ReferenceServiceImpl
 */
public class ReferenceServiceImpl implements ReferenceService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ReferenceServiceImpl.class);

    private String message;

    public String getMessage() {
        return message;
    }

    public ReferenceServiceImpl setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public void reference() {
        LOGGER.info("Reference summer!Your message : {}",message);
    }
}
