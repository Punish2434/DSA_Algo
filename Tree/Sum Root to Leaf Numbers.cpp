/*     Scroll down to see JAVA code and C# also    */
/*
    Company Tags                : Google, Meta, Accolite, Amazon, Microsoft, Samsung, FactSet, 
                                  Housing.com, Oracle, Goldman Sachs, Adobe, Coupon Dunia, Atlassian
    Leetcode Link               : https://leetcode.com/problems/sum-root-to-leaf-numbers/
*/


/ C++ ******************************************************************************************/
//Recursion-1
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    
    int find(TreeNode* root, int curr) {
        
        if(!root)
            return 0;
        
        curr = curr*10 + root->val;
        
        if(root->left == NULL && root->right == NULL) {
            return curr;
        }
        
        int left_num  = find(root->left, curr);
        int right_num = find(root->right, curr);
        
        return left_num + right_num;
    }
    
    int sumNumbers(TreeNode* root) {
        return find(root, 0);
    }
};



/ JAVA ******************************************************************************************/
//Recursion-1
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int find(TreeNode root, int curr) {
        if (root == null)
            return 0;

        curr = curr * 10 + root.val;

        if (root.left == null && root.right == null) {
            return curr;
        }

        int leftNum = find(root.left, curr);
        int rightNum = find(root.right, curr);

        return leftNum + rightNum;
    }

    public int sumNumbers(TreeNode root) {
        return find(root, 0);
    }
}


//Recursion-2
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    int sumNumbers(TreeNode* root, int sum = 0) {
        if(!root)
            return 0;
        
        if(!root->left && !root->right)
            return sum*10+root->val;
        
        int ls = sumNumbers(root->left, sum*10+root->val);
        int rs = sumNumbers(root->right, sum*10+root->val);
        
        return ls + rs;
    }
};



//Recursion-2
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    private int sumNumbers(TreeNode root, int sum) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return sum * 10 + root.val;

        int leftSum = sumNumbers(root.left, sum * 10 + root.val);
        int rightSum = sumNumbers(root.right, sum * 10 + root.val);

        return leftSum + rightSum;
    }
}
/ C# ******************************************************************************************/
//Recursion-1
//T.C : O(n)
//S.C : O(1)

```csharp
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val = 0, TreeNode left = null, TreeNode right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public int Find(TreeNode root, int curr) {
        if (root == null)
            return 0;

        curr = curr * 10 + root.val;

        if (root.left == null && root.right == null) {
            return curr;
        }

        int leftNum = Find(root.left, curr);
        int rightNum = Find(root.right, curr);

        return leftNum + rightNum;
    }

    public int SumNumbers(TreeNode root) {
        return Find(root, 0);
    }
}
```

// - I've translated the Java code to C# while maintaining the same logic and structure.
// - The `TreeNode` class remains the same.
// - The `Find` method recursively computes the sum of numbers formed by paths from the root to leaf nodes.
// - The `SumNumbers` method serves as an entry point and initializes the recursion with an initial value of 0.
