package Leetcode.分治_递归;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 14:21 2020/2/22
 * @Modified By:
 */
public class m_95 {

    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        List<TreeNode> result = generateTreesBi(1, n);
        return result;
    }

    public List<TreeNode> generateTreesBi(int start, int n) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if (start > n) {
            result.add(null);
            return result;
        }
        for (int i = start ; i <= n ; ++i) {
            List<TreeNode> left = generateTreesBi(start, i-1);
            List<TreeNode> right = generateTreesBi(i+1, n);
            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = lnode;
                    node.right = rnode;
                    result.add(node);
                }
            }
        }
        return result;
    }
}
