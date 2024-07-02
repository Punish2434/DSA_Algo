/*    Scroll below to see JAVA code and C# also   */

/*
    Company Tags           : 
    GFG Link               : https://www.geeksforgeeks.org/problems/linked-list-of-strings-forms-a-palindrome/1
*/
/ C++ *****************************************************************************************************************************/
//T.C:  O(n)
//S.C : O(n)

class Solution {
  public:
    bool Palin(string str){
        int n=str.length();
        for(int i=0;i<n;i++){
            if(str[i] != str[n-1-i])
            return false;
        }
        return true;
        }
    bool compute(Node* head) {
        //CodeGenius
        string a="";
        Node* temp=head;
        if(temp==NULL){
            return false;
        }
        while(temp){
            a.append(temp->data);
            temp=temp->next;
        }
        return Palin(a);
        
    }
};

/ Java *****************************************************************************************************************************/
//T.C:  O(n)
//S.C : O(n)
  
class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class Solution {

    // Helper method to check if a string is a palindrome
    public boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // Method to compute if the linked list forms a palindrome
    public boolean compute(Node head) {
        if (head == null) {
            return false;
        }

        StringBuilder a = new StringBuilder();
        Node temp = head;

        while (temp != null) {
            a.append(temp.data);
            temp = temp.next;
        }

        return isPalindrome(a.toString());
    }

    public static void main(String[] args) {
        Node head = new Node('r');
        head.next = new Node('a');
        head.next.next = new Node('c');
        head.next.next.next = new Node('e');
        head.next.next.next.next = new Node('c');
        head.next.next.next.next.next = new Node('a');
        head.next.next.next.next.next.next = new Node('r');

        Solution solution = new Solution();
        System.out.println(solution.compute(head));  // Should print true
    }
}
/ C# *****************************************************************************************************************************/
//T.C:  O(n)
//S.C : O(n)

using System;
using System.Text;

public class Node {
    public char Data;
    public Node Next;

    public Node(char data) {
        this.Data = data;
        this.Next = null;
    }
}

public class Solution {

    // Helper method to check if a string is a palindrome
    public bool IsPalindrome(string str) {
        int n = str.Length;
        for (int i = 0; i < n / 2; i++) {
            if (str[i] != str[n - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    // Method to compute if the linked list forms a palindrome
    public bool Compute(Node head) {
        if (head == null) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        Node temp = head;

        while (temp != null) {
            sb.Append(temp.Data);
            temp = temp.Next;
        }

        return IsPalindrome(sb.ToString());
    }

    public static void Main(string[] args) {
        Node head = new Node('r');
        head.Next = new Node('a');
        head.Next.Next = new Node('c');
        head.Next.Next.Next = new Node('e');
        head.Next.Next.Next.Next = new Node('c');
        head.Next.Next.Next.Next.Next = new Node('a');
        head.Next.Next.Next.Next.Next.Next = new Node('r');

        Solution solution = new Solution();
        Console.WriteLine(solution.Compute(head));  // Should print True
    }
}
