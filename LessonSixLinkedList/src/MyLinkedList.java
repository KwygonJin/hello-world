import java.util.Iterator;

public class MyLinkedList<T> implements IMyCollections<T>, Iterable<T>{
	private Node first;
	private Node last;
	private int counter = 0;
	
	private class Node {
		T data;
		Node next;
		
		Node(T link) {
			data = link;
		}
	}
	
	@Override
	public boolean add(T t) {
		if (t == null)
			return false;
		
		Node node = new Node(t);
		if (first == null) {
			first = node;
			last = node;
		}
		last.next = node;
		last = node;		
		counter++;
			
		return true;	
	}

	@Override
	public void remove(T t) {
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
	public boolean contains(T t) {
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
	public T get(int position) {
		if (position >= counter) {
			System.out.println("Position mismath");
			return null;
		}
		if (position == 0)
			return first.data;
		if (position + 1 == counter) {
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
		return counter;
	}

	@Override
	public boolean isEmpty() {
		return counter == 0;
	}

	@Override
	public void clear() {
		first = null;
		last = null;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>();
	}
	
	private Node getRec(T baseT, Node currNode, Node prevNode) {
	     if (currNode == null)
	         return null; //��������� ����� ������
	     if (currNode.data.equals(baseT)) {
	    	prevNode.next = currNode.next;	
	    	counter--;
	     	if (baseT.equals(last.data))
				last = prevNode;
	     	return null;
	     }
	     return getRec(baseT, currNode.next, currNode);
	}
	
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
