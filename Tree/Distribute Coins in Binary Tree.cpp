/*             Scroll below to see JAVA code and C# also      */
/*
     
      Company Tags                : Microsoft
      Leetcode Link               : https://leetcode.com/problems/distribute-coins-in-binary-tree
    
*/
/ C++ **********************************************************************************************************************************************************/
//T.C : O(n)
//S.C : O(height of tree due to recursion)
class Solution {
public:
    int solve(TreeNode* root, int &moves) {
        if(root == NULL) {
            return 0;
        }
        
        int l = solve(root->left, moves);
        int r = solve(root->right, moves);
        
        int total_extra_candies = (l + r + root->val) - 1;
        
        moves += abs(l) + abs(r);
        
        return total_extra_candies;
    }

    int distributeCoins(TreeNode* root) {
        int moves = 0;
        if(!root->left && !root->right) {
            return 0;
        }
        solve(root, moves);
        
        return moves;
    }
};




/ JAVA **********************************************************************************************************************************************************/
//T.C : O(n)
//S.C : O(height of tree due to recursion)
//Approach -1
class Solution
{
    public static int distributeCoins(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        int[] moves = {0};
        solve(root, moves);

        return moves[0];
    }
    private static int solve(TreeNode root, int[] moves) {
        if (root == null) {
            return 0;
        }

        int l = solve(root.left, moves);
        int r = solve(root.right, moves);

        int totalExtraCandies = (l + r + root.val) - 1;

        moves[0] += Math.abs(l) + Math.abs(r);

        return totalExtraCandies;
    }
}
//Approach -2
class Solution {
    private int moves;

    public int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftExcess = dfs(node.left);
        int rightExcess = dfs(node.right);
        
        // Calculate the moves needed to balance the left and right subtrees
        moves += Math.abs(leftExcess) + Math.abs(rightExcess);
        
        // Return the excess number of coins at this node
        // This includes the coins at this node, plus the excess coins from left and right subtrees, minus 1 (the coin that should remain at this node)
        return node.val + leftExcess + rightExcess - 1;
    }

}
/ C# **********************************************************************************************************************************************************/


public class Solution
{
    private int moves;

    public int DistributeCoins(TreeNode root)
    {
        moves = 0;
        Dfs(root);
        return moves;
    }

    private int Dfs(TreeNode node)
    {
        if (node == null)
        {
            return 0;
        }

        int leftExcess = Dfs(node.left);
        int rightExcess = Dfs(node.right);

        // Calculate the moves needed to balance the left and right subtrees
        moves += Math.Abs(leftExcess) + Math.Abs(rightExcess);

        // Return the excess number of coins at this node
        // This includes the coins at this node, plus the excess coins from left and right subtrees, minus 1 (the coin that should remain at this node)
        return node.val + leftExcess + rightExcess - 1;
    }
}
