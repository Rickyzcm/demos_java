package urlDemo;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;

public class TestURLConnection {

	public static void main(String[] args) throws Exception {
		// 创建一个 URL 对象
		URL url = new URL("http://www.javasoft.com/cgi-bin/backwards");
		
		// 由 URL 对象获取URLConnection 对象
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);
		
		// 由URLConnection获取输出流，并构造PrintStream对象
		PrintStream ps = new PrintStream(connection.getOutputStream());
		
		ps.println("字符串实际内容");	//向服务器写出字符串
		ps.close();
		
		// 由 URLConnection 获取输入流，并构造 DataInputStream 对象
		DataInputStream dis = new DataInputStream(connection.getInputStream());
		String inputLine;
		
		// 从服务器持续读入，并显示
		while((inputLine = dis.readLine())!= null) {
			System.out.println(inputLine);
		}
		
		dis.close();
	}

}
