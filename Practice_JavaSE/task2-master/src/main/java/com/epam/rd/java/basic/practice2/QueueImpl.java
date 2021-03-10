package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue {
	private final static int maxSize = 100;
	private final Object[] queArray = new Object[maxSize];
	private int front;
	private int rear;
	private int nNumbers;

	public QueueImpl() {
		front = 0;
		rear = -1;
		nNumbers = 0;

	}

	@Override
	public void clear() {
		for (int i = 0; i < queArray.length - 1; i++)
			queArray[i] = null;
		nNumbers = 0;
	}

	@Override
	public int size() {
		if (nNumbers == -1) {
			return 0;
		}
		return nNumbers;
	}

	public Iterator<Object> iterator() {
		return new IteratorImpl();
	}

	private class IteratorImpl implements Iterator<Object> {
		private int index=1;

		@Override
		public boolean hasNext() {
			return index < nNumbers;
		

		}

		@Override
		public Object next() {
		if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return queArray[index++];
		}

	}

	@Override
	public void enqueue(Object element) {
		if (rear == maxSize - 1) // deal with wraparound
			rear = -1;
		queArray[++rear] = element; // increment rear and insert
		nNumbers++;
		System.out.println("add:" + element);
	}

	@Override
	public Object dequeue() {
		Object temp = queArray[front++]; // get value and incr front
		if (front == maxSize) // deal with wraparound
			front = 0;
		nNumbers--; // one less item
		return temp;
	}

	@Override
	public Object top() {
		if (nNumbers == 0) {
			return null;
		}
		return queArray[front];
	}

	@Override
	public String toString() {
		StringBuilder val = new StringBuilder();
		for (int i = 0; i < this.nNumbers; i++) {
			val.append(queArray[i]).append(", ");

		}
		if (this.nNumbers > 0) {
			val.delete(val.length() - 2, val.length());
		}
		return "[" + val + "]";
	}

	public static void main(String[] args) {

		QueueImpl q = new QueueImpl();
		q.clear();
		q.enqueue(2);
		q.enqueue(8);
		q.enqueue(10);
		q.clear();
		q.dequeue();
		System.out.println(q.top());
		System.out.println(q.size());

		System.out.println("==========================");
		Iterator<?> iterator = q.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().toString());
		}

	}

}
