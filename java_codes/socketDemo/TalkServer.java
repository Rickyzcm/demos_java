package socketDemo;

import java.net.ServerSocket;
import java.net.Socket;

public class TalkServer {

	public static void main(String[] args) {
		try {
			// 创建一个服务器 Socket 对象 Server
			ServerSocket server = new ServerSocket(3001);
			System.out.println("服务器的 Socket 已经创建成功");
			System.out.println("正在等待客户机连接.....");
			
			//循环建立客户机连接
			for(int i =1;i <= 10;i++) {
				// 包括创建 Socket 对象 s 并连接到服务器 Socket 上
				Socket s = new Socket("127.0.0.1",3001);
				System.out.println("已经与第"+i+"个客户机连接");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
