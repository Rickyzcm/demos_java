package classDemo;

public class JStudent extends JPeople{
	String studentID;
	String major;
	
	String name; // 定义一个和父类成员同名的成员变量 name
	
	public String getName() {
		return "wangwu";
	}
	
	public String getName2() {
		super.name="张三";
		return super.getName();
	}
	
	public String getStudentID() {
		return studentID;
	}
	public String getMajor() {
		return major;
	}
	
	
}
