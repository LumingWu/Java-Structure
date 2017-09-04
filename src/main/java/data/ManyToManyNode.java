package main.java.data;

public class ManyToManyNode<E> extends Node{

    private Node[] predecessors;
    private Node[] successors;

    public ManyToManyNode(int n_size, int m_size){
        super();
        predecessors = new Node[n_size];
        successors = new Node[m_size];
    }

    public ManyToManyNode(E value, int n_size, int m_size){
        super(value);
        predecessors = new Node[n_size];
        successors = new Node[m_size];
    }

    public Node[] getPredecessors() {
        return predecessors;
    }

    public Node[] getSuccessors() {
        return successors;
    }
}
