package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ArrayImpl.
 */
public class ArrayImpl implements Array {
	private int count;
	private Object[] array;

	ArrayImpl(int s) {
		array = new Object[s];
	}

	@Override
	public int size() {
		return toArray().length;
	}

	@Override
	public void add(Object element) {
		Object[] array2 = new Object[array.length + 1];
		System.arraycopy(array, 0, array2, 0, array.length);
		array2[array2.length - 1] = element;
		array = array2;
		count++;
	}

	@Override
	public void set(int index, Object element) {
		array[index] = element;
	}

	@Override
	public Object get(int index) {
		return array[index];
	}

	@Override
	public int indexOf(Object element) {
		int value = -1;
		for (int i = 0; i < array.length; ++i) {
			if (element == array[i]) {
				value = i;
				return value;
			}
		}
		return value;
	}

	@Override
	public void remove(int index) {
		Object[] array2 = new Object[array.length - 1];
		System.arraycopy(array, 0, array2, 0, index);
		System.arraycopy(array, index + 1, array2, index, array2.length - index);
		array = array2;
	}

	@Override
	public void clear() {
		array = new Object[] {};
		count = 0;
	}

	public Object[] toArray() {
		return this.array.clone();
	}

	@Override
	public Iterator<Object> iterator() {
		return new IteratorImpl();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	private class IteratorImpl implements Iterator<Object> {
		private int currId;
		private int k = -1;
		private boolean current;
		private boolean flag = true;

		public boolean isNextOrPrevious() {
			return current;
		}

		public void setNextOrPrevious(boolean current) {
			this.current = current;
		}

		public boolean isFlag() {
			return flag;
		}

		@Override
		public boolean hasNext() {
			return (k < toArray().length - 1);
		}

		@Override
		public Object next() {
			if (k >= size()) {
				throw new NoSuchElementException();
			}
			flag = false;
			current = false;
			return toArray()[++k];
		}

		@Override
		public void remove() {
			if (k < 0) {
				throw new IllegalStateException();
			}
			ArrayImpl.this.remove(k);
			if (k < currId) {
				currId--;
			}
			k = -1;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < toArray().length; i++) {
			if (toArray()[i] == null) {
				sb.append("[" + "null" + "]");
				return sb.toString();
			}
			sb.append("").append(toArray()[i].toString()).append("");
			if (i != size() - 1) {
				sb.append(", ");
			}
		}
		return "[" + sb.toString() + "]";
	}

	public static void main(String[] args) {
		ArrayImpl a = new ArrayImpl(4);
		a.set(0, "A");

		a.set(1, "B");
		a.set(2, "C");
		a.set(3, null);
	
		System.out.println("===============");

		System.out.println(a.size());
		System.out.println("===============");

		System.out.println(a.indexOf("null"));


		for (Object o : a) {
			System.out.println(o.toString());
		}
	}
}
