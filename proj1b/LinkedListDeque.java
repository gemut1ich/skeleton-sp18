public class LinkedListDeque<T> implements Deque<T> {

    private class stuffNode {

        public T item;
        public stuffNode next;
        public stuffNode prev;

        stuffNode(T item, stuffNode next, stuffNode before){
            this.item = item;
            this.prev = before;
            this.next = next;
        }
    }


    private stuffNode sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new stuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    @Override
    /** add item to the first Node*/
    public void addFirst(T item){
        size++;
        sentinel.next = new stuffNode(item, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;

    }

    @Override
    /** add item to the last Node*/
    public void addLast(T item){
        size++;
        sentinel.prev = new stuffNode(item, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
    }

    @Override
    /** return if the List is Empty */
    public boolean isEmpty(){
        return sentinel.next == sentinel;
    }

    @Override
    /** return the size of a List */
    public int size(){
        return size;
    }

    @Override
    /** print the whole List */
    public void printDeque(){
        stuffNode ptr = sentinel.next;
        while (ptr!=sentinel){
            System.out.print(ptr.item);
            ptr = ptr.next;
        }
    }

    @Override
    /** remove the first Node */
    public T removeFirst(){
        size--;
        stuffNode first = sentinel.next;
        sentinel.next = first.next;
        sentinel.next.prev = sentinel;
       return first.item;
    }

    @Override
    /** remove the Last Node */
    public T removeLast(){
        size--;
        stuffNode last = sentinel.prev;
        last.prev.next = sentinel;
        sentinel.prev = last.prev;
        return last.item;
    }

    @Override
    /** get the Node corresponding to index */
    public T get(int index){
        if (index < 0){
            return null;
        }
        stuffNode getNode = sentinel;
        for (int i = index; i >= 0; i--){
            getNode = getNode.next;
            if (getNode == sentinel){
                return null;
            }
        }
        return getNode.item;
    }
    /** get the Node corresponding to index, implementing with Recursive */
    public T getRecursive(int index){
        if (index < 0){
            return null;
        }
        return getRecursive(index, sentinel.next);
    }
    /** implement of getRecursive */
    private T getRecursive(int index, stuffNode current){
        if (current == sentinel){
            return null;
        }
        if (index == 0){
            return current.item;
        }
        return getRecursive(index - 1, current.next);
    }



}
