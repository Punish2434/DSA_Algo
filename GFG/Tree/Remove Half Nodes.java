/*         Scroll below to see JAVA code and C# also        */

    // Company Tags                : Amazon
    // GFG Link               : https://www.geeksforgeeks.org/problems/remove-half-nodes/1


// C++ ********************************************************************************************************************************************/
//Approach (Using simple recursion)
//T.C : O(n)
//S.C : O(h) 
#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    Node(int val) : data(val), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    Node* removeHalfNodes(Node* root) {
        if (root == nullptr) {
            return nullptr;
        }
        
        root->left = removeHalfNodes(root->left);
        root->right = removeHalfNodes(root->right);
        
        if (root->left == nullptr && root->right != nullptr) {
            return root->right;
        }
        
        if (root->left != nullptr && root->right == nullptr) {
            return root->left;
        }
        
        return root;
    }
};
// Java ********************************************************************************************************************************************/
//Approach (Using simple recursion)
//T.C : O(n)
//S.C : O(h) 

class Solution {
    // Return the root of the modified tree after removing all the half nodes.
    public Node RemoveHalfNodes(Node root) {
        // Code Here
        if(root == null)
        {
            return null;
        }
        
        root.left = RemoveHalfNodes(root.left);
        root.right = RemoveHalfNodes(root.right);
        
        if(root.left == null && root.right != null)
        {
            return root.right;
        }

        if(root.left != null && root.right == null)
        {
            return root.left;
        }
        
        return root;
    }
}

// C# ********************************************************************************************************************************************/
//Approach (Using simple recursion)
//T.C : O(n)
//S.C : O(h) 

public class Node {
    public int data;
    public Node left, right;
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Solution {
    public Node RemoveHalfNodes(Node root) {
        if (root == null) {
            return null;
        }
        
        root.left = RemoveHalfNodes(root.left);
        root.right = RemoveHalfNodes(root.right);
        
        if (root.left == null && root.right != null) {
            return root.right;
        }
        
        if (root.left != null && root.right == null) {
            return root.left;
        }
        
        return root;
    }
}

// JavaScript ********************************************************************************************************************************************/
//Approach (Using simple recursion)
//T.C : O(n)
//S.C : O(h) 
class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    removeHalfNodes(root) {
        if (root === null) {
            return null;
        }
        
        root.left = this.removeHalfNodes(root.left);
        root.right = this.removeHalfNodes(root.right);
        
        if (root.left === null && root.right !== null) {
            return root.right;
        }
        
        if (root.left !== null && root.right === null) {
            return root.left;
        }
        
        return root;
    }
}
