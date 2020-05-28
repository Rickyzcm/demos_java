
## Java的多态性
  + 方法重载
  + 方法覆盖

### 方法重载
  + Java 是支持重载的语言
  + 意味着同一个类中会出现两个或者两个以上同名的方法

#### 实现(在于两个函数间比较)
  * 参数个数不同
  * 参数类型不同
  * 参数名相同但类型不同

1. 计算图形面积的方法重载例子
   ```java  
    // 计算矩形面积
    public double area(float a,float b){
        return a*b;
    }

    // 计算三角形面积，参数个数不同，实现了方法 area 的重载
    public double area(float a,float b,float c){
        float d= (a+b+c)/2;
        return Math.sqrt(d*(d-a)*(d-b)*(d-c));
    }

    // 计算边长为整数的矩形面积，参数类型不同，实现了方法 area 的重载  
    public double area(int a,int b){
        return a*b;
    }

    // 计算一边长为整数，一边长为小数的矩形面积，参数类型不同，实现了方法 area 的重载
    public double area(int a,float b){
        return a*b;
    }

    // 计算一边长为整数，一边长为小数的矩形面积，参数顺序不同，实现了方法 area 的重载
    public double area(float a,int b){
        return a*b;
    }  

   ```  
    > 注意(容易进入的误区)
      * 注意置换参数顺序制造的方法重载必须要在不同类型的参数之间
      * 返回值类型不同或函数名不同，不能成为方法重载

  1. 类的构造方法也可以进行方法重载
     > 通过定义多个不同参数的构造方法 
     **JConstructionPeople.java** 
     ```java
     public class JConstructionPeople {
        private String name;
        private int age;
        
        // 构造方法1
        public JConstructionPeople(String n) {
          this(n,25);
        }
        
        // 构造方法2
        public JConstructionPeople(String n,int age) {
          name = n;
          this.age =age;
        }
        
        // 构造方法3
        public JConstructionPeople() {
          this("who am i");
        }

        // main()
        public static void main(String[] args) {
            JConstructionPeople jsp1 = new JConstructionPeople();
            JConstructionPeople jsp2 = new JConstructionPeople("Ricky");
            System.out.println("对象jsp1.name= "+jsp1.name+"\t对象jsp1.age= "+jsp1.age);
            System.out.println("对象jsp2.name= "+jsp2.name+"\t对象jsp2.age= "+jsp2.age);
            }
        }
     ```  

     > jsp1对象生成过程：  
       ——>调用方法3(无参的构造方法):  
          ——>执行 this("who am i"):  
             ——>调用方法1(含一个String类型参数的构造方法):  
                ——>执行 this("who am i",25):  
                   ——>调用方法2(含一个String类型参数和一个int类型参数(共2个参数)的构造方法):  
                      ——>执行 name="who am i";age = 25; 
            
     > jsp1对象生成过程:  
       ——>调用方法1(含一个String类型参数的构造方法):  
          ——>执行 this("Ricky",25):  
             ——>调用方法2(含一个String类型参数和一个int类型参数(共2个参数)的构造方法):  
                ——>执行 name="Ricky";age = 25;   

     **输出结果**
     ```
     对象jsp1.name= who am i	对象jsp1.age= 25
     对象jsp2.name= Ricky	    对象jsp2.age= 25
     ```
### 方法覆盖
  + 子类和父类中有同名方法(包含参数和返回类型也完全相同),子类中的方法就会覆盖父类中的方法

