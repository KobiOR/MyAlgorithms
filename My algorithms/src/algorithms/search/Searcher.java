package algorithms.search;

public interface Searcher<T> {
    // the search method
    public Solution<T> search(Searchable s);
    
    // get how many nodes were evaluated by the algorithm
    public int getNumberOfNodesEvaluated();
}
