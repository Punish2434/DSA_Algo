/*        Scroll below to see JAVA code , C# and JavaScript also        */
/*
    Company Tags                : Amazon,Microsoft,Samsung,Ola Cabs
    GFG Link               : https://www.geeksforgeeks.org/problems/k-distance-from-root/1
*/

/ C++ ************************************************************************************************************************************/

#include <iostream>
#include <vector>

class Tree {
private:
    std::vector<int> al;
public:
    std::vector<int> Kdistance(Node* root, int k) {
        // Your code here
        al.clear();
        Dfs(root, k);
        return al;
    }
    void Dfs(Node* root, int k) {
        if (!root) return;
        if (k == 0) al.push_back(root->data);
        else {
            Dfs(root->left, k - 1);
            Dfs(root->right, k - 1);
        }
    }
};
/ Java ************************************************************************************************************************************/

class Tree
{
     // Recursive function to print right view of a binary tree.
    ArrayList<Integer> al;
     ArrayList<Integer> Kdistance(Node root, int k)
     {
          // Your code here
         al = new ArrayList<>();
         dfs(root,k);
         return al;
     }
     void dfs(Node root, int k){
          if(root==null) return ;
          if(k==0) al.add(root.data);
          else{
            dfs(root.left,k-1);
            dfs(root.right, k-1);
          }
     }
}
/ C# ************************************************************************************************************************************/
  using System;
using System.Collections.Generic;

public class Tree {
    // Recursive function to print right view of a binary tree.
    private List<int> al;
    public List<int> Kdistance(Node root, int k) {
        // Your code here
        al = new List<int>();
        Dfs(root, k);
        return al;
    }
    private void Dfs(Node root, int k) {
        if (root == null) return;
        if (k == 0) al.Add(root.data);
        else {
            Dfs(root.left, k - 1);
            Dfs(root.right, k - 1);
        }
    }
}

/ JavaScript ************************************************************************************************************************************/
class Tree {
    constructor() {
        this.al = [];
    }
    Kdistance(root, k) {
        // Your code here
        this.al.length = 0;
        this.dfs(root, k);
        return this.al;
    }
    dfs(root, k) {
        if (!root) return;
        if (k === 0) this.al.push(root.data);
        else {
            this.dfs(root.left, k - 1);
            this.dfs(root.right, k - 1);
        }
    }
}
