package concurrency;

import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
    Map<String, Bucket> map = new HashMap<>();

    boolean shouldThrottle(String key) {
        Bucket bucket = map.get(key);

        return false;
    }


    class Bucket {
        String key;
        String maxAmount;
        int refillTime;
        int refillAmount;
        int value;
        long lastUpdate;
    }
}
