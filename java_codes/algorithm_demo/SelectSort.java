package algorithm_demo;

import java.util.*;

public class SelectSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i=0;
        byte []arr = new byte[5];
        while(scan.nextByte()!='\0'){
            arr[i++]=scan.nextByte();
        }
        System.out.println(Arrays.toString(arr));
    }

    public static Object selectSort(int a[], int n){
        int i,j,max=0;    // 此处看你的习惯是设立最大值还是最小值

        for(i=0;i<a.length;i++){
            max = i;
            for(j=i;j<a.length;j++){
                if (a[max] < a[j]){
                    max = j;
                }
            }
            //
            if(max != i){
                int t = a[i];
                a[i] = a[max];
                a[max] = t;
            }


        }
        return a;
    }
}
