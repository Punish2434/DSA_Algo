/*     Scroll down to see JAVA code and c#    */
/*
    Also popular as              : Minimum rotations to unlock a circular lock
    Company Tags                 : META
    Leetcode Link                : https://leetcode.com/problems/open-the-lock/
    
    Similar Question :  1. Word Ladder (Leetcode) 
                        2. Gene Mutation (Leetcode)
                        3. Sequential Digits (Leetcode)
                        4. Print all Jumping Numbers smaller than or equal to a given value (GFG)
                        
    
*/


/ C++ *************************************************************************************************/
//Using BFS
//T.C : We have n = 10 slots in each wheel and we have w = 4 wheels. In worst case we will explore all possible combinations.
//      Total Combinations = O(n^w)
//S.C : In worst case we will store all possible combinations in queue O(n^w)
class Solution {
public:
    void fillNeighbors(queue<string>& que, string& curr, unordered_set<string>& dead) {
        for(int i = 0; i<4; i++) {
            char ch  = curr[i];

            char dec = ch=='0' ? '9' : ch-1;
            char inc = ch=='9' ? '0' : ch+1;

            curr[i]  = dec;
            if(!dead.count(curr)) {
                dead.insert(curr);
                que.push(curr);
            }

            curr[i] = inc;
            if(!dead.count(curr)) {
                dead.insert(curr);
                que.push(curr);
            }
            curr[i] = ch;
        }
    }
    int openLock(vector<string>& deadends, string target) {
        unordered_set<string> dead(begin(deadends), end(deadends));
        
        string start = "0000";        
        if(dead.count(start))
            return -1;
        
        queue<string> que;
        que.push(start);
        
        int level = 0;
        while(!que.empty()) {
            int n = que.size();
            
            while(n--) {
                string curr = que.front();
                que.pop();
                if(curr == target)
                    return level;
                
                fillNeighbors(que, curr, dead);
            }
            level++;
        }
        return -1;
    }
};



/ JAVA *************************************************************************************************/
//Using BFS
//T.C : We have n = 10 slots in each wheel and we have w = 4 wheels. In worst case we will explore all possible combinations.
//      Total Combinations = O(n^w)
//S.C : In worst case we will store all possible combinations in queue O(n^w)
class Solution {
    public void fillNeighbors(Queue<String> que, StringBuilder curr, Set<String> dead) {
        for (int i = 0; i < 4; i++) {
            char ch = curr.charAt(i);

            char dec = (ch == '0') ? '9' : (char) (ch - 1);
            char inc = (ch == '9') ? '0' : (char) (ch + 1);

            curr.setCharAt(i, dec);
            String decStr = curr.toString();
            if (!dead.contains(decStr)) {
                dead.add(decStr);
                que.add(decStr);
            }

            curr.setCharAt(i, inc);
            String incStr = curr.toString();
            if (!dead.contains(incStr)) {
                dead.add(incStr);
                que.add(incStr);
            }
            curr.setCharAt(i, ch);
        }
    }

    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }

        String start = "0000";
        if (dead.contains(start)) {
            return -1;
        }

        Queue<String> que = new LinkedList<>();
        que.add(start);

        int level = 0;
        while (!que.isEmpty()) {
            int n = que.size();

            while (n-- > 0) {
                String curr = que.poll();
                if (curr.equals(target)) {
                    return level;
                }

                StringBuilder currBuilder = new StringBuilder(curr);
                fillNeighbors(que, currBuilder, dead);
            }
            level++;
        }
        return -1;
    }
}
/ C# *************************************************************************************************/

```csharp
using System;
using System.Collections.Generic;

public class Solution
{
    public void FillNeighbors(Queue<string> que, StringBuilder curr, HashSet<string> dead)
    {
        for (int i = 0; i < 4; i++)
        {
            char ch = curr[i];

            char dec = (ch == '0') ? '9' : (char)(ch - 1);
            char inc = (ch == '9') ? '0' : (char)(ch + 1);

            curr[i] = dec;
            string decStr = curr.ToString();
            if (!dead.Contains(decStr))
            {
                dead.Add(decStr);
                que.Enqueue(decStr);
            }

            curr[i] = inc;
            string incStr = curr.ToString();
            if (!dead.Contains(incStr))
            {
                dead.Add(incStr);
                que.Enqueue(incStr);
            }
            curr[i] = ch;
        }
    }

    public int OpenLock(string[] deadends, string target)
    {
        HashSet<string> dead = new HashSet<string>(deadends);
        string start = "0000";
        if (dead.Contains(start))
        {
            return -1;
        }

        Queue<string> que = new Queue<string>();
        que.Enqueue(start);

        int level = 0;
        while (que.Count > 0)
        {
            int n = que.Count;

            while (n-- > 0)
            {
                string curr = que.Dequeue();
                if (curr == target)
                {
                    return level;
                }

                StringBuilder currBuilder = new StringBuilder(curr);
                FillNeighbors(que, currBuilder, dead);
            }
            level++;
        }
        return -1;
    }
}
```

// **Key Differences:**
// 1. **Syntax:**
//     - In C#, we use `HashSet<T>` instead of `Set<T>` for the deadends collection.
//     - C# uses `Queue<T>` instead of `LinkedList<T>` for the queue.
//     - C# uses `StringBuilder` in a similar way as Java's `StringBuilder`.
// 2. **Method Naming:**
//     - In C#, method names follow PascalCase (e.g., `FillNeighbors`, `OpenLock`).
// 3. **String Comparison:**
//     - In C#, we use `==` to compare strings (e.g., `curr == target`).
// 4. **String Manipulation:**
//     - C# uses `curr[i]` instead of `curr.charAt(i)` to access characters in a string.
//     - C# uses `curr.ToString()` to convert a `StringBuilder` to a string.
// 5. **Collections Initialization:**
//     - C# initializes the `HashSet` with `new HashSet<string>(deadends)`.



