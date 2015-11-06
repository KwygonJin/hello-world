package com.myThreadsLists;

import java.util.Iterator;

public class MyThreadExecutorLinkedList {
	public static void main(String[] args) {

		MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();

		Thread threadProducer = new Thread(new Runnable() {

			@Override
			public void run() {
				linkedList.add(5);
				System.out.println("add " + linkedList);
				System.out.println("size " + linkedList.size());				
			}
		});

		threadProducer.setPriority(Thread.MAX_PRIORITY);
		threadProducer.start();

		Thread threadConsumer = new Thread(new Runnable() {

			@Override
			public void run() {
				linkedList.remove(5);
				System.out.println("remove " + linkedList);
				System.out.println("size after remove " + linkedList.size());			
			}
		});

		threadConsumer.setPriority(Thread.MIN_PRIORITY);
		threadConsumer.start();

		for (int i = 6; i < 100; i++) {
			if (i == 10) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						for (Iterator<Integer> itForEach = linkedList.iterator(); itForEach.hasNext();) {
						System.out.println("Show: " + itForEach.next());
						itForEach.remove();			
					}
					}
				}).start();				
			} else {		
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						linkedList.add(8);
						System.out.println("add in cycle " + linkedList);
						System.out.println("size in cycle " + linkedList.size());
					}
				}).start();
			}
		}
	}
}
