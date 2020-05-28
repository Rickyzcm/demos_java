package java_reflection;

public final class Teacher extends Person{
	public String position;
	private int salary;
	private void speak(String message) {
		System.out.println("Speak: "+message);
	}
	
	@Override
	public String toString() {
		return "[position:"+position+"Salary:"+salary+"]";
	}
	
	private int getSalary() {
		return this.salary;
	}
}
