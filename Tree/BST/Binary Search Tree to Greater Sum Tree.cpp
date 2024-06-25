/*    scroll below to see JAVA code and C# also    */
/*
    Company Tags                : AMAZON
    Leetcode Link               : https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree
*/

/ JAVA ************************************************************************************************************************************/
//Simple recursive approach
//T.C : O(n)
//S.C : O(1)
class Solution {
public:

    void solve(TreeNode* root, int &sum) {
        if(!root) { //root == NULL
            return;
        }

        
        solve(root->right, sum); //RIGHT is covered
        
        sum += root->val;

        root->val = sum;

        solve(root->left, sum); //Covergin the left
    }

    TreeNode* bstToGst(TreeNode* root) {
        int sum = 0;

        solve(root, sum);

        return root;
    }
};


/ JAVA ************************************************************************************************************************************/
//Simple recursive approach
//T.C : O(n)
//S.C : O(1)
class Solution {
    public void solve(TreeNode root, int[] sum) {
        if (root == null) {
            return;
        }

        solve(root.right, sum); // Process right subtree

        sum[0] += root.val; // Update the sum with the value of the current node
        root.val = sum[0]; // Update the current node value with the sum

        solve(root.left, sum); // Process left subtree
    }

    public TreeNode bstToGst(TreeNode root) {
        int[] sum = new int[1]; // Use an array to hold the sum because Java passes by value
        solve(root, sum); // Start the conversion
        return root; // Return the modified tree
    }
}

/ C# ************************************************************************************************************************************/
// Simple recursive approach
// T.C : O(n)
// S.C : O(1)

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public void Solve(TreeNode root, ref int sum) {
        if (root == null) {
            return;
        }

        Solve(root.right, ref sum); // Process right subtree

        sum += root.val; // Update the sum with the value of the current node
        root.val = sum; // Update the current node value with the sum

        Solve(root.left, ref sum); // Process left subtree
    }

    public TreeNode BstToGst(TreeNode root) {
        int sum = 0;
        Solve(root, ref sum); // Start the conversion
        return root; // Return the modified tree
    }
}
