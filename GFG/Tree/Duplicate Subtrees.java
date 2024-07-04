
/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags           : Microsoft
    GFG Link               : https://www.geeksforgeeks.org/problems/duplicate-subtrees/1
*/

/ C++ ***********************************************************************************************************************/
//Approach-1 (Using Recursive approach)
//T.C : O(n)
//S.C : O(n)

class Solution {
  public:
    string solve(Node *root,unordered_map<string,int> &mp,vector<Node*> &ans){
        //base case
        if(!root){
            return "N";
        }
        
        //recursive case
        string s=to_string(root->data) + "," + solve(root->left,mp,ans)
        + "," + solve(root->right,mp,ans);
        mp[s]++;
        if(mp[s]==2){
            ans.push_back(root);
        }
        return s;
    }
    
    
    vector<Node*> printAllDups(Node* root) {
        // CodeGenius
        unordered_map<string,int> mp;
        vector<Node*> ans;
        solve(root,mp,ans);
        return ans;
        
    }
};

/ Java ***********************************************************************************************************************/
//Approach-1 (Using Recursive approach)
//T.C : O(n)
//S.C : O(n)

  class Solution {
    public String solve(Node root, Map<String, Integer> mp, Vector<Node> ans) {
        // base case
        if (root == null) {
            return "N";
        }
        
        // recursive case
        String s = Integer.toString(root.data) + "," + solve(root.left, mp, ans)
                 + "," + solve(root.right, mp, ans);
        mp.put(s, mp.getOrDefault(s, 0) + 1);
        if (mp.get(s) == 2) {
            ans.add(root);
        }
        return s;
    }
    
    public Vector<Node> printAllDups(Node root) {
        Map<String, Integer> mp = new HashMap<>();
        Vector<Node> ans = new Vector<>();
        solve(root, mp, ans);
        return ans;
    }
}


  / C# ***********************************************************************************************************************/
//Approach-1 (Using Recursive approach)
//T.C : O(n)
//S.C : O(n)


    using System;
using System.Collections.Generic;

class Node {
    public int data;
    public Node left, right;
    
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    public string Solve(Node root, Dictionary<string, int> mp, List<Node> ans) {
        // base case
        if (root == null) {
            return "N";
        }
        
        // recursive case
        string s = root.data.ToString() + "," + Solve(root.left, mp, ans)
                 + "," + Solve(root.right, mp, ans);
        if (mp.ContainsKey(s)) {
            mp[s]++;
        } else {
            mp[s] = 1;
        }
        if (mp[s] == 2) {
            ans.Add(root);
        }
        return s;
    }
    
    public List<Node> PrintAllDups(Node root) {
        Dictionary<string, int> mp = new Dictionary<string, int>();
        List<Node> ans = new List<Node>();
        Solve(root, mp, ans);
        return ans;
    }
}
