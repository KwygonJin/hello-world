package com.myThreadsLists;

import java.util.*;

public class ArrayListGame<T> {
	private int counter;
	private List<T> arrayList;
		
	public ArrayListGame(int size) { 
		this.arrayList = new ArrayList<T>(size);
	}

	public synchronized int size() {
		return counter;
	}
	
	public synchronized void producer(T t) throws InterruptedException {					
		arrayList.add(t);
		counter += 1;
		System.out.println("Add element " + arrayList);
	}
	
	public synchronized void consumer(int t) throws InterruptedException {	
		arrayList.remove(t);
		counter -= 1;
		System.out.println("Remove element "+arrayList);		
	}
}

