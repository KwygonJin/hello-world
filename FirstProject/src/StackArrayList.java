import java.util.*;

public class StackArrayList<Type> implements ICollection<Type> {
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
	
	@Override
	public String toString() {
		return storage.toString();
	}
	
	@SuppressWarnings("unused")
	private int getCapacity() {
		return capacity;
	}
	
	private Type deleteFirst() {
		Type s = storage.remove(0);
		if (this.getSize() == capacity - 5) {
			this.storage.trimToSize();
		}
		return s;
	}
}
