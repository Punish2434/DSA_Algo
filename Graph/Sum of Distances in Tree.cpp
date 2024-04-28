/*   Scroll down to see JAVA code and C# also  */

/*
    Company Tags                : Google
    Leetcode Link               : https://leetcode.com/problems/sum-of-distances-in-tree/
*/
/ C++ ************************************************************************************************************/

//Time : O(n), Space : O(n)
class Solution {
public:
    //store count of subtrees of each node
    long result_base_node = 0;
    vector<int> count;
    int N;
    int dfsBase(unordered_map<int, vector<int>> &adj, int curr_node, int prev_node, int curr_depth) {
        int total_node = 1;
        
        result_base_node += curr_depth;
        
        for(int &child : adj[curr_node]) {
            if(child == prev_node)
                continue;
            
            total_node += dfsBase(adj, child, curr_node, curr_depth+1);
        }
        
        //store count of subtrees of each node
        count[curr_node] = total_node;
        
        return total_node;
    }
    
    void DFS(unordered_map<int, vector<int>> &adj, int parent_node, int prev_node, vector<int>& result) {
        
        for(int &child : adj[parent_node]) {
            if(child == prev_node)
                continue;
            
            result[child] = result[parent_node] - count[child] + (N - count[child]);
            DFS(adj, child, parent_node, result);
        }
        
    }
    
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        unordered_map<int, vector<int>> adj;
        N = n;
        count.resize(n, 0);
        for(auto &vec : edges) {
            int u = vec[0];
            int v = vec[1];
            
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        
        
        result_base_node = 0;
        
        dfsBase(adj, 0, -1, 0);
        
        vector<int> result(n, 0);
        
        result[0] = result_base_node;
        
        DFS(adj, 0, -1, result);
        
        return result;
    }
};

/ Java ************************************************************************************************************/
class Solution {
    private List<List<Integer>> graph;
    private int[] subtreeSize;
    private int[] answer;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // Initialize the graph and subtreeSize arrays
        graph = new ArrayList<>();
        subtreeSize = new int[n];
        answer = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the adjacency list representation of the tree
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Calculate subtree sizes and answer for the root (node 0)
        dfs(0, -1);

        // Calculate answer for other nodes based on the root's answer
        dfs2(0, -1);

        return answer;
    }

    // First DFS to compute subtree sizes
    private void dfs(int node, int parent) {
        subtreeSize[node] = 1;
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) {
                dfs(neighbor, node);
                subtreeSize[node] += subtreeSize[neighbor];
                answer[node] += answer[neighbor] + subtreeSize[neighbor];
            }
        }
    }

    // Second DFS to update answer for all nodes
    private void dfs2(int node, int parent) {
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) {
                answer[neighbor] = answer[node] - subtreeSize[neighbor] + (graph.size() - subtreeSize[neighbor]);
                dfs2(neighbor, node);
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};

        Solution solution = new Solution();
        int[] result = solution.sumOfDistancesInTree(n, edges);

        // Print the result
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}


/ C# ************************************************************************************************************/
using System;
using System.Collections.Generic;

public class Solution {
    private List<List<int>> graph;
    private int[] subtreeSize;
    private int[] answer;

    public int[] SumOfDistancesInTree(int n, int[][] edges) {
        // Initialize the graph and subtreeSize arrays
        graph = new List<List<int>>();
        subtreeSize = new int[n];
        answer = new int[n];

        for (int i = 0; i < n; i++) {
            graph.Add(new List<int>());
        }

        // Build the adjacency list representation of the tree
        foreach (var edge in edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].Add(v);
            graph[v].Add(u);
        }

        // Calculate subtree sizes and answer for the root (node 0)
        Dfs(0, -1);

        // Calculate answer for other nodes based on the root's answer
        Dfs2(0, -1);

        return answer;
    }

    // First DFS to compute subtree sizes
    private void Dfs(int node, int parent) {
        subtreeSize[node] = 1;
        foreach (var neighbor in graph[node]) {
            if (neighbor != parent) {
                Dfs(neighbor, node);
                subtreeSize[node] += subtreeSize[neighbor];
                answer[node] += answer[neighbor] + subtreeSize[neighbor];
            }
        }
    }

    // Second DFS to update answer for all nodes
    private void Dfs2(int node, int parent) {
        foreach (var neighbor in graph[node]) {
            if (neighbor != parent) {
                answer[neighbor] = answer[node] - subtreeSize[neighbor] + (graph.Count - subtreeSize[neighbor]);
                Dfs2(neighbor, node);
            }
        }
    }

    public static void Main(string[] args) {
        int n = 6;
        int[][] edges = { new int[] { 0, 1 }, new int[] { 0, 2 }, new int[] { 2, 3 }, new int[] { 2, 4 }, new int[] { 2, 5 } };

        Solution solution = new Solution();
        int[] result = solution.SumOfDistancesInTree(n, edges);

        // Print the result
        foreach (var val in result) {
            Console.Write(val + " ");
        }
    }
}
