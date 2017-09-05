package main.java.tree;

import main.java.data.Node;

import java.util.Arrays;


public class MTree<E> {

    private Node<E>[] tree = (Node<E>[])new Object[10];
    private int m;
    private int size = 0;

    public MTree(int m_ary){
        m = m_ary;
    }

    private void resize(){
        tree = Arrays.copyOf(tree, (int)(tree.length * 1.5));
    }

    public int size(){
        return size;
    }

    public int space(){
        return tree.length;
    }

    /*
    * This should only be used when creating the tree
    * */
    public void add(E e){
        if(size + 2 == tree.length){
            resize();
        }
        tree[size + 1] = new Node<E>(e);
        size++;
    }

    private void remove_subtree(int index){
        if(index >= size() || tree[index] == null){
            return;
        }
        tree[index] = null;
        size--;
        for(int i = 0; i < m; i++){
            remove_subtree(index * m + i);
        }
    }

    public E remove(int index){
        if(index >= 0 && index < tree.length && tree[index] != null){
            E temp = tree[index].getValue();
            remove_subtree(index);
            return temp;
        }
        return null;
    }

    private int height(int index){
        if(index < tree.length && tree[index] != null){
            int height = 0;
            for(int i = 0; i < m; i++){
                height = Math.max(height, height(index * m + i));
                return height + 1;
            }
        }
        return 0;
    }

    public int height(){
        int height = 0;
        for(int i = 0; i < m; i++){
            height = Math.max(height, height(m + i));
        }
        return height;
    }

    public int left(int index){
        return index * m;
    }

    public int right(int index){
        return (index + 1) * m - 1;
    }

    public int parent(int index){
        if(index == 1){
            return 1;
        }
        return index / m;
    }

    public int depth(int index){
        if(index == 1){
            return 0;
        }
        return depth(parent(index)) + 1;
    }

}
