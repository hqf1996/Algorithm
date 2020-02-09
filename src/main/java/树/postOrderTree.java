package 树;

import java.util.Stack;

/**
 * @Author: hqf
 * @description: 二叉树的后序遍历递归和非递归实现
 * @Data: Create in 13:56 2020/2/9
 * @Modified By:
 */
public class postOrderTree {
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
     * 二叉树前序遍历递归实现
     * @param pRoot
     */
    public void postOrderTree1(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        } else {
            postOrderTree1(pRoot.left);
            postOrderTree1(pRoot.right);
            sb.append(pRoot.val);
        }
    }

    /**
     * 二叉树后续遍历非递归实现（与前序和中序遍历有所不同，需要两个栈，其中一个是辅助栈，
     * 用来记录另一个栈中该节点是其父节点的左结点还是右节点）
     * @param pRoot
     */
    public void postOrderTree2(TreeNode pRoot) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stackLeftOrRight = new Stack<>();
        while (pRoot != null || !stack1.isEmpty()) {
            while (pRoot != null) {
                stack1.push(pRoot);
                stackLeftOrRight.push(1);  // 1表示左结点，2表示右节点。也可以理解成1是还没有遍历过它的右子节点，
                                                // 2是已经遍历过右子节点了，则可以弹出并打印。
                pRoot = pRoot.left;
            }
            while (!stack1.isEmpty() && stackLeftOrRight.peek() == 2) {
                //如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                TreeNode node = stack1.pop();
                stackLeftOrRight.pop();
                sb.append(node.val);
            }
            if (!stack1.isEmpty() && stackLeftOrRight.peek() == 1) {
                //如果是从左子节点返回父节点，则将标记改为右子节点
                stackLeftOrRight.pop();
                stackLeftOrRight.push(2);
                pRoot = stack1.peek().right;
            }
        }
    }

    /**
     * 后序非递归的另一种实现方法（以根-右-左的顺序入栈，所以最后出栈的顺序就是左-右-根，
     * 这种方法和前序中序的写法几乎一样，只不过左右子树入栈顺序反一下就可以了，很好记）
     * @param pRoot
     */
    public void postOrderTree3(TreeNode pRoot) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        while (pRoot != null || !stack1.isEmpty()) {
            while (pRoot != null) {
                stack1.push(pRoot);
                stack2.push(pRoot);
                pRoot = pRoot.right;
            }
            if (!stack1.isEmpty()) {
                pRoot = stack1.pop();
                pRoot = pRoot.left;
            }
        }

        while (stack2.size() >0) {
            TreeNode node = stack2.pop();
            sb.append(node.val);
        }
    }

    public static void main(String[] args) {
        postOrderTree postTest = new postOrderTree();
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
//        postTest.postOrderTree1(tree[0]);
        // 非递归实现
//        postTest.postOrderTree2(tree[0]);
        postTest.postOrderTree3(tree[0]);
        System.out.println(sb.toString());
    }
}
