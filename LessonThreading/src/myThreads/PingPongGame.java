package myThreads;

public class PingPongGame {
	Object o = new Object();
	volatile int state;
	final static int PONG = 1;
	final static int PING = 0;
	
	public void doPong() throws InterruptedException {
		while (true) {
			synchronized (o) {
				while (state == PING) {	
					o.wait();
				} 
				
				System.out.println("Pong");	
				state = PING;
				o.notify();
			}
		}
	}
	
	public void doPing() throws InterruptedException {
		while (true) {
			synchronized (o) {
				while (state == PONG) {	
					o.wait();
				} 
				
				System.out.println("Ping");	
				state = PONG;
				o.notify();		
			}		
		}
	}
}
