# 经典排序算法(Java实现)

## 排序算法包含
|算法名称|类名|平均时间复杂度|说明|
-|-|-|-
|冒泡排序|BubbleSort|O(n*n)|原理属于交换排序|
|快速排序|QuickSort||
|桶排序(简化版)|BucketSort/Simple||
|选择排序|SelectSort||
||||

### 冒泡排序
#### 基本思想
   > 每次比较两个相邻的元素，如果他们顺序错误，就将他们交换过来

#### 一次完整的冒泡算法实现
  + 使用了 java 的 Arrays 类(内置方法输出数组)和 Random 类(随机生成事先规定范围的测试数据)

    ```java
      import java.util.Arrays;
      import java.util.Random;
      import java.util.Scanner;

      public class BubbleSort {
         public static void main(String[] args) {
            System.out.println("请输入想要生成数组的长度");
            Scanner scan = new Scanner(System.in);
            int [] arr = new int [scan.nextInt()];
            for (int i = 0;i<arr.length;i++) {
               Random ran = new Random();	// 生成一个随机种子
               arr[i] = ran.nextInt(100);
            }
            System.out.println("原数组为"+Arrays.toString(arr));
            
            // 冒泡排序
            int temp = 0,step = 0;
            for(int i = 0;i<arr.length;i++) {
               for (int j = i+1;j<arr.length;j++) {
                  if (arr[i]>arr[j]) {
                     temp = arr[i];
                     arr[i] = arr[j];
                     arr[j] = temp;
                  }
                  System.out.println("第"+(++step)+"次冒泡排序"+Arrays.toString(arr));
               }
            }
            System.out.println("冒泡排序后的数组为"+Arrays.toString(arr));
         }
      }
    ```  

  + 随机的测试数据和输出效果  

     ```
      请输入想要生成数组的长度
      5
      原数组为[60, 96, 34, 84, 52]
      第1次冒泡排序[60, 96, 34, 84, 52]
      第2次冒泡排序[34, 96, 60, 84, 52]
      第3次冒泡排序[34, 96, 60, 84, 52]
      第4次冒泡排序[34, 96, 60, 84, 52]
      第5次冒泡排序[34, 60, 96, 84, 52]
      第6次冒泡排序[34, 60, 96, 84, 52]
      第7次冒泡排序[34, 52, 96, 84, 60]
      第8次冒泡排序[34, 52, 84, 96, 60]
      第9次冒泡排序[34, 52, 60, 96, 84]
      第10次冒泡排序[34, 52, 60, 84, 96]
      冒泡排序后的数组为[34, 52, 60, 84, 96]
     ```   


#### 冒泡排序算法核心步骤  
   ```java
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
```  
   > `temp` 就是起到了这个临时变量的作用

#### 思考背景--无需额外变量变量交换两个数/变量的值
在对经典排序算法进行复习的时候，发现排序算法对数组队列等数组结构中元素的操作大几率会用到交换两个变量的值(在逻辑上表现为交换两个元素的位置)，基础操作会是在额外声明一个新变量用于辅助交换元素的临时存值空间，比如
要想做到不使用临时变量存储对两个数进行位置互换(逻辑上)，是不是可以通过数学关系上两者的运算来达到这个效果，以下对此优化，做到不使用额外的变量空间置换两个数

#### 优化方法1：   
   算数运算(加减)
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
#### 优化方法2：
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
    **可读性可能也是差强人意**

**以上只是对方法的探讨。**


### 快速排序
  + 基于 `二分` 的思想
  + 多次改变基准数排序步骤利用`递归`方法自身

