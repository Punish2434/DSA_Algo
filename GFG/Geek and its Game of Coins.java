/*    Scroll below to see JAVA code and C# also    */
/*
  
    Company Tags                : 
    GFG Link               : https://www.geeksforgeeks.org/problems/geek-and-its-game-of-coins4043/1
*/

/ C++ **********************************************************************************************************************************/
//T.C : O(n)
//S.C : O(n)
#include <iostream>
using namespace std;

int findWinner(int n, int x, int y) {
    // Create the dp array
    int dp[n + 1];
    
    // Initialize base cases
    dp[0] = 0;
    dp[1] = 1;
    
    // Fill the dp array
    for (int i = 2; i <= n; i++) {
        if (i - 1 >= 0 && dp[i - 1] == 0) {
            dp[i] = 1;
        } else if (i - x >= 0 && dp[i - x] == 0) {
            dp[i] = 1;
        } else if (i - y >= 0 && dp[i - y] == 0) {
            dp[i] = 1;
        } else {
            dp[i] = 0;
        }
    }
    
    // Return the result
    return dp[n];
}

int main() {
    int n = 10; // Example value for n
    int x = 2;  // Example value for x
    int y = 3;  // Example value for y
    cout << "Winner: " << findWinner(n, x, y) << endl;
    return 0;
}
/ Java **********************************************************************************************************************************/
//T.C : O(n)
//S.C : O(n)
class Solution {
    public static int findWinner(int n, int x, int y) {
        // Create the dp array
        int[] dp = new int[n + 1];
        
        // Initialize base cases
        dp[0] = 0;
        dp[1] = 1;
        
        // Fill the dp array
        for (int i = 2; i <= n; i++) {
            if (i - 1 >= 0 && dp[i - 1] == 0) {
                dp[i] = 1;
            } else if (i - x >= 0 && dp[i - x] == 0) {
                dp[i] = 1;
            } else if (i - y >= 0 && dp[i - y] == 0) {
                dp[i] = 1;
            } else {
                dp[i] = 0;
            }
        }
        
        // Return the result
        return dp[n];
    }
}


/ C# **********************************************************************************************************************************/
//T.C : O(n)
//S.C : O(n)
  public class Solution {
    public static int FindWinner(int n, int x, int y) {
        // Create the dp array
        int[] dp = new int[n + 1];
        
        // Initialize base cases
        dp[0] = 0;
        dp[1] = 1;
        
        // Fill the dp array
        for (int i = 2; i <= n; i++) {
            if (i - 1 >= 0 && dp[i - 1] == 0) {
                dp[i] = 1;
            } else if (i - x >= 0 && dp[i - x] == 0) {
                dp[i] = 1;
            } else if (i - y >= 0 && dp[i - y] == 0) {
                dp[i] = 1;
            } else {
                dp[i] = 0;
            }
        }
        
        // Return the result
        return dp[n];
    }
}
