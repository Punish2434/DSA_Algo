/*     Scroll below to see JAVA code and C# also  */
/*
    Company Tags                : META
    Leetcode Link               : https://leetcode.com/problems/sum-of-left-leaves/
*/


/ C++ *****************************************************************************************************************************/
//Approach-1 (Using Parent Pointer)
//T.C : O(n)
//S.C : O(1) Auxiiliary Space and O(depth of tree) recursion system stack space
class Solution {
public:
    int sum(TreeNode* curr, TreeNode* parent) {
        if(!curr)
            return 0;
        
        int left  = sum(curr->left, curr);
        int right = sum(curr->right, curr);
        
        int sum = 0;
        if(curr->left == NULL && curr->right == NULL) {
            if(parent && parent->left == curr)
                sum += curr->val;
        }
        
        return left+right+sum;
    }
    int sumOfLeftLeaves(TreeNode* root) {
        if(!root)
            return 0;
        TreeNode* parent = NULL;
        return sum(root, parent);
    }
};


//Approach-2 (without parentpointer, only using a flag)
//T.C : O(n)
//S.C : O(1) Auxiiliary Space and O(depth of tree) recursion system stack space
class Solution {
public:
    
    int solve(TreeNode* curr, bool isLeft) {
        if(!curr) {
            return 0;
        }
        
        if(!curr->left && !curr->right && isLeft) {
            return curr->val;
        }
        
        return solve(curr->left, true) + solve(curr->right, false);
    }
    
    int sumOfLeftLeaves(TreeNode* root) {
        return solve(root, false);
    }
};



/ JAVA *****************************************************************************************************************************/
//Approach-1 (Using Parent Pointer)
//T.C : O(n)
//S.C : O(1) Auxiiliary Space and O(depth of tree) recursion system stack space
class Solution {
    public int sum(TreeNode curr, TreeNode parent) {
        if (curr == null)
            return 0;

        int left = sum(curr.left, curr);
        int right = sum(curr.right, curr);

        int sum = 0;
        if (curr.left == null && curr.right == null) {
            if (parent != null && parent.left == curr)
                sum += curr.val;
        }

        return left + right + sum;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode parent = null;
        return sum(root, parent);
    }
}



//Approach-2 (without parentpointer, only using a flag)
//T.C : O(n)
//S.C : O(1) Auxiiliary Space and O(depth of tree) recursion system stack space
class Solution {
    public int solve(TreeNode curr, boolean isLeft) {
        if (curr == null) {
            return 0;
        }

        if (curr.left == null && curr.right == null && isLeft) {
            return curr.val;
        }

        return solve(curr.left, true) + solve(curr.right, false);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return solve(root, false);
    }
}

/ C# *****************************************************************************************************************************/

//Approach-1 (Using Parent Pointer)
//T.C : O(n)
//S.C : O(1) Auxiiliary Space and O(depth of tree) recursion system stack space
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
    public int Sum(TreeNode curr, TreeNode parent)
    {
        if (curr == null)
            return 0;

        int left = Sum(curr.left, curr);
        int right = Sum(curr.right, curr);

        int sum = 0;
        if (curr.left == null && curr.right == null)
        {
            if (parent != null && parent.left == curr)
                sum += curr.val;
        }

        return left + right + sum;
    }

    public int SumOfLeftLeaves(TreeNode root)
    {
        if (root == null)
            return 0;
        TreeNode parent = null;
        return Sum(root, parent);
    }
}
// ```

// - The `TreeNode` class represents a binary tree node with an integer value, left child, and right child.
// - The `Sum` method calculates the sum of left leaves in the tree based on the given conditions.
// - The `SumOfLeftLeaves` method initializes the parent as `null` and calls the `Sum` method to compute the result.


//Approach-2 (without parentpointer, only using a flag)
//T.C : O(n)
//S.C : O(1) Auxiiliary Space and O(depth of tree) recursion system stack space
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
    public int Solve(TreeNode curr, bool isLeft)
    {
        if (curr == null)
        {
            return 0;
        }

        if (curr.left == null && curr.right == null && isLeft)
        {
            return curr.val;
        }

        return Solve(curr.left, true) + Solve(curr.right, false);
    }

    public int SumOfLeftLeaves(TreeNode root)
    {
        return Solve(root, false);
    }
}
```

// - The `TreeNode` class represents a binary tree node with an integer value, left child, and right child.
// - The `Solve` method calculates the sum of left leaves in the tree based on the given conditions.
// - The `SumOfLeftLeaves` method initializes the `isLeft` parameter as `false` and calls the `Solve` method to compute the result.

