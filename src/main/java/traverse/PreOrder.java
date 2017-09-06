package main.java.traverse;

import main.java.data.BinaryNode;

import java.util.Arrays;
import java.util.LinkedList;

public class PreOrder {

    private static void traverse(LinkedList list, BinaryNode node){
        if(node != null){
            list.add(node);
            traverse(list, node.getLeft());
            traverse(list, node.getRight());
        }
    }

    public static BinaryNode[] traverse(BinaryNode node){
        LinkedList<BinaryNode> list = new LinkedList<BinaryNode>();
        traverse(list, node);
        return list.toArray(new BinaryNode[list.size()]);
    }

}
