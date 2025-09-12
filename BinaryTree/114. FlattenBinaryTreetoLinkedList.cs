/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Solution {
    private TreeNode prev = null; // keeps track of the previously processed node

    public void Flatten(TreeNode root) {
        if (root == null) return;

        // traverse right first so that prev points to flattened right subtree
        Flatten(root.right);
        Flatten(root.left);

        // attach the previously processed node to the current node's right
        root.right = prev;
        root.left = null;  // left must always be null per problem statement

        // update prev to current node for next iteration
        prev = root;
    }
}

-------------------- .py-----------------------------
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def __init__(self):
        self.prev = None  # keeps track of the previously processed node

    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return

        # traverse right first so that self.prev points to flattened right subtree
        self.flatten(root.right)
        self.flatten(root.left)

        # attach the previously processed node to the current node's right
        root.right = self.prev
        root.left = None  # left must always be null per problem statement

        # update prev to current node for next iteration
        self.prev = root

#