#### 快速排序算法实现
   + ```java
      static void QuickSort(int left, int right, int a[]) {
         if (left > right)
            return;

         int i, j, t, temp;
         temp = a[left]; // temp 就是保存基准数的
         i = left; // 用于标记比基准数大的数组元素的索引,首先初始化到序列最左侧
         j = right; // 用于标记比基准数小的数组元素的索引,首先初始化到序列最右侧

         while (i != j) { // 当 i和j还未相遇时，比较操作不会终止

            // 先从右侧开始遍历比较
            while (a[j] >= temp &&i<j) {
               j--;
            }

            while (a[i] <= temp &&i<j) {
               i++;
            }
            
            if (i < j) {
               // 循环操作数已经终止 接下来进行交换数位置的操作
               t = a[i];
               a[i] = a[j];
               a[j] = t;
            }

         }
         // 当i与 j相遇，接下来进行i,j所在的位置作为新的基准数，原来的基准数放入a[i]的位置(基准数归位)
         a[left] = a[i];
         a[i] = temp;
         //
         QuickSort(left, i - 1, a);
         QuickSort(i + 1, right, a);
      }
     ```

#### 一个完整的快速排序的实例
   + 使用 Scanner 和 Arrays 进行辅助测试程序的进行  
     ```java
      import java.util.Arrays;
      import java.util.Scanner;

      public class QuickSortTest {

         static void QuickSort(int left, int right, int a[]) {
            if (left > right)
               return;

            int i, j, t, temp;
            temp = a[left]; // temp 就是保存基准数的
            i = left; // 用于标记比基准数大的数组元素的索引,首先初始化到序列最左侧
            j = right; // 用于标记比基准数小的数组元素的索引,首先初始化到序列最右侧

            while (i != j) { // 当 i和j还未相遇时，比较操作不会终止

               // 先从右侧开始遍历比较
               while (a[j] >= temp &&i<j) {
                  j--;
               }
               while (a[i] <= temp &&i<j) {
                  i++;
               }
               if (i < j) {
                  // 循环操作数已经终止 接下来进行交换数位置的操作
                  t = a[i];
                  a[i] = a[j];
                  a[j] = t;
               }
            }
            // 当i与 j相遇，接下来进行i,j所在的位置作为新的基准数，原来的基准数放入a[i]的位置(基准数归位)
            a[left] = a[i];
            a[i] = temp;
            //完成这个基准数的所有排序工作之后对方法自身进行递归调用完成划分开的多个序列进行相同快排操作
            QuickSort(left, i - 1, a);
            QuickSort(i + 1, right, a);
         }

         public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int[] array = new int[11];
            int n = scan.nextInt();
            for (int i = 1; i <= n; i++) {
               array[i] = scan.nextInt();
            }
            System.out.println("快速排序前的数组：" + Arrays.toString(array));
            QuickSort(1, n, array);
            System.out.println("快速排序后的数组：" + Arrays.toString(array));
         }
      }
     ```  
   + 输入测试数据和输出结果
     ```
     10 
     6 1 2 7 9 3 4 5 10 8 
     快速排序前的数组：[6, 1, 2, 7, 9, 3, 4, 5, 10, 8]
     快速排序后的数组：[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
     ```

### 简化版桶排序
  + 假设一组自然数，我们已知这组数的最大值和最小值
  + 我们将会设立一个长度略大于这组数最大值的数组
  + 遍历这个数组，将每个元素的数值与数组索引值相同的数组元素+1(表示个数+1)
  + 遍历结束以后，可以根绝升序还是降序的要求进行顺序或者逆序打印数组里不为0的索引值，每个数组元素的值多大，该数组元素对应的索引值就重复打印多少次

#### “简化版桶排序” 算法实现   
   + 命题  
     输入一组数(已知是0~9的自然数)：  
        > 5 3 5 2 8   

     使用简化版的桶排序将该组数降序输出
   + Java 实现版本  
     ```java
      public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
         int []array = new int [101];
         int i,j,n;
         for (i=0;i<array.length;i++) {
            array[i]=0;
         }
         n = scan.nextInt();
         for (i=0;i<n;i++) {
            if (scan.hasNextInt()) {
               array[scan.nextInt()]++;
            }
         }
         for (i=0;i<array.length;i++) {
            if(array[i]>0) {
               for(j=0;j<array[i];j++) {
                  System.out.printf("%d ",i);
               }
            }
         }
         scan.close();
      }
     ```  
