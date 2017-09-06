package main.java.tree;

import main.java.data.BinaryNode;
import main.java.traverse.InOrder;

public class BinarySearchTree<E extends Comparable<E>> {

    private BinaryNode<E> root = null;
    private int size = 0;

    public BinarySearchTree(){

    }

    public int size(){
        return size;
    }

    private void insert(BinaryNode node, E e){
        int compare = node.getValue().compareTo(e);
        if(compare <= 0){
            if(node.getLeft() == null){
                BinaryNode<E> newNode = new BinaryNode(e);
                newNode.setParent(node);
                node.setLeft(newNode);
            }
            else{
                insert(node.getLeft(), e);
            }
        }
        else{
            if(node.getRight() == null){
                BinaryNode<E> newNode = new BinaryNode(e);
                newNode.setParent(node);
                node.setRight(newNode);
            }
            else{
                insert(node.getRight(), e);
            }
        }
    }

    public void insert(E e){
        if(root == null){
            root = new BinaryNode<E>(e);
        }
        insert(root, e);
        size++;
    }

    private BinaryNode<E> search(BinaryNode<E> node, E e){
        int compare = node.getValue().compareTo(e);
        if(compare < 0){
            if(node.getLeft() == null){
                return null;
            }
            return search(node.getLeft(), e);
        }
        else if(compare > 0){
            if(node.getRight() == null){
                return null;
            }
            return search(node.getRight(), e);
        }
        return node;
    }

    public BinaryNode<E> search(E e){
        if(root == null){
            return null;
        }
        return search(root, e);
    }

    public BinaryNode<E> delete(BinaryNode<E> node){
        BinaryNode<E> left = node.getLeft();
        BinaryNode<E> right = node.getRight();
        BinaryNode<E> parent = node.getParent();
        if(left == null){
            if(right == null){
                if(parent.getLeft() == node){
                    parent.setLeft(null);
                }
                else{
                    parent.setRight(null);
                }
            }
            else{
                if(parent.getLeft() == node){
                    parent.setLeft(right);
                }
                else{
                    parent.setRight(right);
                }
            }
        }
        else{
            if(right == null){
                if(parent.getLeft() == node){
                    parent.setLeft(left);
                }
                else{
                    parent.setRight(left);
                }
            }
            else{
                BinaryNode<E>[] list = InOrder.traverse(node);
                BinaryNode<E> pre_order_predecessor = null;
                for(int i = 0; i < list.length; i++){
                    if(list[i] == node){
                        pre_order_predecessor = list[i - 1];
                    }
                }
                BinaryNode<E> temp = new BinaryNode<E>(node.getValue());
                node.setValue(pre_order_predecessor.getValue());
                BinaryNode<E> pred_parent = pre_order_predecessor.getParent();
                BinaryNode<E> pred_left = pre_order_predecessor.getLeft();
                if(pred_left == null){
                    if(pred_parent.getRight() == pre_order_predecessor){
                        pred_parent.setRight(null);
                    }
                    else{
                        pred_parent.setLeft(null);
                    }
                }
                else{
                    pred_left.setParent(pred_parent);
                    if(pred_parent.getRight() == pre_order_predecessor){
                        pred_parent.setRight(pred_left);
                    }
                    else{
                        pred_parent.setLeft(pred_left);
                    }

                }
                pre_order_predecessor.setParent(null);
                return temp;
            }
        }
        node.setParent(null);
        return node;
    }


}
