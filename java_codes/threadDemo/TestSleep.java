package threadDemo;

public class TestSleep extends Thread{
	private int i = 0;
	
	public void run() {
		long start = System.nanoTime();
		for(int i =0;i<10;i++) {
			System.out.println("睡眠: "+i);
			try {
				sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("线程被唤醒");
			}
		}
		long end =System.nanoTime();
		System.out.println("总的运行时间: "+(end-start)/1000000+"ms");
	}
	
	public static void main(String[] args) {
		TestSleep t1 = new TestSleep();
		t1.start();
	}

}
