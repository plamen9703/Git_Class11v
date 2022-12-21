package edu.npmg.v11;

public class Employ {
	private String name;
	private String position;
	private double salary;
	private int experiance;
	private double salaryBonus;

	public void setName(String name) {
		this.name=name;
	}
	public void setPosition(String position) {
		this.position=position;
	}
	public void setSalary(double salary) {
		this.salary=salary;
	}
	public void setExperiance(int expiriance) {
		this.experiance=expiriance;
	}
	public void setSalaryBonus(double salaryBonus) {
		this.salaryBonus=salaryBonus;
	}
	
	public String getName() {
		return name;
	}
	public String getPosition() {
		return position;
	}
	public double getSalary() {
		return salary+(salary*experiance)/100+salaryBonus;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s - %.2f", name, position,getSalary());
	}
}
