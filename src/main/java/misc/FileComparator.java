package misc;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.management.RuntimeErrorException;

public class FileComparator implements Comparator<File> {

    public int compare(File f1, File f2) {
        int r = 0;
        try {
            r = f1.getCanonicalPath().compareTo(f2.getCanonicalPath());
        } catch (Throwable e) {
            throw new RuntimeErrorException((Error) e);
        }
        return r;
    }

    public static void main(String[] args) {
        ArrayList<File> files = new ArrayList<File>();
        for (String arg : args) {
            files.add(new File(arg));
        }
        Collections.sort(files, new FileComparator());
        for (File f : files) {
            System.out.println(f);
        }
    }

}
