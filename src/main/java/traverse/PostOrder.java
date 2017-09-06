package main.java.traverse;

import main.java.data.BinaryNode;

import java.util.LinkedList;

public class PostOrder {

    private static void traverse(LinkedList list, BinaryNode node){
        if(node != null){
            traverse(list, node.getLeft());
            traverse(list, node.getRight());
            list.add(node);
        }
    }

    public static BinaryNode[] traverse(BinaryNode node){
        LinkedList<BinaryNode> list = new LinkedList<BinaryNode>();
        traverse(list, node);
        return list.toArray(new BinaryNode[list.size()]);
    }

}
