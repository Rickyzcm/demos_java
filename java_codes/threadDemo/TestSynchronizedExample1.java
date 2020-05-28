package threadDemo;

public class TestSynchronizedExample1 implements Runnable {

	private int ticket = 10; // 10张票

	public void run() {
		while(true) {
			synchronized (this) {
				if(ticket > 0) {
					try {
						Thread.sleep(10);	//当前线程睡眠用以模拟数据库消耗时间
						// 容易出现越界情况
					}catch (Exception e) {
						e.printStackTrace();
					}
					// 睡眠之后，继续当前的票进行销售
					System.out.println(Thread.currentThread().getName()+"卖票-->"+(this.ticket--));
				}else {
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		// 建立三个售票窗口的线程类来模拟窗口售票
		TestSynchronizedExample1 t1 = new TestSynchronizedExample1(); // 创建线程类

		Thread t1s = new Thread(t1);	//新建线程
		Thread t2s = new Thread(t1);
		Thread t3s = new Thread(t1);
		// t1s,t2s,t3s所用的时同一个对象，开了三个线程
		// 此时，对于这三个线程，t1就是一个公共变量
		
		t1s.setName("窗口 1");
		t2s.setName("窗口 2");
		t3s.setName("窗口 3");
		t1s.start();
		t2s.start();
		t3s.start();
	}

}
