// C++ ************************************************************************************************************
  class Solution
{
	int help(int i,int j,int n,int m,int a[],int b[],int diff,vector<vector<int>> &dp){
	    if(i==n or j==m)return 0;
	    if(dp[i][j]!=-1)return dp[i][j];
	    int sum1 = 0, sum2 = 0;
	    if(diff){
	        sum1 = help(i+1,j,n,m,a,b,diff-1,dp);
	    }
	    sum2 = a[i]*b[j]+help(i+1,j+1,n,m,a,b,diff,dp);
	    return dp[i][j] = max(sum1,sum2);
	}
	int maxDotProduct(int n, int m, int a[], int b[]) 
	{ 
		// Your code goes here
		vector<vector<int>> dp(n,vector<int>(m,-1));
		return help(0,0,n,m,a,b,n-m,dp);
	} 
}
// JAVA ************************************************************************************************************

  class Solution
{
    
	int help(int i,int j,int n,int m,int a[],int b[],int dp[][],int diff){
	    if(i==n || j==m)return 0;
	    if(dp[i][j]!=-1)return dp[i][j];
	    int sum1=0,sum2=0;
	    if(diff!=0)
	    sum1 = help(i+1,j,n,m,a,b,dp,diff-1);
	    sum2 =a[i]*b[j]+help(i+1,j+1,n,m,a,b,dp,diff);
	    return dp[i][j] = Math.max(sum1,sum2);
	}
	public int maxDotProduct(int n, int m, int a[], int b[]) 
	{ 
		// Your code goes here
		int dp[][] = new int[n][m];
		for(int temp[]:dp){
		    Arrays.fill(temp,-1);
		}
		return help(0,0,n,m,a,b,dp,n-m);
	} 
}


// Time Complexity:- O(N*M)
// Space Complexity:- O(N*M)

// C# ************************************************************************************************************
// Let's break down the given C# code that calculates the maximum dot product of two arrays with the insertion of zeros.

// 1. **Problem Description**:
//    - We are given two arrays, `A` and `B`, both containing positive integers.
//    - Our goal is to maximize the dot product by inserting zeros into the second array (`B`), while maintaining the order of elements in `B`.

// 2. **Approach**:
//    - We can think of two choices for each pair of elements: either include `A[i] * B[j]` in the product or exclude `A[i]` (insert a zero at the current position in `B`).
//    - To solve this problem, we'll use dynamic programming.

// 3. **Dynamic Programming Approach**:
//    - Initialize a 2D matrix `dp[n + 1][m + 1]` (where `n` is the size of array `B` and `m` is the size of array `A`).
//    - Set all elements of `dp` to 0 initially.
//    - Iterate over `i` from 1 to `n` and `j` from `i` to `m`.
//    - For each pair `(i, j)`:
//      - Calculate two values:
//        1. Include `A[j]`: `dp[i][j] = dp[i - 1][j - 1] + A[j - 1] * B[i - 1]`
//        2. Exclude `A[j]`: `dp[i][j] = dp[i][j - 1]`
//      - Choose the maximum of the above two values and store it in `dp[i][j]`.
//    - The final result is `dp[n][m]`.

// 4. **C# Implementation**:
   ```csharp
   public class Solution
   {
       public int Help(int i, int j, int n, int m, int[] a, int[] b, int[,] dp, int diff)
       {
           if (i == n || j == m)
               return 0;
           if (dp[i, j] != -1)
               return dp[i, j];
           int sum1 = 0, sum2 = 0;
           if (diff != 0)
               sum1 = Help(i + 1, j, n, m, a, b, dp, diff - 1);
           sum2 = a[i] * b[j] + Help(i + 1, j + 1, n, m, a, b, dp, diff);
           return dp[i, j] = Math.Max(sum1, sum2);
       }

       public int MaxDotProduct(int n, int m, int[] a, int[] b)
       {
           int[,] dp = new int[n, m];
           for (int i = 0; i < n; i++)
           {
               for (int j = 0; j < m; j++)
               {
                   dp[i, j] = -1;
               }
           }
           return Help(0, 0, n, m, a, b, dp, n - m);
       }
   }
   ```

// 5. **Explanation**:
//    - The `Help` method recursively calculates the maximum dot product based on the given parameters.
//    - The `MaxDotProduct` method initializes the dynamic programming array `dp` and calls the `Help` method to compute the result.
