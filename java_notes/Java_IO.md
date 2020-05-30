Java_IO
===

流(stream)
---
+ 又称数据流
+ 是供数据传输的通道
+ 是从源到到目的的字节的有序队列，特点先进先出
+ 按功能来分：输入流(input)和输出流(output)
    - 输入字节流
+ 按类型来分：字节流和字符流
    - 字节流按8位(bit),以(即2Byte)1个字节为单位输入输出数据
    > 以(Inputstream/Outputstream)为基类
    - 字符流按16位(bit)的Unicode(即2Byte)为单位输入输出数据
    > 以(Reader/Write)为基类,类名大多以Reader或Writer结尾
+ 按照流的处理位置来分：节点流和处理流


**注意使用Java流的代码**
+ 必须使Java流的代码包括在try-catch处理中，如  
  
   ```java
   try{
        FileInputStream rf = new FileInputStream("...文件完整路径...");
        ...
   }catch(Exception e){
       //
   }
   ```

### 标准输入输出流
  + 指Java在命令行方式下的输入输出方式  

    |对象|功能|
    -|-
    |System.in|标准输入|
    |System.out|标准输出|
    |System.err|标准错误输出|

  > 每当main()方法被执行的时候，就自动生成以上三个对象

### 字节流

+ 常用字节流的类层次
    ```
    java.lang.Object  
            |__ InputStream  
            |       |__ FileInputStream
            |       |__ FilterInputStream
            |               |__ BufferedInputStream  
            |               |__ DataInputStream
            |
            |__ OutputStream
                    |__ FileOutputStream
                    |__ FilterOutputStream
                            |__ BufferedOutputStream
                            |__ DataOutputStream
                            |__ PrintStream
    ```


### 字符流

### 可能会遇到的面试问题

#### java 中的IO流分为几种？

 > 按功能来分：输入流(input)和输出流(output)  
   按类型来分：字节流和字符流  
   字节流按8位以字节为单位输入输出数据  
   字符流按16位以字符为单位输入输出数据

#### BIO、NIO、AIO有什么区别？
  > BIO：Block IO同步阻塞式 IO，就是我们平常使用的传统IO  
  > NIO：New IO同步非阻塞式 IO，是传统IO的升级，客户端和服务端通过Channel(管道)多路复用  
  > AIO：Asynchronous IO是NIO的升级，也叫NIO2，实现了异步非堵塞 IO，异步IO的操作属于事件和回调机制