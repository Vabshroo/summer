package github.vabshroo.core.io.support;

import github.vabshroo.core.io.AbstractXmlResourceReader;
import github.vabshroo.core.io.Resource;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Create by IntelliJ IDEA
 *
 * @Author chenlei
 * @DateTime 2017/10/12 11:27
 * @Description XmlResourceReader
 */
public class XmlResourceReader extends AbstractXmlResourceReader {

    private final static Logger LOGGER = LoggerFactory.getLogger(XmlResourceReader.class);

    public XmlResourceReader(XmlResource resource) {
        super(resource);
    }

    public Elements getElementsByTag(String tagName) {
        return ((XmlResource)resource).getDocument().getElementsByTag(tagName);
    }

    @Override
    public void initDoc() throws IOException {
        ((XmlResource)resource).setDocument(Jsoup.parse(readAsString()));
    }
}
