package threadDemo;

public class RunnableExample1 implements Runnable{
	
	private int tickets= 10;
	//重写run方法
	public void run() {
		while(this.tickets>=0) {
			System.out.println(Thread.currentThread().getName()+"卖票-->"+(this.tickets--));
		}
	}
	
	// 建立三个售票窗口的线程类来模拟窗口管理器
	public static void main(String[] args) {
		
		RunnableExample1 t1 = new RunnableExample1();	//创建线程类
		RunnableExample1 t2 = new RunnableExample1();
		RunnableExample1 t3 = new RunnableExample1();
		
		Thread t1s = new Thread(t1);	//创建线程
		Thread t2s = new Thread(t2);
		Thread t3s = new Thread(t3);
		
		t1s.setName("窗口 1");	//给线程命名
		t2s.setName("窗口 2");
		t3s.setName("窗口 3");
		
		t1s.start();	// 线程运行
		t2s.start();
		t3s.start();
	}

}
