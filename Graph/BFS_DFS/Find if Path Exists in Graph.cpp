/*   Scroll down to see JAVA code and C# also  */
/*
    Company Tags                : Microsoft, Adobe, Amazon, Morgan Stanley, Samsung
    Leetcode Link               : https://leetcode.com/problems/find-if-path-exists-in-graph/
*/



/ C++ *****************************************************************************************************/
//Using DFS : O(m+n)
class Solution {
public:
    
    bool check(unordered_map<int, vector<int>>& mp, int node, int dest, vector<bool>& visited) {
        if(node == dest)
            return true;
        
        if(visited[node])
            return false;
        
        visited[node] = true;
        for(auto &it : mp[node]) {
            if(check(mp, it, dest, visited))
                return true;
        }
        return false;
    }
    
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        
        if(source == destination)
            return true;
        
        unordered_map<int, vector<int>> mp;
        
        for(vector<int> &vec : edges) {
            int u = vec[0];
            int v = vec[1];
            
            mp[u].push_back(v);
            mp[v].push_back(u);
        }
        
        vector<bool> visited(n, false);
        return check(mp, source, destination, visited);
    }
};


//Using BFS : O(m+n)
class Solution {
public:    
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        unordered_map<int, vector<int>> mp;
        
        for(vector<int> &vec : edges) {
            int u = vec[0];
            int v = vec[1];
            
            mp[u].push_back(v);
            mp[v].push_back(u);
        }
        
        vector<bool> visited(n, false);
        
        queue<int> que;
        que.push(source);
        visited[source] = true;
        
        while(!que.empty()) {
            int node = que.front();
            que.pop();
            if(node == destination)
                return true;

            for(auto &it : mp[node]) {
                if(!visited[it]) {
                    visited[it] = true;
                    que.push(it);
                }
            }
        }
        
        return false;
    }
};

/ Java *****************************************************************************************************/
  //Using DFS : O(m+n)

import java.util.*;

class Solution {
    public boolean check(Map<Integer, List<Integer>> mp, int node, int dest, boolean[] visited) {
        if (node == dest)
            return true;

        if (visited[node])
            return false;

        visited[node] = true;
        for (int it : mp.get(node)) {
            if (check(mp, it, dest, visited))
                return true;
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if (source == destination)
            return true;

        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int[] vec : edges) {
            int u = vec[0];
            int v = vec[1];

            mp.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            mp.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        boolean[] visited = new boolean[n];
        return check(mp, source, destination, visited);
    }
}


//Using BFS : O(m+n)
import java.util.*;

class Solution {
    public boolean validPath(int n, List<List<Integer>> edges, int source, int destination) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        
        for (List<Integer> vec : edges) {
            int u = vec.get(0);
            int v = vec.get(1);
            
            mp.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            mp.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        
        boolean[] visited = new boolean[n];
        
        Queue<Integer> que = new LinkedList<>();
        que.offer(source);
        visited[source] = true;
        
        while (!que.isEmpty()) {
            int node = que.poll();
            if (node == destination)
                return true;

            for (int it : mp.get(node)) {
                if (!visited[it]) {
                    visited[it] = true;
                    que.offer(it);
                }
            }
        }
        
        return false;
    }
}

/ C# *****************************************************************************************************/
//Using DFS : O(m+n)
using System;
using System.Collections.Generic;

public class Solution
{
    public bool Check(Dictionary<int, List<int>> mp, int node, int dest, bool[] visited)
    {
        if (node == dest)
            return true;

        if (visited[node])
            return false;

        visited[node] = true;
        foreach (int it in mp[node])
        {
            if (Check(mp, it, dest, visited))
                return true;
        }
        return false;
    }

    public bool ValidPath(int n, int[][] edges, int source, int destination)
    {
        if (source == destination)
            return true;

        Dictionary<int, List<int>> mp = new Dictionary<int, List<int>>();

        foreach (int[] vec in edges)
        {
            int u = vec[0];
            int v = vec[1];

            if (!mp.ContainsKey(u))
                mp[u] = new List<int>();
            mp[u].Add(v);

            if (!mp.ContainsKey(v))
                mp[v] = new List<int>();
            mp[v].Add(u);
        }

        bool[] visited = new bool[n];
        return Check(mp, source, destination, visited);
    }
}
//Using BFS : O(m+n)

using System;
using System.Collections.Generic;

public class Solution
{
    public bool ValidPath(int n, List<List<int>> edges, int source, int destination)
    {
        Dictionary<int, List<int>> mp = new Dictionary<int, List<int>>();
        
        foreach (List<int> vec in edges)
        {
            int u = vec[0];
            int v = vec[1];
            
            if (!mp.ContainsKey(u))
                mp[u] = new List<int>();
            mp[u].Add(v);
            
            if (!mp.ContainsKey(v))
                mp[v] = new List<int>();
            mp[v].Add(u);
        }
        
        bool[] visited = new bool[n];
        
        Queue<int> que = new Queue<int>();
        que.Enqueue(source);
        visited[source] = true;
        
        while (que.Count > 0)
        {
            int node = que.Dequeue();
            if (node == destination)
                return true;

            foreach (int it in mp[node])
            {
                if (!visited[it])
                {
                    visited[it] = true;
                    que.Enqueue(it);
                }
            }
        }
        
        return false;
    }
}
