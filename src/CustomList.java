import java.util.Arrays;
import java.util.Collections;

public class CustomList {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private int[] elements;

    public CustomList() {
        this.elements = new int[DEFAULT_CAPACITY];
    }

    public boolean add(Integer e) {
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

    public boolean remove(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        int element = elements[index];
        int numElts = elements.length - (index + 1);
        System.arraycopy(elements, index + 1, elements, index, numElts);
        size--;
        for (int i = 0; i < size; i++) {
            elements[i] -= element;
        }
        return true;
    }

    private void ensureCapacity() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }

    @SuppressWarnings("unchecked")
    public int get(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return elements[index];
    }

    public int min() {
        Integer[] list = new Integer[size];
        for (int i = 0; i < size; i++) {
            list[i] = elements[i];
        }
        return Collections.min(Arrays.asList(list));
    }

    public int max() {
        Integer[] list = new Integer[size];
        for (int i = 0; i < size; i++) {
            list[i] = elements[i];
        }
        return Collections.max(Arrays.asList(list));
    }

    public double avg() {
        double avg = 0.0;
        for (int i = 0; i < size; i++) {
            avg += elements[i];
        }
        return avg / size;
    }

    @Override
    public String toString() {
        int[] list = new int[size];
        System.arraycopy(elements, 0, list, 0, size);
        return Arrays.toString(list);
    }
}
