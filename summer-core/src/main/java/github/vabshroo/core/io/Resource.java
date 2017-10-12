package github.vabshroo.core.io;

import java.io.File;

/**
 * Create by IntelliJ IDEA
 * Interface for file or classpath resource.
 *
 * @Author chenlei
 * @DateTime 2017/10/12 10:56
 * @Description Resource
 */
public interface Resource {

    boolean exists();

    File getFile();

}
