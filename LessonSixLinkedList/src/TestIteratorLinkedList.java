import java.util.Iterator;
import java.util.LinkedList;


public class TestIteratorLinkedList {

	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("123");
		linkedList.add("124");
		linkedList.add("125");
		linkedList.add("126");
		linkedList.add("127");
		Iterator<String> it = linkedList.iterator();
		System.out.println(it.hasNext());
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		it = linkedList.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
		linkedList.add("123");
		linkedList.add("553");
		it = linkedList.iterator();
		System.out.println(it.hasNext());
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
