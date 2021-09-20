package com.mycompany.myapp;

import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        TwoWayList<Integer> list = new TwoWayList<>();
        list.addLast(4);
        list.addFirst(5);
        list.addFirst(7);
        list.addFirst(6);
        list.addLast(8);
        list.addLast(10);
        list.removeByValue(7);
        list.removeFirst();
        list.removeLast();
        list.addValueAt(1, 9);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        System.out.println();

        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasPrevious())
            System.out.println(listIterator.previous());

        System.out.println();
        System.out.println(list.getSize());
    }
}
