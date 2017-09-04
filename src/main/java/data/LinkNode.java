package main.java.data;

public class LinkNode<E> extends Node{

    private Node predecessor = null;
    private Node successor = null;

    public LinkNode(){
        super();
    }

    public LinkNode(Object val) {
        super(val);
    }

    public Node getPredecessor(){
        return predecessor;
    }

    public Node getSuccessor(){
        return successor;
    }

    public void setPredecessor(Node pred){
        predecessor = pred;
    }

    public void setSuccessor(Node suc){
        successor = suc;
    }

}
