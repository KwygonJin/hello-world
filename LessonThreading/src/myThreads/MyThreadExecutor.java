package myThreads;

public class MyThreadExecutor {

	public static void main(String[] args) {
		
		//PingPong game
		PingPongGame game = new PingPongGame();		
		new Thread(new Runnable() {
				
			@Override
			public void run() {
				try {
					game.doPing();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					game.doPong();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
		}).start();

	}
	
}

