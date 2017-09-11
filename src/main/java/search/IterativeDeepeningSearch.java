package main.java.search;

import main.java.data.OneToManyNode;

public class IterativeDeepeningSearch<E> {

    /*
    The time complexity is almost same as bfs and it is very wasteful in visiting the same nodes over and over.
    But it does keep less nodes in memory during operation, significantly lower.
    */
    public OneToManyNode<E> search(OneToManyNode<E> node, E value){
        DepthLimitedSearch<E> dls = new DepthLimitedSearch<E>();
        OneToManyNode<E> n;
        int limit = 0;
        while((n = dls.search(node, value, limit)) != null){
            if(n.getValue() != null){
                return n;
            }
            limit++;
        }
        return null;
    }

}
