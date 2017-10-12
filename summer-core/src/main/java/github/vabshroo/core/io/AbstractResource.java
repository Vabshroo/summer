package github.vabshroo.core.io;

import java.io.*;

/**
 * Create by IntelliJ IDEA
 * An abstract implementation of Resource
 *
 * @Author chenlei
 * @DateTime 2017/10/12 10:58
 * @Description AbstractResource
 */
public abstract class AbstractResource implements Resource {

    private File file;

    protected AbstractResource(File file){
        this.file = file;
    }

    @Override
    public boolean exists() {
        return getFile().exists();
    }

    @Override
    public File getFile() {
        return file;
    }
}
