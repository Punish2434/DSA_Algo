/*    Scroll below to see JAVA code and C# code also    */
/*
    Company Tags                : will update soon
    Leetcode Link               : https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
*/


/ C++ ************************************************************************************************************/
//Approach-1 (Simply simulate whatever the problem asks for)
//T.C : O(n)
//S.C : O(n)
class Solution {
public:
    int countStudents(vector<int>& students, vector<int>& sandwiches) {
        int len = students.size();
        queue<int> que;
        stack<int> st;

        for (int i = 0; i < len; i++) {
            st.push(sandwiches[len - i - 1]);
            que.push(students[i]);
        }

        int lastServed = 0;
        while (!que.empty() && lastServed < que.size()) {
            if (st.top() == que.front()) {
                st.pop();
                que.pop();
                lastServed = 0;
            } else {
                que.push(que.front());
                que.pop();
                lastServed++;
            }
        }

        return que.size();
    }
};


//Aproach-2 (Using counter only)
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    int countStudents(vector<int>& stud, vector<int>& sand) {
        int n = stud.size();
        int arr[2] = {0};
        //arr[0] = count of student who like circular
        //arr[1] = count of student who like square
          
        for(int &x : stud)
            arr[x]++;
        
        for(int i = 0; i<n; i++) {
            if(arr[sand[i]] == 0) return n-i;
            arr[sand[i]]--;
        }
        
        return 0;
    }
};



/JAVA ************************************************************************************************************/
//Approach-1 (Simply simulate whatever the problem asks for)
//T.C : O(n)
//S.C : O(n)
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int len = students.length;
        Queue<Integer> que = new LinkedList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < len; i++) {
            st.push(sandwiches[len - i - 1]);
            que.add(students[i]);
        }

        int lastServed = 0;
        while (!que.isEmpty() && lastServed < que.size()) {
            if (st.peek() == que.peek()) {
                st.pop();
                que.poll();
                lastServed = 0;
            } else {
                que.add(que.peek());
                que.poll();
                lastServed++;
            }
        }

        return que.size();
    }
}


//Aproach-2 (Using counter only)
class Solution {
    public int countStudents(int[] stud, int[] sand) {
        int n = stud.length;
        int[] arr = new int[2];
        //arr[0] = count of student who like circular
        //arr[1] = count of student who like square
          
        for(int x : stud)
            arr[x]++;
        
        for(int i = 0; i < n; i++) {
            if(arr[sand[i]] == 0) return n - i;
            arr[sand[i]]--;
        }
        
        return 0;
    }
}

// Let's break down the given Java code step by step:

// 1. **Problem Description**:
//     - The problem involves students and sandwiches.
//     - Students form a queue, and sandwiches are placed in a stack.
//     - Each student either prefers circular (0) or square (1) sandwiches.
//     - The goal is to determine how many students will be unable to eat lunch.

// 2. **Explanation of the Code**:
//     - The `countStudents` method takes two arrays as input: `stud` (student preferences) and `sand` (sandwiches available).
//     - It calculates the number of students who will be unable to eat lunch.

// 3. **Initialization**:
//     - `int n = stud.length;`: Get the total number of students.
//     - `int[] arr = new int[2];`: Create an array `arr` to store counts of students who like circular (index 0) and square (index 1) sandwiches.

// 4. **Counting Students' Preferences**:
//     - Iterate through the `stud` array:
//         - If the student prefers circular sandwiches (value 0), increment `arr[0]`.
//         - If the student prefers square sandwiches (value 1), increment `arr[1]`.

// 5. **Processing Sandwiches**:
//     - Iterate through the `sand` array:
//         - For each sandwich, check if there are any students who like that type of sandwich:
//             - If `arr[sand[i]]` (count of students who like the current sandwich type) is 0, return `n - i`.
//                 - `n - i` represents the number of remaining students who haven't received a sandwich.
//         - Decrement `arr[sand[i]]` (since a student has taken that type of sandwich).

// 6. **Final Result**:
//     - If all students receive sandwiches, return 0 (everyone can eat).
//     - Otherwise, return the count of students who couldn't get a sandwich.

// 7. **Example**:
//     - Suppose `stud = [1, 1, 0, 0]` (two students like square sandwiches, two like circular sandwiches) and `sand = [0, 1, 0, 1]` (two square and two circular sandwiches).
//     - The process:
//         - First student (square) takes a sandwich.
//         - Second student (square) takes a sandwich.
//         - Third student (circular) takes a sandwich.
//         - Fourth student (circular) takes a sandwich.
//         - All students have eaten.
//     - Output: 0 (everyone can eat).

// 8. **Complexity**:
//     - Time complexity: O(n) (linear, where n is the number of students)
//     - Space complexity: O(1) (constant, as we use a fixed-size array)

// In summary, the code efficiently processes student preferences and sandwiches to determine the number of students who will be unable to eat lunch. 😊



/C# ************************************************************************************************************/
//Approach-1 (Simply simulate whatever the problem asks for)
//T.C : O(n)
//S.C : O(n)
public class Solution {
    public int CountStudents(int[] students, int[] sandwiches) {
        int len = students.Length;
        Queue<int> que = new Queue<int>();
        Stack<int> st = new Stack<int>();

        for (int i = 0; i < len; i++) {
            st.Push(sandwiches[len - i - 1]);
            que.Enqueue(students[i]);
        }

        int lastServed = 0;
        while (que.Count > 0 && lastServed < que.Count) {
            if (st.Peek() == que.Peek()) {
                st.Pop();
                que.Dequeue();
                lastServed = 0;
            } else {
                que.Enqueue(que.Peek());
                que.Dequeue();
                lastServed++;
            }
        }


        return que.Count;
    }
}



//Aproach-2 (Using counter only)

```csharp
public class Solution {
    public int CountStudents(int[] stud, int[] sand) {
        int n = stud.Length;
        int[] arr = new int[2];
        // arr[0] = count of students who like circular
        // arr[1] = count of students who like square

        foreach (int x in stud)
            arr[x]++;

        for (int i = 0; i < n; i++) {
            if (arr[sand[i]] == 0)
                return n - i;
            arr[sand[i]]--;
        }

        return 0;
    }
}
```

// In this approach, we maintain an array `arr` to keep track of the count of students who 
// prefer circular sandwiches (index 0) and those who prefer square sandwiches (index 1). 
// We iterate through the `stud` array to populate this count. Then, we iterate through the `sand` array, 
//   decrementing the count for the corresponding sandwich preference. If at any point the count becomes zero, 
// we return the remaining unserved students. Otherwise, if all students are served, we return 0. 🥪👩‍🎓
