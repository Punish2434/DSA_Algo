/*   Scroll down to see JAVA code and C# also  */
/*
  Company Tags                : Paytm, Amazon, Microsoft, Samsung, Snapdeal, Citrix, D-E-Shaw, Ola Cabs, Visa, Linkedin, Opera, Streamoid Technologies, Informatica
  Leetcode Qn Link            : https://leetcode.com/problems/number-of-islands/
*/

/ C++ *****************************************************************************************************/
//Approach-1 (DFS)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
public:
    vector<pair<int, int>> dir{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    void dfs(vector<vector<char>>& grid, int i, int j) {
        if(i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size() || grid[i][j] != '1')
            return;
        
        /*
          You can also use lambda function for checking if next cell is valid or not
          auto isSafe = [&](int &i, int &j) {
            if(i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size() || grid[i][j] != '1')
                return false;
            return true;
          }; 
        */
        
        grid[i][j] = '$';
        
        for(pair<int, int> &p : dir) {
            int i_ = i + p.first;
            int j_ = j + p.second;
            dfs(grid, i_, j_);
        }
    }
    int numIslands(vector<vector<char>>& grid) {
        if(grid.size() == 0)
            return 0;
        
        int m = grid.size();
        int n = grid[0].size();
        int count = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
};


//Approach-2 (BFS)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
public:
    vector<pair<int, int>> dir{ {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    void bfs(vector<vector<char>>& grid, int i, int j, queue<pair<int, int>>& que) {
        que.push({i, j});
        grid[i][j] = '$';
        
        //lambda function (You can also add if check instead of lambda)
        auto isSafe = [&](int &i, int &j) {
            if(i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size() || grid[i][j] != '1')
                return false;
            return true;
        };
        
        while(!que.empty()) {
            auto curr = que.front();
            que.pop();
            
            for(auto &p : dir) {
                int i_ = curr.first  + p.first;
                int j_ = curr.second + p.second;
                
                if(isSafe(i_, j_)) {
                    que.push({i_, j_});
                    grid[i_][j_] = '$';
                }
            }
        }
    }
    int numIslands(vector<vector<char>>& grid) {
        if(grid.size() == 0)
            return 0;
        
        int m = grid.size();
        int n = grid[0].size();
        int count = 0;
        queue<pair<int, int>> que;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == '1') {
                    bfs(grid, i, j, que);
                    count++;
                }
            }
        }
        
        return count;
    }
};


/ JAVA *****************************************************************************************************/
//Approach-1 (DFS)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    private List<int[]> dir = new ArrayList<>();
    
    Solution() {
        dir.add(new int[]{1, 0});
        dir.add(new int[]{-1, 0});
        dir.add(new int[]{0, 1});
        dir.add(new int[]{0, -1});
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1')
            return;
        
        grid[i][j] = '$';
        
        for(int[] p : dir) {
            int i_ = i + p[0];
            int j_ = j + p[1];
            dfs(grid, i_, j_);
        }
    }
    
    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
}



//Approach-2 (BFS)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private boolean isSafe(char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1';
    }
    
    private void bfs(char[][] grid, int i, int j, Queue<int[]> que) {
        que.offer(new int[]{i, j});
        grid[i][j] = '$';
        
        while (!que.isEmpty()) {
            int[] curr = que.poll();
            
            for (int[] p : dir) {
                int i_ = curr[0] + p[0];
                int j_ = curr[1] + p[1];
                
                if (isSafe(grid, i_, j_)) {
                    que.offer(new int[]{i_, j_});
                    grid[i_][j_] = '$';
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<int[]> que = new ArrayDeque<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j, que);
                    count++;
                }
            }
        }
        
        return count;
    }
}
/ C# *****************************************************************************************************/
//Approach-1 (DFS)
//T.C : O(m*n)
//S.C : O(m*n)

```csharp
using System;
using System.Collections.Generic;

public class Solution
{
    private List<int[]> dir = new List<int[]>();

    public Solution()
    {
        dir.Add(new int[] { 1, 0 });
        dir.Add(new int[] { -1, 0 });
        dir.Add(new int[] { 0, 1 });
        dir.Add(new int[] { 0, -1 });
    }

    private void Dfs(char[][] grid, int i, int j)
    {
        if (i < 0 || i >= grid.Length || j < 0 || j >= grid[0].Length || grid[i][j] != '1')
            return;

        grid[i][j] = '$';

        foreach (int[] p in dir)
        {
            int i_ = i + p[0];
            int j_ = j + p[1];
            Dfs(grid, i_, j_);
        }
    }

    public int NumIslands(char[][] grid)
    {
        if (grid.Length == 0)
            return 0;

        int m = grid.Length;
        int n = grid[0].Length;
        int count = 0;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == '1')
                {
                    Dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }
}
```

// - The `List<int[]>` is used to store the directions.
// - The `Dfs` method corresponds to the `dfs` method in Java.
// - The `NumIslands` method corresponds to the `numIslands` method in Java.

//Approach-2 (BFS)
//T.C : O(m*n)
//S.C : O(m*n)

using System;
using System.Collections.Generic;
using System.Linq;

public class Solution
{
    private int[][] dir = { new int[] { 1, 0 }, new int[] { -1, 0 }, new int[] { 0, 1 }, new int[] { 0, -1 } };

    private bool IsSafe(char[][] grid, int i, int j)
    {
        return i >= 0 && i < grid.Length && j >= 0 && j < grid[0].Length && grid[i][j] == '1';
    }

    private void Bfs(char[][] grid, int i, int j, Queue<int[]> que)
    {
        que.Enqueue(new int[] { i, j });
        grid[i][j] = '$';

        while (que.Any())
        {
            int[] curr = que.Dequeue();

            foreach (int[] p in dir)
            {
                int i_ = curr[0] + p[0];
                int j_ = curr[1] + p[1];

                if (IsSafe(grid, i_, j_))
                {
                    que.Enqueue(new int[] { i_, j_ });
                    grid[i_][j_] = '$';
                }
            }
        }
    }

    public int NumIslands(char[][] grid)
    {
        if (grid.Length == 0)
            return 0;

        int m = grid.Length;
        int n = grid[0].Length;
        int count = 0;
        Queue<int[]> que = new Queue<int[]>();

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == '1')
                {
                    Bfs(grid, i, j, que);
                    count++;
                }
            }
        }

        return count;
    }
}


// - The `List<int[]>` is replaced with `Queue<int[]>`.
// - The `IsSafe` method corresponds to the `isSafe` method in Java.
// - The `Bfs` method corresponds to the `bfs` method in Java.
// - The `NumIslands` method corresponds to the `numIslands` method in Java.
