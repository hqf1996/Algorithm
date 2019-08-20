package 排序算法;

import java.util.Arrays;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 23:49 2019/8/20
 * @Modified By:
 */
public class SelectionSort {
    public static int[] selectionSort(int []a){
        if (a.length == 0){
            return null;
        }
        for (int i = 0 ; i < a.length ; ++i){
            int minIndex = i;//记录最小的index
            for (int j = i ; j < a.length ; ++j){
                if (a[j] < a[minIndex]){
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int []a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] sort_a = selectionSort(a);
        System.out.println(Arrays.toString(sort_a));
    }
}
