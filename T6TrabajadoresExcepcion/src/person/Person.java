package person;

import person.exception.ErrorEdadInvalida;

public class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) throws ErrorEdadInvalida {
		this.setAge(age);
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int edad)throws ErrorEdadInvalida {
		if(edad<0) {
			throw new ErrorEdadInvalida("La edad debe ser mayor o igual a 0");
		}
		this.age=edad;
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
