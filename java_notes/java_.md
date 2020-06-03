
## Java的多态性
  > 多态性是指同名的若干种方法，具有不同的实现(方法体中的代码不一样)  
  > 让程序具备良好扩展性。

  + 方法重载(Overloading)
    - 又称静态多态性
    - 同一类中允许多个同名方法，这些同名方法的主要区别：
      + 参数的个数不同
      + 同样参数名，但类型不同(包括不同类型的参数之间置换参数顺序)
  + 方法覆盖(Overriding)
    - 又称动态多态性
    - 子类对父类的方法进行重新定义，但其方法名，返回值和参数形态完全相同 

### 方法重载
  + Java 是支持重载的语言
  + 意味着同一个类中会出现两个或者两个以上同名的方法

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

## 接口
+ 接口是一个特殊的类：由常量和抽象方法组成
### 使用接口注意的规则
+ 通过关键字 interface 可以指定一个接口必须做什么，而不是规定这个接口如何去做。
+ 接口中定义的方法是不含方法体的。(即抽象方法)
+ 一旦接口被定义，任何类成员都可以实现该接口。
   > 一个类只可以有一个父类，但是可以实现多个接口

### 定义格式
  ```java
  [public] interface 接口名 [extends 父接口列表]{
      数据类型 变量名 = 常量值;      // 常量域声明
      返回类型 方法名(参数列表)[throws 异常列表]    // 抽象方法声明
  }
  ```

### 接口的几个规则
#### 接口具有继承性，一个接口还可以继承多个父接口，父接口用逗号隔开
  ```java
  interface InterfaceA{
    void testA();
  }

  interface InterfaceB{
    void testB();
  }

  interface InterfaceC extends InterfaceA,InterfaceB{
    void testC();
  }
  ```  
  *以上例子中接口 C 继承了接口 A 和接口 B*  

#### 系统默认 接口中的所有成员变量的修饰都是加上 `public`、 `static` 和 `final` 属性  
  > (即使不加修饰词，系统也是默认具有的以上三个属性的)，所以在接口中定义的变量都是不能改变的值  

  ```java
  interface circle{
    double PI = 3.1415926;
  }
  ```
 **完全等同于**  
  ```java
  interface circle{
    public static final double PI = 3.1415926;
  }
  ```  

####  接口只包括常量和抽象方法
  > 在接口内不能把定义变量和具体的成员方法，会导致错误

#### 接口本身具有抽象属性，不需 `abstract`修饰
  > 接口的访问控制权限有 `public` 和 默认权限，不具有 `protected` 和 `private` 权限
  ```java
  abstract interface InterfaceA  // 加上 `abstract` 关键字也不会报错

  public interface InterfaceA   // 声明一个具有公共权限的接口

  protected interface InterfaceA    // 编译出错，接口没有 protected 权限

  private interface InterfaceA    // 编译出错，接口没有 private 权限
  ```

#### 同一个Java 源文件中不能有两个及两个以上被 `public` 修饰的类或接口

#### 接口没有构造方法，不能通过接口直接生成接口的实例对象

### 接口的实现
  + 一个接口可以被一个类或者多个类实现
  + 一个类实现一个接口时，必须实现接口中的所有方法(方法覆盖)

#### 接口实现的具体格式
   + ```java
      class <类名> implements 接口1,接口2,...
     ```
#### 接口实现的具体例子
    不妨设立一个图形接口 JShape，该接口有两种方法：
      1.area():用来表示图形的面积
      2.draw():用来表示图形的画法  
   ```java
      interface JShape{
        void area();
        void draw();
        // 默认的public 访问权限
      }
   ```
    Circle 和 Rectangle2 分别实现了该接口
      需要注意的是两个类在实现接口的方法的时候需要加`public`关键字
   ```java
      class JCircle implements JShape {
        public void area() {
          System.out.println("面积公式：PI*radius*radius");
        }
        
        public void draw() {
          System.out.println("画我请使用圆规");
        }
      }

      class JRectangle2 implements JShape {
        public void area() {
          System.out.println("面积公式：width * height");
        }
        
        public void draw() {
          System.out.println("画我请使用直尺");
        }
      }
   ```
   然后设立 main() 函数进行测试
   ```java
    public static void main(String[] args) {
      JCircle c = new JCircle();
      c.area();
      c.draw();
      JRectangle2 t = new JRectangle2();
      t.area();
      t.draw();
    }
   ```

#### 通过接口可以引入多个类的共享常量
   > 接口中定义成员变量的都被默认 具有 public、static、final 属性，完全可以看做常量  

   ```java
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
   ```  
   > main() 函数进行测试
   ```java
    public static void main(String[] args) {
      JCircle2 c = new JCircle2();
      c.draw();
      System.out.println(c.getName());
    }
   ```
   > 输出控制台内容
   ```
    画我请使用圆规
    图形类：圆
   ```  

