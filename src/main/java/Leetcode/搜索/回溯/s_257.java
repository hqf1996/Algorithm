package Leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 11:12 2020/2/27
 * @Modified By:
 */
public class s_257 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 这个是一般的dfs的解法，是不带有回溯的意思的，因为这边用的是String，而非StringBuilder，每次的对象都是新创建的，
    // 而非是自身，所以不需要减去下一层递归添加上的字符，而用StringBuilder因为都是添加在同一个对象上的，所以在返回上一层
    // 的时候需要把已经添加上的字符都减去。
    public List<String> binaryTreePaths(TreeNode root) {
        // dfs
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, "", result);
        return result;
    }

    public void dfs(TreeNode root, String s, List<String> result) {
        if (s == "") {
            s+=root.val;
        } else {
            s+=("->"+root.val);
        }
        if (root.left==null && root.right==null) {
            result.add(s);
        } else {
            if (root.left != null) {
                dfs(root.left, s, result);
            }
            if (root.right != null) {
                dfs(root.right, s, result);
            }
        }
    }

    // 用StringBuilder的回溯的写法
//    public List<String> binaryTreePaths(TreeNode root) {
//        // dfs
//        List<String> result = new ArrayList<>();
//        if (root == null) {
//            return result;
//        }
//        dfs(root, new StringBuilder(), result);
//        return result;
//    }
//
//    public void dfs(TreeNode root, StringBuilder sb, List<String> result) {
//        if (root == null) {
//            return;
//        }
//        sb.append(root.val);
//        if (root.left==null && root.right==null) {
//            result.add(sb.toString());
//            return;
//        } else {
//            if (root.left != null) {
//                dfs(root.left, sb.append("->"), result);
//                sb.delete(sb.length()-String.valueOf(root.left.val).length()-2, sb.length());
//            }
//            if (root.right != null) {
//                dfs(root.right, sb.append("->"), result);
//                sb.delete(sb.length()-String.valueOf(root.right.val).length()-2, sb.length());
//            }
//        }
//    }
}
