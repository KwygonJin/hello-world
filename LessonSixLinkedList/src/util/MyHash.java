package util;

import java.lang.reflect.Array;

public class MyHash<T> implements IMyCollections<T> {
	private T[] arr;
	private int counter = 0;
	
	@SuppressWarnings("unchecked")
	public MyHash (Class<T> clazz, int count) { 
		arr = (T[])Array.newInstance(clazz, count);
	}
	
	@Override
	public boolean add(T t) {
		int objHash = t.hashCode();
		arr[getRightHash(objHash)] = t;
		counter++;
		return true;
	}

	@Override
	public void remove(T t) {
		int objHash = t.hashCode();
		if (this.contains(t)) { 
			arr[getRightHash(objHash)] = null;
			counter--;		
		}
	}

	@Override
	public boolean contains(T t) {
		return arr[getRightHash(t.hashCode())] == t;
	}

	@Override
	public T get(int position) {
		return arr[getRightHash(position)];
	}
	//не повтор€ютс€ цифры
	//не начинаетс€ с нул€
	//четыре знака
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
		for (int i = 0; i < arr.length; i++) 
			arr[i] = null;
		counter = 0;
	}
	
	private int getRightHash(int objHash) {
		if (objHash >= arr.length - 1) {
			objHash  = objHash - arr.length/2;
			return getRightHash(objHash);
		} else
			return objHash;
	}
}
