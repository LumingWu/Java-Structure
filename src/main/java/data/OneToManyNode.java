package main.java.data;

import main.java.list.LinkedList;

public class OneToManyNode<E> extends Node{

    private Node predecessor = null;
    private LinkedList<Node> successors;

    public OneToManyNode(){
        super();
    }

    public OneToManyNode(E value){
        super(value);
    }

    public Node getPredecessor() {
        return predecessor;
    }

    public LinkedList<Node> getSuccessors() {
        return successors;
    }

}
