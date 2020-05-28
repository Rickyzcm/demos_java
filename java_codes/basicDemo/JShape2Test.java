package basicDemo;

interface JShape2{
	String shapename = "图形类";
	void area();
	void draw();
	// 默认的public 访问权限
}

class JCircle2 implements JShape2 {
	String getName() {
		return shapename+"：圆";
	}
	
	public void area() {
		System.out.println("面积公式：PI*radius*radius");
	}
	
	public void draw() {
		System.out.println("画我请使用圆规");
	}
}

public class JShape2Test {

	public static void main(String[] args) {
		JCircle2 c = new JCircle2();
		c.draw();
		System.out.println(c.getName());
	}

}
