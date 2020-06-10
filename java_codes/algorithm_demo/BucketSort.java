package algorithm_demo;

import java.util.Arrays;
import java.util.Scanner;

public class BucketSort {

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
}
