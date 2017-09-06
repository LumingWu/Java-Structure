package main.java.data;

public class BinaryNode<E extends Comparable<E>> implements Comparable<BinaryNode<E>>{

    private E value;
    private BinaryNode<E> parent = null;
    private BinaryNode<E> left = null;
    private BinaryNode<E> right = null;

    public BinaryNode(E val){
        value = val;
    }

    public E getValue(){
        return value;
    }

    public void setValue(E val){
        value = val;
    }

    public BinaryNode<E> getParent() {
        return parent;
    }

    public BinaryNode<E> getLeft(){
        return left;
    }

    public BinaryNode<E> getRight(){
        return right;
    }

    public void setParent(BinaryNode<E> p){
        parent = p;
    }

    public void setLeft(BinaryNode<E> l){
        left = l;
    }

    public void setRight(BinaryNode<E> r){
        right = r;
    }


    @Override
    public int compareTo(BinaryNode<E> o) {
        return value.compareTo(o.getValue());
    }
}
