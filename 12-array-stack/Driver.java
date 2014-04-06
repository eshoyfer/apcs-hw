public class Driver {
	public static void main(String[] args) {
		MyStack s = new MyStack(); 
		System.out.println(s);
		s.push("1");
		s.push("2");
		s.push("3");
		System.out.println(s);
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s);
		for (int i = 3; i < 100; i++) {
			s.push(new String(i + ""));
		}
		System.out.println(s);
	}
}