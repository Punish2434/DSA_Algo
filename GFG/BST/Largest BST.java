/*         Scroll below to see JAVA code and C# also        */

    // Company Tags           : Flipkart,Amazon,Microsoft,Samsung,D-E-Shaw
    // GFG Link               : https://www.geeksforgeeks.org/problems/largest-bst/1
// C++ ********************************************************************************************************************************************/
//Approach (using )
//T.C : O(n)
//S.C : O(h) 
class Solution{
    public:
    /*You are required to complete this method */
    // Return the size of the largest sub-tree which is also a BST
    vector<int> solve(Node *root){
        //{//size,TF,mini,maxi} left max<node<right min
        if(root == NULL){//null
            return {0,1,INT_MAX,INT_MIN};
        }
        {
            if(root->left==NULL && root->right==NULL){//leaf
                return {1,1,root->data,root->data};
            }
            vector<int>left=solve(root->left);
            vector<int>right=solve(root->right);
            
            int leftsize=left[0],LTF=left[1],leftmini=left[2],leftmaxi=left[3];
            int rightsize=right[0],RTF=right[1],rightmini=right[2],rightmaxi=right[3];
            if(LTF ==1 && RTF==1 && root->data>leftmaxi && root->data<rightmini){
                return {leftsize+rightsize+1,1,min(root->data,leftmini),max(root->data,rightmaxi)};
            }
            else{
                return {max(leftsize,rightsize),0,0,0};
            }
        }
    }
    
    int largestBst(Node *root)
    {
    	//codeGenius
    	return solve(root)[0];
    }
};
//Java ********************************************************************************************************************************************/
//Approach (using )
//T.C : O(n)
//S.C : O(h) 
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        return largestBstHelper(root).maxBstSize;
    }
    
    // Helper function to find the size of the largest BST
    static BstInfo largestBstHelper(Node root) {
        if (root == null) {
            return new BstInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }

        BstInfo leftInfo = largestBstHelper(root.left);
        BstInfo rightInfo = largestBstHelper(root.right);

        BstInfo currInfo = new BstInfo();
        currInfo.size = 1 + leftInfo.size + rightInfo.size;

        if (leftInfo.isBst && rightInfo.isBst && root.data > leftInfo.maxValue && root.data < rightInfo.minValue) {
            currInfo.minValue = Math.min(root.data, leftInfo.minValue);
            currInfo.maxValue = Math.max(root.data, rightInfo.maxValue);
            currInfo.maxBstSize = currInfo.size;
            currInfo.isBst = true;
        } else {
            currInfo.maxBstSize = Math.max(leftInfo.maxBstSize, rightInfo.maxBstSize);
            currInfo.isBst = false;
        }

        return currInfo;
    }
    
    // Helper class to store information about subtrees
    static class BstInfo {
        int size;          // Size of the current subtree
        int minValue;      // Minimum value in the current subtree
        int maxValue;      // Maximum value in the current subtree
        int maxBstSize;    // Size of the largest BST in the subtree
        boolean isBst;     // Whether the current subtree is a BST

        BstInfo() {}

        BstInfo(int size, int minValue, int maxValue, int maxBstSize, boolean isBst) {
            this.size = size;
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.maxBstSize = maxBstSize;
            this.isBst = isBst;
        }
    }
}


// C# ********************************************************************************************************************************************/
//Approach (using )
//T.C : O(n)
//S.C : O(h) 
using System;

public class Node {
    public int data;
    public Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Solution {
    public class BstInfo {
        public int size;
        public int minValue;
        public int maxValue;
        public int maxBstSize;
        public bool isBst;

        public BstInfo(int size = 0, int minValue = int.MaxValue, int maxValue = int.MinValue, int maxBstSize = 0, bool isBst = true) {
            this.size = size;
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.maxBstSize = maxBstSize;
            this.isBst = isBst;
        }
    }

    public static int LargestBst(Node root) {
        return LargestBstHelper(root).maxBstSize;
    }

    private static BstInfo LargestBstHelper(Node root) {
        if (root == null) {
            return new BstInfo();
        }

        BstInfo leftInfo = LargestBstHelper(root.left);
        BstInfo rightInfo = LargestBstHelper(root.right);

        BstInfo currInfo = new BstInfo();
        currInfo.size = 1 + leftInfo.size + rightInfo.size;

        if (leftInfo.isBst && rightInfo.isBst && root.data > leftInfo.maxValue && root.data < rightInfo.minValue) {
            currInfo.minValue = Math.Min(root.data, leftInfo.minValue);
            currInfo.maxValue = Math.Max(root.data, rightInfo.maxValue);
            currInfo.maxBstSize = currInfo.size;
            currInfo.isBst = true;
        } else {
            currInfo.maxBstSize = Math.Max(leftInfo.maxBstSize, rightInfo.maxBstSize);
            currInfo.isBst = false;
        }

        return currInfo;
    }
}
