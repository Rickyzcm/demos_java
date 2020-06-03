package _datastructure_demo;

import java.util.Vector;

public class TestVector {

	public static void main(String[] args) {
		// 使用Vector的构造方法创建
		Vector<String> v= new Vector<String>(4); 
		
		//向其中添加元素：add()方法
		v.add("Test0");
		v.add("Test1");
		v.add("Test0");
		v.add("Test2");
		v.add("Test2");
		
		//从 Vector中删除元素
		v.remove("Test0");	// 按照指定内容删除元素
		v.remove(0);	// 按照索引号删除元素
		
		int size = v.size();	// 获得Vector中已有的元素的个数
		System.out.println("size: "+size); 		//输出size:3
		
		for(int i=0;i<size;i++) {
			System.out.println(v.get(i));
		}
	}

}
