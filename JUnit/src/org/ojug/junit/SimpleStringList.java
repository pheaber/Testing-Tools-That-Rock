package org.ojug.junit;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SimpleStringList implements List<String> {

    private String[] data = new String[16];

    /* package */int count = 0;

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public boolean add(String element) {
        if (this.count == this.data.length) {
            // double the size, then copy the data to the new array
            String[] newData = new String[this.data.length * 2];
            System.arraycopy(this.data, 0, newData, 0, this.data.length);
            this.data = newData;
        }

        this.data[this.count++] = element;
        return false;
    }

    @Override
    public String get(int index) {
        if ((this.count == 0) || (index > this.count)) {
            throw new IndexOutOfBoundsException("Asking for too much: " + index);
        }

        return this.data[index];
    }

    public void calculate() {
        try {
            for (int x = 0; x < 5; x++) {
                System.out.println(x + ": I am thinking...");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Oh no! I was interrupted!");
        }
    }

    @Override
    public void add(int index, String element) {

    }

    @Override
    public boolean addAll(Collection<? extends String> collection) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Object element) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public int indexOf(Object element) {
        return 0;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public int lastIndexOf(Object element) {
        return 0;
    }

    @Override
    public ListIterator<String> listIterator() {
        return null;
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }

    @Override
    public boolean remove(Object element) {
        return false;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public String set(int index, String element) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] array) {
        return null;
    }

}
