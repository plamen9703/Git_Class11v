package game.pong;

public class Manager extends Employ{
	
	private Employ[] employees;
	
	public Manager() {
		name="Plamen";
		employees=new Employ[10];
	}
	
	public Manager(String name) {
		super.name=name;
	}
	
	public void addEmploy(Employ e) {
		for(int i =0;i<employees.length;i++) {
			if(employees[i]==null) {
				employees[i]=e;
				break;
			}
		}
	}
	
	
	public void printEmploys() {
		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i]);
		}
	}
	
	public Employ getEmploy(int i) {
		return employees[i];
	}

	@Override
	public String toString() {
		return String.format("Manager [%s]", name);
	}
	
	
}
