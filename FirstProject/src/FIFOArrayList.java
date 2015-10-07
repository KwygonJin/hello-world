import java.util.*;

public class FIFOArrayList <Type> implements ICollection<Type> {
	private int capacity = 10;
	private ArrayList<Type> storage = new ArrayList<Type>(capacity);
	
	@Override
	public void push(Type element) {
		if (this.getSize() == 10) {
			this.storage.ensureCapacity(capacity += 10);
		}
		storage.add(0, element);
	}
	
	@Override
	public Type pop() {
		 return deleteFirst();
	}

	@Override
	public int getSize() {
		return storage.size();
	}
	
	@Override
	public boolean isEmpty() {
		return storage.isEmpty();
	}

	public String toString() {
		return storage.toString();
	}
	
	@SuppressWarnings("unused")
	private int getCapacity() {
		return capacity;
	}
	
	private Type deleteFirst() {
		Type s;
		try {
			s = storage.remove(getSize() == 0? 0 : getSize() - 1);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Array is empty!");
			s = null;
		}
		if (s != null && this.getSize() == capacity - 5) {
			this.storage.trimToSize();
		}
		
		return s;
	}
}
