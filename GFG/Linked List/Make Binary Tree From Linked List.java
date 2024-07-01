
/*    Scroll below to see JAVA code and C#  also  */
/*
    Company Tags           : 
    GFG Link               : https://www.geeksforgeeks.org/problems/make-binary-tree/1
*/

/ C++ **************************************************************************************************************************/
//T.C : O(n)
//S.C : O(n)

TreeNode *solve(vector<int> &arr,int i){
    //base case
    if(i>=arr.size())
    return NULL;
    //recursive code
    TreeNode *newNode=new TreeNode(arr[i]);
    newNode->left=solve(arr,2*i+1);
    newNode->right=solve(arr,2*i+2);
    return newNode;
    
}
void convert(Node *head, TreeNode *&root) {
    // CodeGenius
    vector<int> arr;
    Node *temp=head;
    while(temp!=NULL){
        arr.push_back(temp->data);
        temp=temp->next;
    }
    root=solve(arr,0);
}
/ Java **************************************************************************************************************************/
//T.C : O(n)
//S.C : O(n)
*class Tree{
int data;
    Tree left;
    Tree right;
    Tree(int d){
        data=d;
        left=null;
        right=null;
    }
}

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/


class GfG {
    // Function to make binary tree from linked list.
    public static Tree convert(Node head, Tree node) {
        if (head == null) {
            return null;
        }

        // Initialize queue to hold Tree nodes
        Queue<Tree> queue = new LinkedList<>();

        // Create the root of the tree
        node = new Tree(head.data);
        queue.add(node);

        // Advance the linked list pointer
        head = head.next;

        // Iterate through the linked list
        while (head != null) {
            // Dequeue a node from the queue
            Tree parent = queue.poll();

            // Create the left child from the next list node
            Tree leftChild = null, rightChild = null;
            if (head != null) {
                leftChild = new Tree(head.data);
                queue.add(leftChild);
                head = head.next;
            }

            // Create the right child from the next list node
            if (head != null) {
                rightChild = new Tree(head.data);
                queue.add(rightChild);
                head = head.next;
            }

            // Attach left and right children to the parent node
            parent.left = leftChild;
            parent.right = rightChild;
        }

        return node;
    }

    // Function to print level order traversal of the binary tree
    public static void levelOrder(Tree root) {
        if (root == null) {
            return;
        }

        // Initialize queue to hold Tree nodes
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        // Iterate through the binary tree
        while (!queue.isEmpty()) {
            Tree node = queue.poll();
            System.out.print(node.data + " ");

            // Enqueue left child
            if (node.left != null) {
                queue.add(node.left);
            }

            // Enqueue right child
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

   
}



  / C# **************************************************************************************************************************/
//T.C : O(n)
//S.C : O(n)

    using System;
using System.Collections.Generic;

public class Node {
    public int data;
    public Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class TreeNode {
    public int data;
    public TreeNode left, right;
    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class Solution {
    public static TreeNode Solve(List<int> arr, int i) {
        // base case
        if (i >= arr.Count) {
            return null;
        }
        // recursive code
        TreeNode newNode = new TreeNode(arr[i]);
        newNode.left = Solve(arr, 2 * i + 1);
        newNode.right = Solve(arr, 2 * i + 2);
        return newNode;
    }

    public static void Convert(Node head, ref TreeNode root) {
        List<int> arr = new List<int>();
        Node temp = head;
        while (temp != null) {
            arr.Add(temp.data);
            temp = temp.next;
        }
        root = Solve(arr, 0);
    }

    public static void Main(string[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        TreeNode root = null;
        Convert(head, ref root);
        
        // Function to print level order traversal of the binary tree
        LevelOrder(root);  // Output: 1 2 3 4 5
    }

    public static void LevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);

        while (queue.Count > 0) {
            TreeNode node = queue.Dequeue();
            Console.Write(node.data + " ");

            if (node.left != null) {
                queue.Enqueue(node.left);
            }

            if (node.right != null) {
                queue.Enqueue(node.right);
            }
        }
    }
}
