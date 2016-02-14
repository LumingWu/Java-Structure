
import List.TuringMachine;
import java.util.LinkedList;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Luming Wu
 */
public class TuringMachineTest {

    TuringMachine<Integer> m;
    LinkedList<Integer> errorList;

    @Before
    public void setUp() {
        m = new TuringMachine<Integer>();
        errorList = new LinkedList<Integer>();
    }

    @After
    public void tearDown() {
        m.clear();
        errorList.clear();
    }

    @Test
    public void addFirstTest() {
        m.addFirst(1);
        if (m.getFirst() != 1) {
            errorList.addLast(1);
        }
        if (m.getLast() != 1) {
            errorList.addLast(2);
        }
        if (m.size() != 1) {
            errorList.addLast(3);
        }
        assertTrue("Error: " + errorList, errorList.isEmpty());
    }

    @Test
    public void addLastTest() {
        m.addFirst(1);
        if (m.getFirst() != 1) {
            errorList.addLast(1);
        }
        if (m.getLast() != 1) {
            errorList.addLast(2);
        }
        if (m.size() != 1) {
            errorList.addLast(3);
        }
        assertTrue("Error: " + errorList, errorList.isEmpty());
    }

    @Test
    public void removeFirstEmptyTest() {
        m.removeFirst();
        assertTrue("The machine was initially nonempty or / and it failed to remove first.", m.isEmpty());
    }

    @Test
    public void removeLastEmptyTest() {
        m.removeLast();
        assertTrue("The machine was initially nonempty or / and it failed to remove last.", m.isEmpty());
    }

    @Test
    public void removeFirstOneTest() {
        m.addFirst(1);
        m.removeFirst();
        if (m.size() != 0) {
            errorList.addLast(1);
        }
        if (m.getFirst() != null) {
            errorList.addLast(2);
        }
        if (m.getLast() != null) {
            errorList.addLast(3);
        }
        assertTrue("List: " + errorList, errorList.isEmpty());
    }

    @Test
    public void removeLastOneTest() {
        m.addFirst(1);
        m.removeLast();
        if (m.size() != 0) {
            errorList.addLast(1);
        }
        if (m.getFirst() != null) {
            errorList.addLast(2);
        }
        if (m.getLast() != null) {
            errorList.addLast(3);
        }
        assertTrue("List: " + errorList, errorList.isEmpty());
    }
    
    @Test
    public void removeFirstTest(){
        m.addFirst(1);
        m.addLast(2);
        m.removeFirst();
        if(m.size() != 1){
            errorList.add(1);
        }
        if(m.getFirst() != 2){
            errorList.add(2);
        }
        if(m.getLast() != 2){
            errorList.add(3);
        }
        assertTrue("List: " + errorList, errorList.isEmpty());
    }
    
    @Test 
    public void removeLastTest(){
        m.addFirst(1);
        m.addLast(2);
        m.removeLast();
        if(m.size() != 1){
            errorList.add(1);
        }
        if(m.getFirst() != 1){
            errorList.add(2);
        }
        if(m.getLast() != 1){
            errorList.add(3);
        }
        assertTrue("List: " + errorList, errorList.isEmpty());
    }
    
}
