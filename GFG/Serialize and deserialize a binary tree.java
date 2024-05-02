/*   Scroll below to see JAVA code and C also  */
/*
    Company Tags            : Paytm,Flipkart,Accolite,Amazon,Microsoft,MAQ Software,Adobe,Linkedin,Quikr,Yahoo,InMobi
    GFG  Link               : https://www.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1
*/

/ C++ ****************************************************************************************************/
#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    
    TreeNode(int val) : val(val), left(nullptr), right(nullptr) {}
};

class Tree {
public:
    // Function to serialize a tree and return a list containing nodes of tree.
    vector<int> serialize(TreeNode* root) {
        vector<int> serializedList;
        fun(root, serializedList);
        return serializedList;
    }
    
    void fun(TreeNode* root, vector<int>& serializedList) {
        if (root == nullptr) {
            serializedList.push_back(-1);
            return;
        }
        serializedList.push_back(root->val);
        fun(root->left, serializedList);
        fun(root->right, serializedList);
    }

    // Function to deserialize a list and construct the tree.
    int index;
    TreeNode* deSerialize(vector<int>& A) {
        index = 0;
        return dfs(A);
    }
    
    TreeNode* dfs(vector<int>& A) {
        if (index == A.size()) return nullptr;
        
        int val = A[index];
        index++;
        
        if (val == -1) return nullptr;
        
        TreeNode* root = new TreeNode(val);
        root->left = dfs(A);
        root->right = dfs(A);
        
        return root;
    }
};
/ Java ****************************************************************************************************/

class Tree {
    // Function to serialize a tree and return a list containing nodes of tree.
    ArrayList<Integer> al;
    public ArrayList<Integer> serialize(Node root) {
        // code here
        al = new  ArrayList<Integer>();
           fun(root);
           return al;
    }
    void fun(Node root){
        if(root==null){
            al.add(-1);
            return;
        }
        al.add(root.data);
        fun(root.left);
        fun(root.right);
    }

    // Function to deserialize a list and construct the tree.
    int index;
    public Node deSerialize(ArrayList<Integer> A) {
        // code here
        index=0;
        return dfs(A);
    }
    Node dfs(ArrayList<Integer> A){
        if(index==A.size()) return null;
        
        int val = A.get(index);
        index++;
        
        if(val==-1) return null;
        
        Node root = new Node(val);
        root.left = dfs(A);
        root.right = dfs(A);
        
        return root;
        
    }
};

/ C# ****************************************************************************************************/
using System;
using System.Collections.Generic;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Tree {
    private List<int> al;
    
    // Function to serialize a tree and return a list containing nodes of tree.
    public List<int> Serialize(TreeNode root) {
        al = new List<int>();
        Fun(root);
        return al;
    }
    
    private void Fun(TreeNode root) {
        if (root == null) {
            al.Add(-1);
            return;
        }
        al.Add(root.val);
        Fun(root.left);
        Fun(root.right);
    }

    // Function to deserialize a list and construct the tree.
    private int index;
    public TreeNode DeSerialize(List<int> A) {
        index = 0;
        return Dfs(A);
    }
    
    private TreeNode Dfs(List<int> A) {
        if (index == A.Count) return null;
        
        int val = A[index];
        index++;
        
        if (val == -1) return null;
        
        TreeNode root = new TreeNode(val);
        root.left = Dfs(A);
        root.right = Dfs(A);
        
        return root;
    }
}

