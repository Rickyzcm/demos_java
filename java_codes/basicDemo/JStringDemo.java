package basicDemo;

import java.lang.String;

public class JStringDemo {

	public static void main(String[] args) {
		String str = "  我 时长2年半  喜欢唱、跳、rap  ";
		int str_index = 2;	// 规定索引值为2
		System.out.println("返回索引值为 "+str_index+" 的字符: "+str.charAt(2));
		System.out.println("返回字符为 "+str_index+" 的索引值: "+str.indexOf(String.valueOf(str_index)));
		
	}

}
