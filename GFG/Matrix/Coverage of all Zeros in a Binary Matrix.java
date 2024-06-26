/*     Scroll below to see JAVA code and C# also  */
/*
    Company Tags                :
    GFG Link               : https://www.geeksforgeeks.org/problems/coverage-of-all-zeros-in-a-binary-matrix4024/1
*/


/ C++ ********************************************************************************************************************************/

//T.C : O(n*m)
//S.C : O(1)
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int findCoverage(vector<vector<int>>& matrix) {
        int rows = matrix.size();
        int cols = matrix[0].size();
        int coverage = 0;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j] == 0) {
                    if (j > 0 && matrix[i][j - 1] == 1) {
                        coverage++;
                    }
                    if (j < cols - 1 && matrix[i][j + 1] == 1) {
                        coverage++;
                    }
                    if (i > 0 && matrix[i - 1][j] == 1) {
                        coverage++;
                    }
                    if (i < rows - 1 && matrix[i + 1][j] == 1) {
                        coverage++;
                    }
                }
            }
        }

        return coverage;
    }
};

int main() {
    Solution solution;
    vector<vector<int>> matrix1 = {{0, 1, 0}, {0, 1, 1}, {0, 0, 0}};
    vector<vector<int>> matrix2 = {{0, 1}};

    cout << solution.findCoverage(matrix1) << endl; // Output: 6
    cout << solution.findCoverage(matrix2) << endl; // Output: 1

    return 0;
}
/ Java ********************************************************************************************************************************/

//T.C : O(n*m)
//S.C : O(1)

class Solution {
    public int findCoverage(int[][] matrix) {
        // code here
        int rows = matrix.length;
        int cols = matrix[0].length;
        int coverage = 0;
        
        // Iterate over each cell in the matrix
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                // check if the cell contains a 0 
                if(matrix[i][j]== 0){
                    //check the left cell
                    if (j > 0 && matrix[i][j - 1] == 1) {
                        coverage++;
                    }
                    // check the right cell
                    if(j<cols-1 && matrix[i][j+ 1]== 1){
                        coverage++;
                        
                    }
                    //check the top cell
                    if(i>0 && matrix[i-1][j]==1){
                        coverage++;
                        
                    }
                    // check the bottom cell
                    if(i<rows-1 && matrix[i+1][j]==1){
                        coverage++;
                    }
                }
            }
        }
        return coverage;
    }
}


/ C# ********************************************************************************************************************************/

//T.C : O(n*m)
//S.C : O(1)
using System;

public class Solution {
    public int FindCoverage(int[][] matrix) {
        int rows = matrix.Length;
        int cols = matrix[0].Length;
        int coverage = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    if (j > 0 && matrix[i][j - 1] == 1) {
                        coverage++;
                    }
                    if (j < cols - 1 && matrix[i][j + 1] == 1) {
                        coverage++;
                    }
                    if (i > 0 && matrix[i - 1][j] == 1) {
                        coverage++;
                    }
                    if (i < rows - 1 && matrix[i + 1][j] == 1) {
                        coverage++;
                    }
                }
            }
        }

        return coverage;
    }

    public static void Main(string[] args) {
        Solution solution = new Solution();

        int[][] matrix1 = new int[][] {
            new int[] { 0, 1, 0 },
            new int[] { 0, 1, 1 },
            new int[] { 0, 0, 0 }
        };

        int[][] matrix2 = new int[][] {
            new int[] { 0, 1 }
        };

        Console.WriteLine(solution.FindCoverage(matrix1)); // Output: 6
        Console.WriteLine(solution.FindCoverage(matrix2)); // Output: 1
    }
}
