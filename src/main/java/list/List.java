package main.java.list;

import java.util.Arrays;

public class List<E> {

    private E[] list;
    private int size = 0;

    public List(){
        this(10);
    }

    public List(int size){
        list = (E[])new Object[size];
    }

    private void resize(){
        list = Arrays.copyOf(list, (int)(list.length * 1.5));
    }

    public void add(E e){
        if(list.length == size){
            resize();
        }
        list[size] = e;
        size++;
    }

    public E remove(int index){
        if(index >= 0 && index < size){
            E temp = (E)list[index];
            for(int i = index + 1; i < size; i++){
                list[i - 1] = list[i];
            }
            list[size] = null;
            size--;
            return temp;
        }
        return null;
    }

    public int size(){
        return size;
    }

    public E get(int index){
        if(index >= 0 && index < size){
            return list[index];
        }
        return null;
    }

}
