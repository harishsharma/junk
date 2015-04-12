package graph;

interface Paths {

    /**
     * Is there a path between s to v.
     * 
     * @param v
     * @return
     */
    public boolean hasPathTo(int v);

    /**
     * Path from s to v.
     * 
     * @param v
     * @return null if no such path is available.
     */
    public Iterable<Integer> pathTo(int v);
}
