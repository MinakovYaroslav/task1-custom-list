import java.util.Arrays;

public class IncrementalArrayList {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private int[] elements;

    IncrementalArrayList() {
        this.elements = new int[DEFAULT_CAPACITY];
    }

    boolean add(Integer e) {
        if (e == null) {
            return false;
        }
        if (size == elements.length) {
            ensureCapacity();
        }
        for (int i = 0; i < size; i++) {
            elements[i] += e;
        }
        elements[size++] = e;
        return true;
    }

    void remove(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        int element = elements[index];
        int numElts = elements.length - (index + 1);
        System.arraycopy(elements, index + 1, elements, index, numElts);
        size--;
        for (int i = 0; i < size; i++) {
            elements[i] -= element;
        }
    }

    private void ensureCapacity() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }

    @SuppressWarnings("unchecked")
    int get(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return elements[index];
    }

    int min() {
        if (elements.length == 0) throw new IllegalStateException("List is empty");
        int e = elements[0];
        if (size > 1) {
            for (int i = 1; i < size; i++) {
                e = e < elements[i] ? elements[i] : e;
            }
        }
        return e;
    }

    int max() {
        if (elements.length == 0) throw new IllegalStateException("List is empty");
        int e = elements[0];
        if (size > 1) {
            for (int i = 1; i < size; i++) {
                e = e > elements[i] ? elements[i] : e;
            }
        }
        return e;
    }

    double avg() {
        double avg = 0.0;
        for (int i = 0; i < size; i++) {
            avg += elements[i];
        }
        return avg / size;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
