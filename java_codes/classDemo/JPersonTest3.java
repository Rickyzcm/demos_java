package classDemo;

class JPerson3{
	int personId;
	
	public JPerson3(int i) {
		personId = i;
		System.out.println("现在personId: "+personId);
	}
	
	public JPerson3(int i,int j) {
		personId=i+j;
		System.out.println("现在personId: "+personId);
	}
}

class JSubPerson3 extends JPerson3{
	public JSubPerson3(int i) {
		super(i);  // 该语句只能位于构造方法第一行
		// super(i,1000);
		System.out.println("现在personId: "+personId);
	}
}

public class JPersonTest3 {
	public static void main(String[] args) {
		JSubPerson3 s1 =new JSubPerson3(100);
	}
}
