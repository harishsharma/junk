package mvel;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.google.common.collect.Lists;
import com.google.common.io.Resources;

import org.mvel2.templates.TemplateRuntime;
import org.weakref.jmx.com.google.common.collect.Maps;

/**
 * 
 * @author harish.sharma
 *
 */
public class SimpleMvel {

    private final Map<String, Object> contextMap;

    public SimpleMvel(final Map<String, Object> contextMap) {
        this.contextMap = contextMap;
    }

    public String eval(final String toEval) {
        return (String) TemplateRuntime.eval(toEval, contextMap);
    }

    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("mvel/mytemplate.properties");
        Properties prop = new Properties();
        prop.load(url.openStream());
        Map<String, Object> ctxMap = Maps.newHashMap();
        ctxMap.put("name", "harish");
        ctxMap.put("lastname", "sharma");
        System.out.println(new SimpleMvel(ctxMap).eval(prop.getProperty("key")));

        String evalString = "My name is : ${name}";
        Map<String, Object> map = Maps.newHashMap();
        map.put("name", "harish");
        map.put("active", false);
        map.put("status", false);
        map.put("some", new Some("hello"));
        System.out.println(new SimpleMvel(map).eval(evalString));
        String str = "@if{active} Your account is currently active! @elseif{status} Your account has been suspended, please contact customer support @else{} Your account is not active @end{}";
        System.out.println(new SimpleMvel(map).eval(str));
        String str1 = "@{some.name}";
        System.out.println(new SimpleMvel(map).eval(str1));
        String str2 = "@foreach{user : users} \n - @{item.name} (Wage: @{item.salary}) @end{}";

        List<String> users = Lists.newArrayList();
        users.add("harish");
        users.add("apoorve");
        map.put("users", users);
        map.put("item", new Item("harish", 00));
        System.out.println(new SimpleMvel(map).eval(str2));

    }
}
