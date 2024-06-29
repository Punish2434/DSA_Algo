/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : 
    GFG Link               : https://www.geeksforgeeks.org/problems/identical-linked-lists/1
*/


/ C++ ******************************************************************************************************************************/

 // Time Complexity: O(n)
 // Auxilliary Space: O(1)
#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node(int data) : data(data), next(nullptr) {}
};

class Solution {
public:
    bool areIdentical(Node* head1, Node* head2) {
        while (head1 != nullptr && head2 != nullptr) {
            if (head1->data != head2->data) {
                return false;
            }
            head1 = head1->next;
            head2 = head2->next;
        }
        return head1 == nullptr && head2 == nullptr;
    }
};

int main() {
    Solution solution;

    Node* head1 = new Node(1);
    head1->next = new Node(2);
    head1->next->next = new Node(3);
    head1->next->next->next = new Node(4);
    head1->next->next->next->next = new Node(5);
    head1->next->next->next->next->next = new Node(6);

    Node* head2 = new Node(99);
    head2->next = new Node(59);
    head2->next->next = new Node(42);
    head2->next->next->next = new Node(20);

    cout << (solution.areIdentical(head1, head2) ? "true" : "false") << endl; // Output: false

    Node* head3 = new Node(1);
    head3->next = new Node(2);
    head3->next->next = new Node(3);
    head3->next->next->next = new Node(4);
    head3->next->next->next->next = new Node(5);

    Node* head4 = new Node(1);
    head4->next = new Node(2);
    head4->next->next = new Node(3);
    head4->next->next->next = new Node(4);
    head4->next->next->next->next = new Node(5);

    cout << (solution.areIdentical(head3, head4) ? "true" : "false") << endl; // Output: true

    return 0;
}


/ Java ******************************************************************************************************************************/

 // Time Complexity: O(n)
 // Auxilliary Space: O(1)
  class Solution {
    // Function to check whether two linked lists are identical or not.
    public boolean areIdentical(Node head1, Node head2) {
        // write your code here
        // Traverse both lists and compare data
        while(head1 != null && head2 != null){
            // If dat of both nodes is not equal , return false
            if(head1.data != head2.data){
                return false;
            }
            //Move to the next nodes
            head1 = head1.next;
            head2 = head2.next;
            
        }
        
        // If both lists are exhausted and are of sam e length, return true
        // If either list is not exhausted , return false
        return head1 == null && head2 == null;
    }
}


/ C# ******************************************************************************************************************************/

 // Time Complexity: O(n)
 // Auxilliary Space: O(1)
using System;

class Node {
    public int data;
    public Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public bool AreIdentical(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
    }

    static void Main(string[] args) {
        Solution solution = new Solution();

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);

        Node head2 = new Node(99);
        head2.next = new Node(59);
        head2.next.next = new Node(42);
        head2.next.next.next = new Node(20);

        Console.WriteLine(solution.AreIdentical(head1, head2)); // Output: False

        Node head3 = new Node(1);
        head3.next = new Node(2);
        head3.next.next = new Node(3);
        head3.next.next.next = new Node(4);
        head3.next.next.next.next = new Node(5);

        Node head4 = new Node(1);
        head4.next = new Node(2);
        head4.next.next = new Node(3);
        head4.next.next.next = new Node(4);
        head4.next.next.next.next = new Node(5);

        Console.WriteLine(solution.AreIdentical(head3, head4)); // Output: True
    }
}
