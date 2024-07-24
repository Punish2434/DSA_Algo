/*         Scroll below to see JAVA code and C# also        */

    // Company Tags           : VMWare,Flipkart,Accolite,Amazon,Microsoft,OYO Rooms,Samsung,Snapdeal,FactSetHike,MakeMyTrip,Ola Cabs,Walmart,Goldman Sachs,MAQ Software,Adobe,Linkedin,Qualcomm,Boomerang Commerce,GreyOrange,Wooker
    // GFG Link               : https://www.geeksforgeeks.org/problems/check-for-bst/1
// C++ ********************************************************************************************************************************************/
//Approach (using inorder traversal)
//T.C : O(n)
//S.C : O(h) 

class Solution {

  public:
    // Function to check whether a Binary Tree is BST or not.
    //inorder left-node-right
    void inorder(Node* root,vector<int> &ans){
        if(root==NULL){
            return;
        }
        inorder(root->left,ans);
        ans.push_back(root->data);
        inorder(root->right,ans);
    }
    bool isBST(Node* root) {
        //codeGenius
        vector<int> ans;
        inorder(root,ans);
        for(int i=0;i<ans.size()-1;i++){
            if(ans[i]>=ans[i+1]){
                return false;
            }
        }
        return true;
    }
};
//Java ********************************************************************************************************************************************/
//Approach (using recursive approach)
//T.C : O(n)
//S.C : O(h) 
class Solution {
    // Helper function to check BST with min and max constraints
    boolean isBSTUtil(Node node, int min, int max) {
        // An empty tree is a BST
        if (node == null)
            return true;

        // False if this node violates min/max constraint
        if (node.data <= min || node.data >= max)
            return false;

        // Otherwise, check the subtrees recursively tightening the min/max constraints
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.data) &&
                isBSTUtil(node.right, node.data, max));
    }

    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    
}
// C# ********************************************************************************************************************************************/
//Approach (using recursive approach)
//T.C : O(n)
//S.C : O(h) 
using System;

class Node {
    public int data;
    public Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    // Helper function to check BST with min and max constraints
    bool IsBSTUtil(Node node, int min, int max) {
        // An empty tree is a BST
        if (node == null)
            return true;

        // False if this node violates min/max constraint
        if (node.data <= min || node.data >= max)
            return false;

        // Otherwise, check the subtrees recursively tightening the min/max constraints
        // Allow only distinct values
        return (IsBSTUtil(node.left, min, node.data) &&
                IsBSTUtil(node.right, node.data, max));
    }

    // Function to check whether a Binary Tree is BST or not.
    public bool IsBST(Node root) {
        return IsBSTUtil(root, int.MinValue, int.MaxValue);
    }

    public static void Main(string[] args) {
        Solution tree = new Solution();
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        root.right.right = new Node(5);

        if (tree.IsBST(root))
            Console.WriteLine("true");
        else
            Console.WriteLine("false");
    }
}
// JavaScript ********************************************************************************************************************************************/
//Approach (using recursive approach)
//T.C : O(n)
//S.C : O(h) 

class Solution {
    // Helper function to check BST with min and max constraints
    isBSTUtil(node, min, max) {
        // An empty tree is a BST
        if (node === null) {
            return true;
        }

        // False if this node violates min/max constraint
        if (node.data <= min || node.data >= max) {
            return false;
        }

        // Otherwise, check the subtrees recursively tightening the min/max constraints
        // Allow only distinct values
        return this.isBSTUtil(node.left, min, node.data) &&
               this.isBSTUtil(node.right, node.data, max);
    }

    // Function to check whether a Binary Tree is BST or not.
    isBST(root) {
        return this.isBSTUtil(root, Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER);
    }
}

// Example usage
