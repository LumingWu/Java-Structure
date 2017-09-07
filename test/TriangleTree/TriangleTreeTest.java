/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TriangleTree;

import main.java.tree.TriangleTree;
import java.util.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author umola_000
 */
public class TriangleTreeTest {
    
    TriangleTree<Integer> t;
    LinkedList<Integer> errorList;
    
    @Before
    public void setUp() {
        t = new TriangleTree<Integer>();
        errorList = new LinkedList<Integer>();
    }
    
    @After
    public void tearDown() {
        t.clear();
        errorList.clear();
    }
    
    @Test
    public void sizeEmptyTest(){
        assertTrue("The tree is not empty.", t.isEmpty());
    }
    
    @Test
    public void sizeTest(){
        t.add(0);
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(5);
        assertTrue("The size is not 6.", t.size() == 6);
    }
    
    @Test
    public void addTest(){
        t.add(0);
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(5);
        for(int i = 0; i < 6; i++){
            if(t.get(i) != i){
                errorList.addLast(i);
            }
        }
        assertTrue("List: " + errorList, errorList.isEmpty());
    }
    
    @Test
    public void removeTest(){
        t.add(0);
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(5);
        t.pop();
        for(int i = 0; i < 5; i++){
            if(t.get(i) != i){
                errorList.addLast(i);
            }
        }
        if(t.size() != 5){
            errorList.addLast(5);
        }
        assertTrue("List: " + errorList, errorList.isEmpty());
    }
    
    @Test
    public void treeHeightEmptyTest(){
        assertTrue("Tree is not empty.", t.height() == 1);
    }
    
    @Test
    public void treeHeightTest(){
        t.add(0);
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(5);
        if(t.getHeight(0) != 1){
            errorList.addLast(1);
        }
        if(t.getHeight(1) != 2){
            errorList.addLast(2);
        }
        if(t.getHeight(2) != 2){
            errorList.addLast(3);
        }
        if(t.getHeight(3) != 3){
            errorList.addLast(4);
        }
        if(t.getHeight(4) != 3){
            errorList.addLast(5);
        }
        if(t.getHeight(5) != 3){
            errorList.addLast(6);
        }
        assertTrue("List: " + errorList, errorList.isEmpty());
    }
    
    @Test
    public void treeHeightParseTest(){
        if(TriangleTree.heightToSize(1) != 1){
            errorList.addLast(2);
        }
        if(TriangleTree.heightToSize(2) != 3){
            errorList.addLast(3);
        }
        if(TriangleTree.heightToSize(3) != 6){
            errorList.addLast(4);
        }
        if(TriangleTree.heightToSize(4) != 10){
            errorList.addLast(5);
        }
        if(TriangleTree.heightToSize(5) != 15){
            errorList.addLast(6);
        }
        assertTrue("List: " + errorList, errorList.isEmpty());
    }
    
    @Test
    public void leftTest(){
        t.add(0);
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(5);
        if(t.left(0) != 1){
            errorList.addLast(1);
        }
        if(t.left(1) != 3){
            errorList.addLast(2);
        }
        if(t.left(2) != 4){
            errorList.addLast(3);
        }
        assertTrue("List: " + errorList, errorList.isEmpty());
    }
    
    @Test
    public void rightTest(){
        t.add(0);
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(5);
        if(t.right(0) != 2){
            errorList.addLast(1);
        }
        if(t.right(1) != 4){
            errorList.addLast(2);
        }
        if(t.right(2) != 5){
            errorList.addLast(3);
        }
        assertTrue("List: " + errorList, errorList.isEmpty());
    }
    
}
