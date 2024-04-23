/*   Scroll down to see JAVA code also   */
/*
    Company Tags                : GOOGLE
    Leetcode Link               : https://leetcode.com/problems/minimum-height-trees/
*/

//NOTE : You can do a brute force to do DFS from each node treating them as root and keep finding the Height in every case. That will give TLE.

/ C++ ************************************************************************************************/
//Using Topological Sorting
//T.C : O(V+E)
//S.C : O(V+E)
class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        if(n == 1)
            return {0};
        
        vector<int> result;
        vector<int> indegree(n);
        map<int, vector<int>> adj;
        
        for(vector<int> vec:edges) {
            int u = vec[0];
            int v = vec[1];
            indegree[u]++;
            indegree[v]++;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        
        queue<int> que;
        for(int i = 0; i<n; i++) {
            if(indegree[i] == 1) //adding all leafs node so that we can remove them later
                que.push(i);
        }
        
        while(n > 2) {
            int size = que.size();
            n -= size; //removing nodes with indegreee 1
            
            while(size--) {
                int u = que.front();
                que.pop();
                for(int v:adj[u]) {
                    indegree[v]--;
                    if(indegree[v] == 1)
                        que.push(v);
                }
            }
        }
        
        while(!que.empty()) {
            result.push_back(que.front());
            que.pop();
        }
        return result;
    }
};



/ JAVA **************************************************************************************************/
//Using Topological Sorting
//T.C : O(V+E)
//S.C : O(V+E)
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Collections.singletonList(0);
        
        List<Integer> result = new ArrayList<>();
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            indegree[u]++;
            indegree[v]++;
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) // adding all leaf nodes so that we can remove them later
                que.offer(i);
        }
        
        while (n > 2) {
            int size = que.size();
            n -= size; // removing nodes with indegree 1
            
            while (size-- > 0) {
                int u = que.poll();
                for (int v : adj.getOrDefault(u, Collections.emptyList())) {
                    indegree[v]--;
                    if (indegree[v] == 1)
                        que.offer(v);
                }
            }
        }
        
        while (!que.isEmpty()) {
            result.add(que.poll());
        }
        return result;
    }
}

/ C# **************************************************************************************************/
using System;
using System.Collections.Generic;
using System.Linq;

public class Solution
{
    public IList<int> FindMinHeightTrees(int n, int[][] edges)
    {
        if (n == 1)
            return new List<int> { 0 };

        List<int> result = new List<int>();
        int[] indegree = new int[n];
        Dictionary<int, List<int>> adj = new Dictionary<int, List<int>>();

        foreach (var edge in edges)
        {
            int u = edge[0];
            int v = edge[1];
            indegree[u]++;
            indegree[v]++;
            if (!adj.ContainsKey(u))
                adj[u] = new List<int>();
            adj[u].Add(v);
            if (!adj.ContainsKey(v))
                adj[v] = new List<int>();
            adj[v].Add(u);
        }

        Queue<int> que = new Queue<int>();
        for (int i = 0; i < n; i++)
        {
            if (indegree[i] == 1)
                que.Enqueue(i);
        }

        while (n > 2)
        {
            int size = que.Count;
            n -= size;

            while (size-- > 0)
            {
                int u = que.Dequeue();
                foreach (var v in adj.GetValueOrDefault(u, Enumerable.Empty<int>()))
                {
                    indegree[v]--;
                    if (indegree[v] == 1)
                        que.Enqueue(v);
                }
            }
        }

        while (que.Count > 0)
        {
            result.Add(que.Dequeue());
        }

        return result;
    }
}

// 1. **Syntax and Language Features**:
//     - **Java** uses semicolons (`;`) to terminate statements, while **C#** uses semicolons as well.
//     - **Java** uses curly braces (`{}`) to define code blocks, whereas **C#** also uses curly braces.
//     - **Java** uses the `public` keyword for method visibility, while **C#** uses `public` as well.
//     - **Java** uses `List<Integer>` for lists, while **C#** uses `List<int>` or `IList<int>`.
//     - **Java** uses `Map<Integer, List<Integer>>` for a dictionary-like structure, while **C#** uses `Dictionary<int, List<int>>`.
//     - **Java** uses `Queue<Integer>` for a queue, while **C#** uses `Queue<int>`.

// 2. **Method Names and Parameters**:
//     - In **Java**, the method is named `findMinHeightTrees`, whereas in **C#**, it is named `FindMinHeightTrees`.
//     - The method signature in **Java** is `public List<Integer> findMinHeightTrees(int n, int[][] edges)`, and in **C#**, it is `public IList<int> FindMinHeightTrees(int n, int[][] edges)`.

// 3. **Collections and Data Structures**:
//     - In **Java**, we use `Collections.singletonList(0)` to create a list with a single element, while in **C#**, we use `new List<int> { 0 }`.
//     - **Java** uses `adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v)` to add elements to the adjacency list, whereas **C#** uses conditional checks and `GetValueOrDefault`.

// 4. **Queue Operations**:
//     - In **Java**, we use `que.offer(i)` to enqueue an element, while in **C#**, we use `que.Enqueue(i)`.
//     - Similarly, `que.poll()` in **Java** corresponds to `que.Dequeue()` in **C#**.

// 5. **Loop and Decrement**:
//     - In **Java**, we decrement `size` within the loop using `size--`, while in **C#**, we decrement it in the loop condition using `while (size-- > 0)`.

// 6. **Empty Collections**:
//     - In **Java**, we use `Collections.emptyList()` for an empty list, while in **C#**, we use `Enumerable.Empty<int>()`.

