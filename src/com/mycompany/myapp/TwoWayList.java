package com.mycompany.myapp;

import java.util.Iterator;
import java.util.ListIterator;

public class TwoWayList<T> implements Iterable<T> {

    private ListItem<T> head;
    private ListItem<T> tail;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public TwoWayList() {
        head = null;
        tail = null;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public void addFirst(T elem) {
        ListItem<T> listItem = new ListItem<T>(elem);
        size++;
        if (isEmpty())
            tail = listItem;
        else
            head.setPrev(listItem);
        listItem.setNext(head);
        head = listItem;

    }

    public void addLast(T elem) {
        ListItem<T> listItem = new ListItem<T>(elem);
        size++;
        if (isEmpty()) {
            head = listItem;
        } else
            tail.setNext(listItem);
        listItem.setPrev(tail);
        tail = listItem;
    }

    public void addValueAt(int index, T value) {
        ListItem<T> cur = head;
        size++;
        int i = 0;
        while (cur != null && i != index) {
            cur = cur.getNext();
            i++;
        }
        ListItem<T> temp = new ListItem<>(value);
        cur.getPrev().setNext(temp);
        temp.setPrev(cur.getPrev());
        cur.setPrev(temp);
        temp.setNext(cur);
    }

    public void removeFirst() {
        ListItem<T> temp = head;
        if (head.getNext() == null)
            tail = null;
        else {
            head.getNext().setPrev(null);
        }
        head = head.getNext();
        size--;
    }

    public void removeLast() {
        if (head.getNext() == null)
            head = null;
        else {
            tail.getPrev().setNext(null);
        }
        tail = tail.getPrev();
        size--;
    }

    public void removeByValue(T value) {
        ListItem<T> cur = head;
        while (cur.getValue() != value) {
            cur = cur.getNext();
            if (cur == null)
                return;
        }
        if (cur == head)
            removeFirst();
        else
            cur.getPrev().setNext(cur.getNext());
        if (cur == tail)
            removeLast();
        else
            cur.getNext().setPrev(cur.getPrev());
        size--;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            ListItem<T> cur = head;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public T next() {
                T value = cur.getValue();
                cur = cur.getNext();
                return value;
            }
        };
    }

    public ListIterator<T> listIterator() {
        return new ListIterator<T>() {
            ListItem<T> temp = tail;

            @Override
            public boolean hasPrevious() {
                return temp != null;
            }

            @Override
            public T previous() {
                T value = temp.getValue();
                temp = temp.getPrev();
                return value;
            }

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(T t) {

            }

            @Override
            public void add(T t) {

            }
        };
    }
}
