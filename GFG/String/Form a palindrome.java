/*         Scroll below to see JAVA code and C# also        */

    // Company Tags           : Amazon,Google,Airtel
    // GFG Link               : https://www.geeksforgeeks.org/problems/form-a-palindrome1455/1
// C++ ********************************************************************************************************************************************/
//Approach-1 (Using Longest Common Subsequence (LCS))
//T.C : O(n2)  
//S.C : O(n2) 
class Solution{
  public:
    int LCS(int n, string s1, string s2){
        int dp[n+1][n+1];
        //base case
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0) dp[i][j] = 0;
            }
        }
        //recursive case
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(s1[i-1] == s2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
    int countMin(string str){
        string rev = str;
        int n = str.size();
        reverse(rev.begin(), rev.end());
        return n - LCS(n, str, rev);
    }
};
// Java ********************************************************************************************************************************************/
//Approach-1 (Using Longest Common Subsequence (LCS))
//T.C : O(n2)  
//S.C : O(n2) 

public class Solution {
    public int LCS(int n, String s1, String s2) {
        int[][] dp = new int[n+1][n+1];
        // base case
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
            }
        }
        // recursive case
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }

    public int countMin(String str) {
        String rev = new StringBuilder(str).reverse().toString();
        int n = str.length();
        return n - LCS(n, str, rev);
    }
}

// C# ********************************************************************************************************************************************/
//Approach-1 (Using Longest Common Subsequence (LCS))
//T.C : O(n2)  
//S.C : O(n2) 
public class Solution {
    public int LCS(int n, string s1, string s2) {
        int[,] dp = new int[n+1, n+1];
        // base case
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) dp[i, j] = 0;
            }
        }
        // recursive case
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i, j] = 1 + dp[i - 1, j - 1];
                } else {
                    dp[i, j] = Math.Max(dp[i - 1, j], dp[i, j - 1]);
                }
            }
        }
        return dp[n, n];
    }

    public int CountMin(string str) {
        string rev = new string(str.Reverse().ToArray());
        int n = str.Length;
        return n - LCS(n, str, rev);
    }
}


// JavaScript ********************************************************************************************************************************************/
//Approach-1 (Using Longest Common Subsequence (LCS))
//T.C : O(n2)  
//S.C : O(n2) 

class Solution {
    LCS(n, s1, s2) {
        let dp = Array.from({ length: n + 1 }, () => Array(n + 1).fill(0));
        // base case
        for (let i = 0; i <= n; i++) {
            for (let j = 0; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
            }
        }
        // recursive case
        for (let i = 1; i <= n; i++) {
            for (let j = 1; j <= n; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }

    countMin(s) {
        let rev = s.split('').reverse().join('');
        let n = s.length;
        return n - this.LCS(n, s, rev);
    }
}
