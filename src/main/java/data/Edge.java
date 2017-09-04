package main.java.data;

public class Edge<E> extends Node{

    private Node nodeL;
    private Node nodeR;

    public Edge(Node nL, Node nR){
        super();
        nodeL = nL;
        nodeR = nR;
    }

    public Edge(E value, Node nL, Node nR){
        super(value);
        nodeL = nL;
        nodeR = nR;
    }

    public Node getLeft(){
        return nodeL;
    }

    public Node getRight(){
        return nodeR;
    }

    public void setNodeL(Node nL) {
        nodeL = nL;
    }

    public void setNodeR(Node nR) {
        nodeR = nR;
    }
}
