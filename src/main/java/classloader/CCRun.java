package classloader;

import java.lang.reflect.Method;

/**
 * http://www.ibm.com/developerworks/java/tutorials/j-classloader/j-classloader.html#
 */
public class CCRun {
    static public void main(String args[]) throws Exception {
        String progClass = args[0];
        String progArgs[] = new String[args.length - 1];
        System.arraycopy(args, 1, progArgs, 0, progArgs.length);
        CompilingClassLoader ccl = new CompilingClassLoader();
        Class<?> clas = ccl.loadClass(progClass);
        Class<?> mainArgType[] = { (new String[0]).getClass()};
        Method main = clas.getMethod("main", mainArgType);
        Object argsArray[] = { progArgs};
        main.invoke(null, argsArray);
    }
}
