package threadDemo;

public class ThreadExample1 extends Thread{
	//	
	int tickets= 10;
	//重写run方法
	public void run() {
		while(this.tickets>=0) {
			System.out.println(this.getName()+"卖票-->"+(this.tickets--));
		}
	}
	
	public static void main(String[] args) {
		
		ThreadExample1 t1 = new ThreadExample1();	// 创建线程类
		ThreadExample1 t2 = new ThreadExample1();
		ThreadExample1 t3 = new ThreadExample1();
		
		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
