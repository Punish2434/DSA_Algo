/*     Scroll below to see JAVA code and C# also    */
/*
   
    Company Tags                : Amazon,D-E-Shaw
    GFG Link               : https://www.geeksforgeeks.org/problems/print-all-nodes-that-dont-have-sibling/1
*/

/ C++ ******************************************************************************************************************************/
class Tree {
void help(Node *root,vector<int> &ans){
    if(!root)return;
    if(root->left==NULL or root->right==NULL){
        if(root->left)ans.push_back(root->left->data);
        if(root->right)ans.push_back(root->right->data);
    }
    help(root->left,ans);
    help(root->right,ans);
}
vector<int> noSibling(Node* node)
{
    // code here
    vector<int> ans;
    help(node,ans);
    sort(ans.begin(),ans.end());
    if(ans.size()==0)return {-1};
    return ans;
}

}
/ Java ******************************************************************************************************************************/

class Tree {
    void help(Node root,ArrayList<Integer> ans){
        if(root==null)return;
        if(root.left==null || root.right==null){
            if(root.left!=null)ans.add(root.left.data);
            if(root.right!=null)ans.add(root.right.data);
        }
        help(root.left,ans);
        help(root.right,ans);
    }
    ArrayList<Integer> noSibling(Node node)
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        help(node,ans);
        Collections.sort(ans);
        if(ans.size()==0)ans.add(-1);
        return ans;
    }
}

// Time Complexity:- O(NLogN)

// Space Complexity:- O(N)

/ C# ******************************************************************************************************************************/

```csharp
public class Solution
{
    private ListNode ReverseList(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        ListNode last = ReverseList(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }

    public ListNode RemoveNodes(ListNode head)
    {
        head = ReverseList(head);

        int maximum = 0;
        ListNode prev = null;
        ListNode current = head;

        while (current != null)
        {
            maximum = Math.Max(maximum, current.val);

            if (current.val < maximum)
            {
                prev.next = current.next;
                ListNode deleted = current;
                current = current.next;
                deleted.next = null;
            }
            else
            {
                prev = current;
                current = current.next;
            }
        }

        return ReverseList(head);
    }
}
```

// **Explanation:**
// 1. We start by creating a `Solution` class with two methods: `ReverseList` and `RemoveNodes`.
// 2. The `ReverseList` method recursively reverses the linked list. It takes a `ListNode` (presumably representing the head of a linked list) as its input.
//     - If the `head` is `null` or if there's only one node (i.e., `head.next` is `null`), we return the `head` as is.
//     - Otherwise, we recursively call `ReverseList` on the next node (`head.next`).
//     - We then update the `next` references to reverse the order of nodes.
// 3. The `RemoveNodes` method:
//     - First, it reverses the linked list using the `ReverseList` method.
//     - It initializes a `maximum` value to keep track of the maximum encountered value.
//     - We iterate through the reversed list:
//         - If the current node's value is less than the maximum value encountered so far, we remove it from the list by updating the `prev.next` reference.
//         - Otherwise, we update the `prev` reference and move to the next node.
//     - Finally, we reverse the modified list again using the `ReverseList` method and return the result.

// Please note that you'll need to define the `ListNode` class separately, as it's not provided in the code snippet. The `ListNode` class should have properties like `val` (for the node value) and `next` (for the reference to the next node).

