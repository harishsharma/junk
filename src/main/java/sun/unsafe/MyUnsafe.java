package sun.unsafe;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * 
 * @author harish.sharma
 *
 */
@SuppressWarnings("restriction")
public class MyUnsafe {

    /*
     * Throws Security Exception.
     */

    public static sun.misc.Unsafe getUnsafe() {
        @SuppressWarnings("deprecation")
        Class<?> cc = sun.reflect.Reflection.getCallerClass(2);
        if (cc.getClassLoader() != null) throw new SecurityException("Unsafe");
        return sun.misc.Unsafe.getUnsafe();
    }

    public static sun.misc.Unsafe getUnsafeRef() throws NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException {
        Field f = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        sun.misc.Unsafe unsafe = (Unsafe) f.get(null);
        return unsafe;
    }

    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException,
            IllegalAccessException {
        // MyUnsafe.getUnsafe();

        sun.misc.Unsafe unsafe = MyUnsafe.getUnsafeRef();
        System.out.println(unsafe.addressSize());
        System.out.println(unsafe.pageSize());
    }
}
