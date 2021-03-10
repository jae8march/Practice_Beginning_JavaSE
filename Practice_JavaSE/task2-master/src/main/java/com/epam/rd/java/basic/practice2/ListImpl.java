package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl implements List,Iterable<Object> {
	
	private class DoubleNode {
		Object item;
		DoubleNode previous;
		DoubleNode next;
	}

	private int size;
	private DoubleNode first;
	private DoubleNode last;
	
	public boolean isEmpty() {
		return size == 0;
	}
	
    @Override
    public void clear() {
       // Just sth
    }

    @Override
    public int size() {
		return size;
    }

    public Iterator<Object> iterator() {
		return new IteratorImpl();
	}

	private class IteratorImpl implements Iterator<Object> {
		int index = 0;
		DoubleNode currentNode = first;

		@Override
		public boolean hasNext() {
			return index < size();
		}

		@Override
		public Object next() {
		    if(!hasNext()) {
				throw new NoSuchElementException();
			}
			Object item = currentNode.item;
			currentNode = currentNode.next;

			index++;

			return item;
		}

    }

	@Override
	public void addFirst(Object element) {
		DoubleNode oldFirst = first;

		first = new DoubleNode();
		first.item = element;
		first.next = oldFirst;

		if (oldFirst != null) {
			oldFirst.previous = first;
		}

		// If the list was empty before adding the new item:
		if (isEmpty()) {
			last = first;
		}

		size++;
	}
	
	@Override
	public void addLast(Object element) {
		DoubleNode oldLast = last;

		last = new DoubleNode();
		last.item = element;
		last.previous = oldLast;

		if (oldLast != null) {
			oldLast.next = last;
		}

		// If the list was empty before adding the new item:
		if (isEmpty()) {
			first = last;
		}

		size++;
	}

    @Override
    public void removeFirst() {
    	if (isEmpty()) {
			return;
		}
		

		if (first.next != null) {
			first.next.previous = null;
		} else { // There is only 1 element in the list
			last = null;
		}
		
		first = first.next;

		size--;
		
	}

    @Override
    public void removeLast() {
    	if (isEmpty()) {
			return;
		}


		if (last.previous != null) {
			last.previous.next = null;
		} else { // There is only 1 element in the list
			first = null;
		}

		last = last.previous;

		size--;

	}

    @Override
    public Object getFirst() {
        return null;
    }

    @Override
    public Object getLast() {
        return null;
    }

    @Override
    public Object search(Object element) {
        return null;
    }

    @Override
    public boolean remove(Object element) {
        return false;
    }

    @Override
    public String toString() {
        return "";
    }

	public static void main(String[] args) {
		ListImpl d = new ListImpl();
		d.addFirst("a");
		d.addFirst("b");
		System.out.println(d.size);
		d.removeFirst();
		System.out.println(d.size);

	}
}
