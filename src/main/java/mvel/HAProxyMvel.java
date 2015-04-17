package mvel;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;

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

    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResource("mvel/haproxy.cfg.template").openStream();
        Map<String, Object> map = Maps.newHashMap();
        List<Server> servers = Lists.newArrayList();
        servers.add(new Server("server1", "localhost", 4000));
        servers.add(new Server("server2", "fabric-02.planet.ev1.inmobi.com", 4000));
        map.put("servers", servers);
        String result = (String) TemplateRuntime.eval(in, map);
        System.out.println(result);
    }
}
