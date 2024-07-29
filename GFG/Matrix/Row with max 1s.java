/*         Scroll below to see JAVA code and C# also        */

    // Company Tags           : Amazon,Microsoft,Snapdeal
    // GFG Link               : https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1
// C++ ********************************************************************************************************************************************/
//Approach-1 (Using  binary search)
// TC:𝑂((n + m)
// SC:𝑂(1)
#include <vector>
#include <iostream>

class Solution {
public:
    int rowWithMax1s(std::vector<std::vector<int>>& arr) {
        int maxRowIndex = -1;
        int maxCount = 0;
        int rows = arr.size();
        int cols = arr[0].size();

        for (int i = 0; i < rows; i++) {
            int count = countOnes(arr[i], cols);
            if (count > maxCount) {
                maxCount = count;
                maxRowIndex = i;
            }
        }

        return maxRowIndex;
    }

private:
    int countOnes(std::vector<int>& row, int cols) {
        int low = 0, high = cols - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (row[mid] == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return cols - low;
    }
};

// Test cases
int main() {
    Solution solution;

    std::vector<std::vector<int>> arr1 = {
        {0, 1, 1, 1},
        {0, 0, 1, 1},
        {1, 1, 1, 1},
        {0, 0, 0, 0}
    };
    std::cout << solution.rowWithMax1s(arr1) << std::endl; // Output: 2

    std::vector<std::vector<int>> arr2 = {
        {0, 0},
        {1, 1}
    };
    std::cout << solution.rowWithMax1s(arr2) << std::endl; // Output: 1

    return 0;
}
// Java ********************************************************************************************************************************************/
//Approach-1 (Using  binary search)
// TC:𝑂((n + m)
// SC:𝑂(1)
class Solution {
    public int rowWithMax1s(int arr[][]) {
        int maxRowIndex = -1;
        int maxCount = 0;
        int rows = arr.length;
        int cols = arr[0].length;

        for (int i = 0; i < rows; i++) {
            int count = countOnes(arr[i], cols);
            if (count > maxCount) {
                maxCount = count;
                maxRowIndex = i;
            }
        }

        return maxRowIndex;
    }

    // Function to count number of 1's in a row using binary search
    private int countOnes(int[] row, int cols) {
        int low = 0, high = cols - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (row[mid] == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return cols - low;
    }
}

// C# ********************************************************************************************************************************************/
//Approach-1 (Using  binary search)
// TC:𝑂((n + m)
// SC:𝑂(1)
using System;

class Solution {
    public int RowWithMax1s(int[][] arr) {
        int maxRowIndex = -1;
        int maxCount = 0;
        int rows = arr.Length;
        int cols = arr[0].Length;

        for (int i = 0; i < rows; i++) {
            int count = CountOnes(arr[i], cols);
            if (count > maxCount) {
                maxCount = count;
                maxRowIndex = i;
            }
        }

        return maxRowIndex;
    }

    private int CountOnes(int[] row, int cols) {
        int low = 0, high = cols - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (row[mid] == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return cols - low;
    }

    static void Main() {
        Solution solution = new Solution();

        int[][] arr1 = new int[][] {
            new int[] {0, 1, 1, 1},
            new int[] {0, 0, 1, 1},
            new int[] {1, 1, 1, 1},
            new int[] {0, 0, 0, 0}
        };
        Console.WriteLine(solution.RowWithMax1s(arr1)); // Output: 2

        int[][] arr2 = new int[][] {
            new int[] {0, 0},
            new int[] {1, 1}
        };
        Console.WriteLine(solution.RowWithMax1s(arr2)); // Output: 1
    }
}


// JavaScript ********************************************************************************************************************************************/
//Approach-1 (Using  binary search)
// TC:𝑂((n + m)
// SC:𝑂(1)
class Solution {

    rowWithMax1s(arr) {
        // code here
        let maxRowIndex = -1;
        let maxCount = 0;
        let rows = arr.length;
        let cols = arr[0].length;
        
        for(let i = 0; i < rows; i++){
            let count = this.countOnes(arr[i], cols);
            if(count > maxCount){
                maxCount = count;
                maxRowIndex = i;
            }
        }
        return maxRowIndex;
    }
    countOnes(row, cols){
        let low = 0, high = cols - 1;
        while(low <= high){
            let mid = Math.floor((low + high)/2);
            if(row[mid] === 0){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return cols - low;
    }
}
