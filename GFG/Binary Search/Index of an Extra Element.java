/*     Scroll below to see JAVA code and C# also    */

/*
    Company Tags                : Amazon,Zoho
    GFG Link               : https://www.geeksforgeeks.org/problems/index-of-an-extra-element/1
*/
/ C++ ***************************************************************************************************************************************/
// Expected Time Complexity: O(log n).
// Expected Auxiliary Space: O(1).
#include <iostream>
#include <vector>

class Solution {
public:
    int findExtra(int n, std::vector<int>& arr1, std::vector<int>& arr2) {
        int left = 0;
        int right = n - 2; // arr2 is of size n-1

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the mid elements are equal, the extra element must be in the right half
            if (arr1[mid] == arr2[mid]) {
                left = mid + 1;
            } else {
                // Else, the extra element is in the left half (including mid)
                right = mid - 1;
            }
        }

        // Left is the index of the extra element
        return left;
    }
};

int main() {
    Solution solution;

    // Test cases
    int n1 = 7;
    std::vector<int> arr1_1 = {2, 4, 6, 8, 9, 10, 12};
    std::vector<int> arr2_1 = {2, 4, 6, 8, 10, 12};
    std::cout << solution.findExtra(n1, arr1_1, arr2_1) << std::endl; // Output: 4

    int n2 = 6;
    std::vector<int> arr1_2 = {3, 5, 7, 8, 11, 13};
    std::vector<int> arr2_2 = {3, 5, 7, 11, 13};
    std::cout << solution.findExtra(n2, arr1_2, arr2_2) << std::endl; // Output: 3

    return 0;
}

/ Java ***************************************************************************************************************************************/
// Expected Time Complexity: O(log n).
// Expected Auxiliary Space: O(1).
class Solution {
    public int findExtra(int n, int arr1[], int arr2[]) {
        int left = 0;
        int right = n - 2; // arr2 is of size n-1

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the mid elements are equal, the extra element must be in the right half
            if (arr1[mid] == arr2[mid]) {
                left = mid + 1;
            } else {
                // Else, the extra element is in the left half (including mid)
                right = mid - 1;
            }
        }

        // Left is the index of the extra element
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int n1 = 7;
        int[] arr1_1 = {2, 4, 6, 8, 9, 10, 12};
        int[] arr2_1 = {2, 4, 6, 8, 10, 12};
        System.out.println(solution.findExtra(n1, arr1_1, arr2_1)); // Output: 4

        int n2 = 6;
        int[] arr1_2 = {3, 5, 7, 8, 11, 13};
        int[] arr2_2 = {3, 5, 7, 11, 13};
        System.out.println(solution.findExtra(n2, arr1_2, arr2_2)); // Output: 3
    }
}
/ C#  ***************************************************************************************************************************************/
// Expected Time Complexity: O(log n).
// Expected Auxiliary Space: O(1).
  
  using System;

public class Solution
{
    public int FindExtra(int n, int[] arr1, int[] arr2)
    {
        int left = 0;
        int right = n - 2; // arr2 is of size n-1

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            // If the mid elements are equal, the extra element must be in the right half
            if (arr1[mid] == arr2[mid])
            {
                left = mid + 1;
            }
            else
            {
                // Else, the extra element is in the left half (including mid)
                right = mid - 1;
            }
        }

        // Left is the index of the extra element
        return left;
    }

    public static void Main(string[] args)
    {
        Solution solution = new Solution();

        // Test cases
        int n1 = 7;
        int[] arr1_1 = {2, 4, 6, 8, 9, 10, 12};
        int[] arr2_1 = {2, 4, 6, 8, 10, 12};
        Console.WriteLine(solution.FindExtra(n1, arr1_1, arr2_1)); // Output: 4

        int n2 = 6;
        int[] arr1_2 = {3, 5, 7, 8, 11, 13};
        int[] arr2_2 = {3, 5, 7, 11, 13};
        Console.WriteLine(solution.FindExtra(n2, arr1_2, arr2_2)); // Output: 3
    }
}
