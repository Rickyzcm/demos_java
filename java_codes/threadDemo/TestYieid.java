package threadDemo;

public class TestYieid extends Thread{
	int i = 0;
	
	public void run() {
		for (int i =1;i<=10;i++) {
			if(i%3==0) {
				System.out.println(Thread.currentThread().getName()+"第"+i+"次运行，让步");
				Thread.yield();
			}else {
				System.out.println(Thread.currentThread().getName()+"第"+i+"次运行");
			}
		}
	}
	
	public static void main(String[] args) {
		TestYieid t1 = new TestYieid();
		TestYieid t2 = new TestYieid();
		TestYieid t3 = new TestYieid();
		
		t1.setName("第一个线程");
		t2.setName("第二个线程");
		t3.setName("第三个线程");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
