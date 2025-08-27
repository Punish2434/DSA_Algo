# Time: O(N) → every node visited once.
# Space: O(N) in worst case (queue storing all nodes in bottom level).

public class Solution {
    public int WidthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        var queue = new Queue<(TreeNode node, long index)>();
        queue.Enqueue((root, 0));

        while (queue.Count > 0) {
            int size = queue.Count;
            long minIndex = queue.Peek().index; // normalize to avoid overflow
            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                var (node, index) = queue.Dequeue();
                long curIndex = index - minIndex; // normalize
                if (i == 0) first = curIndex;
                if (i == size - 1) last = curIndex;

                if (node.left != null) queue.Enqueue((node.left, curIndex * 2));
                if (node.right != null) queue.Enqueue((node.right, curIndex * 2 + 1));
            }

            maxWidth = Math.Max(maxWidth, (int)(last - first + 1));
        }

        return maxWidth;
    }
}


from collections import deque

class Solution:
    def widthOfBinaryTree(self, root):
        if not root:
            return 0
        
        max_width = 0
        queue = deque([(root, 0)])
        
        while queue:
            size = len(queue)
            min_index = queue[0][1]  # normalize
            first, last = 0, 0
            
            for i in range(size):
                node, index = queue.popleft()
                cur_index = index - min_index
                if i == 0: first = cur_index
                if i == size - 1: last = cur_index
                
                if node.left:
                    queue.append((node.left, cur_index * 2))
                if node.right:
                    queue.append((node.right, cur_index * 2 + 1))
            
            max_width = max(max_width, last - first + 1)
        
        return max_width
