package game.pong;

public class MainManager {

	public static void main(String[] args) {
		Manager m=new Manager();
		m.addEmploy(new Employ());
		m.addEmploy(new Manager("hristo"));
		m.printEmploys();
		Employ e=m.getEmploy(0);
		System.out.println(e.getClass().getName());
	}

}
