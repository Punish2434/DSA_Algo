/*    Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : Will update soon
    GFG  Link               : https://www.geeksforgeeks.org/problems/maximum-sum-of-hour-glass3842/1
*/


/ C++ ********************************************************************************************************************************/
//Approach-1 (Using LIS code eactly)
  
    class Solution {
    int findMaxSum(int n, int m, vector<vector<int>> mat) {
        // code here
        if(n<3 or m<3)return -1;
        int ans = INT_MIN;
        for(int i=2;i<n;i++){
            int sum=0;
            for(int j=1;j<m-1;j++){
                sum = mat[i-2][j-1]+mat[i-2][j]+mat[i-2][j+1]+mat[i-1][j]+mat[i][j-1]+mat[i][j]+mat[i][j+1];
                ans=max(sum,ans);
            }
        }
        return ans;
    }
}

/ Java ********************************************************************************************************************************/

    class Solution {
    int findMaxSum(int n, int m, int mat[][]) {
        // code here
        if(n<3 || m<3)return -1;
        int ans = Integer.MIN_VALUE;
        for(int i=2;i<n;i++){
            int sum=0;
            for(int j=1;j<m-1;j++){
                sum=mat[i][j-1]+mat[i-2][j-1]+mat[i-1][j]+mat[i][j]+mat[i-2][j]+mat[i][j+1]+mat[i-2][j+1];
                ans=Math.max(ans,sum);
            }
        }
        return ans;
    }
  
};

// Time Complexity:- O(N*M)
// Space Complexity:- O(1)
/ C# ******************************************************************************************************************************/
Certainly! Below is the equivalent **C# code** for the given Java code snippet along with an explanation:

```csharp
public class Solution
{
    public int FindMaxSum(int n, int m, int[][] mat)
    {
        // Check if dimensions are valid
        if (n < 3 || m < 3)
            return -1;

        int ans = int.MinValue; // Initialize the result to the smallest possible value

        // Iterate through rows starting from the third row
        for (int i = 2; i < n; i++)
        {
            int sum = 0; // Initialize the sum for the current row

            // Iterate through columns excluding the first and last columns
            for (int j = 1; j < m - 1; j++)
            {
                // Calculate the sum of adjacent elements
                sum = mat[i][j - 1] + mat[i - 2][j - 1] + mat[i - 1][j] +
                      mat[i][j] + mat[i - 2][j] + mat[i][j + 1] + mat[i - 2][j + 1];

                // Update the maximum sum encountered so far
                ans = Math.Max(ans, sum);
            }
        }

        return ans; // Return the maximum sum
    }
}
```

// **Explanation**:
// - We are given a 2D matrix `mat` with dimensions `n` rows and `m` columns.
// - The goal is to find the maximum sum of adjacent elements in the matrix, subject to the condition that `n` and `m` are both greater than or equal to 3.
// - We initialize the result (`ans`) to the smallest possible value (`int.MinValue`).
// - We iterate through the rows starting from the third row (since we need at least three rows for adjacent elements).
// - For each row, we iterate through the columns excluding the first and last columns (since we need at least three columns for adjacent elements).
// - We calculate the sum of adjacent elements as specified in the code.
// - We update the maximum sum encountered so far (`ans`) by taking the maximum of its current value and the calculated sum.
// - Finally, we return the maximum sum.
