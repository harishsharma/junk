package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;


/**
 * 
 * @author harish.sharma
 *
 */
@Slf4j
public class Reflection {

    public static void main(String[] args) throws ClassNotFoundException {
        @SuppressWarnings("unchecked")
        Class<RefTest> clazz = (Class<RefTest>) Class.forName("reflection.RefTest");
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            log.debug("{}", m);
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            log.debug("{}", f);
        }
        log.debug("{}", clazz);
    }
}
