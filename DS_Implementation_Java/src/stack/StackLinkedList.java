package stack;

import linked_list.SinglyLinkedList;

public class StackLinkedList<E> {
    private SinglyLinkedList<E> list;

    public StackLinkedList() {
       list = new SinglyLinkedList<>();
    }

    public void push(E element){
        list.insertAtHead(element);
    }

    public E pop() {
        return list.removeAtHead();
    }

    public E peek() {
       return list.getHead();
    }

    public E search(E element) {
        return list.search(element);
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
