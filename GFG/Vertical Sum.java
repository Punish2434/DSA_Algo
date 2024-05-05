/*         Scroll Down to see JAVA code and C# also      */
/*
    Company Tags            : Apple, Adobe, Microsoft, Samsung
    GFG Link                : https://www.geeksforgeeks.org/problems/vertical-sum/1
   
*/

/ C++ *********************************************************************/
class Solution {
    int mn=INT_MAX,mx=INT_MIN;
    void help(Node *root,unordered_map<int,int> &mm,int vLevel){
        if(!root)return;
        mn=min(mn,vLevel);
        mx=max(mx,vLevel);
        mm[vLevel]+=root->data;
        help(root->left,mm,vLevel-1);
        help(root->right,mm,vLevel+1);
    }
    vector <int> verticalSum(Node *root) {
        // add code here.
        unordered_map<int,int> mm;
        help(root,mm,0);
        vector<int> ans;
        for(int i=mn;i<=mx;i++){
            if(mm[i])ans.push_back(mm[i]);
        }
        return ans;
    }
}
/ Java *********************************************************************/
class Solution {

  int mn = Integer.MAX_VALUE,mx=Integer.MIN_VALUE;
  void help(Node root,HashMap<Integer,Integer> mm,int vLevel){
      if(root==null)return;
      mn=Math.min(mn,vLevel);
      mx=Math.max(mx,vLevel);
      mm.put(vLevel,mm.getOrDefault(vLevel,0)+root.data);
      help(root.left,mm,vLevel-1);
      help(root.right,mm,vLevel+1);
  }
    public ArrayList <Integer> verticalSum(Node root) {
        // add your code here
        HashMap<Integer,Integer> mm = new HashMap<>();
        help(root,mm,0);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=mn;i<=mx;i++){
            if(mm.get(i)!=null)ans.add(mm.get(i));
        }
        return ans;
    }

}
// Time Complexity:- O(N)
// Space Complexity:- O(N)
/ C# *********************************************************************/

```csharp
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

public class Solution {
    private int mn = int.MaxValue; // Initialize minimum vertical level
    private int mx = int.MinValue; // Initialize maximum vertical level

    // Recursive helper function to compute vertical sums
    private void Help(TreeNode root, Dictionary<int, int> mm, int vLevel) {
        if (root == null) return; // Base case: empty node

        // Update minimum and maximum vertical levels
        mn = Math.Min(mn, vLevel);
        mx = Math.Max(mx, vLevel);

        // Update the vertical sum for the current level
        mm[vLevel] = mm.GetValueOrDefault(vLevel, 0) + root.val;

        // Recurse on left and right subtrees
        Help(root.left, mm, vLevel - 1);
        Help(root.right, mm, vLevel + 1);
    }

    public List<int> VerticalSum(TreeNode root) {
        Dictionary<int, int> mm = new Dictionary<int, int>(); // Map to store vertical sums
        Help(root, mm, 0); // Compute vertical sums recursively

        List<int> ans = new List<int>();
        for (int i = mn; i <= mx; i++) {
            if (mm.ContainsKey(i)) {
                ans.Add(mm[i]); // Add vertical sums to the result list
            }
        }

        return ans;
    }
}
```

// **Explanation**:
// 1. We define a `TreeNode` class to represent the nodes of the binary tree.
// 2. The `Solution` class contains the `VerticalSum` method, which computes the vertical sums of nodes in the tree.
// 3. The `Help` method is a recursive helper function that traverses the tree and updates the vertical sums in the `mm` dictionary.
// 4. We maintain two variables (`mn` and `mx`) to keep track of the minimum and maximum vertical levels encountered during traversal.
// 5. For each node, we update the vertical sum for its corresponding vertical level (`vLevel`).
// 6. Finally, we iterate over the vertical levels from `mn` to `mx` and add the computed sums to the result list (`ans`).

