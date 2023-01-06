package deusClass;

public class Student extends People {

	private double gPA;

	public Student(String name, String role, int age, double gPA) {
		super(name, role, age);
		// This keyword berfungsi untuk memeberitahu java bahwa ini adalah variable class (global variable dalam kelas Student)
		this.gPA = gPA;
		
		System.out.println("Student telah di buat");
	}

	public double getgPA() {
		return gPA;
	}

	public void setgPA(double gPA) {
		this.gPA = gPA;
	}

	// Override salah satu konsep Polymorph
	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("My GPA is " + this.gPA + " from 4.0");
	}
	
	

	
	

	
	
	
	
}
