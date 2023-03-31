package net.lubosovo.sortedLinkedList;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedLinkedList<T> {

    public SortedLinkedList() {
        comparator = (Comparator<T>) Comparator.naturalOrder();
        head = null;
    }

    public SortedLinkedList(Collection<? extends T> c) {
        this();
        List<? extends T> l = c.stream().collect(Collectors.toList());
        l.sort(comparator);
        Item<T> next = null;
        for (int i = l.size() - 1; i >= 0; --i) {
            Item<T> current = new Item<T>(l.get(i), next);
            next = current;
        }
        head = next;
    }

    int size() {
        int size = 0;
        Item<T> current = head;
        while (current != null) {
            ++size;
            current = current.next;
        }
        return size;
    }

    T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index negative");
        }
        Item<T> current = head;
        for (int i = 0; i < index; ++i) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index " + index + ", Size " + i);
            }
            current = current.next;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index " + index + ", Size " + index);
        }
        return current.value;
    }

    boolean contains(T value) {
        boolean contains = false;
        Item<T> current = head;
        while (current != null) {
            contains = value == null ? current.value == null : value.equals(current.value);
            if (contains) {
                break;
            }
            current = current.next;
        }
        return contains;
    }

    boolean add(T value) {
        Item<T> previous = null;
        Item<T> current = head;
        while (current != null && comparator.compare(current.value, value) <= 0) {
            previous = current;
            current = current.next;
        }
        if (previous != null) {
            current = new Item<T>(value, current);
            previous.next = current;
        } else {
            head = new Item<T>(value, head);
        }
        return true;
    }

    T remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index negative");
        }
        Item<T> previous = null;
        Item<T> current = head;
        for (int i = 0; i < index; ++i) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index " + index + ", Size " + i);
            }
            previous = current;
            current = current.next;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index " + index + ", Size " + index);
        }
        if (previous != null) {
            previous.next = current.next;
        } else {
            head = current.next;
        }
        return current.value;
    }

    private final Comparator<T> comparator; 
    private Item<T> head; 

    private static class Item<T> {
        T value;
        Item<T> next;

        Item(T value, Item<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
