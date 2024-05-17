/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : Dunzo, Sprinkler
    Leetcode Link               : https://leetcode.com/problems/delete-leaves-with-a-given-value
*/


/ C++ ************************************************************************************************************************/
//Simple Recursion story to code
//T.C : O(n)
//S.C : O(height)
class Solution {
public:
    TreeNode* removeLeafNodes(TreeNode* root, int target) {
        if(!root) {
            return NULL;
        }

        root->left  = removeLeafNodes(root->left, target);
        root->right = removeLeafNodes(root->right, target);

        if(root->left == NULL && root->right == NULL && root->val == target)
            return NULL;

        return root;
        
    }
};



/ JAVA ************************************************************************************************************************/
//Simple Recursion story to code
//T.C : O(n)
//S.C : O(height)

public class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        
        // Recursively process left and right subtrees
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        
        // If the current node is a leaf and has the target value, remove it
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        
        return root;
    }
}
/ C# ************************************************************************************************************************/
public class Solution
{
    public TreeNode RemoveLeafNodes(TreeNode root, int target)
    {
        if (root == null)
        {
            return null;
        }

        // Recursively process left and right subtrees
        root.left = RemoveLeafNodes(root.left, target);
        root.right = RemoveLeafNodes(root.right, target);

        // If the current node is a leaf and has the target value, remove it
        if (root.left == null && root.right == null && root.val == target)
        {
            return null;
        }

        return root;
    }
}
