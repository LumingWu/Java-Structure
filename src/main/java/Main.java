package main.java;

import main.java.sort.InsertionSort;
import main.java.sort.SelectionSort;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Integer[] a = {5, 4, 3, 2, 1};
        List<Integer> l = (List<Integer>)Arrays.asList(a);
        new InsertionSort<Integer>().sort(l);
        System.out.println(l);
    }

}
