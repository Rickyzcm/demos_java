package basicDemo;

class JOverriding{
	public void test1() {
		System.out.println("Hi Overriding!");
	}
}

class JSubOverriding extends JOverriding{
	// 方法1 方法覆盖
	public void test1() {
		System.out.println("Hi JSubOverriding!");
	}
	
	// 方法2 方法重载
	public void test1(int i) {
		System.out.println("Hi JSubOverriding!，Now i = "+ i);
	}
	/*
	 * 方法3 既不是方法覆盖，也不是方法重载，不被允许
	 * public String test1(){return "OK";}
	 */
	
}

public class JOverrringTest {

	public static void main(String[] args) {
		JSubOverriding jsubOverriding = new JSubOverriding();
		JOverriding joverriding = new JOverriding();
		jsubOverriding.test1();
		jsubOverriding.test1(100);
		joverriding.test1();
	}

}
