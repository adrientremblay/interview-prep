package hash_map;

import linked_list.SinglyLinkedList;

import java.util.Objects;

public class HashMap<K, V> {
    private SinglyLinkedList<V>[] map;

    public HashMap(int size) {
        this.map = new SinglyLinkedList[size];
    }

    private int hash(Object item) {
        return Objects.hashCode(item);
    }

    private int map(int hashCode) {
        return hashCode / this.map.length;
    }

}
