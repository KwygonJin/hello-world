import java.util.Iterator;

public class MyLinkedList<T> implements IMyCollections<T>, Iterable<T>{
	private Node first;
	private Node last;
	private int counter = 0;
	
	public class Node {
		private T data;
		Node next;
		
		Node(T link) {
			data = link;
		}
		
		public void set(T t) {
			this.data = t;
		}
		
		public T get() {
			return data;
		}
	}
	
	@Override
	public boolean add(T t) {
		// TODO Auto-generated method stub
		if (t == null) {
			return false;
		} else {
			Node node = new Node(t);
			if (first == null) {
				first = node;
				last = node;
			} else if (last != null) {
				last.next = node;
				last = node;
			}
			
			counter++;
			return true;	
		}
	}

	@Override
	public void remove(T t) {
		// TODO Auto-generated method stub
		if (t == null) {
			System.out.println("null argument remove");
			return;
		}		
		
		if (first == null) {
			return;
		}
		
		if (t.equals(first.data)) {
			first = first.next;
			return;
		}
		
		Node temp = first;
		Node tempPrev = first; 

		while(temp != null) {
			if (temp.get().equals(t)) {
				tempPrev.next = temp.next;				
				counter--;
				if (t.equals(last.data)) {
					last = tempPrev;
				}
				break;				
			}
			tempPrev = temp;
			temp = temp.next;
		}
	}

	@Override
	public boolean contains(T t) {
		// TODO Auto-generated method stub
		Node temp = first;
		boolean cont = false;
		while(temp != null) {
			if (temp.get().equals(t)) {				
				cont = true;
				break;
			}
			temp = temp.next;
		}
		return cont;
	}

	@Override
	public T get(int position) {
		// TODO Auto-generated method stub
		if (position >= counter) {
			System.out.println("Position mismath");
			return null;
		}
		
		if (position == 0) {
			return first.get();
		}
		
		if (position + 1 == counter) {
			return last.get();
		}
		
		Node temp = first;		
		int count = 0;
		
		while(count != position) {
			temp = temp.next;
			count++;
		}	
		
		return temp.get();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return counter;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return counter == 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		first = null;
		last = null;
		
		Node temp = first;
		
		while(temp != null) {
			temp = temp.next;
			temp = null;
		}	
		counter = 0;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator<T>();
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
		    	T cur = (T) nextIt.get();
				return cur;	    		
	    	} else {
		    	nextIt = nextIt.next;
		    	T cur = (T) nextIt.get();
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
			
			if (first == null) {
				return;
			}
			
			if (nextIt == first) {
				first = first.next;
				return;
			}
			
			Node temp = first;
			Node tempPrev = null; 

			while(temp != null) {
				if (temp.get().equals(nextIt.data)) {
					if (tempPrev != null) {
						tempPrev.next = temp.next;
					}
					if (nextIt.equals(last)) {
						last = tempPrev;
					}
					//nextIt = temp.next;
					counter--;
					break;				
				}
				tempPrev = temp;
				temp = temp.next;
			}        
	    }
	    
	}
}
