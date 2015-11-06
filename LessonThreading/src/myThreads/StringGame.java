package myThreads;

public class StringGame {
	private Object lock = new Object();
	private String word = "";
	private String oldString;
	private String newString = "";

	public StringGame(String newString) {
		this.oldString = newString;
	}
	
	public boolean isFinish () {
		synchronized (lock) {
			return oldString.isEmpty() && word.isEmpty();
		}
	}

	public void producer() throws InterruptedException {
		while(!oldString.isEmpty() || !word.isEmpty()) {
			synchronized (lock) {
				while (!word.isEmpty())
					lock.wait();
				if (oldString.indexOf(' ') == -1) {
					word = oldString;
					oldString = "";
					lock.notify();
				} else {
					word = oldString.substring(0, oldString.indexOf(' '));
					oldString = oldString.substring(oldString.indexOf(' ') + 1);
					System.out.println("Find verb");
					System.out.println("verb: " + word);
					System.out.println("oldString: " + oldString);
					lock.notify();
				}
			}
		}
	}
	
	public void consumer() throws InterruptedException {	
		while(!oldString.isEmpty() || !word.isEmpty()) {
			synchronized (lock) {
				while (word.isEmpty()) 
					lock.wait();
				newString = newString.concat(" ").concat(word); 
				word = "";	
				System.out.println("Cocat verb");
				System.out.println("verb: " + word);	
				System.out.println("newString: " + newString);
				lock.notify();	
			}
		}
	}
}

