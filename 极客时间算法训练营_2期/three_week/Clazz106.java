package sf.极客时间算法训练营_2期.three_week;

import java.util.HashMap;

/**
 * @Description : 从中序到和后续构建二叉树
 * @Author :
 * @Date: 2021-12-05 11:59
 **/
public class Clazz106 {
    private HashMap<Integer, Integer> inorderArrayMap = new HashMap<>();
    private int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderArrayMap.put(inorder[i], i);//妙啊！将节点值及索引全部记录在哈希表中
        }

        post = postorder;
        TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    public TreeNode buildTree(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if (inorderEnd < inorderStart || postorderEnd < postorderStart) return null;

        int root = post[postorderEnd];//根据后序遍历结果，取得根节点
        int rootIndexInInorderArray = inorderArrayMap.get(root);//获取对应的索引

        TreeNode node = new TreeNode(root);//创建该节点
        node.left = buildTree(inorderStart, rootIndexInInorderArray - 1, postorderStart, postorderStart + rootIndexInInorderArray - inorderStart - 1);
        node.right = buildTree(rootIndexInInorderArray + 1, inorderEnd, postorderStart + rootIndexInInorderArray - inorderStart, postorderEnd - 1);
        return node;//注意！返回的是新建的node！
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
