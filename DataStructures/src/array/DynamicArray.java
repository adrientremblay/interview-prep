package array;

import java.util.Arrays;
import java.util.Iterator;

public class DynamicArray<E> implements Iterable<E> {
    private int capacity;
    private int length;
    private E[] arr;

    // Private methods
    private void resize() {
        this.capacity *= 2;
        E[] newArr = (E[]) new Object[this.capacity];
        for (int i = 0 ; i < arr.length ; i++){
            newArr[i]= arr[i];
        }
        this.arr = newArr;
    }

    // Constructors
    public DynamicArray() {
        this(8);
    }

    public DynamicArray(int capacity){
        if (capacity < 0) throw new IllegalArgumentException("Capacity cannot be below 0!");

        this.capacity=capacity;
        this.length=0;
        arr = (E[]) new Object[capacity];
    }

    // Public Methods
    public E get(int index) {
        return arr[index];
    }

    public void insert(int index, E value) {
        if (index < 0) throw new IndexOutOfBoundsException();

        // index will resolve to being the end of the array
        if (index >= this.length) {
            this.append(value);
            return;
        }

        if  (this.length == capacity - 1) resize();

        for (int i = this.length - 1 ; i >= index ; i--) {
           arr[i+1]  = arr[i];
        }
        arr[index] = value;
    }

    public void append(E value) {
        if  (this.length == capacity - 1) resize();

        arr[this.length] = value;
        this.length++;
    }

    public int search(E value) {
        for (int i = 0 ; i < this.length ; i++) {
           if (arr[i].equals(value)) return i;
        }

        return -1;
    }

    public boolean contains(E value) {
        return search(value) != -1;
    }

    public void delete(E value) {
        int deleteIndex = this.search(value);
        if (deleteIndex == -1) throw new IndexOutOfBoundsException();

        for (int i = deleteIndex ; i < this.length ; i++){
           arr[i] = arr[i+1];
        }

        this.length-=1;
    }

    public int size() {
        return this.length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        return "DynamicArray{" +
                "capacity=" + capacity +
                ", length=" + length +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }

    @Override
    public Iterator<E> iterator() {
        return new java.util.Iterator<E>() {
            int index = 0;
            public boolean hasNext() {return index < length;}
            public E next() { return arr[index++];}
        };
    }
}
