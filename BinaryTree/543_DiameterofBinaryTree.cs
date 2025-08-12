 **C# – Optimized O(n) Solution


public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val = 0, TreeNode left = null, TreeNode right = null)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution
{
    private int maxDiameter = 0;

    public int DiameterOfBinaryTree(TreeNode root)
    {
        DFS(root);
        return maxDiameter;
    }

    private int DFS(TreeNode node)
    {
        if (node == null) return 0;

        int leftHeight = DFS(node.left);
        int rightHeight = DFS(node.right);

        // Update max diameter if longer path found
        maxDiameter = Math.Max(maxDiameter, leftHeight + rightHeight);

        // Return height of current subtree
        return Math.Max(leftHeight, rightHeight) + 1;
    }
}


---
**Python – Optimized O(n) Solution

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        self.max_diameter = 0

        def dfs(node):
            if not node:
                return 0

            left_height = dfs(node.left)
            right_height = dfs(node.right)

            # Update max diameter if longer path found
            self.max_diameter = max(self.max_diameter, left_height + right_height)

            # Return height of current subtree
            return max(left_height, right_height) + 1

        dfs(root)
        return self.max_diameter


---

### **Complexity**

* **Time Complexity**: O(n) → Each node visited once
* **Space Complexity**: O(h) recursion stack, where `h` = height of the tree

