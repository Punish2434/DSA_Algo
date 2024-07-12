/*      Scroll below to see JAVA code and C# also    */
/*

    Company Tags           : Accolite,Amazon,Microsoft,Samsung,FactSet,Housing.com,Oracle ,Goldman Sachs,Adobe,CouponDunia,Atlassian
    GFG Link               : https://geeksforgeeks.org/problems/root-to-leaf-path-sum/1
*/


/ C++ **************************************************************************************************************************/
//Approach-1 (Using Recursion)
//T.C : O(n)
//S.C : O(h)

  #include <iostream>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    Node(int item) : data(item), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    bool hasPathSum(Node* root, int target) {
        if (!root) return false;
        if (!root->left && !root->right && root->data == target) return true;
        int newTarget = target - root->data;
        return hasPathSum(root->left, newTarget) || hasPathSum(root->right, newTarget);
    }
};

int main() {
    Node* root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);

    Solution sol;
    cout << sol.hasPathSum(root, 2) << endl; // Output: 0 (false)
    cout << sol.hasPathSum(root, 4) << endl; // Output: 1 (true)

    return 0;
}
/ Java **************************************************************************************************************************/
//Approach-1 (Using Recursion)
//T.C : O(n)
//S.C : O(h)

  class Solution {
    /*you are required to complete this function */
    boolean hasPathSum(Node root, int target) {
        // Your code here
        
        if(root == null){
            return false;
        }
        // If we reach a leaf node and its value is equal to the target, return true
        if(root.left == null && root.right == null && root.data == target) {
            return true;
        }
        //Otherwise , check the subtrees with the reduced target value
        int newTarget = target - root.data;
        return hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget);
    }
}

/ C# **************************************************************************************************************************/
//Approach-1 (Using Recursion)
//T.C : O(n)
//S.C : O(h)

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
    public bool HasPathSum(Node root, int target) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.data == target) {
            return true;
        }
        int newTarget = target - root.data;
        return HasPathSum(root.left, newTarget) || HasPathSum(root.right, newTarget);
    }

    public static void Main(string[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        
        Solution sol = new Solution();
        
        Console.WriteLine(sol.HasPathSum(root, 2)); // Output: false
        Console.WriteLine(sol.HasPathSum(root, 4)); // Output: true
    }
}
/ JavaScript **************************************************************************************************************************/
//Approach-1 (Using Recursion)
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
    hasPathSum(root, target) {
        if (root === null) {
            return false;
        }
        if (root.left === null && root.right === null && root.data === target) {
            return true;
        }
        let newTarget = target - root.data;
        return this.hasPathSum(root.left, newTarget) || this.hasPathSum(root.right, newTarget);
    }
}

// Example usage
const root = new Node(1);
root.left = new Node(2);
root.right = new Node(3);

const sol = new Solution();
console.log(sol.hasPathSum(root, 2)); // Output: false
console.log(sol.hasPathSum(root, 4)); // Output: true
