/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : 
    GFG Link               : https://www.geeksforgeeks.org/problems/minimum-cost-to-make-two-strings-identical1107/1


/ C++ ************************************************************************************************************************/
//Approach-1 (DP)

class Solution {
    int findMinCost(string x, string y, int costX, int costY) {
        // Your code goes here
        int n=x.length(),m=y.length();
        int dp[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(x[i-1]==y[j-1])dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return (n-dp[n][m])*costX+(m-dp[n][m])*costY;
    }
}

/ Java ************************************************************************************************************************/


// Time Complexity:- O(N*M)
// Space Complexity:- O(N*M)
class Solution {
    public int findMinCost(String x, String y, int costX, int costY) {
        int n = x.length(), m =y.length();
        int dp[][] = new int [n+1][m+1];
        for(int i=0; i<=n; i++)
        dp[i][0]=0;
        for(int i=0;i<=m;i++)
        dp[0][i]=0;
        
        for(int i=1; i<=n; i++){
            for(int j=1;j<=m;j++){
                if(x.charAt(i-1)==y.charAt(j-1))dp[i][j]=1+dp[i-1][j-1];
	            else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return (n-dp[n][m])*costX+(m-dp[n][m])*costY;
    }
}



/ C# ************************************************************************************************************************/

```csharp
public class Solution {
    public int FindMinCost(string x, string y, int costX, int costY) {
        int n = x.Length;
        int m = y.Length;
        int[,] dp = new int[n + 1, m + 1];

        for (int i = 0; i <= n; i++)
            dp[i, 0] = 0;

        for (int i = 0; i <= m; i++)
            dp[0, i] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (x[i - 1] == y[j - 1])
                    dp[i, j] = 1 + dp[i - 1, j - 1];
                else
                    dp[i, j] = Math.Max(dp[i - 1, j], dp[i, j - 1]);
            }
        }

        return (n - dp[n, m]) * costX + (m - dp[n, m]) * costY;
    }
}
```

// Explanation:
// - The given Java code calculates the minimum cost based on the longest common subsequence (LCS) between strings `x` and `y`.
// - We create a 2D array `dp` to store the LCS lengths.
// - The dynamic programming approach computes the LCS lengths for each pair of characters in `x` and `y`.
// - The final result is calculated using the formula `(n - dp[n, m]) * costX + (m - dp[n, m]) * costY`, where `n` and `m` are the lengths of strings `x` and `y`, respectively.

