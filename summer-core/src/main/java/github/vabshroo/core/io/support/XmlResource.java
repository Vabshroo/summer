package github.vabshroo.core.io.support;

import github.vabshroo.core.io.AbstractResource;
import org.jsoup.nodes.Document;

import java.io.File;

/**
 * Create by IntelliJ IDEA
 *
 * @Author chenlei
 * @DateTime 2017/10/12 11:28
 * @Description XmlResource
 */
public class XmlResource extends AbstractResource {

    Document document;

    public XmlResource(File file) {
        super(file);
    }

    public XmlResource setDocument(Document document) {
        this.document = document;
        return this;
    }

    public Document getDocument() {
        return document;
    }
}
