/*         Scroll below to see JAVA code and C# also        */

    // Company Tags                : Facebook, Uber, Google, Microsoft
    // Leetcode Link               : https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/


// C++ ********************************************************************************************************************************************/
//Approach (Using simple Greedy)
//T.C : O(m+n)
//S.C : O(m*n) //You can exclude this because it is what is expected to return from the function
class Solution {
public:
    vector<vector<int>> restoreMatrix(vector<int>& rowSum, vector<int>& colSum) {
        int m = rowSum.size();
        int n = colSum.size();
        vector<vector<int>> vec(m, vector<int>(n));
        
        int i = 0, j = 0;
        while(i < m && j < n) {
            vec[i][j] = min(rowSum[i], colSum[j]);

            rowSum[i] -= vec[i][j];
            colSum[j] -= vec[i][j];

            if(rowSum[i] == 0) i++;
            if(colSum[j] == 0) j++;
            
        }
        return vec;
    }
};



// JAVA ********************************************************************************************************************************************/
//Approach (Using simple Greedy)
//T.C : O(m+n)
//S.C : O(m*n) //You can exclude this because it is what is expected to return from the function
class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] matrix = new int[m][n];
        
        int i = 0, j = 0;
        while (i < m && j < n) {
            matrix[i][j] = Math.min(rowSum[i], colSum[j]);

            rowSum[i] -= matrix[i][j];
            colSum[j] -= matrix[i][j];

            if (rowSum[i] == 0) i++;
            if (colSum[j] == 0) j++;
        }
        
        return matrix;
    }
}


// C# ********************************************************************************************************************************************/
//Approach (Using simple Greedy)
//T.C : O(m+n)
//S.C : O(m*n) //You can exclude this because it is what is expected to return from the function
  public class Solution {
    public int[][] RestoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.Length;
        int cols = colSum.Length;
        
        int[][] matrix = new int[rows][];
        for(int i = 0; i < rows; i++){
            matrix[i] = new int[cols];
        }
        
        int row = 0;
        int col = 0;
        
        while(row < rows && col < cols){
            int minValue = Math.Min(rowSum[row], colSum[col]);
            matrix[row][col] = minValue;
            rowSum[row] -= minValue;
            colSum[col] -= minValue;
            
            if(rowSum[row] == 0){
                row++;
            }
            if(colSum[col] == 0){
                col++;
            }
        }
        return matrix;
    }
}
