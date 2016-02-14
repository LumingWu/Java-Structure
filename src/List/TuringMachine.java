package List;

/**
 *
 * @author Luming Wu
 */
public class TuringMachine<E>{
    private int _size = 0;
    private Cell<E> _head;
    private Cell<E> _first;
    private Cell<E> _last;
    
    public TuringMachine(){
        
    }
    
    public int size(){
        return _size;
    }
    
    public boolean isEmpty(){
        return _size == 0;
    }
    
    public void clear(){
        _size = 0;
        _head = null;
        _first = null;
        _last = null;
    }
    
    public E getFirst(){
        if(_first == null){
            return null;
        }
        return _first.e;
    }
    
    public void addFirst(E e){
        if(_size == 0){
            _first = new Cell<E>(e);
            _first.e = e;
            _last = _first;
        }
        else{
            Cell<E> newCell = new Cell<E>(e);
            newCell.successor = _first;
            _first.predecessor = newCell;
            _first = newCell;
        }
        _size = _size + 1;
    }
    
    public E removeFirst(){
        switch(_size){
            case 0:
                return null;
            case 1:
                E e1 = _first.e;
                this.clear();
                return e1;
            default:
                E e2 = _first.e;
                _first = _first.successor;
                _first.predecessor = null;
                _size = _size - 1;
                return e2;
        }
    }
    
    public E getLast(){
        if(_last == null){
            return null;
        }
        return _last.e;
    }
    
    public void addLast(E e){
        if(_size == 0){
            _first = new Cell<E>(e);
            _first.e = e;
            _last = _first;
        }
        else{
            Cell<E> newCell = new Cell<E>(e);
            newCell.predecessor = _last;
            _last.successor = newCell;
            _last = newCell;
        }
        _size = _size + 1;
    }
    
    public E removeLast(){
        switch(_size){
            case 0:
                return null;
            case 1:
                E e1 = _last.e;
                this.clear();
                return e1;
            default:
                E e2 = _last.e;
                _last = _last.predecessor;
                _last.successor = null;
                _size = _size - 1;
                return e2;
        }
    }
    
    public void runHead(){
        _head = _first;
    }
    
    public E readHead(){
        return _head.e;
    }
    
    public void writeHead(E e){
        _head.e = e;
    }
    
    public void headLeft(){
        if(_head.predecessor != null){
            _head = _head.predecessor;
        }
    }
    
    public void headLeftMost(){
        _head = _first;
    }
    
    public void headRight(){
        if(_head.successor != null){
            _head = _head.successor;
        }
    }
    
    public void headRightMost(){
        _head = _last;
    }
    
    public boolean headIsLeftMost(){
        return _head.predecessor == null;
    }
    
    public boolean headIsRightMost(){
        return _head.successor == null;
    }
    
    private class Cell<E>{
        
        public E e;
        public Cell<E> predecessor;
        public Cell<E> successor;
        
        public Cell(E e){
            this.e = e;
        }
        
    }
}
