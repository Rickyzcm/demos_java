package basicDemo;

public class JConstructionPeople {

	private String name;
	private int age;
	
	// 构造方法1
	public JConstructionPeople(String n) {
		this(n,25);
	}
	
	// 构造方法2
	public JConstructionPeople(String n,int age) {
		name = n;
		this.age =age;
	}
	
	// 构造方法3
	public JConstructionPeople() {
		this("who am i");
	}
	
	public static void main(String[] args) {
		JConstructionPeople jsp1 = new JConstructionPeople();
		JConstructionPeople jsp2 = new JConstructionPeople("Ricky");
		System.out.println("对象jsp1.name= "+jsp1.name+"\t对象jsp1.age= "+jsp1.age);
		System.out.println("对象jsp2.name= "+jsp2.name+"\t对象jsp2.age= "+jsp2.age);
	}

}
