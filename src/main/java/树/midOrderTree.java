package 树;

import java.util.Stack;

/**
 * @Author: hqf
 * @description: 二叉树的中序遍历递归和非递归实现
 * @Data: Create in 13:47 2020/2/9
 * @Modified By:
 */
public class midOrderTree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static StringBuilder sb = new StringBuilder();

    /**
     * 二叉树中序遍历递归实现
     * @param pRoot
     */
    public void midOrderTree1(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        } else {
            midOrderTree1(pRoot.left);
            sb.append(pRoot.val);
            midOrderTree1(pRoot.right);
        }
    }

    /**
     * 二叉树中序遍历非递归实现（借助栈来实现，与前序遍历基本一样）
     * @param pRoot
     */
    public void midOrderTree2(TreeNode pRoot) {
        Stack<TreeNode> stack = new Stack<>();
        while (pRoot != null || !stack.isEmpty()) {
            while (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            if (!stack.isEmpty()) {
                pRoot = stack.pop();
                sb.append(pRoot.val);
                pRoot = pRoot.right;
            }
        }
    }

    public static void main(String[] args) {
        midOrderTree midTest = new midOrderTree();
        // 创建一棵二叉树
        TreeNode []tree = new TreeNode[10];
        for (int i = 0 ; i < tree.length ; ++i) {
            tree[i] = new TreeNode(i);
        }
        for (int i = 0 ; i < tree.length ; ++i) {
            if (2*i+1 < tree.length) {
                tree[i].left = tree[2*i+1];
            }
            if (2*i+2 < tree.length) {
                tree[i].right = tree[2*i+2];
            }
        }
        // 递归实现
//        midTest.midOrderTree1(tree[0]);
        // 非递归实现
        midTest.midOrderTree2(tree[0]);
        System.out.println(sb.toString());
    }
}
