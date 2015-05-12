package handlebar;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import org.apache.commons.io.FileUtils;

/**
 * 
 * @author harish.sharma
 *
 */
public class HandleB {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/mustache/someconf.template");
        String fileContent = FileUtils.readFileToString(file, Charset.defaultCharset());
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache ms = mf.compile(new StringReader(fileContent), "sometemplate");
        Writer writer = new StringWriter();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("this.val", "world");
        ms.execute(writer, map).flush();
        System.out.println(writer.toString());
    }
}
