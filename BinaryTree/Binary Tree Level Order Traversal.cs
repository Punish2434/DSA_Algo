/*
    LeetCode 102: Binary Tree Level Order Traversal
    Approach : Breadth-First Search (Queue)

    Time Complexity  : O(n)
    Space Complexity : O(n)
*/

public class Solution
{
    public IList<IList<int>> LevelOrder(TreeNode root)
    {
        IList<IList<int>> result = new List<IList<int>>();

        if (root == null)
        {
            return result;
        }

        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);

        while (queue.Count > 0)
        {
            int levelSize = queue.Count;
            List<int> level = new List<int>(levelSize);

            for (int i = 0; i < levelSize; i++)
            {
                TreeNode node = queue.Dequeue();
                level.Add(node.val);

                if (node.left != null)
                {
                    queue.Enqueue(node.left);
                }

                if (node.right != null)
                {
                    queue.Enqueue(node.right);
                }
            }

            result.Add(level);
        }

        return result;
    }
}
