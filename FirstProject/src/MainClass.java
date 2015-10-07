
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Work with Stack through ArrayList
		ICollection<String> icollStackAL = new StackArrayList<String>();
		System.out.println("StackArrayList");
		System.out.println("Is empty " + icollStackAL.isEmpty());
		System.out.println("Add elements...");
		icollStackAL.push("1");
		icollStackAL.push("2");
		icollStackAL.push("3");
		icollStackAL.push("4");
		icollStackAL.push("5");
		icollStackAL.push("6");
		icollStackAL.push("7");
		icollStackAL.push("8");
		icollStackAL.push("9");
		icollStackAL.push("10");
		icollStackAL.push("11");
		System.out.println("Is empty " + icollStackAL.isEmpty());
		System.out.println(icollStackAL);
		System.out.println("Size: " + icollStackAL.getSize());
		System.out.println("Deleting elements...");
		System.out.println(icollStackAL.pop());
		System.out.println(icollStackAL.pop());
		System.out.println(icollStackAL.pop());
		System.out.println(icollStackAL.pop());
		System.out.println(icollStackAL.pop());
		System.out.println(icollStackAL.pop());
		System.out.println("Size: " + icollStackAL.getSize());
		System.out.println(icollStackAL);
		
		//Work with Stack through Array
		System.out.println("");
		System.out.println("");
		ICollection<String> icollStackA = new StackArray<String>(String.class);
		System.out.println("StackArray");
		System.out.println("Is empty " + icollStackA.isEmpty());
		System.out.println("Add elements...");
		icollStackA.push("1");
		icollStackA.push("2");
		icollStackA.push("3");
		icollStackA.push("4");
		icollStackA.push("5");
		icollStackA.push("6");
		icollStackA.push("7");
		icollStackA.push("8");
		icollStackA.push("9");
		icollStackA.push("10");
		icollStackA.push("11");
		System.out.println("Is empty " + icollStackA.isEmpty());
		System.out.println(icollStackA);
		System.out.println("Size: " + icollStackA.getSize());
		System.out.println(icollStackA.pop());
		System.out.println(icollStackA.pop());
		System.out.println(icollStackA.pop());
		System.out.println(icollStackA.pop());
		System.out.println(icollStackA.pop());
		System.out.println(icollStackA.pop());
		System.out.println("Size: " + icollStackA.getSize());
		System.out.println(icollStackA);		
		
		//Work with FIFO(or queue) through ArrayList
		System.out.println("");
		System.out.println("");
		ICollection<String> icollQueueAL = new FIFOArrayList<String>();
		System.out.println("QueueArrayList");
		System.out.println("Is empty " + icollQueueAL.isEmpty());
		System.out.println("Add elements...");
		icollQueueAL.push("1");
		icollQueueAL.push("2");
		icollQueueAL.push("3");
		icollQueueAL.push("4");
		icollQueueAL.push("5");
		icollQueueAL.push("6");
		icollQueueAL.push("7");
		icollQueueAL.push("8");
		icollQueueAL.push("9");
		icollQueueAL.push("10");
		icollQueueAL.push("11");
		System.out.println("Is empty " + icollQueueAL.isEmpty());
		System.out.println(icollQueueAL);
		System.out.println("Size: " + icollQueueAL.getSize());
		System.out.println("Deleting elements...");
		System.out.println(icollQueueAL.pop());
		System.out.println(icollQueueAL.pop());
		System.out.println(icollQueueAL.pop());
		System.out.println(icollQueueAL.pop());
		System.out.println(icollQueueAL.pop());
		System.out.println(icollQueueAL.pop());
		System.out.println("Size: " + icollQueueAL.getSize());
		System.out.println(icollQueueAL);				
		
		//Work with FIFO(or queue) through ArrayList
		System.out.println("");
		System.out.println("");
		ICollection<String> icollQueueA = new FIFOArray<String>(String.class);
		System.out.println("QueueArray");
		System.out.println("Is empty " + icollQueueA.isEmpty());
		System.out.println("Add elements...");
		icollQueueA.push("1");
		icollQueueA.push("2");
		icollQueueA.push("3");
		icollQueueA.push("4");
		icollQueueA.push("5");
		icollQueueA.push("6");
		icollQueueA.push("7");
		icollQueueA.push("8");
		icollQueueA.push("9");
		icollQueueA.push("10");
		icollQueueA.push("11");
		System.out.println("Is empty " + icollQueueA.isEmpty());
		System.out.println(icollQueueA);
		System.out.println("Size: " + icollQueueA.getSize());
		System.out.println("Deleting elements...");
		System.out.println(icollQueueA.pop());
		System.out.println(icollQueueA.pop());
		System.out.println(icollQueueA.pop());
		System.out.println(icollQueueA.pop());
		System.out.println(icollQueueA.pop());
		System.out.println(icollQueueA.pop());
		System.out.println("Size: " + icollQueueA.getSize());
		System.out.println(icollQueueA);	
	 }

}
