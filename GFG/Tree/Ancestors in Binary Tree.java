/*    Scroll below to see JAVA code and C# also    */
/*
    Company Tags            : AMAZON
    GFG Link                : https://www.geeksforgeeks.org/problems/ancestors-in-binary-tree/1
*/


/ C++ ******************************************************************************************************************************************/

// Time Complexity: O(n)
// Space Complexity: O(h), where h is the height of the tree

  #include <iostream>
#include <vector>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    Node(int x) : data(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<int> Ancestors(Node* root, int target) {
        vector<int> result;
        findAncestors(root, target, result);
        return result;
    }

private:
    bool findAncestors(Node* root, int target, vector<int>& result) {
        if (root == NULL) {
            return false;
        }

        if (root->data == target) {
            return true;
        }

        if (findAncestors(root->left, target, result) || findAncestors(root->right, target, result)) {
            result.push_back(root->data);
            return true;
        }

        return false;
    }
};

/ Java ******************************************************************************************************************************************/

// Time Complexity: O(n)
// Space Complexity: O(h), where h is the height of the tree
  
  
import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {

    public ArrayList<Integer> Ancestors(Node root, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        findAncestors(root, target, result);
        return result;
    }

    private boolean findAncestors(Node root, int target, ArrayList<Integer> result) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        }

        // If target is present in either left or right subtree of this node, then this node is an ancestor of target
        if (findAncestors(root.left, target, result) || findAncestors(root.right, target, result)) {
            result.add(root.data);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        root.left.left.left = new Node(7);

        int target = 7;
        ArrayList<Integer> ancestors = solution.Ancestors(root, target);
        System.out.println(ancestors); // Output: [4, 2, 1]

        target = 1;
        ancestors = solution.Ancestors(root, target);
        System.out.println(ancestors); // Output: []
    }
}



  / C# ******************************************************************************************************************************************/

// Time Complexity: O(n)
// Space Complexity: O(h), where h is the height of the tree
using System;
using System.Collections.Generic;

public class Node {
    public int data;
    public Node left, right;
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Solution {
    public List<int> Ancestors(Node root, int target) {
        List<int> result = new List<int>();
        findAncestors(root, target, result);
        return result;
    }

    private bool findAncestors(Node root, int target, List<int> result) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        }

        if (findAncestors(root.left, target, result) || findAncestors(root.right, target, result)) {
            result.Add(root.data);
            return true;
        }

        return false;
    }
}

  /JavaScript ******************************************************************************************************************************************/

    
// Time Complexity: O(n)
// Space Complexity: O(h), where h is the height of the tree
  class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    ancestors(root, target) {
        let result = [];
        this.findAncestors(root, target, result);
        return result;
    }

    findAncestors(root, target, result) {
        if (root === null) {
            return false;
        }

        if (root.data === target) {
            return true;
        }

        if (this.findAncestors(root.left, target, result) || this.findAncestors(root.right, target, result)) {
            result.push(root.data);
            return true;
        }

        return false;
    }
}



