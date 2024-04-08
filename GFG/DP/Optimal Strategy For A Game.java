/*    Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : will update soon
    GFG Link                    : https://www.geeksforgeeks.org/problems/optimal-strategy-for-a-game-1587115620/1
*/

/ C++ ************************************************************************************************************/
  class solve
{
   
    long long help(int i,int j,int arr[],vector<vector<long long>> &dp){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int sum1=arr[i],sum2=arr[j];
        sum1+=min(help(i+2,j,arr,dp),help(i+1,j-1,arr,dp));
        sum2+=min(help(i+1,j-1,arr,dp),help(i,j-2,arr,dp));
        return dp[i][j] = max(sum1,sum2);
    }
    long long maximumAmount(int n, int arr[]){
        // Your code here
        vector<vector<long long>> dp(n,vector<long long>(n,-1));
        return help(0,n-1,arr,dp);
    }
}

/ Java ************************************************************************************************************/
  class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long help(int i,int j,int arr[],long dp[][]){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        long sum1 = arr[i],sum2=arr[j];
        sum1+=Math.min(help(i+2,j,arr,dp),help(i+1,j-1,arr,dp));
        sum2+=Math.min(help(i+1,j-1,arr,dp),help(i,j-2,arr,dp));
        return dp[i][j] = Math.max(sum1,sum2);
    }
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int n, int arr[])
    {
        // Your code here
        long dp[][]=new long[n][n];
        for(long temp[]:dp)Arrays.fill(temp,-1);
        return help(0,n-1,arr,dp);
    }
}

/ C# ************************************************************************************************************/

```csharp
public class Solution {
    public long CountMaximum(int n, int[] arr) {
        long[,] dp = new long[n, n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i, j] = -1;
            }
        }
        return Help(0, n - 1, arr, dp);
    }

    private long Help(int i, int j, int[] arr, long[,] dp) {
        if (i > j) return 0;
        if (dp[i, j] != -1) return dp[i, j];

        long sum1 = arr[i];
        long sum2 = arr[j];

        sum1 += Math.Min(Help(i + 2, j, arr, dp), Help(i + 1, j - 1, arr, dp));
        sum2 += Math.Min(Help(i + 1, j - 1, arr, dp), Help(i, j - 2, arr, dp));

        return dp[i, j] = Math.Max(sum1, sum2);
    }
}
// ```

// Explanation:
// 1. `CountMaximum` method initializes a 2D array `dp` to store computed results. It then calls the `Help` method with initial parameters.
// 2. `Help` method recursively computes the maximum possible amount of money we can win. It uses dynamic programming to avoid redundant calculations.
// 3. The base case checks if `i > j`, in which case the result is 0.
// 4. If the result for the current subproblem is already computed (`dp[i, j] != -1`), it returns that value.
// 5. Otherwise, it calculates the two possible sums (`sum1` and `sum2`) by considering different choices of sandwiches.
// 6. The recursive calls handle the subproblems with adjusted indices.
// 7. The final result is stored in `dp[0, n - 1]`.

// This code efficiently finds the maximum amount of money that can be won based on the given rules. 🥪💰



// Time Complexity:- O(N*N)
// Space Complexity:- O(N*N)
