
/*         Scroll down to see JAVA code and C# also        */
/*
    MY YOUTUBE VIDEO ON THIS Qn : https://www.youtube.com/watch?v=r2LPa779amQ
    Company Tags                : Mirosoft
    GFG            : https://www.geeksforgeeks.org/problems/minimum-points-to-reach-destination0540/1
*/

/ C++ *************************************************************************************************************/

 class Solution {
	int help(int i,int j,int n,int m,vector<vector<int>> &points,vector<vector<int>> &dp){
	    if(i==m-1 && j==n-1)return 1-points[i][j];
	    if(i==m or j==n)return INT_MAX;
	    if(dp[i][j]!=-1)return dp[i][j];
	    int a = help(i+1,j,n,m,points,dp);
	    int b = help(i,j+1,n,m,points,dp);
	    return dp[i][j] = max(1,min(a,b)-points[i][j]);
	}
	int minPoints(int m, int n, vector<vector<int>> points) 
	{ 
	    // Your code goes here
	    vector<vector<int>> dp(m,vector<int>(n,-1));
	    return help(0,0,n,m,points,dp);
	} 
 }
/ Java *************************************************************************************************************/

   class Solution {
   static int help(int i,int j,int n,int m,int points[][],int dp[][]){
        if(i==m-1 && j==n-1)return 1-points[i][j];
        if(i==m || j==n)return Integer.MAX_VALUE;
        if(dp[i][j]!=-1)return dp[i][j];
        int a = help(i,j+1,n,m,points,dp);
        int b = help(i+1,j,n,m,points,dp);
        return dp[i][j] = Math.max(1,Math.min(a,b)-points[i][j]);
    }
    public int minPoints(int points[][], int m, int n) {
        // Your code goes here
        int dp[][] = new int[m][n];
        for(int []temp:dp)Arrays.fill(temp,-1);
	    return help(0,0,n,m,points,dp);
    }
}

// Time Complexity:- O(M*N)
// Space Complexity:- O(M*N)

/C# *************************************************************************************************************/
  public class Solution {
    public int MinPoints(int[][] points, int m, int n) {
        int[,] dp = new int[m, n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i, j] = -1;
        
        return Help(0, 0, n, m, points, dp);
    }
    
    private int Help(int i, int j, int n, int m, int[][] points, int[,] dp) {
        if (i == m - 1 && j == n - 1)
            return 1 - points[i][j];
        
        if (i == m || j == n)
            return int.MaxValue;
        
        if (dp[i, j] != -1)
            return dp[i, j];
        
        int a = Help(i, j + 1, n, m, points, dp);
        int b = Help(i + 1, j, n, m, points, dp);
        
        return dp[i, j] = Math.Max(1, Math.Min(a, b) - points[i][j]);
    }
}



// 1. **Problem Description**:
//    - The problem involves navigating through a grid of cells, where each cell has a certain value (`points[i][j]`).
//    - We need to find the minimum points required to traverse from the top-left corner `(0, 0)` to the bottom-right corner `(m-1, n-1)` while ensuring that the cumulative sum of points along the path is always positive.

// 2. **Code Explanation**:
//    - We have a class named `Solution` with two methods:
//      - `MinPoints`: The entry point for our solution. It initializes the memoization array `dp` and calls the helper method.
//      - `Help`: A recursive helper method that explores two possible paths:
//        - Moving right (`i, j+1`).
//        - Moving down (`i+1, j`).
//    - Base cases:
//      - If we reach the bottom-right corner, return `1 - points[i][j]`.
//      - If we go out of bounds (i.e., `i == m` or `j == n`), return `int.MaxValue`.
//    - We calculate the minimum points required by taking the maximum of:
//      - `1` (to ensure a positive cumulative sum).
//      - The minimum of the points needed for the rightward and downward paths.
//    - The `dp` array stores the results of subproblems to avoid recomputation.

// 3. **Complexity Analysis**:
//    - **Time Complexity**: The recursive calls explore each cell once, so the time complexity is O(m * n).
//    - **Space Complexity**: The memoization array `dp` uses O(m * n) space.
