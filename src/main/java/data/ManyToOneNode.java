package main.java.data;

import main.java.list.LinkedList;

public class ManyToOneNode<E> extends Node{

    private LinkedList<Node> predecessors;
    private Node successor = null;

    public ManyToOneNode(){
        super();
    }

    public ManyToOneNode(E value){
        super(value);
    }

    public LinkedList<Node> getPredecessors() {
        return predecessors;
    }

    public Node getSuccessor() {
        return successor;
    }

    public void setSuccessor(Node suc){
        successor = suc;
    }

}
