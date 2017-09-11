package main.java.search;

import main.java.data.OneToManyNode;

import java.util.LinkedList;

public class BreadthFirstSearch<E> {

    private OneToManyNode search(LinkedList<OneToManyNode<E>> fringe, E value){
        int size = fringe.size();
        if(size == 0){
            return null;
        }
        for(int i = 0; i < size; i++){
            if(fringe.getFirst().getValue().equals(value)){
                return fringe.getFirst();
            }
            fringe.addLast(fringe.removeFirst());
        }
        for(int j = 0; j < size; j++){
            OneToManyNode<E>[] children = fringe.removeFirst().getSuccessors();
            for(int k = 0; k < children.length; k++){
                fringe.addLast(children[k]);
            }
        }
        return search(fringe, value);
    }

    public OneToManyNode search(OneToManyNode<E> node, E value){
        LinkedList<OneToManyNode<E>> fringe = new LinkedList<OneToManyNode<E>>();
        fringe.add(node);
        return search(fringe, value);
    }

}
