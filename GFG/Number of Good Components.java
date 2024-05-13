/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : 
    GFG Link               : https://www.geeksforgeeks.org/problems/number-of-good-components--170647/1
*/


/ C++ ******************************************************************************************************************************/

//T.C : O(v^2 * s)
//S.C : O(v + e)
class Solution {
  public:
    void dfs(int i,int s,vector<vector<int>> &adj,vector<int> &vis,bool &a,int &node){
        vis[i]=1;
        node++;
        if(s!=adj[i].size()){
            a=false;
        }
        for(auto x:adj[i]){
            if(!vis[x])dfs(x,s,adj,vis,a,node);
        }
    }
    int findNumberOfGoodComponent(int e, int v, vector<vector<int>> &edges) {
        // code here
        vector<vector<int>> adj(v+1);
        for(auto x:edges){
            adj[x[0]].push_back(x[1]);
            adj[x[1]].push_back(x[0]);
        }
        int ans=0;
        vector<int> vis(v+1,0);
        for(int i=1;i<=v;i++){
            if(!vis[i]){
                int node=0;
                bool a=true;
                dfs(i,adj[i].size(),adj,vis,a,node);
                if(a and node-1==adj[i].size())ans++;
            }
        }
        return ans;
    }
};
/ Java ******************************************************************************************************************************/

import java.util.*;

class Solution {
    public void dfs(int i, int s, List<List<Integer>> adj, int[] vis, boolean[] a, int[] node) {
        vis[i] = 1;
        node[0]++;
        if (s != adj.get(i).size()) {
            a[0] = false;
        }
        for (int x : adj.get(i)) {
            if (vis[x] == 0) {
                dfs(x, s, adj, vis, a, node);
            }
        }
    }

    public int findNumberOfGoodComponent(int e, int v, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] x : edges) {
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }
        int ans = 0;
        int[] vis = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            if (vis[i] == 0) {
                int[] node = {0};
                boolean[] a = {true};
                dfs(i, adj.get(i).size(), adj, vis, a, node);
                if (a[0] && node[0] - 1 == adj.get(i).size()) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
/ C# ******************************************************************************************************************************/

using System;
using System.Collections.Generic;

public class Solution {
    public void Dfs(int i, int s, List<List<int>> adj, int[] vis, ref bool a, ref int node) {
        vis[i] = 1;
        node++;
        if (s != adj[i].Count) {
            a = false;
        }
        foreach (int x in adj[i]) {
            if (vis[x] == 0) {
                Dfs(x, s, adj, vis, ref a, ref node);
            }
        }
    }

    public int FindNumberOfGoodComponent(int e, int v, int[][] edges) {
        List<List<int>> adj = new List<List<int>>();
        for (int i = 0; i <= v; i++) {
            adj.Add(new List<int>());
        }
        foreach (int[] x in edges) {
            adj[x[0]].Add(x[1]);
            adj[x[1]].Add(x[0]);
        }
        int ans = 0;
        int[] vis = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            if (vis[i] == 0) {
                int node = 0;
                bool a = true;
                Dfs(i, adj[i].Count, adj, vis, ref a, ref node);
                if (a && node - 1 == adj[i].Count) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
