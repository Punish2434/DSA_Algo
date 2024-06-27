/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : 
    GFG Link               : https://www.geeksforgeeks.org/problems/toeplitz-matrix/1
*/


/ C++ ********************************************************************************************************************************/

//T.C : O(n*m)
//S.C : O(1)
  class Solution {
     bool isToepliz(vector<vector<int>>& mat) {
    // codeGenius
    int n=mat.size();
    int m=mat[0].size();
    for(int i=1;i<n;i++){
        for(int j=1;j<m;j++){
            if(mat[i][j]!=mat[i-1][j-1])
            return false;
        }
    }return true;
   }
}

/ Java ********************************************************************************************************************************/

//T.C : O(n*m)
//S.C : O(1)
class Solution {
    /*You are required to complete this method*/
    boolean isToeplitz(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] != mat[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
/ C# ********************************************************************************************************************************/
//T.C : O(n*m)
//S.C : O(1)
  
  public class Solution {
    /*You are required to complete this method*/
    public bool IsToeplitz(int[][] mat) {
        int n = mat.Length;
        int m = mat[0].Length;
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] != mat[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}

