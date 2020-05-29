package algorithm_demo;

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
		//
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
