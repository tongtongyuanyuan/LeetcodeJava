import javax.swing.tree.TreeNode;

public class secondMin {

    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(TreeNode left, TreeNode right, int x) {
            this.left = left;
            this.right = right;
            this.val = x;
        }

    }
    // time: O(N)
    private static int findSecondMinimumValue(TreeNode root) {
        first = root.val;
        dfs(root);
        return second < Long.MAX_VALUE ? (int) second : -1;
    }

    static int first;
    static long second = Long.MAX_VALUE;

    public static void dfs(TreeNode root) {
        // if root is not null we can check its values
        if (root != null) {
            // if node.val is between first and second
            // we found the new second value
            if (first < root.val && root.val < second) { // first < root < second
                second = root.val;
            } else if (first == root.val) { // if root == first meaning all nodes in the subtree are atleast  of first value so we can trinside to find.
                dfs(root.left);
                dfs(root.right);
            }

            // any root greater than second we do not care as we need only second min
        }
    }
}
