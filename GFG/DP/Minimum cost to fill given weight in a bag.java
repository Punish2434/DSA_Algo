/*   Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : 
    GFG Link               : https://www.geeksforgeeks.org/problems/minimum-cost-to-fill-given-weight-in-a-bag1956/1
*/


/ C++ ************************************************************************************************************/
// Time Complexity:- O(N*W)
// Space Complexity:- O(W)
class Solution {
    int minimumCost(int n, int w, vector<int> &cost) {
        // code here
        vector<int> dp(w+1,INT_MAX);
        dp[0]=0;
        for(int i=0;i<n;i++){
            if(cost[i]!=-1){
                for(int j=i+1;j<=w;j++){
                    dp[j]=min(dp[j],cost[i]+dp[j-i-1]);
                }
            }
        }
        return dp[w]!=INT_MAX?dp[w]:-1;
    }
}
/ Java ************************************************************************************************************/

// Time Complexity:- O(N*W)
// Space Complexity:- O(W)
class Solution {
    public static int minimumCost(int n, int w, int[] cost) {
        // code here
        int dp[] = new int[w+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<n;i++){
            if(cost[i]!=-1){
                for(int j=i+1;j<=w;j++){
                    dp[j]=Math.min(dp[j],cost[i]+dp[j-i-1]);
                }
            }
        }
        return dp[w]!=Integer.MAX_VALUE?dp[w]:-1;
    }
}
/ C# ************************************************************************************************************/

```csharp
public class Solution {
    public static int MinimumCost(int n, int w, int[] cost) {
        int[] dp = new int[w + 1];
        Array.Fill(dp, int.MaxValue);
        dp[0] = 0;
        
        for (int i = 0; i < n; i++) {
            if (cost[i] != -1) {
                for (int j = i + 1; j <= w; j++) {
                    dp[j] = Math.Min(dp[j], cost[i] + dp[j - i - 1]);
                }
            }
        }
        
        return dp[w] != int.MaxValue ? dp[w] : -1;
    }
}
```

// Explanation:
// - We create an array `dp` to store the minimum cost for each weight value from 0 to `w`.
// - Initialize `dp[0]` to 0 (since the cost for weight 0 is 0).
// - Iterate through the given `cost` array:
//   - If `cost[i]` is not -1 (indicating a valid cost), update `dp[j]` for all valid weights.
//   - Use the recurrence relation: `dp[j] = Math.Min(dp[j], cost[i] + dp[j - i - 1])`.
// - Finally, return `dp[w]` if it's not equal to `int.MaxValue`, otherwise return -1.

