public class ArrayDeque<T> implements Deque<T> {
    /** add item to the first Node*/
    private T[] items;
    private int size = 0;

    int front = 1;
    int end = 0;
    int capacity = 8;

    ArrayDeque(){
        T[] item = (T []) new Object[8];
    }

    @Override
    public void  addLast(T item){
        end++;
        size++;
        items[end] = item;
        if (end >= capacity){
            end %= capacity;
        }
        if (size == capacity){
            resize(capacity * 2);
        }
    }

    private void resize(int capacity) {
        this.capacity = capacity;
        T[] a = (T []) new Object[capacity];
        int index = front;
        int i = 0;
        while (index!= end+1){
            a[i] = items[index];
            i++;
            index++;
            index = index % capacity;
        }
        front = 0;
        end = size - 1;
    }

    @Override
    public void addFirst(T item){
        front--;
        front = (front + capacity) % capacity;
        items[front] = item;
        size++;
        front = (front +capacity)%capacity;
        if (size == capacity){
            resize(capacity * 2);
        }
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }


    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        if (size !=0) {
            int index = front;
            while (index!= end+1){
                System.out.print(items[index]);
                index++;
                index = index % capacity;
            }
        }


    }
    @Override
    public T removeFirst(){
        T first = items[front];
        items[front] = null;
        front++;
        front %= capacity;
        size--;
        return first;
    }

    @Override
    public T removeLast(){
        T last = items[end];
        items[end] = null;
        end--;
        end %= capacity;
        size--;
        return last;
    }

    @Override
    public T get(int index){
        return items[index%capacity];
    }


}
