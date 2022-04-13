package com.epam.training.hw_10;

public class ArrayWrapper<T> {

    private final T[] array;

    public ArrayWrapper(T[] array) {
        this.array = array;
    }

    public T get(int i) {
        try {
            return array[--i];
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new IncorrectArrayWrapperIndex();
        }
    }

    public boolean replace(int index, T newElement) {
        if (newElement instanceof Integer && (Integer) array[index] < (Integer) newElement) {
            array[--index] = newElement;
        } else if (newElement instanceof String &&
                array[index].toString().length() < ((String) newElement).length()) {
            array[--index] = newElement;
        }
        return array[index].equals(newElement);
    }
}

