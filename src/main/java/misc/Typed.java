package misc;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Typed {
    static Class<?> comparableClassFor(Object x) {
        if (x instanceof Comparable) {
            Class<?> c;
            Type[] ts, as;
            Type t;
            ParameterizedType p;
            if ((c = x.getClass()) == String.class) // bypass checks
                return c;
            if ((ts = c.getGenericInterfaces()) != null) {
                for (int i = 0; i < ts.length; ++i) {
                    if (((t = ts[i]) instanceof ParameterizedType)
                            && ((p = (ParameterizedType) t).getRawType() == Comparable.class)
                            && (as = p.getActualTypeArguments()) != null && as.length == 1 && as[0] == c) // type arg is
                                                                                                          // c
                        return c;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(comparableClassFor(new Inner()));
    }

    private static class Inner implements Comparable<Inner> {

        @Override
        public int compareTo(Inner o) {
            // TODO Auto-generated method stub
            return 0;
        }

    }
}
