import java.lang.reflect.Array;
import java.util.Arrays;

public class FIFOArray<Type> implements ICollection<Type> {

	private Type[] arr;
	private int counter = 0;
	
	@SuppressWarnings("unchecked")
	public FIFOArray (Class<Type> clazz) { 
		arr =  (Type[])Array.newInstance(clazz, 10);
	}
	
	@Override
	public Type pop() {
		if (isEmpty()) {
			System.out.println("Array is empty!");
		}
		Type s = arr[counter - 1];	
		arr[counter - 1] = null;
		counter--;
		
		if (arr.length >= counter + 5) {
			arr = Arrays.copyOfRange(arr, 0, counter);			
		}
		return s;
	}
	
	@Override
	public void push(Type s) {	
		if (counter == arr.length ) {
			arr = Arrays.copyOf(arr, arr.length + 10);
			for (int i = counter - 1; i >= 0 ; i--) {
				arr[i+1] = arr[i];
			}
			arr[0] = s;
		} else {
			for (int i = counter - 1; i >= 0 ; i--) {
				arr[i+1] = arr[i];
			}
			arr[0] = s;
		}
		counter++;
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
	private FIFOArray() {
		
	}	

}
