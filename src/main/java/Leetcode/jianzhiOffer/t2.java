package Leetcode.jianzhiOffer;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 10:54 2020/3/11
 * @Modified By:
 */
public class t2 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 从矩阵的左下角开始走
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        int x = m, y = n;
        while (x>=0 && y<=n) {
            if (matrix[x][y] > target) {
                x--;
            } else if (matrix[x][y] < target) {
                y++;
            } else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] matrix = {};
        t2 tt = new t2();
        tt.findNumberIn2DArray(matrix, 5);
    }
}
