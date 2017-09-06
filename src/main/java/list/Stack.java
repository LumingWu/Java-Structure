package main.java.list;

import main.java.data.LinkNode;

public class Stack<E> {

    private LinkNode<E> top = null;
    private int size = 0;

    public Stack(){

    }

    public void push(E e){
        LinkNode<E> newNode = new LinkNode<E>(e);
        newNode.setPredecessor(top);
        top = newNode;
        size++;
    }

    public E pop(){
        if(size > 0){
            E value = (E)top.getValue();
            top = (LinkNode<E>)top.getPredecessor();
            size--;
            return value;
        }
        return null;
    }

}
