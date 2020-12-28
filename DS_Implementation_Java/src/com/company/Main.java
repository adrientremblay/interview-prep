package com.company;

import array.DynamicArray;
import linked_list.SinglyLinkedList;
import stack.StackLinkedList;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        StackLinkedList<Integer> stack = new StackLinkedList<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.search(2));
        System.out.println(stack);
    }
}
