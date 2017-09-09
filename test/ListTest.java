import main.java.list.List;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertTrue;

public class ListTest {

    @Test
    public void empty(){
        List<Integer> l = new List<Integer>();
        LinkedList errors = new LinkedList();
        if(l.size() != 0){
            errors.add(0);
        }
        if(l.get(0) != null){
            errors.add(1);
        }
        if(l.remove(0) != null){
            errors.add(2);
        }
        assertTrue("Errors: " + errors, errors.isEmpty());
    }

    @Test
    public void addOne(){
        List<Integer> l = new List<Integer>();
        l.add(1);
        LinkedList errors = new LinkedList();
        if(l.size() != 1){
            errors.add(0);
        }
        if(l.get(0) != 1){
            errors.add(1);
        }
        if(l.remove(0) != 1){
            errors.add(2);
        }
        assertTrue("Errors: " + errors, errors.isEmpty());
    }

    @Test
    public void addLarge(){
        List<Integer> l = new List<Integer>();
        for(int i = 0; i < 10000; i++){
            l.add(i);
        }
        LinkedList errors = new LinkedList();
        for(int j = 0; j < 10000; j++){
            if(l.get(j) != j){
                errors.add(j);
            }
        }
        if(l.size() != 10000){
            errors.add(10000);
        }
        assertTrue("Errors: " + errors, errors.isEmpty());
    }

    @Test
    public void removeEmpty(){
        List<Integer> l = new List<Integer>();
        l.add(1);
        l.remove(0);
        LinkedList errors = new LinkedList();
        if(l.size() != 0){
            errors.add(0);
        }
        if(l.get(0) != null){
            errors.add(1);
        }
        assertTrue("Errors: " + errors, errors.isEmpty());
    }

    @Test
    public void removeLarge(){
        List<Integer> l = new List<Integer>();
        for(int i = 0; i < 10000; i++){
            l.add(i);
        }
        int remove = (int)(Math.random() * 10000);
        int removed = l.remove(remove);
        LinkedList errors = new LinkedList();
        if(l.size() != 9999){
            errors.add(0);
        }
        if(removed != remove){
            errors.add(1);
        }
        for(int i = remove; i < l.size(); i++){
            if(l.get(i) != i + 1){
                errors.add(i + 1);
            }
        }
        assertTrue("Errors: " + errors, errors.isEmpty());
    }

}
