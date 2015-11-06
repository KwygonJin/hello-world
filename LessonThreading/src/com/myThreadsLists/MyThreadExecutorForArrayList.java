package com.myThreadsLists;

public class MyThreadExecutorForArrayList {
	public static void main(String[] args) {
		int arrLength = 10;
		ArrayListGame<Integer> game = new ArrayListGame<Integer>(arrLength);
		//ArrayList<Integer> arrayList = new ArrayList<Integer>();

		Thread threadProducer = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					game.producer(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		threadProducer.setPriority(Thread.MAX_PRIORITY);
		threadProducer.start();

		Thread threadConsumer = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					game.consumer(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		threadConsumer.setPriority(Thread.MIN_PRIORITY);
		threadConsumer.start();

		for (int i = 6; i < 100; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						game.producer(7);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
}
