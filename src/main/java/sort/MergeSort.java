package main.java.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Divide the list by 2 for log(n) times. Then merge log(n) times. For each merge, it is linear, at most n.
 * @param <E>
 */
public class MergeSort<E extends Comparable<E>> {
    /* Kornrod's merge would be a good approximation merge.
       But that kills the purpose of merge sort because now correctness is worse than heap sort.
       It is impractical because placing k-element blocks is also not O(1), it is at least O(N+M)
      Benefit is the location of every element is k slot off.
    * */

    private void merge(List<E> list, int L1, int R1, int L2, int R2){
        int size = R1 + R2 - L1 - L2 + 2;
        ArrayList<E> merge = new ArrayList<E>(size);
        int i = L1, j = L2;
        while(merge.size() < size){
            if(i <= R1){
                if(j <= R2){
                    if(list.get(i).compareTo(list.get(j)) <= 0) {
                        merge.add(list.get(i));
                        i++;
                    }
                    else{
                        merge.add(list.get(j));
                        j++;
                    }
                }
                else{
                    while(i <= R1){
                        merge.add(list.get(i));
                        i++;
                    }
                }
            }
            else{
                while(j <= R2){
                    merge.add(list.get(j));
                    j++;
                }
            }
        }
        int left_size = R1 - L1 + 1;
        for(int k = 0; k < merge.size(); k++){
            if(k < left_size){
                list.set(L1 + k, merge.get(k));
            }
            else{
                list.set(L2 + k - left_size, merge.get(k));
            }
        }
    }

    private void sort(List<E> list, int left, int right){
        if(left == right){
            return;
        }
        if(left + 1 == right){
            if(list.get(left).compareTo(list.get(right)) > 0){
                E temp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, temp);
            }
            return;
        }
        int middle = (left + right) / 2;
        sort(list, 0, middle);
        sort(list, middle + 1, right);
        merge(list, 0, middle, middle + 1, right);
    }

    // Less Space In-Place Merge-Sort
    public void sort(List<E> list){sort(list, 0, list.size() - 1); }

    /*
    private List<E> merge(List<E> left, List<E> right){
        int i = 0, j = 0;
        ArrayList<E> l = new ArrayList<E>(left.size() + right.size());
        while(i < left.size() || j < right.size()){
            if(i < left.size()){
                if(j < right.size()){
                    if(left.get(i).compareTo(right.get(j))<= 0){
                        l.add(left.get(i));
                        i++;
                    }
                    else{
                        l.add(right.get(j));
                        j++;
                    }
                }
                else{
                    while(i < left.size()){
                        l.add(left.get(i));
                        i++;
                    }
                }
            }
            else{
                while(j < right.size()){
                    l.add(right.get(j));
                    j++;
                }
            }
        }
        return l;
    }

    public List<E> sort(List<E> list){
        if(list.size() == 1){
            return list;
        }
        if(list.size() == 2){
            if(list.get(0).compareTo(list.get(1)) > 0){
                E temp = list.get(0);
                list.set(0, list.get(1));
                list.set(1, temp);
            }
            return list;
        }
        int middle = list.size() / 2;
        List<E> left = sort(list.subList(0, middle));
        List<E> right = sort(list.subList(middle, list.size()));
        return merge(left, right);
    }
    */
}
