class Solution {
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        longPath(root);
        return ans;
    }

    public int longPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = longPath(root.left);
        int right = longPath(root.right);
        int leftArrow = 0;
        int rightArrow = 0;

        if (root.left != null && root.left.val == root.val) {
            leftArrow = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rightArrow = right + 1;
        }
        ans = Math.max(ans, leftArrow + rightArrow);
        return Math.max(leftArrow, rightArrow);
    }
}