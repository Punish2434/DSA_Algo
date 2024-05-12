/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                :
    Leetcode Link               : https://leetcode.com/problems/largest-local-values-in-a-matrix
*/


/ C++ ***************************************************************************************************************************************/
//Approach(Simply traversing and finding the result)
//T.C : O(n*n)
//S.C : O(n*n) for thr result but you can ignore it because it's the result that we have to return
class Solution {
public:
    int findLocalMax(vector<vector<int>>& grid, int x, int y) {
        int maxElement = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                maxElement = max(maxElement, grid[i][j]);
            }
        }
        return maxElement;
    }
    
    vector<vector<int>> largestLocal(vector<vector<int>>& grid) {
        int n = grid.size();
        vector<vector<int>> maxLocal(n - 2, vector<int>(n - 2, 0));
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                maxLocal[i][j] = findLocalMax(grid, i, j);
            }
        }
        return maxLocal;
    }
};


/ JAVA ***************************************************************************************************************************************/
//Approach 1 (Simply traversing and finding the result)
//T.C : O(n*n)
//S.C : O(n*n) for thr result but you can ignore it because it's the result that we have to return
class Solution {
    private int findLocalMax(int[][] grid, int x, int y) {
        int maxElement = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                maxElement = Math.max(maxElement, grid[i][j]);
            }
        }
        return maxElement;
    }
    
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                maxLocal[i][j] = findLocalMax(grid, i, j);
            }
        }
        return maxLocal;
    }
}
//Approach 2
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n - 2][n - 2];

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                // Calculate the maximum value in the 3x3 matrix centered at (i, j)
                int max = Integer.MIN_VALUE;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        max = Math.max(max, grid[x][y]);
                    }
                }
                maxLocal[i - 1][j - 1] = max;
            }
        }

        return maxLocal;
    }
}


/ C# ***************************************************************************************************************************************/
//Approach 1 (Simply traversing and finding the result)
//T.C : O(n*n)
//S.C : O(n*n) for thr result but you can ignore it because it's the result that we have to return
using System;

public class Solution
{
    private int FindLocalMax(int[][] grid, int x, int y)
    {
        int maxElement = 0;
        for (int i = x; i < x + 3; i++)
        {
            for (int j = y; j < y + 3; j++)
            {
                maxElement = Math.Max(maxElement, grid[i][j]);
            }
        }
        return maxElement;
    }

    public int[][] LargestLocal(int[][] grid)
    {
        int n = grid.Length;
        int[][] maxLocal = new int[n - 2][];
        for (int i = 0; i < n - 2; i++)
        {
            maxLocal[i] = new int[n - 2];
            for (int j = 0; j < n - 2; j++)
            {
                maxLocal[i][j] = FindLocalMax(grid, i, j);
            }
        }
        return maxLocal;
    }
}
//Approach 2
using System;

public class Solution
{
    public int[][] LargestLocal(int[][] grid)
    {
        int n = grid.Length;
        int[][] maxLocal = new int[n - 2][];
        for (int i = 1; i < n - 1; i++)
        {
            maxLocal[i - 1] = new int[n - 2];
            for (int j = 1; j < n - 1; j++)
            {
                // Calculate the maximum value in the 3x3 matrix centered at (i, j)
                int max = int.MinValue;
                for (int x = i - 1; x <= i + 1; x++)
                {
                    for (int y = j - 1; y <= j + 1; y++)
                    {
                        max = Math.Max(max, grid[x][y]);
                    }
                }
                maxLocal[i - 1][j - 1] = max;
            }
        }
        return maxLocal;
    }
}
