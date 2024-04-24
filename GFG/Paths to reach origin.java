/*    Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : 
    Leetcode Link               : https://www.geeksforgeeks.org/problems/paths-to-reach-origin3850/1
*/

/ C++ **********************************************************************************/
   class Solution
{
    int mod = 1e9+7;
    int help(int x,int y,vector<vector<int>> &dp){
        if(x==0 and y==0)return 1;
        if(x<0 or y<0)return 0;
        if(dp[x][y]!=-1)return dp[x][y];
        int a = help(x-1,y,dp);
        int b = help(x,y-1,dp);
        return dp[x][y] = (a+b)%mod;
    }
    int ways(int x, int y)
    {
        //code here.
        vector<vector<int>> dp(x+1,vector<int>(y+1,-1));
        return help(x,y,dp);
    }
}
/ Java **********************************************************************************/


// Time Complexity:- O(x*y)
// Space Complexity:- O(x*y)
    class Solution
{
    static int mod = 1000000007;
    static int help(int x, int y, int dp[][]){
        if(x==0 && y==0)return 1;
        if(x<0 || y<0)return 0;
        if(dp[x][y]!= -1)return dp[x][y];
        int a = help(x-1,y,dp);
        int b = help(x,y-1,dp);
        return dp[x][y] = (a+b)%mod;
    }
    public static int ways(int n, int m)
    {
        // complete the function
        int dp[][] = new int [n+1][m+1];
        for(int temp[]:dp)Arrays.fill(temp,-1);
        return help(n,m,dp);
    }
}

/ C# **********************************************************************************/

using System;

class Solution
{
    static int mod = 1000000007;

    static int Help(int x, int y, int[,] dp)
    {
        if (x == 0 && y == 0)
            return 1;
        if (x < 0 || y < 0)
            return 0;
        if (dp[x, y] != -1)
            return dp[x, y];
        int a = Help(x - 1, y, dp);
        int b = Help(x, y - 1, dp);
        return dp[x, y] = (a + b) % mod;
    }

    public static int Ways(int n, int m)
    {
        // Initialize a 2D array to store intermediate results
        int[,] dp = new int[n + 1, m + 1];
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= m; j++)
            {
                dp[i, j] = -1;
            }
        }

        // Call the recursive helper function
        return Help(n, m, dp);
    }

    static void Main()
    {
        int n = 3; // Example: n = 3
        int m = 4; // Example: m = 4
        int result = Ways(n, m);
        Console.WriteLine($"Number of ways to reach ({n}, {m}): {result}");
    }
}
```

// **Explanation**:
// - The given Java code defines a class `Solution` with a static method `ways` that calculates the number of ways to reach a cell `(n, m)` in a grid starting from the top-left corner `(0, 0)`.
// - The grid has dimensions `(n+1) x (m+1)`.
// - The function uses dynamic programming with memoization to avoid redundant calculations.
// - It initializes a 2D array `dp` to store intermediate results.
// - The `Help` function recursively computes the number of ways to reach a cell `(x, y)` by considering two possible moves: moving left `(x-1, y)` and moving up `(x, y-1)`.
// - The base cases are when `x` or `y` becomes negative (return 0) or when `x` and `y` are both 0 (return 1).
// - The final result is computed modulo 1000000007.

  
