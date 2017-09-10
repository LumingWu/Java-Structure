package main.java;

import main.java.sort.QuickSort;
import main.java.tree.PriorityQueue;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Integer[] a = {5, 4, 3, 2, 1};
        List<Integer> l = (List<Integer>)Arrays.asList(a);
        new QuickSort<Integer>().sort(l);
        System.out.println(l);
        PriorityQueue<Integer> p = new PriorityQueue<Integer>(5);
        p.insert(5);p.insert(4);p.insert(3);p.insert(2);p.insert(1);
        for(int i = 0; i < 5; i++){
            System.out.print(p.removeMin());
        }
        System.out.println();
    }

}
