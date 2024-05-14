/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : AMAZON, Facebook, Microsoft, Oracle, LinkedIn, Airbnd
    Leetcode Link               : https://leetcode.com/problems/path-with-maximum-gold/
*/



/ C++ ******************************************************************************************************************************/
// Time Complexity: 𝑂 ( 𝑚 × 𝑛 × 4 min ⁡ ( 𝑚 , 𝑛 ) ) O(m×n×4 min(m,n) ) 
// Space Complexity: 𝑂 ( 𝑚 × 𝑛 ) O(m×n) (due to the maximum recursion depth)
  
class Solution
{
public:
    int getMaximumGold(vector<vector<int>>& grid)
    {
        int m = grid.size();
        int n = grid[0].size();
        int maxGold = 0;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] != 0)
                {
                    maxGold = max(maxGold, dfs(grid, i, j));
                }
            }
        }

        return maxGold;
    }

private:
    int dfs(vector<vector<int>>& grid, int row, int col)
    {
        if (row < 0 || row >= grid.size() || col < 0 || col >= grid[0].size() || grid[row][col] == 0)
        {
            return 0;
        }

        int originalGold = grid[row][col];
        grid[row][col] = 0; // Mark the cell as visited

        int up = dfs(grid, row - 1, col);
        int down = dfs(grid, row + 1, col);
        int left = dfs(grid, row, col - 1);
        int right = dfs(grid, row, col + 1);

        grid[row][col] = originalGold; // Restore the original gold value

        return originalGold + max(max(up, down), max(left, right));
    }
};

/ Java ******************************************************************************************************************************/

class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxGold = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }

        return maxGold;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        int originalGold = grid[row][col];
        grid[row][col] = 0; // Mark the cell as visited

        int up = dfs(grid, row - 1, col);
        int down = dfs(grid, row + 1, col);
        int left = dfs(grid, row, col - 1);
        int right = dfs(grid, row, col + 1);

        grid[row][col] = originalGold; // Restore the original gold value

        return originalGold + Math.max(Math.max(up, down), Math.max(left, right));
    }
}

/ C# ******************************************************************************************************************************/


public class Solution
{
    public int GetMaximumGold(int[][] grid)
    {
        int m = grid.Length;
        int n = grid[0].Length;
        int maxGold = 0;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] != 0)
                {
                    maxGold = Math.Max(maxGold, Dfs(grid, i, j));
                }
            }
        }

        return maxGold;
    }

    private int Dfs(int[][] grid, int row, int col)
    {
        if (row < 0 || row >= grid.Length || col < 0 || col >= grid[0].Length || grid[row][col] == 0)
        {
            return 0;
        }

        int originalGold = grid[row][col];
        grid[row][col] = 0; // Mark the cell as visited

        int up = Dfs(grid, row - 1, col);
        int down = Dfs(grid, row + 1, col);
        int left = Dfs(grid, row, col - 1);
        int right = Dfs(grid, row, col + 1);

        grid[row][col] = originalGold; // Restore the original gold value

        return originalGold + Math.Max(Math.Max(up, down), Math.Max(left, right));
    }
}

