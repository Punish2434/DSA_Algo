/*     Scroll below to see JAVA code and C# also    */
/*

    Company Tags                : will update soon
    Leetcode Link               : https://leetcode.com/problems/maximum-score-words-formed-by-letters
*/


/ C++ ******************************************************************************************************************************************/

// Time Complexity:- O(N*Sum)
// Space Complexity:- O(N*Sum)
  class Solution {
    int mod=1e9+7;
    int help(int n,int d,vector<int> &arr,int &sum,int temp,int index, vector<vector<int>> &dp){
        if(sum-temp*2<d)return 0;
        if(index==n){
            int secondSum=sum-temp;
            if(secondSum-temp==d)return 1;
            return 0;
        }
        if(dp[index][temp]!=-1)return dp[index][temp];
        int a = help(n,d,arr,sum,temp,index+1,dp);
        int b = help(n,d,arr,sum,temp+arr[index],index+1,dp);
        return dp[index][temp] = (a+b)%mod;
    }
    int countPartitions(int n, int d, vector<int>& arr) {
        // Code here
        int sum=0;
        for(int i=0;i<n;i++)sum+=arr[i];
        vector<vector<int>> dp(n,vector<int>(sum+1,-1));
        return help(n,d,arr,sum,0,0,dp);
    }

}

// Time Complexity:- O(N*Sum)
// Space Complexity:- O(N*Sum)
/ Java ******************************************************************************************************************************************/
class Solution {
    static int mod=1000000007;
    static int help(int n,int d,int[] arr,int sum,int temp,int index,int dp[][]){
        if(sum-temp-temp<d)return 0;
        if(index==n){
            int secondSum=sum-temp;
            if(secondSum-temp==d)return 1;
            return 0;
        }
        if(dp[index][temp]!=-1)return dp[index][temp];
        int a = help(n,d,arr,sum,temp,index+1,dp);
        int b = help(n,d,arr,sum,temp+arr[index],index+1,dp);
        return dp[index][temp] = (a+b)%mod;
    }
    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        int sum=0;
        for(int i=0;i<n;i++)sum+=arr[i];
        int dp[][] = new int[n][sum+1];
        for(int x[]:dp)Arrays.fill(x,-1);
        return help(n,d,arr,sum,0,0,dp);
      
    }
}
/ C# *******************************************************************************************************************************************/
Certainly! Let's convert the given Java code into C#.

```csharp
using System;

public class Solution
{
    static int mod = 1000000007;

    static int Help(int n, int d, int[] arr, int sum, int temp, int index, int[][] dp)
    {
        if (sum - temp - temp < d)
            return 0;

        if (index == n)
        {
            int secondSum = sum - temp;
            if (secondSum - temp == d)
                return 1;
            return 0;
        }

        if (dp[index][temp] != -1)
            return dp[index][temp];

        int a = Help(n, d, arr, sum, temp, index + 1, dp);
        int b = Help(n, d, arr, sum, temp + arr[index], index + 1, dp);

        return dp[index][temp] = (a + b) % mod;
    }

    public static int CountPartitions(int n, int d, int[] arr)
    {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        int[][] dp = new int[n][];
        for (int i = 0; i < n; i++)
            dp[i] = new int[sum + 1];

        for (int i = 0; i < n; i++)
            for (int j = 0; j <= sum; j++)
                dp[i][j] = -1;

        return Help(n, d, arr, sum, 0, 0, dp);
    }
}
```


// - I've changed the method names to follow C# naming conventions (e.g., `Help` instead of `help` and `CountPartitions` instead of `countPartitions`).
// - Used `int[][]` instead of `int[,]` for the `dp` array.
// - Initialized the `dp` array with `-1` values.
// - Replaced the enhanced `for` loop with regular `for` loops for array initialization.

