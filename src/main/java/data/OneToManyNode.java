package main.java.data;

public class OneToManyNode<E> extends Node{

    private Node predecessor = null;
    private Node[] successors;

    public OneToManyNode(int s_size){
        super();
        successors = new Node[s_size];
    }

    public OneToManyNode(E value, int s_size){
        super(value);
        successors = new Node[s_size];
    }

    public Node getPredecessor() {
        return predecessor;
    }

    public Node[] getSuccessors() {
        return successors;
    }

}
