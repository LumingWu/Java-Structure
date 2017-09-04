package main.java.data;

public class Node<E> {

    private E value;

    public Node(){
        value = null;
    }

    public Node(E val){
        value = val;
    }

    public E getValue(){
        return value;
    }

    public void setValue(E val){
        value = val;
    }
}
