package main.java.sort;

import java.util.List;

public class QuickSort<E extends Comparable<E>> {

    private void swap(List<E> list, int a, int b){
        E temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

    /*
    less than pivot to the left of pivot, else they will be equal to pivot or right of pivot.
    */
    private int partition(List<E> list, int l, int r){
        E pivot = list.get(r);
        int i = l;
        for(int j = l; j < r; j++){
            if(list.get(j).compareTo(pivot) < 0){
                swap(list, i, j);
                i++;
            }
        }
        swap(list, i, r);
        return i;
    }

    private void sort(List<E> list, int l, int r){
        if(l < r){
            int pivot = partition(list, l, r);
            sort(list, l, pivot - 1);
            sort(list, pivot + 1, r);
        }
    }

    public void sort(List<E> list){
        sort(list, 0, list.size() - 1);
    }

}
