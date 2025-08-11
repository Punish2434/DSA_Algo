
##C# – Optimized BFS Solution

using System;
using System.Collections.Generic;

public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val = 0, TreeNode left = null, TreeNode right = null)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution
{
    public bool IsSameTree(TreeNode p, TreeNode q)
    {
        Queue<(TreeNode, TreeNode)> queue = new Queue<(TreeNode, TreeNode)>();
        queue.Enqueue((p, q));

        while (queue.Count > 0)
        {
            var (node1, node2) = queue.Dequeue();

            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;

            queue.Enqueue((node1.left, node2.left));
            queue.Enqueue((node1.right, node2.right));
        }

        return true;
    }
}


---

## Python – Optimized BFS Solution

from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        queue = deque([(p, q)])

        while queue:
            node1, node2 = queue.popleft()

            if not node1 and not node2:
                continue
            if not node1 or not node2:
                return False
            if node1.val != node2.val:
                return False

            queue.append((node1.left, node2.left))
            queue.append((node1.right, node2.right))

        return True


Both solutions:

* ✅ **O(n)** time complexity (n = number of nodes)
* ✅ **O(n)** space complexity for the queue
* ✅ Handle large trees without hitting recursion limits


