/*    scroll below to see JAVA code and C# also    */
/*
    Company Tags                : AMAZON
    GFG Link               : https://www.geeksforgeeks.org/problems/left-rotate-matrix-k-times2351/1
*/

/ C++ ************************************************************************************************************************************/

//T.C : O(n*m)
//S.C : O(n*m)

class Solution {
  public:
    vector<vector<int>> rotateMatrix(int k, vector<vector<int>> mat) {
        // codeGenius
        int n=mat.size();
        int m=mat[0].size();
        k=k%m;
        for(auto &row :mat){
            reverse(row.begin(),row.end());
            reverse(row.rbegin(),row.rbegin()+k);
            reverse(row.rbegin()+k,row.rend());
            
        }
        return mat; //O(1)
    }
};


/ Java ************************************************************************************************************************************/

//T.C : O(n*m)
//S.C : O(n*m)

  class Solution {
    public int[][] rotateMatrix(int k, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];

        k %= m;
        if (k == 0) return mat;

        for (int i = 0; i < n; i++) {
            int x = 0;
            for (int j = k; j < m; j++, x++) {
                ans[i][x] = mat[i][j];
            }
            for (int j = 0; j < k; j++, x++) {
                ans[i][x] = mat[i][j];
            }
        }

        return ans;
    }

    
}

/ C# ************************************************************************************************************************************/
//T.C : O(n*m)
//S.C : O(n*m)
public class Solution {
    public int[][] RotateMatrix(int k, int[][] mat) {
        int n = mat.Length;
        int m = mat[0].Length;
        int[][] ans = new int[n][];

        for (int i = 0; i < n; i++) {
            ans[i] = new int[m];
        }

        k %= m;
        if (k == 0) return mat;

        for (int i = 0; i < n; i++) {
            int x = 0;
            for (int j = k; j < m; j++, x++) {
                ans[i][x] = mat[i][j];
            }
            for (int j = 0; j < k; j++, x++) {
                ans[i][x] = mat[i][j];
            }
        }

        return ans;
    }

    public static void Main(string[] args) {
        Solution sol = new Solution();

        int[][] mat1 = {
            new int[] { 1, 2, 3, 4 },
            new int[] { 5, 6, 7, 8 },
            new int[] { 9, 10, 11, 12 }
        };
        int k1 = 2;
        int[][] ans1 = sol.RotateMatrix(k1, mat1);
        PrintMatrix(ans1);

        int[][] mat2 = {
            new int[] { 1, 2, 3, 4, 5, 6, 7 }
        };
        int k2 = 3;
        int[][] ans2 = sol.RotateMatrix(k2, mat2);
        PrintMatrix(ans2);
    }

    private static void PrintMatrix(int[][] matrix) {
        foreach (var row in matrix) {
            foreach (var elem in row) {
                Console.Write(elem + " ");
            }
            Console.WriteLine();
        }
    }
}
