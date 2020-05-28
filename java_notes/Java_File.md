

Java File 操作
---
主要是用于处理磁盘文件，包括：
+ 创建、移动、删除文件，创建目录，改变文件名等等
+ 获取 文件名、文件路径、文件长度、最后一次修改时间等文件信息  
 
| 类名 | 所在包 | 说明
-|-|-
| File | java.io | 从 java.lang.Object 直接继承过来

### 常用方法
  + exists()  检测文件路径是否存在
  + createFile()  创建文件
  + createDirectory()  创建文件夹
  + copy()  复制文件
  + move()  移动文件
  + delete()  删除一个文件或目录
  + size()  查看文件个数
  + read()  读取文件
  + write()  写入文件