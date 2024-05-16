/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : Facebook, Amazon
    Leetcode Link               : https://leetcode.com/problems/evaluate-boolean-binary-tree/description/
*/

/ C++ ************************************************************************************************************************/
//Using simple recursion
//T.C : O(n)
//S.C : O(depth of tree)
class Solution {
public:
    bool evaluateTree(TreeNode* root) {
        if(root->left == NULL && root->right == NULL) {
            return root->val;
        }
        
        if(root->val == 2) {
            return evaluateTree(root->left) | evaluateTree(root->right);
        }
        
        return evaluateTree(root->left) & evaluateTree(root->right);
    }
};



/ JAVA ************************************************************************************************************************/
//Using simple recursion
//T.C : O(n)
//S.C : O(depth of tree)
class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val != 0; // Convert int to boolean
        }
        
        if (root.val == 2) {
            return evaluateTree(root.left) | evaluateTree(root.right);
        }
        
        return evaluateTree(root.left) & evaluateTree(root.right);
    }
}

// And
public class Solution {

    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return true; // An empty tree is considered valid
        }

        if (root.left == null && root.right == null) {
            // Leaf node: return its value (0 or 1)
            return root.val == 1;
        }

        boolean leftResult = evaluateTree(root.left);
        boolean rightResult = evaluateTree(root.right);

        if (root.val == 2) {
            // OR operation
            return leftResult || rightResult;
        } else if (root.val == 3) {
            // AND operation
            return leftResult && rightResult;
        }

        // Invalid node value
        return false;
    }

}



/ C# ************************************************************************************************************************/
public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Solution
{
    public bool EvaluateTree(TreeNode root)
    {
        if (root == null)
        {
            return true; // An empty tree is considered valid
        }

        if (root.left == null && root.right == null)
        {
            // Leaf node: return its value (0 or 1)
            return root.val == 1;
        }

        bool leftResult = EvaluateTree(root.left);
        bool rightResult = EvaluateTree(root.right);

        if (root.val == 2)
        {
            // OR operation
            return leftResult || rightResult;
        }
        else if (root.val == 3)
        {
            // AND operation
            return leftResult && rightResult;
        }

        // Invalid node value
        return false;
    }

    public static void Main(string[] args)
    {
        // Example usage:
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        Solution solution = new Solution();
        Console.WriteLine("Example result: " + solution.EvaluateTree(root)); // Output: true
    }
}
