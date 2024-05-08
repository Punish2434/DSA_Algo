/*  Scroll below to see JAVA code and C# also  */
/*

    Company Tags                : Paytm,Amazon
    GFG Link               : https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
*/

/ C++ **********************************************************************************************************************************************/

class Solution {
  void help(Node *root,vector<vector<int>> &ans,vector<int> temp){
      if(!root)return;
      if(!root->left and !root->right){
          temp.push_back(root->data);
          ans.push_back(temp);
          return;
      }
      temp.push_back(root->data);
      help(root->left,ans,temp);
      help(root->right,ans,temp);
  }
    vector<vector<int>> Paths(Node* root) {
        // code here+
        vector<vector<int>> ans;
        vector<int> temp;
        help(root,ans,temp);
        return ans;
    }
}
/ Java **********************************************************************************************************************************************/
//Approach-1 
  class Solution {
      static void help(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp){
         if(root==null) return;
         if(root.left==null&&root.right==null){
             temp.add(root.data);
             ArrayList<Integer> temp2 = new ArrayList<>();
             temp2.addAll(temp);
             ans.add(temp2);
             temp.remove(temp.size()-1);
             return;
         }
         temp.add(root.data);
         help(root.left,ans,temp);
         help(root.right,ans,temp);
         temp.remove(temp.size()-1);
     }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        help(root,ans,temp);
        return ans;
    }
}

// Time Complexity:- O(N)
// Space Complexity:- O(H*L)     where H is height and L is number of leaf nodes
//Approach-2
class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result; // Base case: if the tree is empty, return an empty list

        // Helper method to perform DFS and collect paths
        dfs(root, new ArrayList<>(), result);

        return result;
    }

    private static void dfs(Node node, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (node == null) return; // Base case: if the node is null, return

        // Add the current node's value to the path
        path.add(node.data);

        // Check if the current node is a leaf node
        if (node.left == null && node.right == null) {
            // If it is a leaf node, add the path to the result list
            result.add(new ArrayList<>(path));
        } else {
            // If not a leaf node, continue DFS on both left and right children
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }

        // Remove the current node's value from the path to backtrack
        path.remove(path.size() - 1);
    }
}

/ C# **********************************************************************************************************************************************/


```csharp
using System;
using System.Collections.Generic;

public class Solution
{
    public static List<List<int>> Paths(TreeNode root)
    {
        List<List<int>> result = new List<List<int>>();
        if (root == null) return result; // Base case: if the tree is empty, return an empty list

        // Helper method to perform DFS and collect paths
        Dfs(root, new List<int>(), result);

        return result;
    }

    private static void Dfs(TreeNode node, List<int> path, List<List<int>> result)
    {
        if (node == null) return; // Base case: if the node is null, return

        // Add the current node's value to the path
        path.Add(node.val);

        // Check if the current node is a leaf node
        if (node.left == null && node.right == null)
        {
            // If it is a leaf node, add the path to the result list
            result.Add(new List<int>(path));
        }
        else
        {
            // If not a leaf node, continue DFS on both left and right children
            Dfs(node.left, path, result);
            Dfs(node.right, path, result);
        }

        // Remove the current node's value from the path to backtrack
        path.RemoveAt(path.Count - 1);
    }
}

// TreeNode class definition (assuming it exists)
public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
}
```

// Explanation:
// - The Java code defines a `Solution` class with a static method `Paths` that takes a `Node` (presumably a binary tree node) as input and returns a list of lists of integers.
// - The method performs a depth-first search (DFS) to collect all paths from the root to leaf nodes.
// - In the C# equivalent, I've renamed the `Node` class to `TreeNode` to match common naming conventions for binary tree nodes.
// - The `Dfs` method recursively explores the tree, adding the values of visited nodes to the `path` list.
// - When a leaf node is encountered, the current path is added to the `result` list.
// - Finally, the value of the current node is removed from the path to backtrack.
// - Note that you'll need to define the `TreeNode` class separately in your C# code.
