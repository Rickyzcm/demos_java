package threadDemo;

public class TestSynchronizedExample2 implements Runnable {

	private int ticket = 10;

	@Override
	public void run() {
		//
		while (ticket > 0) {
			sell();
		}
	}
	
	// 将售票的方法单独包装成同步方法，达到与同步语句块同样的效果
	public synchronized void sell() {
		if (ticket > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// 睡眠结束之后，继续当前的票销售
			System.out.println(Thread.currentThread().getName() + "卖票-->" + (this.ticket--));
		}
	}

	public static void main(String[] args) {
		//
		// 建立三个售票窗口的线程类来模拟窗口售票
		TestSynchronizedExample2 t1 = new TestSynchronizedExample2(); // 创建线程类

		Thread t1s = new Thread(t1); // 新建线程
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
