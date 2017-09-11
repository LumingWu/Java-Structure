package main.java.search;

import main.java.data.OneToManyNode;

import java.util.LinkedList;

public class DepthFirstSearch<E> {

    public OneToManyNode<E> search(OneToManyNode<E> node, E value){
        if(node.getValue() == value){
            return node;
        }
        OneToManyNode<E>[] children = node.getSuccessors();
        for(int i = 0; i < children.length; i++){
            OneToManyNode<E> m_node = search(children[i], value);
            if(m_node != null){
                return m_node;
            }
        }
        return null;
    }

}
