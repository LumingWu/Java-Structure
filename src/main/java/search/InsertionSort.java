package main.java.search;

import java.util.List;

public class InsertionSort<E extends Comparable<E>> {

    public void sort(List<E> list){
        for(int i = 1; i < list.size(); i++){
            int j = i;
            while(j > 0){
                if(list.get(j).compareTo(list.get(j - 1)) >= 0){
                    break;
                }
                E temp = list.get(j);
                list.set(j, list.get(j - 1));
                list.set(j - 1, temp);
                j--;
            }
        }
    }

}
