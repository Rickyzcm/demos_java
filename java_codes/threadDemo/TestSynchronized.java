package threadDemo;

public class TestSynchronized implements Runnable{
	private int ticket = 10;	// 票初始为10张
	
	public void run() {
		while(true) {
			if(ticket > 0) {
				try {
					Thread.sleep(200);	//当前线程睡眠用以模拟数据库消耗时间
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
	
	public static void main(String[] args) {
		// 建立三个售票窗口的线程类来模拟窗口售票
		TestSynchronized t1 = new TestSynchronized();	//创建线程类
		
		Thread t1s = new Thread(t1);
		Thread t2s = new Thread(t1);
		Thread t3s = new Thread(t1);
		t1s.setName("窗口 1");
		t2s.setName("窗口 2");
		t3s.setName("窗口 3");
		t1s.start();
		t2s.start();
		t3s.start();
	}

}
