package com.myThreadsLists;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class MyLinkedList<T> implements IMyCollections<T>, Iterable<T>{
	private Node first;
	private Node last;
	private AtomicInteger counter = new AtomicInteger(0);
	
	private class Node {
		T data;
		Node next;
		
		Node(T link) {
			data = link;
		}
	}
	
	@Override
	public synchronized boolean add(T t) {
		if (t == null)
			return false;
		
		Node node = new Node(t);
		if (first == null) {
			first = node;
			last = node;
		}
		last.next = node;
		last = node;		
		counter.getAndIncrement();
			
		return true;	
	}

	@Override
	public synchronized void remove(T t) {
		if (t == null)
			return;	
		if (first == null)
			return;
		
		if (t.equals(first.data)) {
			first = first.next;
			return;
		}

		getRec(t, first, first);
	}

	@Override
	public synchronized boolean contains(T t) {
		Node temp = first;
		boolean cont = false;
		while(temp != null) {
			if (temp.data.equals(t)) {				
				cont = true;
				break;
			}
			temp = temp.next;
		}
		return cont;
	}
	
	@Override
	public synchronized T get(int position) {
		if (position >= counter.intValue()) {
			System.out.println("Position mismath");
			return null;
		}
		if (position == 0)
			return first.data;
		if (position + 1 == counter.intValue()) {
			return last.data;
		}
		
		Node temp = first;		
		int count = 0;
		
		while(count != position) {
			temp = temp.next;
			count++;
		}	
		
		return temp.data;
	}

	@Override
	public int size() {
		return counter.intValue();
	}

	@Override
	public boolean isEmpty() {
		return counter.intValue() == 0;
	}

	@Override
	public synchronized void clear() {
		first = null;
		last = null;
	}

	@Override
	public synchronized Iterator<T> iterator() {
		return new MyIterator<T>();
	}
	
	private Node getRec(T baseT, Node currNode, Node prevNode) {
	     if (currNode == null)
	         return null; //проверяем конец списка
	     if (currNode.data.equals(baseT)) {
	    	prevNode.next = currNode.next;	
	    	counter.decrementAndGet();
	     	if (baseT.equals(last.data))
				last = prevNode;
	     	return null;
	     }
	     return getRec(baseT, currNode.next, currNode);
	}
	
	@SuppressWarnings("hiding")
	private class MyIterator<T> implements Iterator<T> {
		public Node nextIt;

	    public boolean hasNext() {
	    	return (nextIt != null || first != null) && nextIt != last;
	    }

	    @SuppressWarnings("unchecked")
		public T next() {
	    	if (nextIt == null) {
		    	nextIt = first;
		    	T cur = (T) nextIt.data;
				return cur;	    		
	    	} else {
		    	nextIt = nextIt.next;
		    	T cur = (T) nextIt.data;
				return cur;
	    	}
	    }

	    public void remove() {
			if (nextIt == null) {
				return;
			}	
			
			if (nextIt.data == null) {
				System.out.println("null argument remove");
				return;
			}		
			
			if (nextIt == first) {
				first = first.next;
				return;
			}
			
			getRec(nextIt.data, first, first);
			    
	    }
		 
	}
}