#### 接口可以扩展
   + 接口使用 `extends` 关键字被其他接口继承
   + 实现该接口的类必须实现该接口的继承列表上所有方法  

 比如  
   ```java
    interface A{void funcA();}
    interface B extends A{void funcB();}
    interface C extends B{void funcC();}
    
    // 实体类 D 实现接口 C 的接口，也必要实现 C 继承的接口B和 B 继承的接口A中的所有抽象方法 
    class D implements C{
      // 对 C 中的 funcC() 实现
      public void funcC(){...}

      // 对 C继承列表中的接口 B 中的 funcB() 需要进行实现
      public void funcB(){...}

      // 对 B 继承列表中的接口 A 的 抽象方法 funcA() 也要实现
      public void funcA(){...}
    }
   ```  

### List接口和ArrayList、LinkedList和 Vector 类
#### ArrayList类
 > 采用可变大小的数组“实现” List 接口
 + 初始 ArrayList 类型的对象大小为零，每植入一个值，数组大小将增加 1 
 + 实现的常用方法：(index为索引号，value为传入的值)
    > `get(index)`、`set(index,value)`、`add(index,value)`、`remove(index)`  

##### 使用ArrayList实现扑克牌分发原理(未区别颜色)
   + java代码实现
     ```java
      /*
      * 实现扑克牌的分发，假设一副扑克牌52张(去掉大小王)
      * 实现随机洗牌操作给四个人分发手牌：每个人手牌数量是一定的
      * 最后将每个人分到的牌按照花色排序后输出
      */

      import java.util.*;

      public class TestDealCard {

        public static void main(String[] args) {
          int numOfHands = 4;
          int cardsPerHand = 12; //
          
          //生成一副牌
          String [] suit = {"♠","♣","❤","♦"};	// 
          String [] rank = {"A","1","2","3","4","5","6","7","8","9","10","J","Q","K"};
          List deck = new ArrayList();
          
          for(int i =0;i<suit.length;i++) {
            for (int j =0;j<rank.length;j++) {
              deck.add(suit[i]+rank[j]);
            }
          }
          
          Collections.shuffle(deck);	//随机改变 deck 中元素的排列次序，即洗牌
          
          for(int i=0;i<numOfHands;i++) {
          // 生成一手牌，并对牌按花色排序后输出
            List p = dealCard(deck,cardsPerHand);
            Collections.sort(p);
            System.out.println(p);
          }
        }
        
        public static List dealCard(List deck,int n) {
          int deckSize = deck.size();
          List handView = deck.subList(deckSize - n, deckSize); // 从 deck 中截取一个子列表
          
          // 利用该子链表创建一个链表，作为返回值
          List hand = new ArrayList(handView);
          handView.clear();
          return hand;
        }
      }
     ```
    + 运行控制台输出一(随机分发的一次结果)  
      ```
      [♠10, ♠2, ♠8, ♠K, ♣2, ♣9, ♣Q, ♦2, ♦8, ♦K, ♦Q, ❤Q]
      [♠A, ♠Q, ♣6, ♣7, ♣8, ♣K, ♦10, ♦4, ❤1, ❤6, ❤8, ❤9]
      [♠4, ♠5, ♠6, ♠7, ♠J, ♣1, ♣3, ♣4, ♦7, ♦9, ♦A, ❤2]
      [♠1, ♣10, ♣5, ♦1, ♦5, ♦6, ♦J, ❤3, ❤4, ❤5, ❤A, ❤K]
      ```  

## 数据结构

### List接口

#### LinkedList 类
   > 链表结构实现 List 接口，提供了在链表开头和结尾处进行get、remove和insert操作以便实现堆栈、队列和双端队列

##### 从数据结构上理解
   > LinkedList是一种双向的链式结构每一个对象除了自身，还有两个引用(指针)

   >链表结构的插入和删除速度会比顺序结构(如ArrayList)的数组慢(慢在寻数上)，因为数组可以随机存储

##### LinkedList 实现栈的数据结构
   + 内含main方法用于测试操作
     ```java
      /*
      * 栈(Stack)的定义：限制仅在表的一端进行插入和删除运算的线性表
      * (1)称提供插入、删除的这一端为栈顶(Top),另一端为栈底(Bottom)
      * (2)当表中没有元素时称为空栈
      * (3)栈为后进先出(LIFO)的线性表
      */
      import java.util.LinkedList;

      public class TestStack {
        LinkedList linkList = new LinkedList<Object>();
        // 判断栈是否空
        public boolean isEmpty() {
          return linkList.isEmpty();
        }
        // 获取栈大当前大小
        public int getSize() {
          return linkList.size();
        }
        // 清空栈
        public void clear() {
          linkList.clear();
        }
        // 入栈
        public void push(Object obj) {
          linkList.addFirst(obj);
        }
        // 移除并返回栈顶元素,即出栈方法
        public Object pop() {
          if(!linkList.isEmpty()) {
            return linkList.removeFirst();
          }
          return "当前栈为空";
        }
        public static void main(String[] args) {
          TestStack myStack = new TestStack();
          myStack.push(1);
          myStack.push(3);
          myStack.push(2);
          System.out.println("移除栈顶元素"+myStack.pop());	// 输出2
          System.out.println("移除栈顶元素"+myStack.pop());	// 输出3
        }
      }
     ```  
     > 在 TestStack 类对 LinkedList 类提供的方法进行了选用，实现了栈在操作和结构上的限定范围，使用main方法进行测试运行的结果：3比2先进栈，但是出栈顺序是先2后3，符合出栈顺序“后进先出”

