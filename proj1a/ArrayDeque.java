public class ArrayDeque<T> {
    /** add item to the first Node*/
    private T[] items;
    private int size = 0;

    int front = 1;
    int end = 0;
    int capacity = 8;

    ArrayDeque(){
        T[] item = (T []) new Object[8];
    }

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


    public boolean isEmptyNotCircular(){
        return size == 0;
    }



    public int size(){
        return size;
    }


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

    public T removeFirst(){
        T first = items[front];
        items[front] = null;
        front++;
        front %= capacity;
        size--;
        return first;
    }


    public T removeLast(){
        T last = items[end];
        items[end] = null;
        end--;
        end %= capacity;
        size--;
        return last;
    }

    public T get(int index){
        return items[index%capacity];
    }


}
