package classDemo;

public class JStudent2 extends JPeople2{
	private String studentID;
	private String major;
	public JStudent2(String name, char sex, int age, String studentID, String major) {
		super(name, sex, age); // 调用父类的构造方法
		this.studentID = studentID;
		this.major = major;
	}
	
	public String getDetails() {
		return super.getDetails()+"\nstudentID:"+studentID+"\nmajor:"+major;
	}
	
	public static void main(String[] args) {
		JStudent2 s = new JStudent2("张三", '男', 22, "2013030507", "计算机");
		System.out.println(s.getDetails());
	}
}
