package myThreads;

public class MyThreadExecutorForString {
	public static void main(String[] args) {
		StringGame game = new StringGame("I have a bad day today");		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					while (!game.isFinish())
						game.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					while (!game.isFinish())
						game.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
		}).start();
		

	}
	
}
