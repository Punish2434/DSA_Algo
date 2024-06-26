/*     Scroll below to see JAVA code and C# also  */
/*
    Company Tags                : Paytm
    Leetcode Link               : https://leetcode.com/problems/balance-a-binary-search-tree/description
*/


/ C++ ********************************************************************************************************************************/
//Simple approach using inordere tree traversal
//T.C : O(n)
//S.C : O(n)
class Solution {
public:
    void inOrder(TreeNode* root, vector<int>& vec) {
        if(!root)
            return;
        
        inOrder(root->left, vec);
        vec.push_back(root->val);
        inOrder(root->right, vec);

    }

    TreeNode* construct(int l, int r, vector<int>& vec) {
        if(l > r)
            return NULL;
        
        int mid = l + (r-l)/2;
        TreeNode* root = new TreeNode(vec[mid]);

        root->left  = construct(l, mid-1, vec);
        root->right = construct(mid+1, r, vec);

        return root;
    }

    TreeNode* balanceBST(TreeNode* root) {
        vector<int> vec;
        inOrder(root, vec);
        int l = 0, r = vec.size()-1;

        return construct(l, r, vec);
    }
};


/ JAVA ********************************************************************************************************************************/
//Simple approach-1 using inordere tree traversal
//T.C : O(n)
//S.C : O(n)


class Solution {
    public TreeNode balanceBST(TreeNode root) {
        // Step 1: Get the in-order traversal of the BST
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values);

        // Step 2: Construct the balanced BST from the sorted list
        return sortedListToBST(values, 0, values.size() - 1);
    }

    private void inOrderTraversal(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, values);
        values.add(node.val);
        inOrderTraversal(node.right, values);
    }

    private TreeNode sortedListToBST(List<Integer> values, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(values.get(mid));
        node.left = sortedListToBST(values, left, mid - 1);
        node.right = sortedListToBST(values, mid + 1, right);

        return node;
    }
}
/ C# ********************************************************************************************************************************/
// Definition for a binary tree node.
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode BalanceBST(TreeNode root) {
        // Step 1: Get the in-order traversal of the BST
        List<int> values = new List<int>();
        InOrderTraversal(root, values);

        // Step 2: Construct the balanced BST from the sorted list
        return SortedListToBST(values, 0, values.Count - 1);
    }

    private void InOrderTraversal(TreeNode node, List<int> values) {
        if (node == null) {
            return;
        }
        InOrderTraversal(node.left, values);
        values.Add(node.val);
        InOrderTraversal(node.right, values);
    }

    private TreeNode SortedListToBST(List<int> values, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(values[mid]);
        node.left = SortedListToBST(values, left, mid - 1);
        node.right = SortedListToBST(values, mid + 1, right);

        return node;
    }
}
