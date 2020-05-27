# 经典排序算法(Java实现)

## 排序算法包含
|算法名称|类名|时间复杂度|说明|
-|-|-|-
|冒泡排序|BubbleSort|O()|原理属于交换排序|
|快速排序|||
||||
||||
||||

### 冒泡排序 BubbleSort
+ 概述
  > 遍历每一个数的基础上，将该数与该数之前的几个数进行比较大小，若该数小于之前的数，则互换位置，否则不动，继续遍历下一个数
+ 核心代码
   ```java
    //约定数组arrayay[n]
    for(int i = 0;i<array.length;i++) {
		for (int j = 0;j<array.length-i-1;j++) {
			if (array[j]>array[j+1]) {
                int temp =0;    //设置临时存储功能的变量
				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
			}
		}
	}

    //Bubble Sort算法时间复杂度O(n*n)
   ```
> 以上的冒泡算法的实现代码在每两个数之间进行比较，需要用三个变量来完成交换排序的步骤，以下对此优化，做到不使用额外的变量空间置换两个数

+ 优化方法1：   
  - 算数运算(加减)
    ```java
    x=x+y; //x暂存两数之和
    y=x-y; //y为两数之和减去y，即原来的x
    x=x-y; //x为两数之和减去现在的y（原来的x），变成原来的y
    ```  
    以上对纯数字的值进行操作符合数学关系

    把 `x` 看成`array[j]`,`y` 看成`array[j+1]`,将核心代码优化一下
    ```java
    array[j] = array[j]+array[j+1];
    array[j+1] = array[j] - array[j+1];
    array[j] = array[j] - array[j+1];
    ```
    **实际上可读性就可能很牵强了**
+ 优化方法2：
    逻辑运算(异或)
    ```java
    x^=y;//x先存x和y两者的信息
    y^=x;//保持x不变，利用x异或反转y的原始值使其等于x的原始值
    x^=y;//保持y不变，利用x异或反转y的原始值使其等于y的原始值
    ```
    同理将核心代码优化结果
    ```java
    array[j] ^= array[j+1];
    array[j+1] ^= array[j];
    array[j] ^= array[j+1];
    ```
