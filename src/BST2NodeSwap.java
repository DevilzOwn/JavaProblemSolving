import java.util.Arrays;

public class BST2NodeSwap {
    int[] inorder = new int[1001];
    int bindex = 0;

    public void recoverTree(TreeNode root) {
        if (root == null || isLeafNode(root)) return;
        int len = inOrder(root, -1);
        Arrays.sort(inorder, 0, len+1);
        correctBST(root);
    }

    private void correctBST(TreeNode root) {
        if(root == null) return;
        if (isLeafNode(root)) {
            if (root.val != inorder[bindex]) {
                root.val = inorder[bindex];
            }
            bindex++;
            return;
        }
        correctBST(root.left);
        if (root.val != inorder[bindex]) {
            root.val = inorder[bindex];
        }
        bindex++;
        correctBST(root.right);
    }

    private int inOrder(TreeNode root, int index) {
        System.out.println(inorder);
        if (root == null) return index;
        if (isLeafNode(root)) {
            inorder[++index] = root.val;
            return index;
        }
        index = inOrder(root.left, index);
        inorder[++index] = root.val;
        index = inOrder(root.right, index);
        return index;
    }

    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}