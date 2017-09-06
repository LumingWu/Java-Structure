package main.java.sort;

import java.util.List;

public class SelectionSort <E extends Comparable<E>> {

    public void sort(List<E> list){
        for(int i = 0; i < list.size(); i++){
            int smallest = i;
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(smallest).compareTo(list.get(j)) > 0){
                    smallest = j;
                }
            }
            E temp = list.get(i);
            list.set(i, list.get(smallest));
            list.set(smallest, temp);
        }
    }

}
