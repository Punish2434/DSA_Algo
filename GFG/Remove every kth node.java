/*    Scroll below to see JAVA code and C# also    */
/*
    Compnay Tags                - 
    GFG  Link               - https://www.geeksforgeeks.org/problems/remove-every-kth-node/1
*/


/ C++ ******************************************************************************************/
class Solution{
    Node* deleteK(Node *head,int K){
      //Your code here
      if(K==1)return NULL;
      Node *temp=head,*prev=NULL;
      int c=1;
      while(temp){
          if(c==K){
              prev->next=temp->next;
              c=0;
          }
          else prev=temp;
          c++;
          temp=temp->next;
      }
      return head;
    }
}
/ Java ******************************************************************************************/

    class Solution
{
    /*You are required to complete this method*/
    Node delete(Node head, int k)
    {
	// Your code here
	if(k==1)return null;
	Node temp = head, prev = null;
	int c=1;
	while(temp!=null){
	    if(c==k){
	        c=0;
	        prev.next = temp.next;
	       
	    }
	    else prev = temp;
	    c++;
	    temp = temp.next;
	}
	return head;
    }
}

// Time Complexity:- O(N)
// Space Complexity:- O(1)

/ C# ******************************************************************************************/


```csharp
public class Solution
{
    /* You are required to complete this method */
    public Node Delete(Node head, int k)
    {
        // If k is 1, return null (since we delete the entire list)
        if (k == 1)
            return null;

        Node temp = head; // Initialize a temporary node to traverse the list
        Node prev = null; // Initialize a previous node to keep track of the previous node
        int c = 1; // Initialize a counter to keep track of the position in the list

        while (temp != null)
        {
            if (c == k)
            {
                // If the current position matches k, skip the current node
                c = 0;
                prev.next = temp.next;
            }
            else
            {
                // Otherwise, update the previous node and move to the next node
                prev = temp;
            }

            c++;
            temp = temp.next;
        }

        // Return the modified head of the list
        return head;
    }
}
```

// **Explanation:**
// - The given Java code defines a method `delete` that removes every `k`-th node from a singly linked list.
// - Here's how the C# code works:
//     1. We start by checking if `k` is equal to 1. If so, we return `null` (since deleting every node results in an empty list).
//     2. We initialize a temporary node `temp` to traverse the list and a previous node `prev` to keep track of the previous node.
//     3. We use a counter `c` to keep track of the position in the list.
//     4. While `temp` is not null (i.e., we haven't reached the end of the list):
//         - If the current position (`c`) matches `k`, we skip the current node by updating `prev.next` to point to the next node.
//         - Otherwise, we move to the next node by updating `prev`.
//         - We increment the counter `c`.
//     5. Finally, we return the modified head of the list.
