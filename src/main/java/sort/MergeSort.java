package main.java.sort;

import java.util.List;

public class MergeSort<E extends Comparable<E>> {
    /*Kornrod's merge would be a good approximation merge.
       But that kills the purpose of merge sort because now correctness is worse than heap sort.
       It is impractical because placing k-element blocks is also not O(1), it is at least O(N+M)
      Benefit is the location of every element is k slot off.
    * */
    private void merge(List<E> list, int L1, int R1, int L2, int R2){/*
        while(L1 <= R1 || L2 <= R2){
            if(list.get(L1).compareTo(list.get(L2)) >){

            }
        }*/
    }

    private void sort(List<E> list, int left, int right){
        if(left == right){
            return;
        }
        if(left + 1 == right && list.get(left).compareTo(list.get(right)) > 0){
            E temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            return;
        }
        int middle = (left + right) / 2;
        sort(list, 0, middle);
        sort(list, middle + 1, right);
        merge(list, 0, middle, middle + 1, right);
    }

    public void sort(List<E> list){
        sort(list, 0, list.size() - 1);
    }

}
