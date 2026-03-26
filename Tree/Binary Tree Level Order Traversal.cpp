/*
    Company Tags  : Amazon, Microsoft, Bloomberg
    Leetcode Link : https://leetcode.com/problems/binary-tree-level-order-traversal/
*/

// Approach: Breadth-First Search (Level by Level)
// T.C : O(n)
// S.C : O(n)
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if (!root) {
            return result;
        }

        queue<TreeNode*> q;
        q.push(root);

        while (!q.empty()) {
            int levelSize = q.size();
            vector<int> currentLevel;
            currentLevel.reserve(levelSize);

            while (levelSize--) {
                TreeNode* node = q.front();
                q.pop();

                currentLevel.push_back(node->val);

                if (node->left) {
                    q.push(node->left);
                }
                if (node->right) {
                    q.push(node->right);
                }
            }

            result.push_back(currentLevel);
        }

        return result;
    }
};
