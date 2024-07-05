/*   Scroll below to see JAVA code and C# also    */
/*
    Company Tags           : 
    GFG Link               : https://www.geeksforgeeks.org/problems/vertical-width-of-a-binary-tree/1
*/


/ C++ *********************************************************************************************************************************/
// T C: O(n).
// S C: O(height of the tree).
class Solution {
  public:
    // Function to find the vertical width of a Binary Tree.
    int maxi=0;
    int mini=0;
    void solve(Node* root,int distance){
        //base case
        if(!root)return ;
        
        //recursive case
        maxi=max(distance,maxi);
        mini=min(distance,mini);
        solve(root->left,distance-1);
        solve(root->right,distance+1);
        
    }
    
    int verticalWidth(Node* root) {
        //codeGenius
        if(!root) return 0;
        solve(root,0);
        return maxi-mini+1;
    }
};

/ Java *********************************************************************************************************************************/
// T C: O(n).
// S C: O(height of the tree).
class Solution {
    int maxi = 0;
    int mini = 0;

    void solve(Node root, int distance) {
        // base case
        if (root == null) return;

        // recursive case
        maxi = Math.max(distance, maxi);
        mini = Math.min(distance, mini);
        solve(root.left, distance - 1);
        solve(root.right, distance + 1);
    }

    int verticalWidth(Node root) {
        // codeGenius
        if (root == null) return 0;
        solve(root, 0);
        return maxi - mini + 1;
    }
}

class Node {
    int val;
    Node left, right;

    Node(int item) {
        val = item;
        left = right = null;
    }
}

/ C# *********************************************************************************************************************************/
// T C: O(n).
// S C: O(height of the tree).
public class Solution {
    int maxi = 0;
    int mini = 0;

    void Solve(Node root, int distance) {
        // base case
        if (root == null) return;

        // recursive case
        maxi = Math.Max(distance, maxi);
        mini = Math.Min(distance, mini);
        Solve(root.left, distance - 1);
        Solve(root.right, distance + 1);
    }

    public int VerticalWidth(Node root) {
        // codeGenius
        if (root == null) return 0;
        Solve(root, 0);
        return maxi - mini + 1;
    }
}

public class Node {
    public int val;
    public Node left, right;

    public Node(int item) {
        val = item;
        left = right = null;
    }
}
