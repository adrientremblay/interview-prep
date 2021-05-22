package FinalExam;
// QArray - Queue implemented as a circular list using an integer array.

class QArray {
    final int capacity;
    private int tail;
    int head, count;
    int[] q;

    public QArray(int capacity) {
        this.capacity = capacity;
        init();
    }

    private void init() {
        q = new int[capacity];
        head = tail = count = 0;
    }

    public int getCount() {
        return count;
    }

    // Add to tail
    public void add(int id) {
        q[tail] = id;
        tail = (tail + 1) % capacity;
        ++count;
    }

    // Remove from head
    public int remove() {
        int id = q[head];
        head = (head + 1) % capacity;
        --count;
        return id;
    }
}

// QNode - Queue implemented in a linked list using nodes.

class Node {
    Node(int id, Node next) {
        this.id = id;
        this.next = next;
    }
    int id;
    Node next;
}

class QNode {
    final int capacity;
    int  count;
    Node head, tail;

    public QNode(int capacity) {
        this.capacity = capacity;
        init();
    }
    private void init() {
        count = 0;
        head = tail = null;
    }
    public int getCount() {
        return count;
    }
    // Add to tail
    public void add(int id) {
        if (tail == null) {
            tail = new Node(id, null);
            head = tail;
        } else {
            tail.next = new Node(id, head);
            tail = tail.next;
        }
        ++count;
    }
    // Remove from head
    public int remove() {
        int id = -1;
        if (head != null) {
            id = head.id;
            head = head.next;
            --count;
        }
        return id;
    }
}

// TestQueues - Test QArray and QNode queues

public class TestQueues {
    private static void print(QArray q) {
        int h = q.head;
        int c = q.count;

        System.out.print("[ ");
        while (c > 0) {
            System.out.print(q.q[h]); System.out.print(' ');
            h = (h + 1) % q.capacity;
            --c;
        }
        System.out.print(']');
    }
    private static void print(QNode q) {
        Node h = q.head;
        int c = q.count;

        System.out.print("[ ");
        while (c > 0) {
            System.out.print(h.id); System.out.print(' ');
            h = h.next;
            --c;
        }
        System.out.print(']');
    }

    public static void main(String[] args) {
        System.out.println("Test class QArray:");
        System.out.println("[ ][ 1 2 3 4 ]1234[ ]");

        QArray q = new QArray(4);
        print(q);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        print(q);
        System.out.print(q.remove());
        System.out.print(q.remove());
        System.out.print(q.remove());
        System.out.print(q.remove());
        print(q);
        System.out.println();

        System.out.println("Test class QNode:");
        System.out.println("[ ][ 1 2 3 4 ]1234[ ]");

        QNode qn = new QNode(4);
        print(qn);
        qn.add(1);
        qn.add(2);
        qn.add(3);
        qn.add(4);
        print(qn);
        System.out.print(qn.remove());
        System.out.print(qn.remove());
        System.out.print(qn.remove());
        System.out.print(qn.remove());
        print(qn);
        System.out.println();
    }
}
/* Output:

Test class QArray:
[ ][ 1 2 3 4 ]1234[ ]
[ ][ 1 2 3 4 ]1234[ ]
Test class QNode:
[ ][ 1 2 3 4 ]1234[ ]
[ ][ 1 2 3 4 ]1234[ ]
*/
