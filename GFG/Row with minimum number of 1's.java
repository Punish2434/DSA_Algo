/*     Scroll down to see JAVA code and c#    */
/*
    Company Tags                 : Amazon
  GFG Link                : https://geeksforgeeks.org/problems/row-with-minimum-number-of-1s5430/1
    
                        
    
*/
/ C++ *************************************************************************************************/

class Solution{
    int minRow(int n, int m, vector<vector<int>> a) {
        // code here
        int ans=-1,mn=INT_MAX,one=0;
        for(int i=0;i<n;i++){
            one=0;
            for(int j=0;j<m;j++){
                if(a[i][j])one++;
            }
            if(one<mn){
                mn=one;
                ans=i+1;
            }
        }
        return ans;
    }
}
/ Java *************************************************************************************************/

class Solution {
    int minRow(int n, int m, int a[][]) {
        // code here
        int ans = -1, mn = Integer.MAX_VALUE, one = 0;
        for( int i=0; i<n ; i++){
            one=0;
            for(int j=0; j<m; j++){
                if(a[i][j] == 1){
                    one ++;
                }
            }
            if(one<mn){
                mn=one; 
                ans=i+1;
            }
        }
        return ans;
    }
};
// Time Complexity:- O(N*M)
// Space Complexity:- O(1)
/ C# *************************************************************************************************/


using System;

public class Solution
{
    public int MinRow(int n, int m, int[][] a)
    {
        int ans = -1, mn = int.MaxValue, one = 0;
        for (int i = 0; i < n; i++)
        {
            one = 0;
            for (int j = 0; j < m; j++)
            {
                if (a[i][j] == 1)
                {
                    one++;
                }
            }
            if (one < mn)
            {
                mn = one;
                ans = i + 1;
            }
        }
        return ans;
    }

    // Example usage:
    static void Main()
    {
        Solution solution = new Solution();
        int n = 3;
        int m = 4;
        int[][] matrix = new int[][] {
            new int[] { 0, 1, 0, 1 },
            new int[] { 1, 0, 1, 0 },
            new int[] { 0, 1, 1, 1 }
        };
        int result = solution.MinRow(n, m, matrix);
        Console.WriteLine($"The row with the fewest 1s is: {result}");
    }
}
```

**Key Differences:**
// 1. **Syntax:**
//     - In C#, we use `int.MaxValue` instead of `Integer.MAX_VALUE`.
//     - C# uses `int[][]` for the 2D array.
//     - C# uses `Console.WriteLine` for output.
//     - C# uses PascalCase for method and class names.
// 2. **Example Usage:**
//     - I've included an example usage in the `Main` method to demonstrate how to call the `MinRow` function.
// 3. **String Comparison:**
//     - In C#, we use `==` to compare integers (e.g., `one < mn`).
// 4. **Array Initialization:**
//     - C# uses `new int[] { ... }` for array initialization.

  
