import java.util.*;

public class FirstTest {

    public static class TreeNode {

        public TreeNode(int data) {
            this.data = data;
        }

        int data;
        TreeNode leftChild;
        TreeNode rightChild;
    }

    /**
     * 构建树
     */
    public static TreeNode createBinaryTree(List<Integer> input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        TreeNode treeNode = null;
        Integer data = input.get(0);
        input.remove(0);
        if (data != null) {
            treeNode = new TreeNode(data);
            treeNode.leftChild = createBinaryTree(input);
            treeNode.rightChild = createBinaryTree(input);
        }
        return treeNode;
    }

    /**
     * 前序遍历
     */
    public static void preOrderTraveral(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        System.out.println(treeNode.data);
        preOrderTraveral(treeNode.leftChild);
        preOrderTraveral(treeNode.rightChild);
    }

    /**
     * 中序遍历
     */
    public static void inOrderTraveral(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        preOrderTraveral(treeNode.leftChild);
        System.out.println(treeNode.data);
        preOrderTraveral(treeNode.rightChild);
    }

    /**
     * 后序遍历
     */
    public static void postOrderTraveral(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        preOrderTraveral(treeNode.leftChild);
        preOrderTraveral(treeNode.rightChild);
        System.out.println(treeNode.data);
    }

    public static void main(String[] args) {
        List<Integer> inputList = new ArrayList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
        TreeNode treeNode = createBinaryTree(inputList);
//        preOrderTraveral(treeNode);  //3 2 9 10 8 4
//        inOrderTraveral(treeNode); // 2 9 10 3 8 4
//        postOrderTraveral(treeNode); // 2 9 10 8 4 3

//        preOderTraverWithStack(treeNode); // 3 2 9 10 8 4
        levelOrderTraversal(treeNode);
    }

    /**
     * 利用栈回溯的特性也能实现树的遍历
     */
    public static void preOderTraverWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //当前节点不为空一直输出，遍历完所有左元素
            while (treeNode != null) {
                System.out.println(treeNode.data);
                //遍历完以后将该节点入栈，便于回溯的时候找右元素
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //开始回溯找右元素
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树层序遍历
     */
    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }
}
