### 1. HttpServlet 已经实现 Servlet 接口的所有方法


### Servlet 是单例的
  + 一般情况下，服务器只创建一个 Servlet 对象
    - Servlet 对象一旦创建，就会一直存在服务直到服务器关闭

#### 在 \<servlet> 中使用 load-on-startup 
   + 在 WEB 应用启动时就可以创建 Servlet 的实例对象，调用该对象的 init() 方法
   
   *作用*
    + 可以为应用写一个 initServlet,在该 Servlet 配置为启动装载时，为整个应用创建必要的数据库表和数据
    + 可以完成一些定时的任务【如定时写日志，定时备份数据】


## 无论在 java web 中访问什么资源，都是在访问 Servlet
  + 访问静态网页，静态图片的时候，缺省 Servlet 都会在站点中寻找该资源，存在则返回给浏览器，没有就报 404 错误

### 缺省 Servlet
  + 凡是在web.xml 文件中找不到匹配的 \<servlet-mapping>元素的 url，这些访问请求都将会交给 `Default Servlet` 来处理

## ServletConfig 对象  

  + 通过 ServletConfig 对象可以读取 web.xml 配置中的初始参数
    *前提*  

    + 在对应的 `<Servlet>` 中已经设置好如下参数  
    **例**
      ```xml 
        <servlet>
		    <!-- 为 Demos_HttpServlet配一个名字【一般和类名一致】 -->
		    <servlet-name>/Demos_HttpServlet</servlet-name>
		    <!-- 类的存放位置在哪里【如果有包名，要加上包名】 -->
		    <servlet-class>com.demos.Demos_HttpServlet</servlet-class>
		    <init-param>
			    <param-name>Demos_HttpServlet_Param_A</param-name>
			    <param-value>Ricky</param-value>
		    </init-param>
	    </servlet>
      ```
    *之后*
    推荐在 Demos_HttpServlet.java 文件的 doGet() 方法体中加上
      ```java
      // 获取ServletConfig 对象  
		  ServletConfig servletconfig = this.getServletConfig();

		  // 根据配置的名字获取值
		  String value = servletconfig.getInitParameter("Demos_HttpServlet_Param_A");
		  System.out.println(value);
      ```
    然后重新运行工程，输入对应 url 查看效果

### 使用 web.xml 文件的好处(为什么使用 web.xml 文件)  

  + 来配置程序的参数信息只需要文件，若要更改，只需要更改 xml 文件即可，无需更改程序代码

## ServletContext 的用处  

  + 代表着当前 web 站点，所欲的 Servlet 都共享着一个 ServletContext 对象，所以 Servlet 之间可以通过 ServletContext 实现通信  

  + ServletConfig 对象可以获得单个 Servlet 的参数信息， ServletContext 可以获得整个 web 站点的参数信息，也就是说 ServletContext 可以读取整个站点的资源文件  

  + 实现Servlet的转发【用ServletContext转发不多，主要用request转发】