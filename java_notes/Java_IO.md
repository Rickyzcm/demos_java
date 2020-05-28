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