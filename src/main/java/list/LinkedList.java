package main.java.list;

import main.java.data.LinkNode;
import main.java.data.Node;

public class LinkedList<E> {

    private LinkNode<E> head;
    private LinkNode<E> tail;
    private int size;

    public LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void add(E e){
        if(size == 0){
            head = new LinkNode<E>(e);
            tail = head;
        }
        else{
            LinkNode<E> newNode = new LinkNode<E>(e);
            newNode.setPredecessor(tail);
            tail.setSuccessor(newNode);
            tail = newNode;
        }
        size++;
    }

    public E remove(int index){
        if(index >= 0  && index < size ){
            LinkNode<E> temp = null;
            if(index <= size / 2){
                temp = head;
                for(int i = 0; i < index; i++){
                    temp = (LinkNode<E>) temp.getSuccessor();
                }
            }
            else{
                temp = tail;
                for(int i = 0; i < (size - 1 - index); i++){
                    temp = (LinkNode<E>) temp.getPredecessor();
                }
            }
            if(temp.getPredecessor() == null){
                if(temp.getSuccessor() == null){
                    head = null;
                    tail = null;
                }
                else{
                    head = (LinkNode<E>)temp.getSuccessor();
                    head.setPredecessor(null);
                }
            }
            else{
                if(temp.getSuccessor() == null){
                    tail = (LinkNode<E>)temp.getPredecessor();
                    tail.setSuccessor(null);
                }
                else{
                    ((LinkNode<E>)temp.getPredecessor()).setSuccessor(temp.getSuccessor());
                    ((LinkNode<E>)temp.getSuccessor()).setPredecessor(temp.getPredecessor());
                }
            }
            size--;
            return (E)temp.getValue();
        }
        return null;
    }

    public int size(){
        return size;
    }

    public E get(int index){
        if(index >= 0  && index < size ) {
            LinkNode<E> temp = null;
            if (index <= size / 2) {
                temp = head;
                for (int i = 0; i < index; i++) {
                    temp = (LinkNode<E>) temp.getSuccessor();
                }
            } else {
                temp = tail;
                for (int i = 0; i < (size - 1 - index); i++) {
                    temp = (LinkNode<E>) temp.getPredecessor();
                }
            }
            return (E)temp.getValue();
        }
        return null;
    }

}
