package Tree;

import java.util.ArrayList;

public class TriangleTree<T> {
    
    ArrayList<Node<T>> tree;
    int height;
    int size;
    int counter;
    
    public TriangleTree(int size){
        tree = new ArrayList<Node<T>>(size);
        height = 1;
        size = 0;
        counter = 0;
    }
    
    public TriangleTree(){
        this(0);
    }
    
    public int size(){
        return size;
    }
    
    public int height(){
        return height;
    }
    
    public boolean add(T e){
        tree.add(new Node(e, height));
        counter = counter + 1;
        if(counter == height){
            counter = 0;
            height = height + 1;
        }
        size = size + 1;
        return true;
    }
    
    public T pop(){
        counter = counter - 1;
        if(counter == 0){
            height = height - 1;
            counter = height;
        }
        size = size - 1;
        return tree.remove(size).value;
    }
    
    public void clear(){
        tree.clear();
        height = 1;
        size = 0;
        counter = 0;
    }
    
    public int getHeight(int index){
        return tree.get(index).height;
    }
    
    public int getRoot(int index){
        return index - tree.get(index).height + 1;
    }
    
    public int getLeft(int index){
        return tree.get(index).height + index;
    }
    
    public int getRight(int index){
        return tree.get(index).height + index + 1;
    }
    
    private class Node<T>{
        
        public T value;
        public int height;
        
        public Node(T e, int h){
            value = e;
            height = h;
        }
    }
}
