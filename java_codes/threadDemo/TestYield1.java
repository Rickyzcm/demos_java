package threadDemo;

public class TestYield1 {

	public static void main(String[] args) {
		TestYield2 t1 = new TestYield2();
		TestYield2 t2 = new TestYield2();
		TestYield2 t3 = new TestYield2();

		t1.setName("第一个线程");
		t2.setName("第二个线程");
		t3.setName("第三个线程");

		t1.start();
		t2.start();
		t3.start();
	}
}

class TestYield2 extends Thread {

	int i = 0;

	public void run() {
		for (int i = 1; i <= 10; i++) {
			if (i % 3 == 0) {
				System.out.println(Thread.currentThread().getName() + "第" + i + "次运行，让步");
				Thread.yield();
			} else {
				System.out.println(Thread.currentThread().getName() + "第" + i + "次运行");
			}
		}
	}
}
