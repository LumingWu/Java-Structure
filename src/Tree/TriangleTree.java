package Tree;

import java.util.ArrayList;

public class TriangleTree<T> {
    
    ArrayList<Node<T>> tree;
    int height;
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
        return tree.size();
    }
    
    public boolean isEmpty(){
        return tree.isEmpty();
    }
    
    public int height(){
        return height;
    }
    
    public T get(int index){
        return tree.get(index).value;
    }
    
    public int levelIndex(int index){
        return tree.get(index).index;
    }
    
    public boolean add(T e){
        tree.add(new Node(e, height, counter));
        counter = counter + 1;
        if(counter == height){
            counter = 0;
            height = height + 1;
        }
        return true;
    }
    
    public T pop(){
        counter = counter - 1;
        if(counter == 0){
            height = height - 1;
            counter = height;
        }
        return tree.remove(tree.size() - 1).value;
    }
    
    public void clear(){
        tree.clear();
        height = 1;
        counter = 0;
    }
    
    public int getHeight(int index){
        return tree.get(index).height;
    }
    
    public int parent(int index){
        return index - tree.get(index).height + 1;
    }
    
    public int left(int index){
        return tree.get(index).height + index;
    }
    
    public int right(int index){
        return tree.get(index).height + index + 1;
    }
    
    public static int heightToSize(int height){
        if(height <= 0){
            return 0;
        }
        return height + heightToSize(height - 1);
    }
    
    private class Node<T>{
        
        public T value;
        public int height;
        public int index;
        
        public Node(T e, int h, int i){
            value = e;
            height = h;
            index = i;
        }
    }
}
