package main.java.tree;

import java.util.ArrayList;

public class PriorityQueue<E extends Comparable<E>> {

    private ArrayList<E> heap;

    @SuppressWarnings("checked")
    public PriorityQueue(int size){
        heap = new ArrayList<E>(size);
    }

    public PriorityQueue(){
        this(1);
    }

    private void minHeapifyUp(int i){
        int parent = parent(i);
        if(heap.get(parent).compareTo(heap.get(i)) > 0){
            swap(i, parent);
            minHeapifyUp(parent);
        }
    }

    private void minHeapifyDown(int i){
        int left = left(i);
        int right = right(i);
        int min = i;
        if(left < size() && heap.get(min).compareTo(heap.get(left)) > 0){
            min = left;
        }
        if(right < size() && heap.get(min).compareTo(heap.get(right)) > 0){
            min = right;
        }
        if(min != i){
            swap(i, min);
            minHeapifyDown(min);
        }
    }

    public int size(){
        return heap.size();
    }

    public void insert(E e){
        heap.add(e);
        minHeapifyUp(size() - 1);
    }

    public E peek(){
        return heap.get(0);
    }

    public E removeMin(){
        E temp = heap.get(0);
        swap(0, size() - 1);
        heap.remove(size() - 1);
        minHeapifyDown(0);
        return temp;
    }

    private int parent(int i){
        if(i == 0){
            return 0;
        }
        return (int)Math.ceil((double)i / 2) - 1;
    }

    private int left(int i){
        return i * 2 + 1;
    }

    private int right(int i){
        return i * 2 + 2;
    }

    private void swap(int a, int b){
        E temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

}
