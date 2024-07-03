/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags           : Microsoft
    GFG Link               : https://www.geeksforgeeks.org/problems/remove-all-occurences-of-duplicates-in-a-linked-list/1
*/



/ C++ ***********************************************************************************************************/
//Approach-1 (Using complete sorting)
//T.C : O(n)
//S.C : O(1)


class Solution {
  public:
    Node* removeAllDuplicates(struct Node* head) {
        // codeGenius
        Node *temp=head;
        Node *prev=NULL;
        while(temp!=NULL){
            
            int cnt=0;
            while(temp!=NULL && temp->next != NULL){
                if(temp->data == temp->next->data){
                    temp=temp->next;
                    cnt++;
                }
                else{
                    break;
                }
            }
            if(cnt>0){
                if(prev != NULL){
                    prev->next=temp->next;
                    temp=prev->next;
                }
                else{
                    head=temp->next;
                    temp=head;
                }
            }
                else{
                prev = temp;
                temp=temp->next;
            }
            
        }
        return head;
        
        
    }
};

/ Java ***********************************************************************************************************/
//Approach-1 (Using complete sorting)
//T.C : O(n)
//S.C : O(1)

class Solution {
    public Node removeAllDuplicates(Node head) {
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            int cnt = 0;
            while (temp != null && temp.next != null) {
                if (temp.data == temp.next.data) {
                    temp = temp.next;
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt > 0) {
                if (prev != null) {
                    prev.next = temp.next;
                    temp = prev.next;
                } else {
                    head = temp.next;
                    temp = head;
                }
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}

  
/ C# ***********************************************************************************************************/
//Approach-1 (Using complete sorting)
//T.C : O(n)
//S.C : O(1)

  public class Node
{
    public int data;
    public Node next;

    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

public class Solution
{
    public Node RemoveAllDuplicates(Node head)
    {
        Node temp = head;
        Node prev = null;

        while (temp != null)
        {
            int cnt = 0;
            while (temp != null && temp.next != null)
            {
                if (temp.data == temp.next.data)
                {
                    temp = temp.next;
                    cnt++;
                }
                else
                {
                    break;
                }
            }

            if (cnt > 0)
            {
                if (prev != null)
                {
                    prev.next = temp.next;
                    temp = prev.next;
                }
                else
                {
                    head = temp.next;
                    temp = head;
                }
            }
            else
            {
                prev = temp;
                temp = temp.next;
            }
        }

        return head;
    }
}
