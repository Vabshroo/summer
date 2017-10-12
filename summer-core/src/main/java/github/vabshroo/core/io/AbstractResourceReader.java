package github.vabshroo.core.io;

import github.vabshroo.core.io.Resource;
import github.vabshroo.core.io.ResourceReader;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by IntelliJ IDEA
 *
 * @Author chenlei
 * @DateTime 2017/10/12 11:07
 * @Description AbstractResourceReader
 */
public abstract class AbstractResourceReader implements ResourceReader {

    protected Resource resource;

    protected InputStream inputStream;

    protected AbstractResourceReader(Resource resource){
        this.resource = resource;
    }

    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        if(inputStream != null){
            return  inputStream;
        }
        if(resource.exists()){
            return (inputStream = new FileInputStream(resource.getFile()));
        }
        return null;
    }

    @Override
    public void close() throws IOException {
        if(inputStream != null){
            inputStream.close();
        }
    }

    @Override
    public String readAsString() throws IOException {
        if(getInputStream() != null){
            List<String> readLines = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(resource.getFile()));
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                readLines.add(line);
            }

            return StringUtils.join(readLines,"\n");
        }
        return null;
    }
}
