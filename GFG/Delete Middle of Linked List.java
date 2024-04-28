/*   Scroll down to see JAVA code and C# also  */

/*
     Company Tags                : Flipkart,Amazon,Microsoft
     GFG  Link               : https://www.geeksforgeeks.org/problems/delete-middle-of-linked-list/1
*/
/ C++ ************************************************************************************************************/
 class Solution {
    Node* deleteMid(Node* head)
    {
        // Your Code Here
        if(head->next==NULL)return NULL;
        Node *slow=head,*fast=head,*temp=NULL;
        while(fast && fast->next){
            temp=slow;
            slow=slow->next;
            fast=fast->next->next;
        }
        temp->next=slow->next;
        return head;
    }
 }
/ Java ************************************************************************************************************/

   class Solution {
    Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        if(head.next==null)return null;
        Node slow=head,fast=head,temp=null;
        while(fast!=null && fast.next!=null){
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        temp.next=slow.next;
        return head;
    }
}
// Time Complexity:- O(N)
// Space Complexity:- O(1)
/ C# ************************************************************************************************************/
Certainly! Below is the equivalent C# code for the given Java solution:

```csharp
public class Solution {
    public Node DeleteMid(Node head) {
        // This is a method-only submission.
        // You only need to complete the method.
        if (head.next == null) return null;
        Node slow = head, fast = head, temp = null;
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = slow.next;
        return head;
    }
}
```

// Explanation:
// 1. The C# code mirrors the Java solution, with necessary syntax adjustments.
// 2. The `DeleteMid` method removes the middle node from the linked list.
// 3. We use `Node` as the data type for the linked list nodes.

