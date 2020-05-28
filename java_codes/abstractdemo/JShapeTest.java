package abstractdemo;

abstract class JShape{
	int JShapeId;	// 可以拥有成员变量
	
	protected void getJShapeId() {	// 可以拥有具体实现的方法
		System.out.println(JShapeId);
	}
	
	abstract protected double area();	// 定义抽象方法 area(),注意没有方法体，更不谈{}
	
	abstract protected void draw();	// 定义抽象方法
}

// 定义一个子类来继承抽象类
class JRectangle extends JShape{
	float width,length;
	
	// 定义构造方法
	JRectangle(float w,float l){
		width = w;
		length = l;
	}
	
	// 对父类的抽象方法进行具体实现
	protected double area() {
		
		return length * width;
		
	}
	protected void draw() {}
	
}
public class JShapeTest {

	public static void main(String[] args) {
		JRectangle r = new JRectangle(10, 20);
		System.out.println("The area of rectangle: "+ r.area());
	}

}
