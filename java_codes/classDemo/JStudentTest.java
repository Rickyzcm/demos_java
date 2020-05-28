package classDemo;

public class JStudentTest {

	public static void main(String[] args) {
		JStudent student = new JStudent();
		student.name = "zhaoliu";
		System.out.println("学生姓名是："+student.name);
		System.out.println("学生姓名是："+student.getName());
		System.out.println("学生姓名是："+student.getName2());
	}

}
