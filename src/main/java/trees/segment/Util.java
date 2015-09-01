package trees.segment;

public class Util {

    /**
     * Returns the size of segement tree from array length.
     * 
     * @param len
     * @return
     */
    public static int getSize(int len) {
        return (int) Math.pow(2, (31 - Integer.numberOfLeadingZeros(len)) + 1) * 2;
    }
}
