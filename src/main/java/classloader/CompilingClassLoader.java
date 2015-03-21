package classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

/**
 * http://www.ibm.com/developerworks/java/tutorials/j-classloader/j-classloader.html#
 */
@Slf4j
public class CompilingClassLoader extends ClassLoader {

    private byte[] getBytes(String filename) throws IOException {
        File file = new File(filename);
        long len = file.length();
        byte raw[] = new byte[(int) len];
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(file);
            int r = fin.read(raw);
            if (r != len) {
                throw new IOException("Can't read all, " + r + " != " + len);
            }
        } finally {
            if (fin != null) fin.close();
        }
        return raw;
    }

    private boolean compile(String javaFile) throws IOException {
        log.info("CCL: Compiling {} ....", javaFile);
        Process p = Runtime.getRuntime().exec("javac " + javaFile);
        try {
            p.waitFor();
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
        int ret = p.exitValue();
        return ret == 0;
    }

    @Override
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> clazz = null;
        clazz = findLoadedClass(name);
        String fileStub = name.replace('.', '/');
        String javaFilename = fileStub + ".java";
        String classFilename = fileStub + ".class";

        File javaFile = new File(javaFilename);
        File classFile = new File(classFilename);
        if (javaFile.exists() && (!classFile.exists() || javaFile.lastModified() > classFile.lastModified())) {

            try {
                if (!compile(javaFilename) || !classFile.exists()) {
                    throw new ClassNotFoundException("Compile failed: " + javaFilename);
                }
            } catch (IOException ie) {
                throw new ClassNotFoundException(ie.toString());
            }
        }
        try {
            byte raw[] = getBytes(classFilename);
            clazz = defineClass(name, raw, 0, raw.length);
        } catch (IOException ie) {
            // This is not a failure! If we reach here, it might
            // mean that we are dealing with a class in a library,
            // such as java.lang.Object
        }

        if (clazz == null) {
            clazz = findSystemClass(name);
        }
        if (resolve && clazz != null) resolveClass(clazz);
        if (clazz == null) throw new ClassNotFoundException(name);
        return clazz;
    }
}
