package _datastructure_demo;

/*
 * 本实例利用 Set 找出不同字符串
 */

import java.util.*;

public class FindDuplications {

	public static void main(String[] args) {
		// 创建一个 HashSet 对象，默认的初始容量是 16
		Set s = new HashSet();
		for(int i=0;i<args.length;i++) {
			/*
			 * 将命令行中的每个字符串加入到集合s中，其中重复的字符串将不能加入，并被打印输出
			 */
			if(!s.add(args[i])) {
				System.out.println("检测到重复项: "+args[i]);
			}
			// 输出集合 s 的元素个数以及集合中的所有元素
			System.out.println(s.size()+" distinct words detected: "+s);
		}
	}

}
