/*     Scroll below to see JAVA code and C# also  */
/*
    Company Tags            : Flipkart,Morgan Stanley,Accolite,Amazon,Microsoft,Snapdeal,MakeMyTrip,Qualcomm
    GFG  Link               : https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
*/


/ C++ ********************************************************************************************************************/

class Solution{
    Node *reverse(Node *head){
        Node *prev=NULL,*curr=head,*nxt=NULL;
        while(curr){
            nxt=curr->next;
            curr->next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }
    struct Node* addTwoLists(struct Node* num1, struct Node* num2)
    {
        // code here
        Node *temp=NULL;
        while(num1 and num1->data==0){
            temp=num1;
            num1=num1->next;
        }
        if(temp)temp->next=NULL;
        temp=NULL;
        while(num2 and num2->data==0){
            temp=num2;
            num2=num2->next;
        }
        if(temp)temp->next=NULL;
        if(!num1 and !num2)return new Node(0);
        if(!num1)return num2;
        if(!num2)return num1;
        num1=reverse(num1);
        num2=reverse(num2);
        temp=new Node(1);
        Node *head1=num1,*head2=num2,*ans=temp;
        int carry=0;
        while(head1 and head2){
            int sum = head1->data+head2->data+carry;
            carry=sum/10;
            temp->next=new Node(sum%10);
            temp=temp->next;
            head1=head1->next;
            head2=head2->next;
        }
        while(head1){
            int sum = head1->data+carry;
            carry=sum/10;
            temp->next=new Node(sum%10);
            temp=temp->next;
            head1=head1->next;
        }
        while(head2){
            int sum = head2->data+carry;
            carry=sum/10;
            temp->next=new Node(sum%10);
            temp=temp->next;
            head2=head2->next;
        }
        if(carry)temp->next=new Node(carry);
        return reverse(ans->next);
    }
}
/ Java ********************************************************************************************************************/

   class Solution{
    //Function to add two numbers represented by linked list.
   static Node reverse(Node head){
        Node prev=null,curr=head,nxt=null;
        while(curr!=null){
            nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }
    static Node addTwoLists(Node num1, Node num2){
        // code here
        // return head of sum list
        Node temp=null;
        while(num1!=null && num1.data==0){
            temp=num1;
            num1=num1.next;
        }
        if(temp!=null)
        temp.next=null;
        while(num2!=null && num2.data==0){
            temp=num2;
            num2=num2.next;
        }
        if(temp!=null)
        temp.next=null;
        if(num1==null && num2==null)return new Node(0);
        if(num1==null)return num2;
        if(num2==null)return num1;
        num1=reverse(num1);
        num2=reverse(num2);
        Node head1=num1,head2=num2;
        temp=new Node(1);
        Node ans=temp;
        int carry=0;
        while(head1!=null && head2!=null){
            int sum = head1.data+head2.data+carry;
            carry=sum/10;
            temp.next=new Node(sum%10);
            temp=temp.next;
            head1=head1.next;
            head2=head2.next;
        }
        while(head1!=null){
            int sum = head1.data+carry;
            carry=sum/10;
            temp.next=new Node(sum%10);
            temp=temp.next;
            head1=head1.next;
        }
        while(head2!=null){
            int sum = head2.data+carry;
            carry=sum/10;
            temp.next=new Node(sum%10);
            temp=temp.next;
            head2=head2.next;
        }
        if(carry!=0)temp.next=new Node(carry);
        return reverse(ans.next);
    }

}

// Time Complexity:- O(N+M)
// Space Complexity:- O(Max(N,M))
/ C# ********************************************************************************************************************/

```csharp
using System;

public class ListNode
{
    public int val;
    public ListNode next;
    public ListNode(int val = 0, ListNode next = null)
    {
        this.val = val;
        this.next = next;
    }
}

public class Solution
{
    // Function to reverse a linked list.
    static ListNode Reverse(ListNode head)
    {
        ListNode prev = null, curr = head, nxt = null;
        while (curr != null)
        {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }

    // Function to add two numbers represented by linked lists.
    static ListNode AddTwoLists(ListNode num1, ListNode num2)
    {
        // Initialize a temporary node.
        ListNode temp = null;

        // Remove leading zeros from num1.
        while (num1 != null && num1.val == 0)
        {
            temp = num1;
            num1 = num1.next;
        }
        if (temp != null)
            temp.next = null;

        // Remove leading zeros from num2.
        while (num2 != null && num2.val == 0)
        {
            temp = num2;
            num2 = num2.next;
        }
        if (temp != null)
            temp.next = null;

        // If both lists are empty, return a new node with value 0.
        if (num1 == null && num2 == null)
            return new ListNode(0);

        // Reverse both lists.
        num1 = Reverse(num1);
        num2 = Reverse(num2);

        // Initialize pointers for both lists and a carry.
        ListNode head1 = num1, head2 = num2;
        temp = new ListNode(1); // Initialize a dummy node.
        ListNode ans = temp;
        int carry = 0;

        // Add corresponding digits and update carry.
        while (head1 != null && head2 != null)
        {
            int sum = head1.val + head2.val + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            head1 = head1.next;
            head2 = head2.next;
        }

        // Process remaining digits in num1.
        while (head1 != null)
        {
            int sum = head1.val + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            head1 = head1.next;
        }

        // Process remaining digits in num2.
        while (head2 != null)
        {
            int sum = head2.val + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            head2 = head2.next;
        }

        // If there's a carry, add it as a new node.
        if (carry != 0)
            temp.next = new ListNode(carry);

        // Reverse the final answer list.
        return Reverse(ans.next);
    }
}
```

// **Explanation**:
// 1. The `ListNode` class represents a node in the linked list. It has an integer value (`val`) and a reference to the next node (`next`).
// 2. The `Reverse` function reverses a linked list using three pointers: `prev`, `curr`, and `nxt`.
// 3. The `AddTwoLists` function adds two linked lists (`num1` and `num2`) representing non-negative integers.
//     - It removes leading zeros from both lists.
//     - Reverses both lists for easier addition.
//     - Initializes a dummy node (`temp`) to build the result list.
//     - Adds corresponding digits from both lists, considering any carry.
//     - Handles remaining digits in either list.
//     - Adds a new node for the carry if needed.
//     - Finally, reverses the result list and returns it.



