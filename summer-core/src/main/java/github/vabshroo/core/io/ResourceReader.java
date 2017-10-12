package github.vabshroo.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Create by IntelliJ IDEA
 *
 * @Author chenlei
 * @DateTime 2017/10/12 11:04
 * @Description ResourceReader
 */
public interface ResourceReader {

    InputStream getInputStream() throws FileNotFoundException;

    void close() throws IOException;

    String readAsString() throws IOException;

}
