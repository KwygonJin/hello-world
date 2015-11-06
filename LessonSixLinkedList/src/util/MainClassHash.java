package util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainClassHash {
	public static void main(String[] args) {
//		Person person = new Person("Name", 3);
//		MyHash<Person> myHash = new MyHash<Person>(Person.class, 15);
//		myHash.add(person);
//		myHash.add(new Person("11", 13));
//		myHash.add(new Person("21", 12));
//		myHash.add(new Person("31", 52));
//		myHash.add(new Person("14", 42));
//		myHash.add(new Person("151", 21));
//		myHash.add(new Person("151", 22));
//		myHash.add(new Person("111", 2));
//		System.out.println(myHash.contains(person));
//		System.out.println(myHash.isEmpty());
//		System.out.println(myHash.size());
//		System.out.println(myHash.get(42));
//		myHash.remove(person);
//		System.out.println(myHash.contains(person));
//		System.out.println(myHash.isEmpty());
//		System.out.println(myHash.size());
//		myHash.clear();
//		System.out.println(myHash.contains(person));
//		System.out.println(myHash.isEmpty());
//		System.out.println(myHash.size());
		System.out.println(getRandom());
	}	
	
	public static int getRandom() {
		Random random = new Random();
		Set<Integer> hashSet = new HashSet<Integer>();
		while (hashSet.size() != 4) {
			int a = random.nextInt(10);
			if (a == 0 && hashSet.size() == 0)
				continue;
			else
				hashSet.add(a);
		}
		String res = "";
		for (Integer integer : hashSet) {
			res = res + integer.toString();
		}
		
		return Integer.parseInt(res);
	}
}
