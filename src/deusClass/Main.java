package deusClass;

import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	Scanner sc = new Scanner(System.in);
	Vector<People> peoples = new Vector<People>();
	Vector<Lecturer> lecturers = new Vector<Lecturer>();
	Vector<Student> students  = new Vector<Student>();
	public Main() {
		// TODO Auto-generated constructor stub
		
		int choose;
		do {
			
			
			System.out.println("1.	Add People");
			System.out.println("2.	View People");
			System.out.println("3.	Remove People");
			System.out.println("4.	Exit");
			try {
				choose = sc.nextInt(); sc.nextLine();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				choose = -1;
				sc.nextLine();
				System.out.println("Tolong masukan Angka");
				sc.nextLine();
			}
			
			
			// Penganti If else selection 
			switch (choose) { // yang di cek itu apa?
			
			case 1: // valuenya apa untuk mentriger hal yang ada didalamnya
				add();
				sc.nextLine();
				break;
			case 2:
				read();
				sc.nextLine();
				break;
				
			case 3:
				if (peoples.size() > 0) {
					delete();
				} else {
					System.out.println("No people to be deleted");
				}
				sc.nextLine();
				break;
				
			case 4:
				choose = 4;
				break;
			default:
				System.out.println("Tolong masukan angka dari 1 sampai 4");
				sc.nextLine();
				break;
			}
			
		} while (choose != 4);
		
		System.out.println("Thank you.");
	}

	public void add() {
		// Declare Variable
		String name, role;
		int age;
		double salary, gpa;
		
		do {
			System.out.print("Input Name [3 - 15 Character] : ");
			name = sc.nextLine();
		} while (name.length() > 15 || name.length() < 3);
		
		do {
			try {
				System.out.print("Input Age [Min 16] : ");
				age = sc.nextInt(); sc.nextLine();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				age = -1;
				sc.nextLine();
				System.out.println("Tolong masukan angka");
				sc.nextLine();
			}
		} while (age < 16);
		
		do {
			System.out.print("Input Role [\"Student\", \"Lecturer\"] : ");
			role = sc.nextLine();
		} while (!role.equals("Student") && !role.equals("Lecturer"));
		
		if (role.equals("Student")) {
			do {
				try {
					System.out.print("Input GPA [0.00 - 4.00] : ");
					gpa = sc.nextDouble();
					sc.nextLine();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					gpa = -1;
					sc.nextLine();
					System.out.println("Tolong masukan Angka atau bilangan decimal");
					sc.nextLine();
				} 
			} while (gpa < 0 || gpa > 4);
			// Create object Student dari data yang tersedia
			Student s = new Student(name, role, age, gpa);
			// add object student ke dalam array people (parent Class)
			peoples.add(s);
		} else {
			do {
				try {
					System.out.print("Input salary [Min 4000000] : ");
					salary = sc.nextDouble();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					salary = -1;
					sc.nextLine();
					System.out.println("Tolong masukan angka saja tanpa special Karater "); // contoh special char -> !@#$%^^&**
					sc.nextLine();
				} 
			} while (salary < 4000000);
			
			Lecturer l = new Lecturer(name, role, age, salary);
			
			peoples.add(l);
		}
	}

	public void read() {
		int idx = 1;
		for (People people : peoples) {
			if (people instanceof Student) {
				Student m = (Student) people;
				
				System.out.printf("%d.\nHello, my name is %s\n", idx++, m.getName());
				System.out.printf("I am %d year(s) old\n", m.getAge());
				System.out.println("I am a " + m.getRole());
				m.info();
				System.out.println("");
			} else {
				Lecturer m = (Lecturer) people;
				System.out.printf("%d.\nHello, my name is %s\n", idx++, m.getName());
				System.out.printf("I am %d year(s) old\n", m.getAge());
				System.out.println("I am a " + m.getRole());
				m.info();
				System.out.println("");
			}
		}
		System.out.println("END --");
		
	}
	
	public void delete() {
		int choose;
		
		read();
		
		do {
			try {
				System.out.printf("Input people Index to delete [1 - %d] : ", peoples.size());
				choose = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				choose = -1;
				sc.nextLine();
				System.out.println("Tolong Input angka saja");
				sc.nextLine();
			} 
		} while (choose < 1 || choose > peoples.size());
		String temp = peoples
				.get(choose-1)
				.getName();
		peoples.remove(choose - 1);
		System.out.println(temp + " has been successfully deleted");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
