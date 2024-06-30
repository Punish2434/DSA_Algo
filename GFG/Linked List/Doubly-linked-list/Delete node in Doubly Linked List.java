/*         Scroll below to see JAVA code and C# also        */
/*
 
    Company Tags           : Amazon , Walmart
    GFG Link               : https://www.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1
*/


/ C++ ****************************************************************************************************************/
// Time Complexity: O(n)
//  Auxilliary Space: O(1)

#include <iostream>

struct Node {
    int data;
    Node* next;
    Node* prev;
    
    Node(int data) {
        this->data = data;
        next = prev = nullptr;
    }
};

class Solution {
public:
    Node* deleteNode(Node* head, int x) {
        // If the linked list is empty or the position is out of range
        if (head == nullptr || x <= 0) {
            return head;
        }

        Node* current = head;

        // If the node to be deleted is the head node
        if (x == 1) {
            head = head->next;
            if (head != nullptr) {
                head->prev = nullptr;
            }
            delete current;
            return head;
        }

        // Traverse to the node to be deleted
        for (int i = 1; current != nullptr && i < x; ++i) {
            current = current->next;
        }

        // If position is more than the number of nodes
        if (current == nullptr) {
            return head;
        }

        // Update the pointers
        if (current->next != nullptr) {
            current->next->prev = current->prev;
        }
        
        if (current->prev != nullptr) {
            current->prev->next = current->next;
        }

        delete current;
        return head;
    }
};

// Helper function to print the list
void printList(Node* head) {
    while (head != nullptr) {
        std::cout << head->data << " ";
        head = head->next;
    }
    std::cout << std::endl;
}
/ Java ****************************************************************************************************************/
// Time Complexity: O(n)
//  Auxilliary Space: O(1)


Definition for doubly Link List Node
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}
*/

class Solution {
    public Node deleteNode(Node head, int x) {
        if (head == null || x <= 0) {
            return head;
        }
        
        Node current = head;
        
        // If head needs to be removed
        if (x == 1) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return head;
        }
        
        // Traverse the list to find the node to be deleted
        for (int i = 1; current != null && i < x; i++) {
            current = current.next;
        }
        
        // If position is more than number of nodes
        if (current == null) {
            return head;
        }
        
        // Node to be deleted is found
        
        // If node to be deleted is not the last node
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        
        // If node to be deleted is not the first node
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        
        return head;
    }

    // Helper function to print the list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Helper function to create a new node
    public Node push(Node head, int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        return head;
    }
    
    
}

/ C# ****************************************************************************************************************/
// Time Complexity: O(n)
//  Auxilliary Space: O(1)
using System;

public class Node {
    public int data;
    public Node next;
    public Node prev;
    
    public Node(int data) {
        this.data = data;
        next = prev = null;
    }
}

public class Solution {
    public Node DeleteNode(Node head, int x) {
        // If the linked list is empty or the position is out of range
        if (head == null || x <= 0) {
            return head;
        }

        Node current = head;

        // If the node to be deleted is the head node
        if (x == 1) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return head;
        }

        // Traverse to the node to be deleted
        for (int i = 1; current != null && i < x; ++i) {
            current = current.next;
        }

        // If position is more than the number of nodes
        if (current == null) {
            return head;
        }

        // Update the pointers
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        
        if (current.prev != null) {
            current.prev.next = current.next;
        }

        return head;
    }
}

// Helper function to print the list
public class LinkedList {
    public static void PrintList(Node head) {
        while (head != null) {
            Console.Write(head.data + " ");
            head = head.next;
        }
        Console.WriteLine();
    }
}
