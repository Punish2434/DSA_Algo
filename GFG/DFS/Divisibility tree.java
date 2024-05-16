/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : 
    GFG  Link               : https://www.geeksforgeeks.org/problems/divisibility-tree1902/1
*/

/ C++ ************************************************************************************************************************/
//Binary first search
class Solution {
    int help(vector<int> adj[],vector<int> &vis,int &ans,int node){
        vis[node]=1;
        int size=1;
        for(int x:adj[node]){
            if(!vis[x]){
                int temp = help(adj,vis,ans,x);
                size+=temp;
                if(temp%2==0)ans++;
            }
        }
        return size;
    }
	int minimumEdgeRemove(int n, vector<vector<int>>edges){
	    // Code here
	    vector<int> adj[n+1];
	    for(auto x:edges){
	        adj[x[0]].push_back(x[1]);
	        adj[x[1]].push_back(x[0]);
	    }
	    vector<int> vis(n+1,0);
	    int ans=0;
	    for(int i=1;i<=n;i++){
	        if(!vis[i]){
	            help(adj,vis,ans,i);
	        }
	    }
	    return ans;
	}
}
/ Java ************************************************************************************************************************/

class Solution {
    static int ans=0;
    int help(ArrayList<ArrayList<Integer>> adj,int vis[],int node){
        vis[node]=1;
        int size=1;
        for(int x:adj.get(node)){
            if(vis[x]==0){
                int temp = help(adj,vis,x);
                size+=temp;
                if(temp%2==0)ans++;
            }
        }
        return size;
    }
    public int minimumEdgeRemove(int n, int[][] edges) {
        // code here
        ans=0;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int x[]:edges){
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }
	    int vis[] = new int[n+1];
	    Arrays.fill(vis,0);
	    for(int i=1;i<=n;i++){
	        if(vis[i]==0){
	            int temp = help(adj,vis,i);
	        }
	    }
	    return ans;
    }
}
// Time Complexity:- O(Max(N,M))
// Space Complexity:- O(Max(N,M))

//And
class Solution {
    public int minimumEdgeRemove(int n, int[][] edges) {
        // Step 1: Create adjacency list for the tree
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        // Step 2: Perform DFS to calculate the size of each subtree
        int[] subtreeSize = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        dfs(1, tree, visited, subtreeSize);

        // Step 3: Count the number of removable edges
        int removableEdges = 0;
        for (int i = 2; i <= n; i++) {
            if (subtreeSize[i] % 2 == 0) {
                removableEdges++;
            }
        }
        
        return removableEdges;
    }

    private int dfs(int node, List<List<Integer>> tree, boolean[] visited, int[] subtreeSize) {
        visited[node] = true;
        int size = 1; // Count the current node
        for (int neighbor : tree.get(node)) {
            if (!visited[neighbor]) {
                size += dfs(neighbor, tree, visited, subtreeSize);
            }
        }
        subtreeSize[node] = size;
        return size;
    }

    
}

/ C# ************************************************************************************************************************/
using System;
using System.Collections.Generic;

public class Solution
{
    public int MinimumEdgeRemove(int n, int[][] edges)
    {
        // Step 1: Create adjacency list for the tree
        List<List<int>> tree = new List<List<int>>();
        for (int i = 0; i <= n; i++)
        {
            tree.Add(new List<int>());
        }
        foreach (var edge in edges)
        {
            int u = edge[0];
            int v = edge[1];
            tree[u].Add(v);
            tree[v].Add(u);
        }

        // Step 2: Perform DFS to calculate the size of each subtree
        int[] subtreeSize = new int[n + 1];
        bool[] visited = new bool[n + 1];
        Dfs(1, tree, visited, subtreeSize);

        // Step 3: Count the number of removable edges
        int removableEdges = 0;
        for (int i = 2; i <= n; i++)
        {
            if (subtreeSize[i] % 2 == 0)
            {
                removableEdges++;
            }
        }

        return removableEdges;
    }

    private int Dfs(int node, List<List<int>> tree, bool[] visited, int[] subtreeSize)
    {
        visited[node] = true;
        int size = 1; // Count the current node
        foreach (var neighbor in tree[node])
        {
            if (!visited[neighbor])
            {
                size += Dfs(neighbor, tree, visited, subtreeSize);
            }
        }
        subtreeSize[node] = size;
        return size;
    }

    public static void Main(string[] args)
    {
        // Example usage:
        int n = 10;
        int[][] edges = { new[] { 2, 1 }, new[] { 3, 1 }, new[] { 4, 3 }, new[] { 5, 2 }, new[] { 6, 1 }, new[] { 7, 2 }, new[] { 8, 6 }, new[] { 9, 8 }, new[] { 10, 8 } };

        Solution solution = new Solution();
        Console.WriteLine("Example result: " + solution.MinimumEdgeRemove(n, edges)); // Output: 2
    }
}
