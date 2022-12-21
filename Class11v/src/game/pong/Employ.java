package game.pong;

public class Employ {
	
	protected String name;
	protected String position;
	protected int yearsExperience;
	protected double salary;
	protected double salaryBonus;
	
	
	public Employ() {
		name="plamen";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getYearsExperience() {
		return yearsExperience;
	}
	public void setYearsExperience(int yearsExperience) {
		this.yearsExperience = yearsExperience;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getSalaryBonus() {
		return salaryBonus;
	}
	public void setSalaryBonus(double salaryBonus) {
		this.salaryBonus = salaryBonus;
	}

	@Override
	public String toString() {
		return "Employ [name=" + name + ", position=" + position + ", yearsExperience=" + yearsExperience + ", salary="
				+ salary + ", salaryBonus=" + salaryBonus + "]";
	}
	
	
	
}
