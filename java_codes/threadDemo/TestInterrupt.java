package threadDemo;

public class TestInterrupt extends Thread{
	
	public void run() {
		long start = System.nanoTime();
		try {
			sleep(5000);
		}catch(InterruptedException e) {
			System.out.println("线程被唤醒");
		}
		
		long end = System.nanoTime();
		System.out.println("总的运行时间: "+(end-start)/1000000+"ms");
	}
	
	public static void main(String[] args) {
		TestInterrupt t1 = new TestInterrupt();
		t1.start();
		t1.interrupt();
	}

}
