package deusClass;

public class Lecturer extends People {
	
	double Salary;

	public Lecturer(String name, String role, int age, double salary) {
		super(name, role, age);
		Salary = salary;

		System.out.println("Lecturer telah di buat");
	}

	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("My Salary is " + this.Salary);
	}
	
	
	
}
