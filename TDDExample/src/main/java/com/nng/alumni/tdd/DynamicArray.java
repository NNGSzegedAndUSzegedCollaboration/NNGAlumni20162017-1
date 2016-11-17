package hu.javadev.tdd.testingdemo;

import java.util.Arrays;

public class DynamicArray<E> {
	private static final int SIZE_STEP = 10;

	private Object[] elements;
	private int size;

	public DynamicArray() {
		elements = new Object[SIZE_STEP];
		size = 0;
	}

	public void add(E element) {
		if (size == elements.length) {
			elements = Arrays.copyOf(elements, elements.length + SIZE_STEP);
		}

		elements[size] = element;
		size++;
	}

	public E remove(int index) {
		E result = get(index);

		for (int i = index; i < size - 1; i++) {
			elements[i] = elements[i + 1];
		}

		size--;

		return result;
	}

	@SuppressWarnings("unchecked")
	public E get(int index) {
		if (size == 0) {
			throw new IllegalStateException("There are no elements available");
		}

		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Index must be between 0 and " + (size - 1) + ", got " + index);
		}

		return (E) elements[index];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

}
