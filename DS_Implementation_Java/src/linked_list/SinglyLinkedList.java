package linked_list;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

public class SinglyLinkedList<E> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
       private E data;
       private Node next;

       public Node(E data) {
          this.data = data;
          this.next = null;
       }

      public E getData() {
        return this.data;
      }

      public Node next() {
          return this.next;
      }

      public boolean hasNext() {
         return this.next() != null;
      }

      public void setNext(Node n) {
           this.next = n;
      }
    }

    // Constructor
    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Public Methods
    public void insertAtHead(E value) {
        this.size++;
        Node newNode = new Node(value);

        if (this.head == null) {
           this.head = newNode;
           this.tail = this.head;
           return;
        }

        Node tmp = this.head;
        this.head = newNode;
        this.head.next = tmp;
    }

    public E removeAtHead() {
        if (this.head == null) return null;

        this.size--;

        E data = this.head.data;
        this.head = this.head.next;
        if (this.head == null) this.tail = null;
        return data;
    }

    public E removeAtTail() {
        if (this.tail == null) return null;
        if (this.head == null) return null;

        this.size--;

        Node trav = head;
        while(trav != null && trav.next != tail) trav = trav.next;
        this.tail = trav;
        if (this.tail == null) {
            this.head = null;
            return null;
        }

        E data = this.tail.next.data;
        this.tail.next = null;
        return data;
    }

    public void insertAtTail(E value) {
        this.size++;

        Node newNode = new Node(value);

        if (this.tail == null) {
            this.head = newNode;
            this.tail = this.head;
            return;
        }

        this.tail.next = newNode;
        this.tail = newNode;
    }

    public E search(E value) {
       Node trav = head;
       while (trav != null){
           if (trav.data.equals(value))
               return trav.data;

           trav = trav.next;
       }

       return null;
    }

    public E removeByValue(E value){
         Node trav = head;
         boolean found = false;
         while(trav.next != null){
             if (trav.next.data.equals(value)) {
                 found = true;
                 break;
             }
             trav = trav.next;
         }

         if (!found) return null;

         if (trav == this.tail)
             return removeAtTail();
        if (trav == this.head)
            return removeAtHead();

        this.size--;

        Node tmp = trav.next;
        trav.next = trav.next.next;
        return tmp.data;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
       StringBuilder sb = new StringBuilder();
       Node tmp = head;

       while (tmp != null && tmp.hasNext()) {
          sb.append("[" + tmp.data + "] -> " );

          tmp=tmp.next;
        }
       if (tmp != null)
        sb.append("[" + tmp.data + "] -> null");

       sb.append("\nsize: " + this.size);

       return sb.toString();
    }

    public E getHead() {
        return this.head.data;
    }

    public E getTail() {
        return this.tail.data;
    }

    //@Override
//    public Iterator<E> iterator() {
//        return new java.util.Iterator<E>() {
//            public boolean hasNext() {
//                return trav.next != null;
//            }
//
//            public E next() {
//                trav = trav.next;
//                return trav.data;
//            }
//        };
//    }

}
