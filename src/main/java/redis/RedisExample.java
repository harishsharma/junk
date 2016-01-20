package redis;

import java.util.Random;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * @author harish.sharma
 *
 */
public class RedisExample {

    private final JedisPool pool;


    public RedisExample() {
        JedisPoolConfig cfg = new JedisPoolConfig();
        cfg.setMaxTotal(9);
        cfg.setMaxWaitMillis(-1l);
        cfg.setTimeBetweenEvictionRunsMillis(60000);
        // cfg.setMaxIdle(5);
        // cfg.setMinIdle(1);
        this.pool = new JedisPool(cfg, "localhost", 6379);
    }

    public void writeRandomShit(Random rand) {
        Jedis jedis = pool.getResource();
        jedis.hset("a" + rand.nextInt(), "ra", "rand");
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        jedis.close();
    }

    public static void main(String[] args) {
        RedisExample ex = new RedisExample();
        Random r = new Random();
        Runnable run = () -> {
            ex.writeRandomShit(r);
        };
        for (int i = 0; i < 100; i++) {
            new Thread(run).start();
        }

    }
}
