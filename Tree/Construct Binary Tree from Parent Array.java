/*         Scroll below to see JAVA code and C# also        */
/*
    Company Tags                : Amazon,Microsoft,Snapdeal
    GFG  Link            : https://www.geeksforgeeks.org/problems/construct-binary-tree-from-parent-array/1
*/


/ C++ **********************************************************************************************************************************/
//Approach -  Using Post Order + set
//T.C : O(n)
//S.C : O(n)
  #include <iostream>
#include <vector>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;

    Node(int item) : data(item), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    Node* createTree(vector<int>& parent) {
        int n = parent.size();
        vector<Node*> created(n);

        for (int i = 0; i < n; ++i) {
            created[i] = new Node(i);
        }

        Node* root = nullptr;

        for (int i = 0; i < n; ++i) {
            if (parent[i] == -1) {
                root = created[i];
            } else {
                Node* parentNode = created[parent[i]];
                if (parentNode->left == nullptr) {
                    parentNode->left = created[i];
                } else {
                    parentNode->right = created[i];
                }
            }
        }
        return root;
    }
};
/ Java**********************************************************************************************************************************/
//Approach -  Using Post Order + set
//T.C : O(n)
//S.C : O(n)
  class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    // Function to construct binary tree from parent array.
    public Node createTree(int parent[]) {
        int n = parent.length;
        Node[] created = new Node[n];

        // Initialize the created nodes
        for (int i = 0; i < n; i++) {
            created[i] = new Node(i);
        }

        Node root = null;

        // Create the tree by setting the left and right children
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                root = created[i];
            } else {
                Node parentNode = created[parent[i]];

                // If the left child is empty, set it to the current node
                if (parentNode.left == null) {
                    parentNode.left = created[i];
                } else {
                    parentNode.right = created[i];
                }
            }
        }
        return root;
    }
}

  / C# **********************************************************************************************************************************/
//Approach -  Using Post Order + set
//T.C : O(n)
//S.C : O(n)
    using System;

public class Node {
    public int data;
    public Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Solution {
    public Node CreateTree(int[] parent) {
        int n = parent.Length;
        Node[] created = new Node[n];

        for (int i = 0; i < n; i++) {
            created[i] = new Node(i);
        }

        Node root = null;

        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                root = created[i];
            } else {
                Node parentNode = created[parent[i]];
                if (parentNode.left == null) {
                    parentNode.left = created[i];
                } else {
                    parentNode.right = created[i];
                }
            }
        }
        return root;
    }
}

  / javaScript **********************************************************************************************************************************/
//Approach -  Using Post Order + set
//T.C : O(n)
//S.C : O(n)
    class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    createTree(parent) {
        const n = parent.length;
        const created = Array(n).fill(null).map((_, i) => new Node(i));

        let root = null;

        for (let i = 0; i < n; i++) {
            if (parent[i] === -1) {
                root = created[i];
            } else {
                const parentNode = created[parent[i]];
                if (parentNode.left === null) {
                    parentNode.left = created[i];
                } else {
                    parentNode.right = created[i];
                }
            }
        }
        return root;
    }
}
