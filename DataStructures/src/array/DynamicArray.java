package array;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Dynamic Array also known as ArrayList or Resizable Array .
 * @param <E> The type of data to be stored in the array
 */
public class DynamicArray<E> implements Iterable<E> {
    private int capacity;
    private int length;
    private E[] arr;

    /**
     * Resizes the array to be twice the size.
     */
    private void resize() {
        this.capacity *= 2;
        E[] newArr = (E[]) new Object[this.capacity];
        for (int i = 0 ; i < arr.length ; i++){
            newArr[i]= arr[i];
        }
        this.arr = newArr;
    }

    /**
     * Default Constructor.
     */
    public DynamicArray() {
        this(8);
    }

    /**
     * Constructor.
     * @param capacity the initial capacity of the array
     */
    public DynamicArray(int capacity){
        if (capacity < 0) throw new IllegalArgumentException("Capacity cannot be below 0!");

        this.capacity=capacity;
        this.length=0;
        arr = (E[]) new Object[capacity];
    }

    /**
     * Gets te element at the given index.
     * @param index the index to retrieve
     * @return element at index
     */
    public E get(int index) {
        return arr[index];
    }

    /**
     * Inserts element at a given index.
     * @param index the index to insert at
     * @param value the element to insert
     */
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

    /**
     * Adds element to the end of the array.
     * @param value the element to insert
     */
    public void append(E value) {
        if  (this.length == capacity - 1) resize();

        arr[this.length] = value;
        this.length++;
    }

    /**
     * Returns the index of the given element.
     * @param value the element to search for
     * @return the index of value in the array if it is present, -1 otherwise
     */
    public int search(E value) {
        for (int i = 0 ; i < this.length ; i++) {
           if (arr[i].equals(value)) return i;
        }

        return -1;
    }

    /**
     * Determines if the element is present in the array or not.
     * @param value the value to search for
     * @return true if the element is present, false otherwise
     */
    public boolean contains(E value) {
        return search(value) != -1;
    }

    /**
     * Deletes the element if it is present in the array.
     * @param value the element to delete
     */
    public void delete(E value) {
        int deleteIndex = this.search(value);
        if (deleteIndex == -1) throw new IndexOutOfBoundsException();

        for (int i = deleteIndex ; i < this.length ; i++){
           arr[i] = arr[i+1];
        }

        this.length-=1;
    }

    /**
     * Determines the size of the array.
     * Size means the current potential capacity.
     * @return the size of the array
     */
    public int size() {
        return this.length;
    }

    /**
     * Determines if the array is empty or not.
     * @return true if the array is empty, false otherwise
     */
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
