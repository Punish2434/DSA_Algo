//Time Complexity: O(n)
//Space Complexity: O(n)


public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val, Node _prev, Node _next, Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}

public class Solution {
    public Node Flatten(Node head) {
        if (head == null) return head;
        
        FlattenRecursive(head);
        return head;
    }

    private Node FlattenRecursive(Node head) {
        Node curr = head;
        Node tail = head;

        while (curr != null) {
            Node next = curr.next;

            if (curr.child != null) {
                Node childTail = FlattenRecursive(curr.child);
                next = curr.next;
                
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;

                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                tail = childTail;
            } else {
                tail = curr;
            }

            curr = next;
        }

        return tail;
    }
}
