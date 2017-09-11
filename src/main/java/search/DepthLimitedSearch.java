package main.java.search;

import main.java.data.OneToManyNode;

public class DepthLimitedSearch<E> {

    /*
    A little bit bad design here. If successful, return a Node with value, if reached limit, return a no value Node.
    Return null only if the whole tree is searched and the limit is not reached.
    */
    private OneToManyNode<E> search(OneToManyNode<E> node, E value, int limit, int count){
        if(node.getValue() == value){
            return node;
        }
        if(count == limit){
            return new OneToManyNode<E>();
        }
        OneToManyNode<E>[] children = node.getSuccessors();
        boolean limit_reached = false;
        for(int i = 0; i < children.length; i++){
            OneToManyNode<E> m_node = search(children[i], value, limit, count + 1);
            if(m_node != null){
                if(m_node.getValue() != null){
                    return m_node;
                }
                limit_reached = true;
            }
        }
        if(limit_reached){
            return new OneToManyNode<E>();
        }
        return null;
    }

    public OneToManyNode<E> search(OneToManyNode<E> node, E value, int limit){
        return search(node, value, limit, 0);
    }

}
