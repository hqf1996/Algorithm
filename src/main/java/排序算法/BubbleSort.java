package 排序算法;

import java.util.Arrays;

/**
 * @Author: hqf
 * @description: 冒泡排序
 * @Data: Create in 23:15 2019/8/19
 * @Modified By:
 */
public class BubbleSort {
    public static int[] bubbleSort(int []a){
        if (a.length == 0) {
            System.out.println("需要长度大于0的数组");
            return null;
        }
        for (int i = 0 ; i < a.length ; ++i){
            for (int j = 0 ; j < a.length-i-1 ; ++j){
//                if (a[j] > a[j+1]){
//                    int temp = a[j];
//                    a[j] = a[j+1];
//                    a[j+1] = temp;
//                }
                // 交换可用位运算
                a[j] ^= a[j+1];
                a[j+1] ^= a[j];
                a[j] ^= a[j+1];
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int []a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] sort_a = bubbleSort(a);
        System.out.println(Arrays.toString(sort_a));
    }
}
