package basicDemo;

interface JShape{
	void area();
	void draw();
	// 默认的public 访问权限
}

class JCircle implements JShape {
	public void area() {
		System.out.println("面积公式：PI*radius*radius");
	}
	
	public void draw() {
		System.out.println("画我请使用圆规");
	}
}

class JRectangle implements JShape {
	public void area() {
		System.out.println("面积公式：width * height");
	}
	
	public void draw() {
		System.out.println("画我请使用直尺");
	}
}

public class JShapTest {

	public static void main(String[] args) {
		JCircle c = new JCircle();
		c.area();
		c.draw();
		JRectangle t = new JRectangle();
		t.area();
		t.draw();
	}

}
