package unit_test;

import java_reflection.Person;

public class Bootstrap {
	public static String className = "java_reflection.Teacher";
	public static void main(String[] args) {
		try { 
			System.out.println("开始加载类");
			Class clazz = Class.forName(className);
			System.out.println("类加载完成");
			System.out.println(clazz.toString());
		}catch(ClassNotFoundException e) {
			e.printStackTrace();	// 当根据指定类名找不到类时，就会抛出 “Class Not Found”的错误
									// 指定的类名必须为全路径类名
		}
	}
}
