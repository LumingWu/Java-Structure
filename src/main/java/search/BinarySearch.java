package main.java.search;

import java.util.List;

public class BinarySearch<E extends Comparable<E>> {

    private int search(List<E> list, E e, int left, int right){
        if(left <= right) {
            int middle = (left + right) / 2;
            int compare = list.get(middle).compareTo(e);
            if (compare < 0) {
                return search(list, e, left, middle - 1);
            } else if (compare > 0) {
                return search(list, e, middle + 1, right);
            }
            return middle;
        }
        return -1;
    }

    public int search(List<E> list, E e){
        return search(list, e, 0, list.size());
    }

}
