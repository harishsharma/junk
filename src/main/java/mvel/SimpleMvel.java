package mvel;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

import com.google.common.io.Resources;

import org.mvel2.templates.TemplateRuntime;
import org.weakref.jmx.com.google.common.collect.Maps;

/**
 * 
 * @author harish.sharma
 *
 */
public class SimpleMvel {

    private final Map<String, String> contextMap;

    public SimpleMvel(final Map<String, String> contextMap) {
        this.contextMap = contextMap;
    }

    public String eval(final String toEval) {
        return (String) TemplateRuntime.eval(toEval, contextMap);
    }

    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("mvel/mytemplate.properties");
        Properties prop = new Properties();
        prop.load(url.openStream());
        Map<String, String> ctxMap = Maps.newHashMap();
        ctxMap.put("name", "harish");
        ctxMap.put("lastname", "sharma");
        System.out.println(new SimpleMvel(ctxMap).eval(prop.getProperty("key")));
    }
}
