package sun.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 
 * @author harish.sharma
 *
 */
@SuppressWarnings("restriction")
public class MyUnsafe {

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
