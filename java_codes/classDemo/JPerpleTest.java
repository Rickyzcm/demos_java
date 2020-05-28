package classDemo;

class JPerson{
	int personId;
		
	public JPerson() {
		personId = 10;
	}
}
	
class JSubPerson extends JPerson{}

public class JPerpleTest {

	public static void main(String[] args) {
		JSubPerson j1 = new JSubPerson(); // 调用 JSubPerson 的构造方法时发现无方法，就会调用父类 JPerson 的构造方法
		System.out.println(j1.personId);
	}
}
