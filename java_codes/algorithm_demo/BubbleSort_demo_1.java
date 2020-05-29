package algorithm_demo;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 输入有 2 行，第 1 行为一个正整数，表示有 n 个同学参与调查(n≤100)。
 * 第 2 行有 n个用空格隔开的正整数，为每本图书的 ISBN 号(假设图书的 ISBN 号在 1~1000 之间)。
 * 请将其`去重`和`排序`  
 * 先使用冒泡排序
 * 然后在输出的时候去重
 */
public class BubbleSort_demo_1 {

	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		int [] array = new int [scan.nextInt()+1];
		int i,j,t,count=0;
		for(i=1;i<array.length;i++) {
			array[i] = scan.nextInt();
		}
		
		for(i =1;i<array.length;i++) {
			for(j=1;j<=array.length-i;j++) {
				if (array[j]>array[j+1]) {
					t = array[j];
					array[j] = array[j+1];
					array[j+1] =t;
				}
			}
		}
		System.out.println(Arrays.toString(array));
		
		for(i=2;i<array.length;i++) {
			if (array[i-1]!=array[i]) {
				count++;
				System.out.printf("%d ",array[i-1]);
			}
		}
		System.out.println("\n一共有 "+count+" 种图书版号");
	}

}
