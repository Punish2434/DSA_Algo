/*    Scroll below to see JAVA code and C# also  */
/*
    Company Tags                : Amazon,Facebook,Google,Visa
    GFG Link                    : https://www.geeksforgeeks.org/problems/padovan-sequence2855/1
*/
/ C++ **************************************************************************************************************************/

// Time Complexity: O(n)
// Space Complexity: O(n)

#include <iostream>
#include <vector>

class Solution {
public:
    int padovanSequence(int n) {
        // Base case for small values of n
        if (n == 0 || n == 1 || n == 2) {
            return 1;
        }

        std::vector<int> dp(n + 1);
        int mod = 1e9 + 7;

        // Initialize the base cases
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;

        // Calculate Padovan sequence for n >= 3
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 3]) % mod;
        }

        return dp[n];
    }
};

int main() {
    Solution sol;
    int n = 10; // Example: Change this value to compute the Padovan sequence for a different 'n'
    std::cout << "Padovan sequence for n = " << n << ": " << sol.padovanSequence(n) << std::endl;
    return 0;
}

/ Java **************************************************************************************************************************/

// Time Complexity: O(n)
// Space Complexity: O(n)



class Solution {
    public int padovanSequence(int n) {
        // Base case for small values of n
        if (n == 0 || n == 1 || n == 2) {
            return 1;
        }

        int[] dp = new int[n + 1];
        int mod = (int) 1e9 + 7;

        // Initialize the base cases
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;

        // Calculate Padovan sequence for n >= 3
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 3]) % mod;
        }

        return dp[n] % mod;
    }

   
}

/ C# **************************************************************************************************************************/

// Time Complexity: O(n)
// Space Complexity: O(n)


using System;

public class Solution {
    public int PadovanSequence(int n) {
        // Base case for small values of n
        if (n == 0 || n == 1 || n == 2) {
            return 1;
        }

        int[] dp = new int[n + 1];
        int mod = (int)1e9 + 7;

        // Initialize the base cases
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;

        // Calculate Padovan sequence for n >= 3
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 3]) % mod;
        }

        return dp[n];
    }

    public static void Main(string[] args) {
        Solution sol = new Solution();
        int n = 10; // Example: Change this value to compute the Padovan sequence for a different 'n'
        Console.WriteLine($"Padovan sequence for n = {n}: {sol.PadovanSequence(n)}");
    }
}

