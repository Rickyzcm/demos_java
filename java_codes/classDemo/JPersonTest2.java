package classDemo;

class JPerson2{
	int personId;
	public JPerson2() {
		personId = 10;
		System.out.println("现在personId的值是: "+personId);
	}
}

class JSubPerson2 extends JPerson2{
	public JSubPerson2(int i) {
		personId = i;
		System.out.println("现在personId的值是: "+personId);
	}
}

public class JPersonTest2 {
	public static void main(String[] args) {
		JSubPerson2 j2=new JSubPerson2(100); // 先输出10，然后输出100
		/**
		 * 继承性规则3：在创建子类的对象的时候，都是先执行父类的构造方法，然后执行子类的
		 */
	}
}
