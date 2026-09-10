class Solution {
    private record Pair(int sum, int cnt) {}
    private int ans = 0; 
    private Pair getAvg(TreeNode node) {
        if(node == null) return new Pair(0, 0); 

        Pair left = getAvg(node.left); 
        Pair right = getAvg(node.right); 
        int sum = left.sum + right.sum + node.val; 
        int cnt = left.cnt + right.cnt + 1; 
        int avg = sum / cnt; 
        if(avg == node.val) ans++; 

        return new Pair(sum, cnt); 
    }
    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;
        ans = 0; 
        getAvg(root); 
        return ans; 
    }
}