package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Stack {

	   private int maxSize=100;        // size of stack array
	   private Object[] stackArray=new Object[maxSize];
	   private int top=-1;
	   int nNumbers;
	
		@Override
		public void clear() {
			for (int i = 0; i < stackArray.length - 1; i++)
				stackArray[i] = null;
			nNumbers = 0;
		}

		@Override
		public int size() {
			return nNumbers;
		}

		public Iterator<Object> iterator() {
			return new IteratorImpl();
		}

		private class IteratorImpl implements Iterator<Object> {
			private int index;

			@Override
			public boolean hasNext() {
				return (index < nNumbers);

			}
			

			@Override
			public Object next(){
			    if(!hasNext()) {
				throw new NoSuchElementException();
			}
				return stackArray[index++];
			}

		}

		@Override
		public void push(Object element) {
			stackArray[++top] = element;
			nNumbers++;
		}

		@Override
		public Object pop() {
			if (nNumbers == 0) {
				return null;
			}
			--nNumbers;
			return stackArray[top--];

		}

		@Override
		public Object top() {
			if (nNumbers == 0) {
				return null;
			}
			return stackArray[top];
		}

		@Override
		public String toString() {

			StringBuilder val = new StringBuilder();
			for (int i = 0; i < this.nNumbers; i++) {
				val.append(stackArray[i]).append(", ");

			}
			if (this.nNumbers > 0) {
				val.delete(val.length() - 2, val.length());
			}

			return "[" + val + "]";
		}

		public static void main(String[] args) {
			StackImpl s = new StackImpl();
			s.push(2);
			s.push(1);
			s.push(5);
			s.push(10);
			System.out.println(s.top());
			System.out.println(s.pop());

			System.out.println(s.size());

			Iterator<?> iterator = s.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next().toString());
			}
		}

	}
