/*         Scroll down to see JAVA code and C# also        */
/*
    Company Tags                : 
    Leetcode Link               : https://leetcode.com/problems/time-needed-to-buy-tickets/
*/

/ C++ *************************************************************************************************************/
//Approach-1 (Using Queue to simply simulate the operations)
//T.C : O(n*m) -> Loop runs intil queue is empty and in worst case all people have maximum m tickets 
//S.C : O(n)
class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        int n = tickets.size();
        queue<int> que;

        for (int i = 0; i < n; i++) {
            que.push(i);
        }

        int time = 0;

        while (!que.empty()) {
            time++;
            int front = que.front();
            que.pop();
            
            tickets[front]--;
            
            if (k == front && tickets[front] == 0) {
                return time;
            }
            if (tickets[front] != 0) {
                que.push(front);
            }
        }

        return time;
    }
};


//Approach-2 (Using Array for simulation)
//T.C : O(m*n) - Outer loop will run until nums[k] is 0. So in worst case nums[k] has max value m 
//S.C : O(1)
class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        int n = tickets.size();
        int time = 0;

        if (tickets[k] == 1)
            return k + 1;

        while (tickets[k] > 0) {
            for (int i = 0; i < n; i++) {

                if (tickets[i] != 0) {
                    tickets[i]--;
                    time++;
                }

                if (tickets[k] == 0)
                    return time;
            }
        }

        return time;
    }
};


//Approach-3 (Using simple observation)
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        int time = 0;
        
        for (int i = 0; i < tickets.size(); i++) {
            
            if (i <= k) {
                time += min(tickets[k], tickets[i]);
            } else {
                time += min(tickets[k] - 1, tickets[i]);
            }
        }
        
        return time;
    }
};


/ JAVA *************************************************************************************************************/
// Approach-1: Using Queue to simulate the operations
// Time Complexity: O(n*m)
// Space Complexity: O(n)
import java.util.LinkedList;
import java.util.Queue;

class SolutionApproach1 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            que.add(i);
        }

        int time = 0;

        while (!que.isEmpty()) {
            time++;
            int front = que.poll();
            tickets[front]--;
            
            if (k == front && tickets[front] == 0) {
                return time;
            }
            if (tickets[front] != 0) {
                que.add(front);
            }
        }

        return time;
    }
}

// Approach-2: Using Array for simulation
// Time Complexity: O(m*n)
// Space Complexity: O(1)
class SolutionApproach2 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int time = 0;

        if (tickets[k] == 1)
            return k + 1;

        while (tickets[k] > 0) {
            for (int i = 0; i < n; i++) {

                if (tickets[i] != 0) {
                    tickets[i]--;
                    time++;
                }

                if (tickets[k] == 0)
                    return time;
            }
        }

        return time;
    }
}

// Approach-3: Using simple observation
// Time Complexity: O(n)
// Space Complexity: O(1)
class SolutionApproach3 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        
        for (int i = 0; i < tickets.length; i++) {
            
            if (i <= k) {
                time += Math.min(tickets[k], tickets[i]);
            } else {
                time += Math.min(tickets[k] - 1, tickets[i]);
            }
        }
        
        return time;
    }
}

/ C# *************************************************************************************************************/
// Approach-1: Using Queue to simulate the operations
// Time Complexity: O(n*m)
// Space Complexity: O(n)
using System;
using System.Collections.Generic;

public class SolutionApproach1
{
    public int TimeRequiredToBuy(int[] tickets, int k)
    {
        int n = tickets.Length;
        Queue<int> que = new Queue<int>();

        for (int i = 0; i < n; i++)
        {
            que.Enqueue(i);
        }

        int time = 0;

        while (que.Count > 0)
        {
            time++;
            int front = que.Dequeue();
            tickets[front]--;

            if (k == front && tickets[front] == 0)
            {
                return time;
            }
            if (tickets[front] != 0)
            {
                que.Enqueue(front);
            }
        }

        return time;
    }
}
// Approach-2: Using Array for simulation
// Time Complexity: O(m*n)
// Space Complexity: O(1)
public class SolutionApproach2
{
    public int TimeRequiredToBuy(int[] tickets, int k)
    {
        int n = tickets.Length;
        int time = 0;

        if (tickets[k] == 1)
            return k + 1;

        while (tickets[k] > 0)
        {
            for (int i = 0; i < n; i++)
            {
                if (tickets[i] != 0)
                {
                    tickets[i]--;
                    time++;
                }

                if (tickets[k] == 0)
                    return time;
            }
        }

        return time;
    }
}
// Approach-3: Using simple observation
// Time Complexity: O(n)
// Space Complexity: O(1)


// 1. **Approach Description**:
//    - The approach is labeled as "Approach-3: Using simple observation."
//    - It aims to calculate the total time required to buy tickets based on certain conditions.

// 2. **Problem Context**:
//    - We have an array of `tickets` representing the cost of tickets at different positions.
//    - We need to find the total time required to buy tickets such that:
//      - If the current position `i` is less than or equal to `k`, we buy the tickets at the minimum cost between `tickets[k]` and `tickets[i]`.
//      - Otherwise (when `i > k`), we buy the tickets at the minimum cost between `tickets[k] - 1` and `tickets[i]`.

// 3. **Code Explanation**:
//    - Initialize a variable `time` to keep track of the total time.
//    - Iterate through the `tickets` array using the index `i`.
//    - Inside the loop:
//      - If `i` is less than or equal to `k`, add the minimum cost between `tickets[k]` and `tickets[i]` to `time`.
//      - Otherwise (when `i > k`), add the minimum cost between `tickets[k] - 1` and `tickets[i]` to `time`.
//    - Finally, return the computed `time`.

// 4. **Complexity Analysis**:
//    - **Time Complexity**: The loop iterates through the entire `tickets` array once, so the time complexity is O(n), where `n` is the length of the array.
//    - **Space Complexity**: The algorithm uses only a constant amount of extra space (the `time` variable), so the space complexity is O(1).

// Here's the equivalent C# code:

```csharp
// Approach-3: Using simple observation
// Time Complexity: O(n)
// Space Complexity: O(1)
public class SolutionApproach3 {
    public int TimeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        
        for (int i = 0; i < tickets.Length; i++) {
            if (i <= k) {
                time += Math.Min(tickets[k], tickets[i]);
            } else {
                time += Math.Min(tickets[k] - 1, tickets[i]);
            }
        }
        
        return time;
    }
}
```
