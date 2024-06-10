/*    Scroll below to see JAVA code and C# also  */
/*
    Company Tags                : 
    Leetcode Link               : https://leetcode.com/problems/height-checker/
*/
/ C++ **************************************************************************************************************************/
// Time Complexity: O(n log n)
// Space Complexity: O(n)
  
#include <iostream>
#include <vector>
#include <algorithm>

class Solution {
public:
    int heightChecker(std::vector<int>& heights) {
        std::vector<int> expected = heights; // Create a copy of the heights array
        std::sort(expected.begin(), expected.end()); // Sort the copy to get the expected order
        
        // Count the number of indices where heights[i] != expected[i]
        int count = 0;
        for (size_t i = 0; i < heights.size(); ++i) {
            if (heights[i] != expected[i]) {
                ++count;
            }
        }
        
        return count;
    }
};

int main() {
    Solution solution;

    std::vector<int> heights1 = {1, 1, 4, 2, 1, 3};
    std::cout << "Output: " << solution.heightChecker(heights1) << std::endl; // Output: 3

    std::vector<int> heights2 = {5, 1, 2, 3, 4};
    std::cout << "Output: " << solution.heightChecker(heights2) << std::endl; // Output: 5

    std::vector<int> heights3 = {1, 2, 3, 4, 5};
    std::cout << "Output: " << solution.heightChecker(heights3) << std::endl; // Output: 0

    return 0;
}
/ Java **************************************************************************************************************************/
// Time Complexity: O(n log n)
// Space Complexity: O(n)

  class Solution {
    public int heightChecker(int[] heights) {
        // Create a copy of the heights array and sort it to get the expected order
        int[] expected = heights.clone();
        Arrays.sort(expected);
        
        // Count the number of indices where heights[i] != expected[i]
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] heights1 = {1, 1, 4, 2, 1, 3};
        System.out.println("Output: " + solution.heightChecker(heights1)); // Output: 3

        int[] heights2 = {5, 1, 2, 3, 4};
        System.out.println("Output: " + solution.heightChecker(heights2)); // Output: 5

        int[] heights3 = {1, 2, 3, 4, 5};
        System.out.println("Output: " + solution.heightChecker(heights3)); // Output: 0
    }
}

/ C# **************************************************************************************************************************/
// Time Complexity: O(n log n)
// Space Complexity: O(n)
using System;
using System.Linq;

public class Solution {
    public int HeightChecker(int[] heights) {
        int[] expected = heights.ToArray(); // Create a copy of the heights array
        Array.Sort(expected); // Sort the copy to get the expected order
        
        // Count the number of indices where heights[i] != expected[i]
        int count = 0;
        for (int i = 0; i < heights.Length; ++i) {
            if (heights[i] != expected[i]) {
                ++count;
            }
        }
        
        return count;
    }

    public static void Main(string[] args) {
        Solution solution = new Solution();

        int[] heights1 = {1, 1, 4, 2, 1, 3};
        Console.WriteLine("Output: " + solution.HeightChecker(heights1)); // Output: 3

        int[] heights2 = {5, 1, 2, 3, 4};
        Console.WriteLine("Output: " + solution.HeightChecker(heights2)); // Output: 5

        int[] heights3 = {1, 2, 3, 4, 5};
        Console.WriteLine("Output: " + solution.HeightChecker(heights3)); // Output: 0
    }
}

