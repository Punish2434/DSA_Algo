/*   Scroll down to see JAVA code and C# also  */
/*
    Company Tags                : 
    GFG Link               : https://www.geeksforgeeks.org/problems/merge-sort-on-doubly-linked-list/1
*/


/ C++ ************************************************************************************************************/
class Node {
public:
    int data;
    Node* next;
    Node* prev;
    Node(int val) : data(val), next(nullptr), prev(nullptr) {}
};

class Solution {
public:
    Node* sortDoubly(Node* h1) {
        if (!h1 || !h1->next) { // empty or one node.
            return h1;
        }
        // split in two halves recursively
        Node* h2 = funsplit(h1);
        h1 = sortDoubly(h1);
        h2 = sortDoubly(h2);
        
        return merge(h1, h2);
    }
    
    Node* funsplit(Node* h1) {
        Node* fast = h1;
        Node* slow = h1;
        while (fast->next && fast->next->next) { // odd and even case
            slow = slow->next;
            fast = fast->next->next;
        }
        Node* temp = slow->next;
        slow->next = nullptr;
        return temp;
    }
    
    Node* merge(Node* h1, Node* h2) {
        Node* dummy = new Node(-1);
        Node* curr = dummy;
        while (h1 && h2) { // till both lists exist.
            if (h1->data < h2->data) {
                curr->next = h1;
                h1->prev = curr;
                h1 = h1->next;
            } else {
                curr->next = h2;
                h2->prev = curr;
                h2 = h2->next;
            }
            curr = curr->next;
        }
        // iterating in remaining elements in h1 list
        if (h1) {
            curr->next = h1;
            h1->prev = curr;
        }
        if (h2) {
            curr->next = h2;
            h2->prev = curr;
        }
        
        Node* ans = dummy->next;
        ans->prev = nullptr;
        return ans;
    }
};


/ Java ************************************************************************************************************/

class Solution {
    // Function to sort the given doubly linked list using Merge Sort.
    static Node sortDoubly(Node h1) {
        //9 add your code here
       if (h1 == null || h1.next == null) { // empty or one node.
            return h1;
        }
        ///split in two halves recursively
        Node h2 = funsplit(h1);
        h1 = sortDoubly(h1);
        h2 = sortDoubly(h2);
        
        return merge(h1, h2);
        
    }
     static Node funsplit(Node h1){
         Node fast = h1, slow=h1;
        while(fast.next!=null && fast.next.next!=null){  //odd and even case
            slow = slow.next; fast= fast.next.next;
        }
        Node temp = slow.next; slow.next=null;
        return temp;
     }
     static Node merge(Node h1, Node h2){
        Node dummy = new Node(-1);
        Node curr = dummy;
        while(h1!=null && h2!=null){ // till both list exist.
            if(h1.data < h2.data){
                curr.next = h1;
                h1.prev = curr;
                
                h1=h1.next;
            }
            else{
                curr.next = h2;
                h2.prev=curr;
                
                h2=h2.next;
            }
            curr=curr.next;
        }
        //iterating in remaining ele in h1 list
        if(h1!=null){
            curr.next = h1;
            h1.prev =curr;
        }
        if(h2!=null){
            curr.next = h2;
            h2.prev=  curr;
        }
        
        Node ans = dummy.next;
        ans.prev = null;
       return ans;
   }
}

/ C# ************************************************************************************************************/

```csharp
public class Node {
    public int data;
    public Node next;
    public Node prev;
    public Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}

public class Solution {
    public Node SortDoubly(Node h1) {
        if (h1 == null || h1.next == null) { // empty or one node.
            return h1;
        }
        // split in two halves recursively
        Node h2 = FunSplit(h1);
        h1 = SortDoubly(h1);
        h2 = SortDoubly(h2);
        
        return Merge(h1, h2);
    }
    
    public Node FunSplit(Node h1) {
        Node fast = h1;
        Node slow = h1;
        while (fast.next != null && fast.next.next != null) { // odd and even case
            slow = slow.next;
            fast = fast.next.next;
        }
        Node temp = slow.next;
        slow.next = null;
        return temp;
    }
    
    public Node Merge(Node h1, Node h2) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        while (h1 != null && h2 != null) { // till both lists exist.
            if (h1.data < h2.data) {
                curr.next = h1;
                h1.prev = curr;
                h1 = h1.next;
            } else {
                curr.next = h2;
                h2.prev = curr;
                h2 = h2.next;
            }
            curr = curr.next;
        }
        // iterating in remaining elements in h1 list
        if (h1 != null) {
            curr.next = h1;
            h1.prev = curr;
        }
        if (h2 != null) {
            curr.next = h2;
            h2.prev = curr;
        }
        
        Node ans = dummy.next;
        ans.prev = null;
        return ans;
    }
}
```

// Explanation:
// 1. We created a `Node` class to represent the doubly linked list nodes.
// 2. Renamed the Java methods (`sortDoubly`, `funsplit`, and `merge`) to C# methods (`SortDoubly`, `FunSplit`, and `Merge`).
// 3. Changed the `Node` type from `Node` to `Node` in method parameters and return types.
// 4. Replaced `null` with `null` in C#.
// 5. Used the C# `public` access modifier for methods.
// 6. Adjusted the method calls to match the C# method names.

