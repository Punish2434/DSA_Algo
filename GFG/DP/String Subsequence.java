/*     Scroll below to see JAVA code and C#  also    */
/*
    Company Tags                :
    GFG Link               : https://www.geeksforgeeks.org/problems/find-number-of-times-a-string-occurs-as-a-subsequence3020/1
*/

/ C++ ****************************************************************************************************************/
// Time Complexity:- O(N*M)
// Space Complexity:- O(N*M)
  
  class Solution {
    int mod = 1e9+7;
    int help(string a,string b,int i,int j,vector<vector<int>> &dp){
        if(j==b.length())return 1;
        if(i==a.length())return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int x=0,y=0;
        if(a[i]==b[j])x=help(a,b,i+1,j+1,dp);
        y=help(a,b,i+1,j,dp);
        return dp[i][j] = (x+y)%mod;
    }
    int countWays(string s1, string s2) {
        // code here
        vector<vector<int>> dp(s1.length(),vector<int> (s2.length(),-1));
        return help(s1,s2,0,0,dp);
    }
}
/ Java ****************************************************************************************************************/
// Time Complexity:- O(N*M)
// Space Complexity:- O(N*M)
  
    class Solution {
    static int mod=1000000007;
    static int help(String a,String b,int i,int j,int dp[][]){
        if(j==b.length())return 1;
        if(i==a.length())return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int x=0,y=0;
        if(a.charAt(i)==b.charAt(j))x = help(a,b,i+1,j+1,dp);
        y = help(a,b,i+1,j,dp);
        return dp[i][j] = (x+y)%mod;
    }
    public static int countWays(String s1, String s2) {
        // code here
        int dp[][] = new int[s1.length()][s2.length()];
        for(int temp[]:dp)Arrays.fill(temp,-1);
        return help(s1,s2,0,0,dp);
    }
}
/ C# ****************************************************************************************************************/
// Time Complexity:- O(N*M)
// Space Complexity:- O(N*M)
  
```csharp
public class Solution {
    static int mod = 1000000007;

    static int Help(string a, string b, int i, int j, int[,] dp) {
        if (j == b.Length) return 1;
        if (i == a.Length) return 0;
        if (dp[i, j] != -1) return dp[i, j];
        int x = 0, y = 0;
        if (a[i] == b[j]) x = Help(a, b, i + 1, j + 1, dp);
        y = Help(a, b, i + 1, j, dp);
        return dp[i, j] = (x + y) % mod;
    }

    public static int CountWays(string s1, string s2) {
        int[,] dp = new int[s1.Length, s2.Length];
        for (int i = 0; i < s1.Length; i++) {
            for (int j = 0; j < s2.Length; j++) {
                dp[i, j] = -1;
            }
        }
        return Help(s1, s2, 0, 0, dp);
    }
}
```

// Explanation:
// 1. We use the `Help` method to recursively compute the number of ways to form string `s2` from string `s1`.
// 2. The `dp` array is used for memoization to avoid redundant calculations.
// 3. If the characters at the current positions match, we recursively explore both options (including and excluding the character).
// 4. The result is computed modulo `mod`.

