package classDemo;

public class JPeople2 {
	private String name;
	private char sex;
	private int age;
	public JPeople2(String name, char sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	
	public String getDetails() {
		return "Name:"+name+"\nsex:"+sex+"\nage:"+age;
	}
	
}
