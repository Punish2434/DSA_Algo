class Solution:
    def binaryTreePaths(self, root):
        result = []
        def dfs(node, path):
            if not node:
                return
            path.append(str(node.val))
            if not node.left and not node.right:
                result.append("->".join(path))
            else:
                dfs(node.left, path[:])   # copy path
                dfs(node.right, path[:])  # copy path
        dfs(root, [])
        return result
      
# Optimized:
# Time: O(n) (each node visited once, joining path at leaf).
# Space: O(h) (recursion stack, path storage).

public class Solution {
    public IList<string> BinaryTreePaths(TreeNode root) {
        var result = new List<string>();
        if (root == null) return result;
        DFS(root, new List<int>(), result);
        return result;
    }

    private void DFS(TreeNode node, List<int> path, IList<string> result) {
        if (node == null) return;
        path.Add(node.val);

        if (node.left == null && node.right == null) {
            result.Add(string.Join("->", path));
        } else {
            DFS(node.left, new List<int>(path), result);
            DFS(node.right, new List<int>(path), result);
        }
    }
}
