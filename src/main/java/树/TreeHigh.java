package 树;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: hqf
 * @description: 求二叉树的树高，有递归和非递归两种解法
 * @Data: Create in 10:49 2020/2/3
 * @Modified By:
 */
public class TreeHigh {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归解法
     * @param root 树根
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return (Math.max(left, right) + 1);
    }

    /**
     * 非递归写法（也就是层序遍历非递归的通常做法）
     * @param root 树根
     * @return
     */
    public int TreeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0 ; i < size ; ++i) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
