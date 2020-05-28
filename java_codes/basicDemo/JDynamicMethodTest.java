package basicDemo;

class A{
	public void hello() {
		System.out.println("Hello,here is A");
	}
}

class B extends A{
	public void hello() {
		System.out.println("Hello,here is B");
	}
}

class C extends B{
	public void hello() {
		System.out.println("Hello,here is C");
	}
}

public class JDynamicMethodTest {

	public static void main(String[] args) {
		A a = new A();	// 实例化 A,得到 A 类型的对象 a
		B b = new B();	// 实例化 B,得到 B 类型的对象 b
		C c = new C();	// 实例化 C,得到 C 类型的对象 c
		A x;		// 声明一个 A 类型的对象 x,即 x 引用对象类型为 A
		x = a;		// 初始化x，被引用的对象类型也是 A
		x.hello();	// x 执行的是类 A 的hello()方法
		x=b;		// 初始化 x 通过向上转型，x引用的是 B 类型的对象b
		x.hello();	// x 执行的是类 B 的hello()方法
		x=c;		// 初始化 x 通过向上转型，x引用的是 C 类型的对象b
		x.hello();	// x 执行的是类 C 的hello()方法
		b = new C();	// 重新初始化 b,通过向上转型， b 引用的是新创建的 C 类型的对象
		b.hello();	// b 执行的是类 C 的hello()方法
		
	}

}
