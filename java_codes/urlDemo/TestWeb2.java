package urlDemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class TestWeb2 {
	public static void main(String[] args) {
		try {						// 声明抛出所有异常
			// 构建一个 URL 对象
			URL  tric = new URL("http://zkfw.91job.org.cn/");
			
			// 使用 openStream 得到一个输入流并由此构造一个 BufferedReader 对象
			BufferedReader in = new BufferedReader(new InputStreamReader(tric.openStream(),"utf-8"));
			
			String inputLine;
			
			// 从输入流不断读取数据，直到读完为止
			while((inputLine = in.readLine())!= null) {
				System.out.println(inputLine); // 把读入的数据输出到屏幕上
			}
			
			in.close();	// 关闭输入流
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
