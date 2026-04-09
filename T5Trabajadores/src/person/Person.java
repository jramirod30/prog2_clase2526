package person;

public class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	
	
	
	
	
	
	
	
	
	
	@Override 
	public String toString() {
		return "Nombre " + this.name + "age " + this.age;
		
	}
	
	@Override
	public boolean equals(Object compare) {
		if(!( compare instanceof Person)) {
			return false;
		}
		Person comparar=(Person)compare;
		return this.age==comparar.age && this.name.equals(comparar.name);
	}
}
