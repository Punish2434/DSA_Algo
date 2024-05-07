/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : Flipkart,Amazon,Microsoft,FactSet,Adobe,Cisco
    GFG Link               : https://www.geeksforgeeks.org/problems/reverse-level-order-traversal/1
*/


/ C++ *********************************************************************************************************************/

class Tree{
vector<int> reverseLevelOrder(Node *root)
{
    // code here
    queue<Node*> q;
    vector<int> ans;
    q.push(root);
    while(q.size()){
        Node *temp = q.front();
        q.pop();
        ans.push_back(temp->data);
        if(temp->right)q.push(temp->right);
        if(temp->left)q.push(temp->left);
    }
    reverse(ans.begin(),ans.end());
    return ans;
}
}
/ Java *********************************************************************************************************************/

  class Tree {
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(q.size()!=0){
            Node temp=q.remove();
            ans.add(temp.data);
            if(temp.right!=null)q.add(temp.right);
            if(temp.left!=null)q.add(temp.left);
        }
        Collections.reverse(ans);
        return ans;
    }

}

// Time Complexity:- O(N)
// Space Complexity:- O(N)
/ C# *********************************************************************************************************************/
Certainly! Let's convert the given Java code into C#.

Here's the equivalent C# code for the provided Java method:

```csharp
using System;
using System.Collections.Generic;

public class Tree
{
    public List<int> ReverseLevelOrder(Node node)
    {
        List<int> ans = new List<int>();
        Queue<Node> q = new Queue<Node>();
        q.Enqueue(node);

        while (q.Count != 0)
        {
            Node temp = q.Dequeue();
            ans.Add(temp.data);

            if (temp.right != null)
                q.Enqueue(temp.right);
            if (temp.left != null)
                q.Enqueue(temp.left);
        }

        ans.Reverse();
        return ans;
    }
}

public class Node
{
    public int data;
    public Node left;
    public Node right;
}
```

// In the C# code:
// - We use `List<int>` instead of `ArrayList<Integer>` for the result.
// - We use `Queue<Node>` instead of `LinkedList<Node>` for the queue.
// - The `Enqueue` and `Dequeue` methods are used instead of `add` and `remove`.
// - The `Collections.reverse(ans)` call is replaced with `ans.Reverse()`.

