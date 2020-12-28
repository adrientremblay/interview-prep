package queue;

import linked_list.SinglyLinkedList;

public class QueueSLL<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<E>();

    public void enqueue(E value) {
       list.insertAtTail(value);
    }

    public E dequeue() {
        return list.removeAtHead();
    }

    public E peek() {
       return list.getHead();
    }

    public boolean contains(E value) {
        return list.search(value) != null;
    }

    public void remove(E value){
        list.removeByValue(value);
    }

    @Override
    public String toString() {
        return list.toString();
   }
}
