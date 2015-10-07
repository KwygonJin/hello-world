import java.lang.reflect.Array;
import java.util.Arrays;

public class StackArray<Type> implements ICollection<Type> {
	private Type[] arr;
	private int counter = 0;
	
	@SuppressWarnings("unchecked")
	public StackArray (Class<Type> clazz) { 
		arr =  (Type[])Array.newInstance(clazz, 10);
	}
	
	@Override
	public Type pop() {
		if (isEmpty()) {
			System.out.println("Array is empty!");
		}
		Type s = arr[0];	
		counter--;
		
		if (arr.length >= counter + 5) {
			@SuppressWarnings("unchecked")
			Type[] arrNew = (Type[])Array.newInstance(s.getClass(), counter);
			for (int i = 1; i <= counter; i++) {
				arrNew[i - 1] = arr[i];
			}
			arr = arrNew;			
		} else {
			for (int i = 1; i < arr.length; i++) {
				arr[i - 1] = arr[i];
			}				
		}
		return s;
	}
	
	@Override
	public void push(Type s) {	
		counter++;
		if (counter == arr.length ) {
			@SuppressWarnings("unchecked")
			Type[] arrNew = (Type[])Array.newInstance(s.getClass(), arr.length + 10);
			for (int i = 0; i < arr.length; i++) {
				arrNew[i+1] = arr[i];
			}
			arrNew[0] = s;
			arr = arrNew;
		} else {
			for (int i = counter - 2; i >= 0 ; i--) {
				arr[i+1] = arr[i];
			}
			arr[0] = s;
		}
	}
	
	@Override
	public int getSize() {
		return counter;
	}
	
	@Override
	public boolean isEmpty() {
		if (counter == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return Arrays.toString(arr);
	}
	
	@SuppressWarnings("unused")
	private StackArray() {
		
	}	
}
