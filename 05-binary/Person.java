public class Person implements Comparable<Person> {
	private int age; 
	private String name;

	public Person() {
		age = 0;
		name = "name"; 
	}

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	// Version 1: Age
	// public int compareTo(Person o) {
	// 	return this.age - o.age;
	// }

	// Version 2: Name
	public int compareTo(Person o) {
			return this.name.compareTo(o.name);
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return age + "/" + name;
	}


}