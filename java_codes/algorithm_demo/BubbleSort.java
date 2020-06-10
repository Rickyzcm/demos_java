package algorithm_demo;

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
