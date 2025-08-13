//GFG
// Optimized C# Code 

using System;
using System.Collections.Generic;
using System.Linq;

public class Node
{
    public int data;
    public Node left, right;
    public Node(int val)
    {
        data = val;
        left = right = null;
    }
}

public class Solution
{
    public List<int> TopView(Node root)
    {
        if (root == null) return new List<int>();

        var hdToNode = new Dictionary<int, int>();
        var queue = new Queue<(Node node, int hd)>();
        queue.Enqueue((root, 0));

        while (queue.Count > 0)
        {
            var (node, hd) = queue.Dequeue();

            if (!hdToNode.ContainsKey(hd))
                hdToNode[hd] = node.data;

            if (node.left != null)
                queue.Enqueue((node.left, hd - 1));

            if (node.right != null)
                queue.Enqueue((node.right, hd + 1));
        }

        return hdToNode.OrderBy(kvp => kvp.Key).Select(kvp => kvp.Value).ToList();
    }
}


---
//Optimized Python Code**

```python
from collections import deque

class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None

class Solution:
    def topView(self, root):
        if not root:
            return []
        
        hd_to_node = {}
        queue = deque([(root, 0)])
        
        while queue:
            node, hd = queue.popleft()
            
            if hd not in hd_to_node:
                hd_to_node[hd] = node.data
            
            if node.left:
                queue.append((node.left, hd - 1))
            if node.right:
                queue.append((node.right, hd + 1))
        
        return [hd_to_node[key] for key in sorted(hd_to_node)]


---
Both codes:

* Use **BFS** to ensure the first node at each horizontal distance is stored.
* Work in **O(n)** time and space.
* Maintain **left-to-right** order by sorting HDs at the end.

---
