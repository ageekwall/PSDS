public class lc938 {

    private int inOrder(TreeNode root, int L, int R) {
        int sum = 0;
        if(root == null) return 0;
        sum += inOrder(root.left, L, R);
        if(root.val >= L &&root.val <= R )
            sum += root.val;
        sum += inOrder(root.right, L, R);
        return sum;
    }
}
