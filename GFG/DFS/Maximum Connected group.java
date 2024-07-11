
/*    Scroll below to see JAVA code and C# also      */
/*
    Company Tags           : 
    GFG Link               : https://www.geeksforgeeks.org/problems/maximum-connected-group/1
*/


/ C++ ************************************************************************************************************************/
//Approach-(DFS)
//T.C : O(n^2)
//S.C : O(n^2)

class Solution {
  public:
    int dfs(vector<vector<int>>& grid,int i,int j,int index){
        //base case
         int n= grid.size();
        if(i<0 || i>=n || j<0 || j>=n || grid[i][j] !=1){
            return 0;
        }
        //recursive
        grid[i][j] = index;
        int count = dfs(grid,i+1,j,index)+dfs(grid,i-1,j,index)
        +dfs(grid,i,j-1,index)+dfs(grid,i,j+1,index);
        return count +1;
    }
    void neighbours(vector<vector<int>>& grid,int i,int j,set<int> & s){
        int n= grid.size();
        if(i>0){
            s.insert(grid[i-1][j]);
        }
        if(j>0){
            s.insert(grid[i][j-1]);
        }
        if(i<n-1){
            s.insert(grid[i+1][j]);
        }
        if(j<n-1){
            s.insert(grid[i][j+1]);
        }
    }
    int MaxConnection(vector<vector<int>>& grid) {
        // codeGenius
        int n=grid.size(),res=0,index=2,count;
        map<int,int> mp;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    mp[index]=dfs(grid,i,j,index);
                    res=max(res,mp[index++]);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    set<int>s;
                    neighbours(grid,i,j,s);
                    count=1;
                    for(int i:s){
                        count+=mp[i];
                        
                    }
                    res=max(res,count);
                }
            }
        }
        return res;     
    }
};

/ Java ************************************************************************************************************************/
//Approach-(DFS)
//T.C : O(n^2)
//S.C : O(n^2)


class Solution {
    public int dfs(int[][] grid, int i, int j, int index) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = index;
        int count = dfs(grid, i + 1, j, index) + dfs(grid, i - 1, j, index)
                + dfs(grid, i, j - 1, index) + dfs(grid, i, j + 1, index);
        return count + 1;
    }

    public void neighbours(int[][] grid, int i, int j, Set<Integer> s) {
        int n = grid.length;
        if (i > 0) {
            s.add(grid[i - 1][j]);
        }
        if (j > 0) {
            s.add(grid[i][j - 1]);
        }
        if (i < n - 1) {
            s.add(grid[i + 1][j]);
        }
        if (j < n - 1) {
            s.add(grid[i][j + 1]);
        }
    }

    public int MaxConnection(int[][] grid) {
        int n = grid.length, res = 0, index = 2;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(grid, i, j, index);
                    mp.put(index, count);
                    res = Math.max(res, count);
                    index++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> s = new HashSet<>();
                    neighbours(grid, i, j, s);
                    int count = 1;
                    for (int val : s) {
                        if (mp.containsKey(val)) {
                            count += mp.get(val);
                        }
                    }
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }

    
}

/ C# ************************************************************************************************************************/
//Approach-(DFS)
//T.C : O(n^2)
//S.C : O(n^2)

  using System;
using System.Collections.Generic;

public class Solution {
    public int Dfs(int[][] grid, int i, int j, int index) {
        int n = grid.Length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = index;
        int count = Dfs(grid, i + 1, j, index) + Dfs(grid, i - 1, j, index)
                    + Dfs(grid, i, j - 1, index) + Dfs(grid, i, j + 1, index);
        return count + 1;
    }

    public void Neighbours(int[][] grid, int i, int j, HashSet<int> s) {
        int n = grid.Length;
        if (i > 0) {
            s.Add(grid[i - 1][j]);
        }
        if (j > 0) {
            s.Add(grid[i][j - 1]);
        }
        if (i < n - 1) {
            s.Add(grid[i + 1][j]);
        }
        if (j < n - 1) {
            s.Add(grid[i][j + 1]);
        }
    }

    public int MaxConnection(int[][] grid) {
        int n = grid.Length, res = 0, index = 2, count;
        Dictionary<int, int> mp = new Dictionary<int, int>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    mp[index] = Dfs(grid, i, j, index);
                    res = Math.Max(res, mp[index++]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    HashSet<int> s = new HashSet<int>();
                    Neighbours(grid, i, j, s);
                    count = 1;
                    foreach (int val in s) {
                        count += mp[val];
                    }
                    res = Math.Max(res, count);
                }
            }
        }
        return res;
    }
}


