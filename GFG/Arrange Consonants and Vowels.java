/*     Scroll below to see JAVA code and C# also   */
/*
    Company Tags                : Amazon 
    GFG Link               : https://www.geeksforgeeks.org/problems/arrange-consonants-and-vowels/1
*/


/ C++ ************************************************************************************************************/

class Solution {
    struct Node* arrangeCV(Node* head) {
        // Code here
        Node *vowel=new Node('a'),*con=new Node('b');
        Node *vowelH=vowel,*conH=con;
        while(head){
            char temp = head->data;
            if(temp=='a' or temp=='e' or temp=='i' or temp=='o' or temp=='u'){
                vowel->next=head;
                vowel=vowel->next;
            }
            else{
                con->next=head;
                con=con->next;
            }
            head=head->next;
        }
        con->next=NULL;
        vowel->next=conH->next;
        return vowelH->next;
    }
}
/ Java ************************************************************************************************************/
class Solution {
    
    public Node arrangeCV(Node head){
        //write code here and return the head of changed linked list
        Node vowel = new Node('a'), con = new Node('b');
        Node vowelH=vowel, conH=con;
        while(head!=null){
            char temp = head.data;
            if(temp=='a'|| temp=='e'|| temp=='i' || temp=='o'|| temp=='u'){
                vowel.next= head;
                vowel=vowel.next;
                
            }else{
                con.next=head;
                con=con.next;
            }
            head=head.next;
        }
        con.next=null;
        vowel.next= conH.next;
        return vowelH.next;
    }
}

// Time Complexity:- O(N)
// Space Complexity:- O(1)

/ C# ************************************************************************************************************/


```csharp
public class Node
{
    public char data;
    public Node next;

    public Node(char value)
    {
        data = value;
        next = null;
    }
}

public class Solution
{
    public Node ArrangeCV(Node head)
    {
        // Initialize two dummy nodes for vowels and consonants
        Node vowel = new Node('a');
        Node con = new Node('b');
        Node vowelH = vowel; // Head of vowel list
        Node conH = con; // Head of consonant list

        while (head != null)
        {
            char temp = head.data;
            if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u')
            {
                // Add vowel to the vowel list
                vowel.next = head;
                vowel = vowel.next;
            }
            else
            {
                // Add consonant to the consonant list
                con.next = head;
                con = con.next;
            }
            head = head.next;
        }

        // Terminate the consonant list
        con.next = null;

        // Combine the vowel and consonant lists
        vowel.next = conH.next;

        // Return the head of the modified linked list
        return vowelH.next;
    }
}
```


// 1. **Node Class**:
//    - We define a simple `Node` class with a `char` data field and a `next` pointer.
//    - The constructor initializes the `data` and sets `next` to `null`.

// 2. **Method Signature**:
//    - The method `ArrangeCV` takes a `Node` (linked list head) as input and returns the head of the modified linked list.

// 3. **Initialization**:
//    - We create two dummy nodes: `vowel` and `con` to hold vowels and consonants, respectively.
//    - `vowelH` and `conH` are used to keep track of the heads of the vowel and consonant lists.

// 4. **Traversing the Input List**:
//    - We iterate through the input linked list (`head`).
//    - If the character is a vowel ('a', 'e', 'i', 'o', or 'u'), we add it to the vowel list.
//    - Otherwise, we add it to the consonant list.

// 5. **Combining the Lists**:
//    - After processing all nodes, we terminate the consonant list by setting `con.next` to `null`.
//    - We then connect the vowel list to the consonant list by setting `vowel.next` to `conH.next`.

// 6. **Returning the Result**:
//    - Finally, we return the head of the modified linked list (which is the head of the vowel list).
