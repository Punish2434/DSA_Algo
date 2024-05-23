/*     Scroll down to see JAVA cod and C# also    */
/*
    Company Tags                : Amazon
    GFG Link               : https://www.geeksforgeeks.org/problems/find-if-string-is-k-palindrome-or-not1923/1
*/

/ C++ ********************************************************************************************************************************************/
//Simple DP
// Time Complexity:- O(N*N)
// Space Complexity:- O(N*N)
class Solution {
    int kPalindrome(string str, int n, int k)
    {
        // code here
        int dp[n][n];
        memset(dp,0,sizeof dp);
        for(int i=2;i<=n;i++){
            for(int row=0;row<=n-i;row++){
                int col = row+i-1;
                if(str[row]==str[col])dp[row][col]=dp[row+1][col-1];
                else dp[row][col]=min(dp[row+1][col],dp[row][col-1])+1;
            }
        }
        return dp[0][n-1]<=k?1:0;
    }
}

/ Java ********************************************************************************************************************************************/

class Solution {
    public int kPalindrome(String str, int n, int k) {
        // code here
        int dp[][] = new int[n][n];
        for(int i=2;i<=n;i++){
            for(int row=0;row<=n-i;row++){
                int col=row+i-1;
                if(str.charAt(row)==str.charAt(col))dp[row][col]=dp[row+1][col-1];
                else dp[row][col]=Math.min(dp[row][col-1],dp[row+1][col])+1;
            }
        }
        return dp[0][n-1]<=k?1:0;
    }
}

/ C# ********************************************************************************************************************************************/
using System;

public class Solution {
    public int KPalindrome(string str, int n, int k) {
        // code here
        int[,] dp = new int[n, n];
        for (int i = 2; i <= n; i++) {
            for (int row = 0; row <= n - i; row++) {
                int col = row + i - 1;
                if (str[row] == str[col])
                    dp[row, col] = dp[row + 1, col - 1];
                else
                    dp[row, col] = Math.Min(dp[row, col - 1], dp[row + 1, col]) + 1;
            }
        }
        return dp[0, n - 1] <= k ? 1 : 0;
    }
}

class Program {
    static void Main(string[] args) {
        Solution solution = new Solution();
        string str = "your_string_here";
        int n = str.Length;
        int k = 3; // your value for k here
        int result = solution.KPalindrome(str, n, k);
        Console.WriteLine("Result: " + result);
    }
}
