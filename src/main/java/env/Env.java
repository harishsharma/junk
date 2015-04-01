package env;

import java.util.Map;
import java.util.Map.Entry;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author harish.sharma
 *
 */
@Slf4j
public class Env {
    public static void main(String[] args) {
        Map<String, String> envs = System.getenv();
        for (Entry<String, String> entry : envs.entrySet()) {
            log.info("{} : {}", entry.getKey(), entry.getValue());
        }
    }
}
