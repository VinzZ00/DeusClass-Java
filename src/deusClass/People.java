package deusClass;

public abstract class People {

	private String name, role;
	private int age;
	
	public People() {
		// TODO Auto-generated constructor stub
	}

	// Overloading Constructor
	public People(String name, String role, int age) {
		super();
		this.name = name;
		this.role = role;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public abstract void info();
	
	

}