##### LinkedList 实现队列的数据结构
   + 内含main方法用于测试队列操作
     ```java
      /*
      * 队列(Queue)定义：只允许在一端进行插入，而在另一端进行删除的运算受限的线性表
      * (1)允许删除的一端称之为队头(Front)
      * (2)允许插入的一端称之为队尾(Rear)
      * (3)没有元素的队列称之为空队列
      * (4)队列也叫先进先出(FIFO)的线性表
      */

      import java.util.LinkedList;
        
      public class TestQueue {
        LinkedList linkedList = new LinkedList();
        //判空
        public boolean isEmpty() {
          return linkedList.isEmpty();
        }
        //获取当前队列长度
        public int getSize() {
          return linkedList.size();
        }
        //清空队列
        public void clear() {
          linkedList.clear();
        }
        // 队尾插入
        public void put(Object obj) {
          linkedList.addLast(obj);
        }
        // 队头移出元素
        public Object get() {
          if(!linkedList.isEmpty()) {
            return linkedList.removeFirst();
          }
          return "队列为空";
        }
        
        public static void main(String[] args) {
          TestQueue tq = new TestQueue();
          tq.put(100);
          tq.put(200);
          tq.put(300);
          System.out.println("队列是否为空"+tq.isEmpty());
          System.out.println("出队列操作"+tq.get());
          System.out.println("出队列操作"+tq.get());
          System.out.println("出队列操作"+tq.get());
          System.out.println("队列是否为空"+tq.isEmpty());
        }
      }
     ```  
     > 控制台输出  

     ```
      队列是否为空false
      出队列操作100
      出队列操作200
      出队列操作300
      队列是否为空true
     ```  

### ArrayList 和 LinkedList 的区别
  > ArrayList 底层原理的数据结构是数组：支持随机访问；移动一个元素ArrayList 是O(n);

  > LinkedList 的底层数据结构是双向循环列表，不支持随机访问；移动一个元素 LinkedList 的是O(1) 

  **两者都可以设置初始的空间大小**  
  > Vector 还可以设置增长空间大小的方法;ArrayList 没有  
  **同步性**
  > Vector 具有同步性，是线程安全的，当用到多线程访问集合的时候使用Vector就不需考虑和编写线程安全的代码

  > ArrayList 是线程异步的,

  **集合中元素数目大于长度时，Vector和ArrayList的增长度**  
  > Vector 的增长率为原来的 100%，；ArrayList 的增长率为原来的 50%

  > 集合中使用数据量比较大的时候，Vector 具有一定优势   

#### Vector(向量) 类
   > 使用可变体积的数组实现 List 接口，使用向量没有数组的范围限制，可以不断地添加元素  

   **注意向量内能添加的数据都是对象，向量是不能存放基本数据类型的数据的**

   + 向量变量的声明格式及构造函数  
     ```java
      Vector<向量元素的数据类型> 变量名;

      // 举例
      Vector<String> v;

      /**
      *Vector 运行时创建一个初始的存储容量initialCapacity
      *存储容量是以capacityIncrement变量定义的增量增长的
      */
      public Vector(int initialCapacity,int capacityIncrement){...}
      // 只创建初始存储容量 initialCapacity
      public Vector(int initialCapacity){...}
      // 不指定初始的存储容量也不指定 capacityIncrement
      public Vector(){...}
     ```  

### Set接口

  > 实现Set接口的常用类包括HashSet、TreeSet和LinkedHashSet  
 
   + HashSet 中一个 HashSet 对象中的元素存储在 Hash表中  
     > 元素数量较大时，访问效率比线性表快
     
   + TreeSet 采用有序树的结构存储集合中的元素，所有元素按照升序排序
 
   + LinkedHashSet采用 Hash表和链表相结合的结构存储集合中的元素：
     > 技能保证结合中元素的顺序，又具有较高的存取效率  

### Map接口 
  > Map集合 把键值映射到某个值，一个键值最多只能映射到一个值  
  + 主要实现操作: 基本操作/批操作、集合视图
   
    ```java  
    //Map 接口定义
    public interface Map{
        /*基本操作*/
        Object put(Object key,Object value);   //添加键值对
        Object get(Object key,Object value);  //通过键获取对应的值或删除该键值对
        Object remove(Object key);  //根据键删除该键值对
        boolean containsKey(Object key);  //测试set中是否有该键
        boolean containsValue(Object value);  //测试set中是否有该值
        int size(); //获取集合长度
        boolean isEmpty();  //判断集合是否为空

        /*整体批操作*/
        void putAll();
        void clear();

        /*集合视图*/
        public Set keySet();
        public Collection values();
    }
    ```  

  *Extra* 
  实现Set接口的类包括：HashMap,HashTable,TreeMap,WeekHashMap,IdentifyHashMap 等5个类
#### TreeMap类  
   > 该类按照键的升序排序元素

### Iterator(迭代器)