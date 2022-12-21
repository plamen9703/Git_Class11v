package edu.npmg.v11;

public class Person {
	private String name;
	private int age;
	private int height;
	private double weigth;
	private int x;
	private int y;
	
	static double getBMI(Person p) {
		return p.height/p.weigth;
	}
	
	public Person() {
		setName("Plamen");
		setAge(25);
		setHeight(178);
		setWeight(112.8);
	}
	
	public Person(String name, int age, int height, double weight) {
		setName(name);
		setAge(age);
		setHeight(height);
		setWeight(weight);
	}
	
	public Person(Person p) {
		setName(p.name);
		setAge(p.age);
		setHeight(p.height);
		setWeight(p.weigth);
	}
	
	public void jump() {
		y++;
	}
	
	public void fall() {
		y--;
	}
	
	public void printLocation() {
		System.out.printf("%d, %d\n", x,y);
	}
	
	public void setName(String name) {
		if(name==null && name.isEmpty()) {
			name="Plam";
		}else {
			this.name=name;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public int getAge() {
		return age;
	}
	public void setHeight(int height) {
		this.height=height;
	}
	public int getHeight() {
		return height;
	}
	public void setWeight(double weigth) {
		this.weigth=weigth;
	}
	public double getWeight() {
		return weigth;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s, Age: %d, Height: %d, Weight: %.2f", name, age,height,weigth);
	}
}
