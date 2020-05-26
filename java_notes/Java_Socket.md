
 

# Java Socket 编程
Java 中，Socket编程主要是指基于 TCP/IP 协议的网络编程

## Socket

+ 两个网络程序通过一个双向的通信连接交换数据，该双向链路的每一端就可称为一个 Socket，也可称为“套接字”。

+ 不同的应用进程和连接通过 OS 为应用与 TCP/IP 提供的 Socket 接口，得以区分不同应用进程间的通信和连接

+ 通常用来实现客户端和服务端的连接

## Socket 主要参数

1. 通信的目的IP地址

1. 使用的传输层协议( TCP or UDP)

1. 使用的端口号

*注：在 Java 环境中，一个Socket的一个 IP 和一个端口号是唯一确定的*

## Socket 工作的基本步骤

1. 创建 Socket

1. 打开连接到 Socket 的输入/输出流

1. 按照一定的协议对 Socket 进行读/写操作

1. 关闭 Socket


## Socket 编程使用到的 Java 类

| 类名 | 所在包 | 说明 |
|-|-|-|
| Socket | java.net | 表示双向连接中的**客户**端 |
| ServerSocket | java.net | 表示双向连接中的**服务**端 |


### ServerSocket 

连接服务端

+ 一次只能与一个客户端相连接

+ 多客户端连接服务请求将会被存入队列中,队列大小默认为50


