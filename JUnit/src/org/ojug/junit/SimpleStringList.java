package org.ojug.junit;

public class SimpleStringList {

    private String[] data = new String[16];

    /* package */int count = 0;

    public boolean isEmpty() {
        return this.count == 0;
    }

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

        System.out.println("I finished thinking");
    }

}
