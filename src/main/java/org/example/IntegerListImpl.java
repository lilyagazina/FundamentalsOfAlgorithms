package org.example;


import org.example.exception.ElementNotFoundException;
import org.example.exception.InvalidArgumentException;
import org.example.exception.ListIndexOutOfBoundsException;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {
    private Integer[] elements;
    private int size;

    public IntegerListImpl(int initSize) {
        elements = new Integer[initSize];
        size = 0;
    }


    public void IntegerListImpl(Integer... args) {
        elements = new Integer[args.length];
        System.arraycopy(args, 0, elements, 0, args.length);
        size = elements.length;
    }

    @Override
    public Integer add(Integer item) {
        if (size == elements.length) {
            resize(size + 1);
        }
        elements[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkBounds(index);
        if (size == elements.length) {
            resize(size + 1);
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkBounds(index);
        elements[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        checkBounds(index);
        Integer result = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        return result;
    }

    @Override
    public boolean contains(Integer item) {
        sort();
        return search(item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkBounds(index);
        return elements[index];
    }

    @Override
    public boolean equals(IntegerList other) {
        if (other == null) {
            throw new InvalidArgumentException();
        }
        if (size != other.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(elements[i], other.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] array = new Integer[size];
        System.arraycopy(elements, 0, array, 0, size);
        return array;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                result.append(", ");
            }
            result.append(elements[i]);
        }
        result.append("]");
        return result.toString();
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new ListIndexOutOfBoundsException();
        }
    }

    private void resize(int newSize) {
        int initSize = size * 2;
        initSize = Math.max(initSize, newSize);
        Integer[] newData = new Integer[initSize];
        System.arraycopy(elements, 0, newData, 0, size);
        elements = newData;
    }

    private void sort() {
        int in, out;
        for (out = 1; out < size; out++) {
            Integer temp = elements[out];
            in = out;
            while (in > 0 && elements[in - 1] >= temp) {
                elements[in] = elements[in - 1];
                in--;
            }
            elements[in] = temp;
        }
    }

    private boolean search(Integer item) {
        int t = 0;
        int d = size - 1;
        while (t <= d) {
            int mid = t + (d - t) / 2;
            if (elements[mid].compareTo(item) == 0) {
                return true;
            } else if (elements[mid].compareTo(item) < 0) {
                t = mid + 1;
            } else {
                d = mid - 1;
            }
        }
        return false;
    }
}


