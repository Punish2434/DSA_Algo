# sum_tree.py
class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None

class Solution:
    def toSumTree(self, root):
        self.convert_to_sum_tree(root)
    
    def convert_to_sum_tree(self, node):
        if not node:
            return 0
        
        # Post-order traversal
        left_sum = self.convert_to_sum_tree(node.left)
        right_sum = self.convert_to_sum_tree(node.right)
        
        # Store original value
        original_value = node.data
        
        # Update node value: 0 for leaf, else sum of subtrees
        node.data = 0 if not node.left and not node.right else left_sum + right_sum
        
        # Return original subtree sum
        return original_value + left_sum + right_sum




#Time Complexity: ( O(N) ), as each node is visited exactly once during post-order traversal.
#Space Complexity: ( O(h) ), where ( h ) is the tree height, due to the recursion stack. For a balanced tree, h=log⁡Nh = \log Nh = \log N; for a skewed tree, h=Nh = Nh = N
.
#Auxiliary Space: ( O(h) ), as no additional data structures are used beyond the recursion stack.
#Best/Average/Worst Case: Time is always ( O(N) ), as every node is processed once. Space is O(log⁡N)O(\log N)O(\log N)for balanced trees and ( O(N) ) for skewed trees.

