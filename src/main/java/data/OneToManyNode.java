package main.java.data;


import java.util.LinkedList;

public class OneToManyNode<E> extends Node{

    private OneToManyNode<E> predecessor = null;
    private OneToManyNode<E>[] successors;

    public OneToManyNode(){
        super();
    }

    public OneToManyNode(E value){
        super(value);
    }

    public OneToManyNode<E> getPredecessor() {
        return predecessor;
    }

    public OneToManyNode<E>[] getSuccessors() {
        return successors;
    }

}
