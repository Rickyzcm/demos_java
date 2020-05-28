package threadDemo;

public class TestJoin extends Thread{
	
	public void run() {
		//线程循环输出次输出字符
		for(int i=1;i<=10;i++) {
			System.out.println(Thread.currentThread().getName()+"第"+i+"次输出");
		}
		System.out.println(Thread.currentThread().getName()+"运行结束");
	}
	
	public static void main(String[] args) {
		System.out.println("主线程运行开始");
		TestJoin t = new TestJoin();
		t.setName("线程1");
		try {
			long start = System.nanoTime();
			t.start();
			t.join();	//等待t线程的运行结束
			
			long end = System.nanoTime();
			System.out.println("耗时"+(end-start)/1000000+"毫秒");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("主线程运行结束");	//main函数的主线程运行结束
	}

}
