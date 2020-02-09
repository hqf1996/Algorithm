package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: hqf
 * @description: 树的层次遍历
 * @Data: Create in 16:37 2020/2/9
 * @Modified By:
 */
public class layerOrderTree {
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
     * 二叉树的层次遍历（要用到队列来做或者List也行，也就相当于图的bfs的做法）
     * @param pRoot
     */
    public void layerOrderTree1(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0 ; i < size ; ++i) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
    }


    public static void main(String[] args) {
        layerOrderTree layerTest = new layerOrderTree();
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

        layerTest.layerOrderTree1(tree[0]);
        System.out.println(sb.toString());
    }
}
