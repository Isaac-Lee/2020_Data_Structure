package lab2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class prob4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, r;
		n = input.nextInt();
		r = input.nextInt();
		input.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		
		Student[] stu = new Student[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(input.nextLine());
			String Class = st.nextToken();
			if (Class.equals("A")){
				String name = st.nextToken();
				String model = st.nextToken();
				String sid = st.nextToken();
				stu[i] = new And(name, sid, model);
			} else {
				String name = st.nextToken();
				String id = st.nextToken();
				stu[i] = new Human(name, id);
			}
		}
		Arrays.sort(stu);
		System.out.println(stu[r-1]);
	}
}

class Human extends Student{
	String id;
	
	public Human(String name, String id) {
		super(name);
		this.id = id;
	}

	@Override
	public int compare(Object o) {
		Human h = (Human) o;
		if (this.id == h.id) {
			if (this.name.equals(h.name)) {
				
			} else {
				return (this.name.compareTo(h.name));
			}
		} else {
			return (this.id.compareTo(h.id));
		}
		return 0;
	}
	
	public String toString() {
		return (this.name +" "+ this.id);
	}
}

class And extends Student {
	String sid;
	String model;
	
	public And(String name, String sid, String model) {
		super(name);
		this.sid = sid;
		this.model = model;
	}

	@Override
	public int compare(Object arg0) {
		And arg = (And) arg0;
		if (this.model.equals(arg.model)) {
			if (this.sid == arg.sid) {
				if (this.name.equals(arg.name)) {
					
				} else {
					return (this.name.compareTo(arg.name));
				}
			} else {
				return (this.sid.compareTo(arg.sid));
			}
		} else {
			return (this.model.compareTo(arg.model));
		}
		return 0;
	}
	
	public String toString() {
		return (this.name +" "+ this.model +" "+ this.sid);
	}
}

abstract class Student implements Comparable<Student> {
	public String name;
	
	public Student(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(Student o) {
		if (this.getClass() == o.getClass()) {
			return this.compare(o);
		} else {
			return this.getClass().toString().compareTo(o.getClass().toString());
		}
	}
	
	
	abstract public int compare(Object o);
}

