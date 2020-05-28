package threadDemo;

import java.io.IOException;

public class TestDaemon extends Thread{
	public TestDaemon() {}
	
	public void run() {
		for(int i =1;i<=100;i++) {
			try {
				Thread.sleep(400);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		TestDaemon test = new TestDaemon();
		test.setDaemon(true);
		//必须在线程启动前调用Thread的setDaemon()方法，否则会抛出异常，虽然这个时候线程是正常工作的，但是已经不再是守护线程
		
		test.start();
		System.out.println("(boolean)isDaemon="+test.isDaemon());
		
		try {
			/**
			 * 接受输入，使程序在此停顿
			 * 一旦接受到用户输入，main线程结束，守护线程自动结束，
			 * 如果用户不输入，那么程序会从1输出到100，但是主进程并没有结束
			 * 而输入回车，主线程退出，全部线程结束
			 * */
			System.in.read();
			
			System.out.println("main线程结束");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
