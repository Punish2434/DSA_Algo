/*         Scroll below to see JAVA code and C# also        */

    // Company Tags                : Paytm,Flipkart,Morgan Stanley,Microsoft,OYO Rooms,Snapdeal,D-E-Shaw,MakeMyTrip,Oracle,MAQ Software,Adobe,nearbuy,Nagarro,BrowserStack,Salesforce
    // Leetcode Link               : https://www.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
// C++ ********************************************************************************************************************************************/
//Approach (Using traverse a given rectangular matrix in spiral order)
// TC:𝑂(n2)
// SC:𝑂(n2)
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> spirallyTraverse(vector<vector<int>>& matrix) {
        vector<int> result;
        if (matrix.empty()) {
            return result;
        }

        int top = 0, bottom = matrix.size() - 1;
        int left = 0, right = matrix[0].size() - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                result.push_back(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                result.push_back(matrix[i][right]);
            }
            right--;

            // Traverse from right to left along the bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.push_back(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse from bottom to top along the left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.push_back(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
};

// Example usage
int main() {
    Solution sol;
    vector<vector<int>> matrix1 = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };
    vector<int> result1 = sol.spirallyTraverse(matrix1);
    for (int num : result1) {
        cout << num << " ";
    }
    cout << endl;

    vector<vector<int>> matrix2 = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12}
    };
    vector<int> result2 = sol.spirallyTraverse(matrix2);
    for (int num : result2) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}

// Java ********************************************************************************************************************************************/
//Approach (Using traverse a given rectangular matrix in spiral order)
// TC:𝑂(n2)
// SC:𝑂(n2)
class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }

        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Traverse from right to left along the bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse from bottom to top along the left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}

// C# ********************************************************************************************************************************************/
//Approach (Using traverse a given rectangular matrix in spiral order)
// TC:𝑂(n2)
// SC:𝑂(n2)
using System;
using System.Collections.Generic;

class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public List<int> SpirallyTraverse(int[][] matrix) {
        List<int> result = new List<int>();
        if (matrix.Length == 0) {
            return result;
        }

        int top = 0, bottom = matrix.Length - 1;
        int left = 0, right = matrix[0].Length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                result.Add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                result.Add(matrix[i][right]);
            }
            right--;

            // Traverse from right to left along the bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.Add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse from bottom to top along the left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.Add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void Main() {
        Solution sol = new Solution();
        int[][] matrix1 = {
            new int[] {1, 2, 3, 4},
            new int[] {5, 6, 7, 8},
            new int[] {9, 10, 11, 12},
            new int[] {13, 14, 15, 16}
        };
        Console.WriteLine(string.Join(", ", sol.SpirallyTraverse(matrix1)));

        int[][] matrix2 = {
            new int[] {1, 2, 3, 4},
            new int[] {5, 6, 7, 8},
            new int[] {9, 10, 11, 12}
        };
        Console.WriteLine(string.Join(", ", sol.SpirallyTraverse(matrix2)));
    }
}

// JavaScript ********************************************************************************************************************************************/
//Approach (Using traverse a given rectangular matrix in spiral order)
// TC:𝑂(n2)
// SC:𝑂(n2)
class Solution {
    spirallyTraverse(matrix) {
        const result = [];
        if (matrix.length === 0) {
            return result;
        }

        let top = 0, bottom = matrix.length - 1;
        let left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (let i = left; i <= right; i++) {
                result.push(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom along the right column
            for (let i = top; i <= bottom; i++) {
                result.push(matrix[i][right]);
            }
            right--;

            // Traverse from right to left along the bottom row
            if (top <= bottom) {
                for (let i = right; i >= left; i--) {
                    result.push(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse from bottom to top along the left column
            if (left <= right) {
                for (let i = bottom; i >= top; i--) {
                    result.push(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}
