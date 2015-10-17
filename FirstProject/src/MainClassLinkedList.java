import java.util.Iterator;
import java.util.LinkedList;

public class MainClassLinkedList {

	public static void main(String[] args) {
		MyLinkedList<String> linkedList = new MyLinkedList<String>();
		System.out.println("Contains 123: " + linkedList.contains("123"));
		System.out.println("Is empty: " + linkedList.isEmpty());
		System.out.println("add 123: " + linkedList.add("123"));
		System.out.println("add 456: " + linkedList.add("456"));
		System.out.println("add 124: " + linkedList.add("124"));
		System.out.println("add 513: " + linkedList.add("513"));
		System.out.println("Is empty: " + linkedList.isEmpty());
		System.out.println("Contains 123: " + linkedList.contains("123"));
		System.out.println("Get 3: " + linkedList.get(3));
		System.out.println("Get 2: " + linkedList.get(2));
		System.out.println("Get 1: " + linkedList.get(1));
		System.out.println("Get 0: " + linkedList.get(0));
		System.out.println("Size: " + linkedList.size());
		System.out.println("Remove 124");
		linkedList.remove("124");
		System.out.println("Remove 888");
		linkedList.remove("888");
		System.out.println("Size: " + linkedList.size());
		System.out.println("Contains 124: " + linkedList.contains("124"));
		System.out.println("add 888: " + linkedList.add("888"));
		System.out.println("Size: " + linkedList.size());
		System.out.println("Get 3: " + linkedList.get(3));
		System.out.println("Get 2: " + linkedList.get(2));
		System.out.println("Get 1: " + linkedList.get(1));
		System.out.println("Get 0: " + linkedList.get(0));
		System.out.println("Clear");
		linkedList.clear();
		System.out.println("Size: " + linkedList.size());
		System.out.println("Is empty: " + linkedList.isEmpty());
		System.out.println("Contains 513: " + linkedList.contains("513"));
		System.out.println("Remove 888");
		linkedList.remove("888");	
		
		//iterator test		
		System.out.println("add 123: " + linkedList.add("123"));
		System.out.println("add 456: " + linkedList.add("456"));
		System.out.println("add 124: " + linkedList.add("124"));
		System.out.println("add 513: " + linkedList.add("513"));
		Iterator<String> it = linkedList.iterator();
		System.out.println("It has next: " + it.hasNext());
		System.out.println("Clear");
		it = linkedList.iterator();
		while (it.hasNext()) {
			System.out.println("Removing: " + it.next());
			it.remove();
		}
		it = linkedList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}		
		System.out.println("add 123: " + linkedList.add("123"));
		it = linkedList.iterator();
		while (it.hasNext()) {
			System.out.println("Element: " + it.next());
		}
	}

}
//