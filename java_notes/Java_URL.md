
# Java URL 编程

## URL

全称 `Uniform Resource Locator` 是统资源定位器的简称。

### URL 常见形式

    [协议名://主机名] http://www.example.com/   

    [协议名://主机名 + 文件名] http://www.example.com/main/index.html   

    [协议名://主机名 + 文件名 + 内部引用] http://www.example.com/main/index.html# TOP   

其中主机名可以用在公网中的IP地址  

*由此可以抽象出以下*

### URL 组成

<u>protocol</u> ://<u>resourceName</u>:<u>port</u>/<u>resouceName</u>#<u>anchor</u>
 
`protocol` 指明获取资源所使用的传输协议，比如*FTP* *HTTP* *File* 等

`resourceName` 资源名 

`port` 端口号  

`anchor` 标记/定位符 <可选> 指定文件内有特定标记的位置

### URL类    

    URL类在包java.net中定义

类构造方法初始化URL对象示例

| 序号 | 方法 | 参数(个数) | 说明 |
|:-:|-|-|-|
| 1. | public URL(String spec) | spec (1个)| spec 为表示 URL 地址的字符串 |   
| 2. | public URL(URL context,String spec) | context,spce(2个) | context 作为基URL, spec 作为相对 URL 共同组成一个 URL 对象 |   
| 3. | public URL(String protocol,String host,String file) | protocol,host,file(3个) | 通过协议名、域名以及文件名构造一个 URL 对象 |  
| 4. | public URL(String protocol,String host,int port,String file) | protocol,host,port,file(4个) | 通过协议名、域名、端口号以及文件名构造一个 URL 对象 |

*注：URL 类构造方法**都**可能会抛出异常，因此在生成 URL 类对象时都要对Exception进行处理*  

#### URL 对象生成后，其属性**只读**,可以通过URL类的方法来获取属性

| 返回值类型 方法名 | 返回信息 |  
-|-
| String getProtocol() | 该URL的协议名 |  
| String getHost() | 该URL的主机名 |  
| int getPort() | 该URL的端口号，如未设置则返回-1 |  
| String getFile() | 该URL的文件名，如未设置则返回空串 |  
| String getRef() | 该URL中记录的引用，如不含引用则返回null |  
| String getQuery() | 该URL的查询信息 |  
| String getPath() | 该URL的路径 |  
| String getAuthority() | 该URL的权限信息 |  
| String getUserInfo() | 该URL的使用者信息 |  

#### 当得到 URL 对象后，使用 openStream（） 读取指定的 `WWW` 资源

+ openStream()与指定的 URL 建立连接并返回 InputStream 类的对象，从连接中读取数据

```java
// 使用 URL 来读取网页资源
public static void main(String[] args) {
	try {						// 声明抛出所有异常
		// 构建一个 URL 对象
		URL  tric = new URL("http://zkfw.91job.org.cn/");
			
		// 使用 openStream 得到一个输入流并由此构造一个 BufferedReader 对象
		BufferedReader in = new BufferedReader(new InputStreamReader(tric.openStream()));
			
		String inputLine;
		
		// 从输入流不断读取数据，直到读完为止
		while((inputLine = in.readLine())!= null) {
			System.out.println(inputLine); // 把读入的数据输出到屏幕上
		}
			
		in.close();	// 关闭输入流
	} catch (Exception e){
		e.printStackTrace();
	}
}
```  

*注：因为读取网页的方式没有指定编码方式，输出结果内中文内容可能产生乱码，以下是针对此问题选用 utf-8 编码进行优化,utf-8包含世界上所有国家使用的字符集。*

```java
BufferedReader in = new BufferedReader(new InputStreamReader(tric.openStream(),"utf-8"));
```  


注：
  + openStream()方法只能读取数据
  + 主机有需要向服务器端发送数据的需求  

所以需要  
### URLConnection 类 实现双向通信

    在包 java.net 中定义

类 URLConnection 的使用

1. 建立连接  
    ```java
    URL url = new URL("https://www.github.com");
    URLConnection connection = url.openConnection();
    ```

1. 向服务端发送数据  
    ```java  
    PrintStream ps = new PrintStream(connection.getOutputStream());
    ```

1. 从服务器读数据
    ```java
    DataInputStream dis = new DataInputStream(connection.getInputStream());
    dis.readLine();
    ```