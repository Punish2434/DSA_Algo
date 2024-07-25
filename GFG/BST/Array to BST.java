/*         Scroll below to see JAVA code and C# also        */

    // Company Tags          : Snapdeal,Adobe,Cisco
    //GFG Link               : https://www.geeksforgeeks.org/problems/array-to-bst4443/1
// C++ ********************************************************************************************************************************************/
//Approach (using height-balanced binary search tree (BST))
//T.C : O(n)
//S.C : O(n) 
#include <vector>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        if (nums.empty()) {
            return nullptr;
        }
        return constructBST(nums, 0, nums.size() - 1);
    }

private:
    TreeNode* constructBST(const vector<int>& nums, int left, int right) {
        if (left > right) {
            return nullptr;
        }
        int mid = left + (right - left) / 2;
        TreeNode* node = new TreeNode(nums[mid]);
        node.left = constructBST(nums, left, mid - 1);
        node.right = constructBST(nums, mid + 1, right);
        return node;
    }
};

// Java ********************************************************************************************************************************************/
//Approach (using height-balanced binary search tree (BST))
//T.C : O(n)
//S.C : O(n) 
class Solution {
 
    
    public Node sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructBST(nums, 0, nums.length - 1);
    }
    
    private Node constructBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        Node node = new Node(nums[mid]);
        node.left = constructBST(nums, left, mid - 1);
        node.right = constructBST(nums, mid + 1, right);
        return node;
    }
}


// C# ********************************************************************************************************************************************/
//Approach (using height-balanced binary search tree (BST))
//T.C : O(n)
//S.C : O(n) 
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val = 0, TreeNode left = null, TreeNode right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode SortedArrayToBST(int[] nums) {
        if (nums == null || nums.Length == 0) {
            return null;
        }
        return ConstructBST(nums, 0, nums.Length - 1);
    }
    
    private TreeNode ConstructBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = ConstructBST(nums, left, mid - 1);
        node.right = ConstructBST(nums, mid + 1, right);
        return node;
    }
}


// JavaScript ********************************************************************************************************************************************/
//Approach (using height-balanced binary search tree (BST))
//T.C : O(n)
//S.C : O(n) 
class Solution {
    sortedArrayToBST(nums) {
        if (!nums || nums.length === 0) {
            return null;
        }
        return this.constructBST(nums, 0, nums.length - 1);
    }
    
    constructBST(nums, left, right) {
        if (left > right) {
            return null;
        }
        const mid = Math.floor((left + right) / 2);
        const node = new Node(nums[mid]);
        node.left = this.constructBST(nums, left, mid - 1);
        node.right = this.constructBST(nums, mid + 1, right);
        return node;
    }
}
