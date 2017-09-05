package main.java.data;

import main.java.list.LinkedList;

public class ManyToManyNode<E> extends Node{

    private LinkedList<Node> predecessors;
    private LinkedList<Node> successors;

    public ManyToManyNode(){
        super();
    }

    public ManyToManyNode(E value){
        super(value);
    }

    public LinkedList<Node> getPredecessors() {
        return predecessors;
    }

    public LinkedList<Node> getSuccessors() {
        return successors;
    }
}
