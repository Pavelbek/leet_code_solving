package pargunov.other;

import java.util.Objects;

public class MyArrayList<T> implements MyList<T> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private Object[] arr;
    private int size;

    public MyArrayList(int initCapacity) {
        if (initCapacity < 0) {
            throw new IllegalArgumentException();
        }
        arr = new Object[initCapacity];
    }

    public MyArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    @Override
    public void add(T element) {
        resizeIfNeeded();
        arr[size++] = element;
    }

    @Override
    public void add(int index, T element) {
        Objects.checkIndex(index, size);
        resizeIfNeeded();
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = element;
    }

    @Override
    public void set(int index, T element) {

    }

    @Override
    @SuppressWarnings("Unchecked cast")
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) arr[index];
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    private void resizeIfNeeded() {
        if (size == arr.length) {
            Object[] newArr = new Object[arr.length * 2];
            System.arraycopy(arr, 0, newArr, 0, size);
            arr = newArr;
        }
    }
}
