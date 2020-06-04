

# 多线程

## 线程有哪些状态
 > 通常 5 种：创建，就绪，运行，阻塞和死亡

## 如何实现线程

| 方法 | 说明 |
-|-
| 继承Thread类，覆盖run方法| 局限于一个类只能继承一个父类 |   
| 实现Runnable接口 | 优点是无须继承Thread类 |  
| 实现Callable接口，实现call()方法 |

## 线程的主要控制办法

|方法|说明|  
 -|- 
| sleep() | 线程睡眠 |  
| interrupt() | 线程唤醒 |  
| yield() | 线程让步 |  
| stop()| 线程终止 |  
| isAlive() | 线程状态测试 |
| suspend() | 线程暂停 |  
| resume() | 线程恢复 |

  *注:sleep()方法可能会抛出异常 interruptedException*

---

### 线程休眠 `sleep()`

```java
public static void sleep(long millis) throws interruptedException  
public static void sleep(long millis,int nanos) throws interruptedExcepion
```
`millis`为毫秒数,`nanos`为纳秒数

### 唤醒线程 `interrupt()`
唤醒线程的方法无外乎
+ 等到线程事先设定的时间自动醒来 
+ 调用 interrupt() 方法


### 线程让步 `yield()`
#### 

让当前正在运行的线程退出，但让出的运行空间归给那个线程*仍由操作系统分配*。

### 线程等待 `join()`

已知线程 t1，t2 在 t1 中调用 t2.join()，则 t1 线程暂停执行，直到 t2 线程完成时，t1 才会恢复执行，达到 t1 线程等待的效果

```java
void join(); // 等待该线程直到线程结束
void join(long millis); // 等待该线程终止的时间最长为 millis 毫秒
void join(long millis,long nanos);  // 等待该线程终止的时间最长为 millis 毫秒+ nanos 纳秒
```


### 线程互斥与同步 `Synchronized`

#### 多线程同步的基本原理
对程序中需要 *同步* 的语句块用 `synchronized` 修饰词进行同步

*同步即让多个线程能够协调地 `并发` 执行*  

```java
synchronized (obj){
    //同步语句块
}   
// 只有获得 obj 对象的锁，才能执行同步语句块
```

而同步方法
```java
synchronized void f(){
    //代码
}
```

### 后台线程 Daemon

  在后台执行服务的线程，例如：  
  * 操作系统中的隐藏程序
  * Java 的垃圾自动回收线程

  *注：*
  + *与后台线程对应的就是前台线程*  
  + *所有使用 Thread 建立的线程默认为前台线程，例如main主线程就是一个前台线程。*

在进程中
  + 只要有一个前台线程未退出，进程就不会终止
  + 只要所有的前台线程都已退出，该后台线程就会自动终结 *(不管本身线程是否结束)*

#### 建立后台程序实例：

```java
public class DaemonThread extends Thread{
    public DaemonThread(){
        setDaemon(true);    //该线程设置为后台线程，若 boolean 值为 false，则是设置为前台程序
        start();
    }
}
```

#### 判断一个线程是否为后台线程(守护线程)

```java
public static void main(String [] args){
    Thread thread = new Thread();
    thread.isDaemon();
}
```  

  *注：*
  + *必须在线程启动前调用 Thread 的 setDaemon()方法，否则会抛出异常，虽然这个时候线程是正常工作的，但是已经不再是守护线程*  

# 需要了解

## 并行和并发的区别？
  > 你吃饭吃到一半，电话来了，你一直到吃完了以后才去接，这就说明你不支持并发也不支持并行。
    你吃饭吃到一半，电话来了，你停了下来接了电话，接完后继续吃饭，这说明你支持并发。
    你吃饭吃到一半，电话来了，你一边打电话一边吃饭，这说明你支持并行。  
  
  + 并发：你要有处理多个任务的能力，但不是同时的
  + 并行：你有同时处理多个任务的能力  

## 守护线程
  > 即(daemon thread)，是个服务线程
