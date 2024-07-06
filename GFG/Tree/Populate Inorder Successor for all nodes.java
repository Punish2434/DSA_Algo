/*     Scroll below to see JAVA code and C#  also    */
/*
    Company Tags           : 
    GFG Link               : https://www.geeksforgeeks.org/problems/populate-inorder-successor-for-all-nodes/1
*/


/ C++ ***********************************************************************************************************************/
//Approach (reverse inorder traversal approach.)
//T.C : O(n)
//S.C : O(1)

#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    Node* next;
    Node(int item) {
        data = item;
        left = right = next = NULL;
    }
};

class Solution {
public:
    Node* next = NULL;

    void populateNext(Node* root) {
        if (root) {
            populateNext(root->right);
            root->next = next;
            next = root;
            populateNext(root->left);
        }
    }
};


/ Java ***********************************************************************************************************************/
//Approach (reverse inorder traversal approach.)
//T.C : O(n)
//S.C : O(1)
  
class Node {
    int data;
    Node left, right, next;
    Node(int item) {
        data = item;
        left = right = next = null;
    }
}

class Solution {
    Node next = null; // This will store the next node in the inorder traversal

    public void populateNext(Node root) {
        // Start the reverse inorder traversal from the root
        if (root != null) {
            // First, traverse the right subtree
            populateNext(root.right);
            
            // Set the next pointer of this node to the previously visited node
            root.next = next;
            
            // Update the next node to the current node
            next = root;
            
            // Now, traverse the left subtree
            populateNext(root.left);
        }
    }
}


/ C# ***********************************************************************************************************************/
//Approach (reverse inorder traversal approach.)
//T.C : O(n)
//S.C : O(1)
using System;

public class Node {
    public int data;
    public Node left, right, next;

    public Node(int item) {
        data = item;
        left = right = next = null;
    }
}

public class Solution {
    private Node next = null;

    public void PopulateNext(Node root) {
        if (root != null) {
            PopulateNext(root.right);
            root.next = next;
            next = root;
            PopulateNext(root.left);
        }
    }
}

/ JavaScript ***********************************************************************************************************************/
//Approach (reverse inorder traversal approach.)
//T.C : O(n)
//S.C : O(1)

  class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}

class Solution {
    constructor() {
        this.next = null;
    }

    populateNext(root) {
        if (root) {
            this.populateNext(root.right);
            root.next = this.next;
            this.next = root;
            this.populateNext(root.left);
        }
    }
}

