

/*      Scroll below to see JAVA code and C# also    */
/*
    Company Tags           : Amazon,Samsung
    GFG Link               : https://www.geeksforgeeks.org/problems/largest-square-formed-in-a-matrix0806/1
*/


/ C++ ******************************************************************************************************/
//Approach-1 (Using dp)
//T.C : O(n*m)
//S.C : O(n*m)

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int maxSquare(int n, int m, vector<vector<int>>& mat) {
        vector<vector<int>> dp(n, vector<int>(m, 0));
        int maxSide = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = mat[i][j];
                } else if (mat[i][j] == 1) {
                    dp[i][j] = min({dp[i-1][j], dp[i][j-1], dp[i-1][j-1]}) + 1;
                } else {
                    dp[i][j] = 0;
                }
                maxSide = max(maxSide, dp[i][j]);
            }
        }

        return maxSide;
    }
};

int main() {
    vector<vector<int>> mat1 = {
        {0, 1, 1, 0, 1}, 
        {1, 1, 0, 1, 0},
        {0, 1, 1, 1, 0},
        {1, 1, 1, 1, 0},
        {1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0}
    };
    Solution sol;
    cout << sol.maxSquare(6, 5, mat1) << endl; // Output: 3
    return 0;
}

/ Java ******************************************************************************************************/
//Approach-1 (Using dp)
//T.C : O(n*m)
//S.C : O(n*m)

class Solution {
    static int maxSquare(int n, int m, int mat[][]) {
        // code here
        
        // Create a DP table to store the size of the largest square sub-matrix endding at that point
        int[][] dp = new int[n][m];
        int maxSide = 0;
        
        //Fill the dp table
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // If we are at the first row or first column,the largest square ending there is the element itself
                if(i == 0 || j == 0){
                    dp[i][j] = mat[i][j];
                }else if(mat[i][j] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }else {
                    dp[i][j] = 0;
                }
                // Update the maximum side length
                maxSide = Math.max(maxSide, dp[i][j]);
            } 
         
            
        }
                // Return the area of the largest square sub-matrix with all 1s

        return maxSide;
    }
}


/ JavaScript ******************************************************************************************************/
//Approach-1 (Using dp)
//T.C : O(n*m)
//S.C : O(n*m)


function maxSquare(n, m, mat) {
    let dp = Array.from({ length: n }, () => Array(m).fill(0));
    let maxSide = 0;

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (i === 0 || j === 0) {
                dp[i][j] = mat[i][j];
            } else if (mat[i][j] === 1) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
            } else {
                dp[i][j] = 0;
            }
            maxSide = Math.max(maxSide, dp[i][j]);
        }
    }

    return maxSide;
}

// Example usage
let mat1 = [
    [0, 1, 1, 0, 1], 
    [1, 1, 0, 1, 0],
    [0, 1, 1, 1, 0],
    [1, 1, 1, 1, 0],
    [1, 1, 1, 1, 1],
    [0, 0, 0, 0, 0]
];
console.log(maxSquare(6, 5, mat1)); // Output: 3

/ C# ******************************************************************************************************/
//Approach-1 (Using dp)
//T.C : O(n*m)
//S.C : O(n*m)

using System;

public class Solution {
    public static int MaxSquare(int n, int m, int[][] mat) {
        int[,] dp = new int[n, m];
        int maxSide = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i, j] = mat[i][j];
                } else if (mat[i][j] == 1) {
                    dp[i, j] = Math.Min(Math.Min(dp[i - 1, j], dp[i, j - 1]), dp[i - 1, j - 1]) + 1;
                } else {
                    dp[i, j] = 0;
                }
                maxSide = Math.Max(maxSide, dp[i, j]);
            }
        }

        return maxSide;
    }

    public static void Main(string[] args) {
        int[][] mat1 = new int[][] {
            new int[] {0, 1, 1, 0, 1}, 
            new int[] {1, 1, 0, 1, 0},
            new int[] {0, 1, 1, 1, 0},
            new int[] {1, 1, 1, 1, 0},
            new int[] {1, 1, 1, 1, 1},
            new int[] {0, 0, 0, 0, 0}
        };
        Console.WriteLine(MaxSquare(6, 5, mat1)); // Output: 3
    }
}

