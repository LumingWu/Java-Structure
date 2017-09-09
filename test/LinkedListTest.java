import main.java.list.LinkedList;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class LinkedListTest {

    @Test
    public void empty(){
        LinkedList<Integer> l = new LinkedList<Integer>();
        String errors = "";
        if(l.size() != 0){
            errors += 0;
        }
        if(l.get(0) != null){
            errors += 1;
        }
        if(l.remove(0) != null){
            errors += 2;
        }
        assertTrue("Errors: " + errors, errors.isEmpty());
    }

    @Test
    public void addOne(){
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(1);
        String errors = "";
        if(l.size() != 1){
            errors += 0;
        }
        if(l.get(0) != 1){
            errors += 1;
        }
        if(l.remove(0) != 1){
            errors += 2;
        }
        assertTrue("Errors: " + errors, errors.isEmpty());
    }

    @Test
    public void addLarge(){
        LinkedList<Integer> l = new LinkedList<Integer>();
        for(int i = 0; i < 10000; i++){
            l.add(i);
        }
        String errors = "";
        for(int j = 0; j < 10000; j++){
            if(l.get(j) != j){
                errors += j;
            }
        }
        if(l.size() != 10000){
            errors += 10000;
        }
        assertTrue("Errors: " + errors, errors.isEmpty());
    }

    @Test
    public void removeEmpty(){
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(1);
        l.remove(0);
        String errors = "";
        if(l.size() != 0){
            errors += 0;
        }
        if(l.get(0) != null){
            errors += 1;
        }
        assertTrue("Errors: " + errors, errors.isEmpty());
    }

    @Test
    public void removeLarge(){
        LinkedList<Integer> l = new LinkedList<Integer>();
        for(int i = 0; i < 10000; i++){
            l.add(i);
        }
        int remove = (int)(Math.random() * 10000);
        int removed = l.remove(remove);
        String errors = "";
        if(l.size() != 9999){
            errors += 0;
        }
        if(removed != remove){
            errors += 1;
        }
        for(int i = remove; i < l.size(); i++){
            if(l.get(i) != i + 1){
                errors += (i + 1);
            }
        }
        assertTrue("Errors: " + errors, errors.isEmpty());
    }

}
