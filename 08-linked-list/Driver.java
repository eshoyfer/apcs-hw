public class Driver {
	public static void main(String[] args) {
		MyLinkedList l1 = new MyLinkedList();
		l1.add("a");
		System.out.println(l1);
		l1.add("b");
		System.out.println(l1);
		l1.add("c");
		System.out.println(l1);
		l1.add("d");
		System.out.println(l1);
		l1.add(1, "Placed at position 1");
		System.out.println(l1);
		System.out.println("Getting position 1:");
		System.out.println(l1.get(1));
		l1.set(1, "Set at position 1");
		System.out.println(l1);
		System.out.println(l1.remove(1));
		System.out.println("^ Removed item. New linked list v");
		System.out.println(l1);
		System.out.println("Find c:");
		System.out.println(l1.find("c"));
		System.out.println("Length:");
		System.out.println(l1.length());

	} 
}