package graph;

/**
 * Given a source and graph , it answers these questions.
 * 
 * @author harish.sharma
 *
 */
public interface GraphSearch {


    /**
     * Is v connected to source.
     * 
     * @param v
     * @return
     */
    public boolean isConnected(int v);

    /**
     * return how many nodes connected from source.
     * 
     * @return
     */
    public int count();
}
