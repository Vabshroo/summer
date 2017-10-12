package github.vabshroo.core.io;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Create by IntelliJ IDEA
 *
 * @Author chenlei
 * @DateTime 2017/10/12 11:29
 * @Description AbstractXmlResourceReader
 */
public abstract class AbstractXmlResourceReader extends AbstractResourceReader {

    protected AbstractXmlResourceReader(Resource resource) {
        super(resource);
    }

    public abstract Elements getElementsByTag(String tagName);

    public abstract void initDoc() throws IOException;

}
