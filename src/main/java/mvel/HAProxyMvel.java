package mvel;

import java.util.Map;

import com.google.common.collect.Maps;

import org.mvel2.templates.TemplateRuntime;

/**
 * 
 * @author harish.sharma
 *
 */
public class HAProxyMvel {

    private final Map<String, Object> ctx;

    public HAProxyMvel(final Map<String, Object> ctx) {
        this.ctx = ctx;
    }

    public String eval(String evalString) {

        return (String) TemplateRuntime.eval(evalString, ctx);
    }

    public static void main(String[] args) {
        String evalString = "My name is : ${name}";
        Map<String, Object> map = Maps.newHashMap();
        map.put("name", "harish");
        map.put("active", false);
        map.put("status", false);
        map.put("some", new Some("hello"));
        System.out.println(new HAProxyMvel(map).eval(evalString));
        String str = "@if{active} Your account is currently active! @elseif{status} Your account has been suspended, please contact customer support @else{} Your account is not active @end{}";
        System.out.println(new HAProxyMvel(map).eval(str));
        String str1 = "@{some.name}";
        System.out.println(new HAProxyMvel(map).eval(str1));
    }

    static enum Account1 {
        SUSPENDED, NOT;
    }
}