#### 注意规则
   + 子类中重写的方法要和父类中被重写的方法名字相同，参数表相同，返回类型相同，只有方法体可以不同。  

      ```java
      class JOverriding{
        public void test1() {
          System.out.println("Hi Overriding!");
        }
      }

      class JSubOverriding extends JOverriding{
        // 方法1 方法覆盖
        public void test1() {
          System.out.println("Hi JSubOverriding!");
        }
        // 方法2 方法重载
        public void test1(int i) {
          System.out.println("Hi JSubOverriding!，Now i = "+ i);
        }
        /*
        * 方法3 既不是方法覆盖，也不是方法重载，不被允许
        * public String test1(){return "OK";}
        */
      }
      ```  

   + 子类覆盖的方法不能缩小父类方法的访问权限
     - Java 规定成员方法的访问控制方式权限大小由大到小  
          public > protected > default > private
     - Java 规定子类的成员方法应当比父类的成员方法具有相同或者是更高的访问控制方式  
     - 方法覆盖只能存在于子类和父类(包括直接父类和间接父类)之间，同一个类中方法只能被重载，不能被覆盖。
     - 父类的静态方法不可以被子类覆盖为非静态的方法，反之亦然，但是父类和子类的静态方法可以同名，以便在子类中隐藏父类的静态方法
     - 父类的私有方法不能被覆盖
     - final 修饰方法，该方法不能被其所在类的子类覆盖(若有需求，也可以使用final来修饰方法以防止覆盖情况发生)  

#### 动态方法调度机制与“向上转型”  
   + 动态方法调度在运行时而不是编译时调用重载方法，通过方法覆盖实现运行时的多态  
   + “向上转型”：子类可以向父类进行类型转型，使得父类的对象也可以引用子类的对象

   > 是被引用对象的类型决定(子类)，而不是引用变量的类型(父类)决定执行哪个版本的重载方法  

  **阐述动态方法调用机制的例程**

  ```java
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
      b = new C();	// 重新初始化 b,通过向上转型，b 引用的是新创建的 C 类型的对象
      b.hello();	// b 执行的是类 C 的hello()方法
	}
  ```
  **Console 输出结果**
   ```
    Hello,here is A
    Hello,here is B
    Hello,here is C
    Hello,here is C
   ```
## 抽象类
  > 专门设计用来让子类继承的类

+ 其内部可以有
 - 成员变量
 - 构造方法
 - 具体方法
 - 抽象方法
+ 抽象类代码定义形如
   ```java
     abstract class<类名>{
         成员变量;
         返回类型 方法名(参数列表){
             方法体;
         }
         abstract 返回类型 方法名(参数列表);
     }
   ```
+ 注意
  - 抽象类可以只包含抽象方法，也可以拥有普通的成员变量和具体方法。
  - 抽象类的子类必须实现(覆盖)父类中的所有抽象方法。
  - 抽象类不可以实例化，也不可以直接使用自己的构造方法生成实例，但是其子类可以进行实例化。
  - 不是抽象类就不可以定义抽象方法。
  - 抽象类不一定非要有抽象方法，只含有普通方法也是可以运行的。

### 代码范例  
+ 针对矩形抽象出图形抽象类，并用矩形子类进行继承并实现其抽象方法的例如
   1. 定义抽象类
      ```java
      abstract class JShape{
        int JShapeId;	// 可以拥有成员变量
    
        protected void getJShapeId() {	// 可以拥有具体实现的方法
          System.out.println(JShapeId);
	      }
	
        abstract protected double area();	// 定义抽象方法 area(),注意没有方法体，更不谈{}
        
        abstract protected void draw();	// 定义抽象方法
      }
      ```  

   1. 定义一个子类来继承抽象类  
      ```java
      class JRectangle extends JShape{
	      float width,length;
	
	      // 定义构造方法
	      JRectangle(float w,float l){
          width = w;
          length = l;
	      }
	
	      // 对父类的抽象方法进行具体实现
	      protected double area() {return length * width;}
	      protected void draw() {}
      }
      ```
   1. 当前主类的main()方法进行实例化对象和测试
      ```java
      JRectangle r = new JRectangle(10, 20);
      System.out.println("The area of rectangle: "+ r.area());  //调用继承JShape抽象类的子类JRectangle实现的area()方法，
      ```  
   1. 输出结果
      ```
      The area of rectangle: 200.0
      ```
   **注意**
     + 继承抽象类的之类必须实现父类中的所有方法，即使没有具体的实现步骤，但是包裹方法体的 `{}` 必须存在。
     + 对于类，不可以同时用 `abstract`和 `final`进行修饰；对于成员方法，不能同时用 `static` 和 `abstract`进行修饰
