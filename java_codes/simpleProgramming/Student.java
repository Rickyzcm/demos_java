package simpleProgramming;

import java.io.*;
import java.util.*;

public class Student {
	String name;	//姓名
	long stno;		//学号
	String sex;		//性别
	
	Student(String name,long stno,String sex){
		this.name = name;
		this.stno = stno;
		this.sex = sex;
	}
	
	public String toString() {
		return "学生 [姓名=" + name + ", 学号=" + stno + ", 性别=" + sex + "]";
	}

	public static void main(String[] args) {
		Vector <Student>group = new Vector<Student>();
		outer:while(true) {
			String ch =input("选择1--增加,2--删除,3--显示,4--退出");
			int choice = Integer.parseInt(ch);
			switch(choice) {
			case 1:
				group.add(inputStudent());
				break;
			case 2:
				long stno = Long.parseLong(input("\n请输入学号"));
				for(int k =0;k<group.size();k++) {
					Student x= (Student)group.get(k);
					if (x.stno == stno) {
						group.removeElement(x);
						System.out.println("删除的学生信息:"+x);
					}
				}
				break;			
			case 3:
				Iterator p = group.iterator();
				if(p.hasNext()) {
					while(p.hasNext()) {//用迭代器遍历Vector
					System.out.println("==> "+p.next());
					}
				}else {
					System.out.println("\n当前信息库为空");
				}
				break;
			case 4:
				break outer;
			}
		}
		System.out.println("系统已退出");
	}
	
	public static String input(String hint) {
		String x = null;
		try {
			System.out.println(hint);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			x = br.readLine();
		}catch(IOException e) {
			System.out.println("输入数据非法");
		}
		return x;
	}
	
	/*
	 * 从键盘输入一个学生信息
	 * */
	public static Student inputStudent() {
		String name = input("\n请输入姓名");
		long stno = Long.parseLong(input("\n请输入学号"));
		String sex = input("\n请输入性别");
		return new Student(name,stno,sex);
	}

}
