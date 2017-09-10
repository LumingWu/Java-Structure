package main.java.sort;

import java.util.List;

public class HeapSort<E extends Comparable<E>> {

    /*
    This will be called at most log(n) times recursively because this method can be called at the root.
    */
    private void maxHeapify(List<E> list, int i){
        int left = left(i);
        int right = right(i);
        int max = i;
        if(left < list.size() && list.get(max).compareTo(list.get(left)) < 0){
            max = left;
        }
        if(right < list.size() && list.get(max).compareTo(list.get(right)) < 0){
            max = right;
        }
        if(max != i){
            swap(list, i, max);
            maxHeapify(list, max);
        }
    }

    private void maxHeapify(List<E> list, int i, int size){
        int left = left(i);
        int right = right(i);
        int max = i;
        if(left < size && list.get(max).compareTo(list.get(left)) < 0){
            max = left;
        }
        if(right < size && list.get(max).compareTo(list.get(right)) < 0){
            max = right;
        }
        if(max != i){
            swap(list, i, max);
            maxHeapify(list, max, size);
        }
    }

    /*
    Starting from the parent of the last node because that is the last node that has children to heapify.
    At most n/2 is O(n), heapify is O(log n) so O(n log n). Although not every node is that above of the tree, proven O(n) for this.
    */
    private void buildMaxHeap(List<E> list){
        for(int i = parent(list.size() - 1); i >= 0; i--){
            maxHeapify(list, i);
        }
    }

    public void sort(List<E> list){
        buildMaxHeap(list);
        for(int i = list.size() - 1; i >= 1; i--){
            swap(list, 0, i);
            maxHeapify(list, 0, i);
        }
    }

    /*
    We must design the heap-sort in such a way that we can sort lists that do not ignore index 0.
    */
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

    private void swap(List<E> list, int a, int b){
        E temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

}
