/*         Scroll Down to see JAVA code and C# also      */
/*
    Company Tags                 : Apple, Adobe, Microsoft, Samsung
    Leetcode Link                : https://leetcode.com/problems/delete-node-in-a-linked-list/
    Similar GfG Link             : https://practice.geeksforgeeks.org/problems/delete-a-node-in-single-linked-list/1
*/

/ C++ *********************************************************************/
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    void deleteNode(ListNode* node) {
        ListNode* prev = NULL;
        
        while(node && node->next) {
            node->val = node->next->val;
            prev = node;
            node = node->next;
        }
        delete(node);
        prev->next = NULL;
    }
};


/ JAVA *********************************************************************/
//T.C : O(n)
//S.C : O(1)
class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = null;

        while (node != null && node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        
        if (node != null) {
            if (prev != null)
                prev.next = null;
            else
                node = null;
        }
    }
}
//Swapping with Next Node:

class Solution {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }

        // Swap values between current node and next node
        int temp = node.val;
        node.val = node.next.val;
        node.next.val = temp;

        // Delete the next node
        node.next = node.next.next;
    }
}
// Why Swap?:
// Swapping values allows us to maintain the order of nodes without directly modifying the pointers.
// It ensures that the values before and after the deleted node remain in the same order.
// The number of nodes in the list decreases by one, as required.
/ C# *********************************************************************/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    public void DeleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }

        // Swap values between current node and next node
        int temp = node.val;
        node.val = node.next.val;
        node.next.val = temp;

        // Delete the next node
        node.next = node.next.next;
    }
}
