package Behavioral.Iterator;


import java.util.ArrayList;

interface InterableCollection {
   Iterator createIterator();
}

interface Iterator {
   int getNext();
   boolean hasNext();
}

class Array implements InterableCollection {
    int[] list;

    public Array(int... numbers) {
       this.list = numbers;
    }

    @Override
    public Iterator createIterator() {
        return new ArrayIterator(list);
    }

}

class ArrayIterator implements Iterator{
    private int[] cache;
    private int index;

    public ArrayIterator(int[] array) {
       this.cache = array;
       index = 0;
    }

    @Override
    public int getNext() {
        if (hasNext())
            return cache[index++];
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean hasNext() {
        return index < cache.length ? true : false;
    }
}
class Client {
    public static void main(String args[]) {
        Array numbers = new Array(1,2,3,4,5,6,7,8,9,10);
        Iterator numbersIterator = numbers.createIterator();
        while (numbersIterator.hasNext()) {
            System.out.println(numbersIterator.getNext());
        }
    }
}
