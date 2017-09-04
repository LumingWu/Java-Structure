package main.java.list;

import java.util.Arrays;

public class List<E> {

    private Object[] list;
    private int size = 0;

    public List(){
        this(10);
    }

    public List(int size){
        list = new Object[size];
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
            for(int i = index; i < size - 1; i++){
                list[index] = list[index + 1];
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
        if(index > 0 && index < size){
            return (E)list[index];
        }
        return null;
    }

}
