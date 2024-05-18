/*             Scroll below to see JAVA code and C# also      */
/*
     
      Company Tags                : Amazon
      Leetcode Link               : https://www.geeksforgeeks.org/problems/find-the-highest-number2259/1
    
*/
/ C++ **********************************************************************************************************************************************************/
#include <iostream>
#include <vector>

class Solution
{
public:
    int findPeakElement(std::vector<int>& a)
    {
        int left = 0;
        int right = a.size() - 1;

        while (left < right)
        {
            int mid = left + (right - left) / 2;

            if (a[mid] > a[mid + 1])
            {
                // The peak is in the left half (including mid)
                right = mid;
            }
            else
            {
                // The peak is in the right half (excluding mid)
                left = mid + 1;
            }
        }

        // When left == right, we've found the peak element
        return a[left];
    }
};

int main()
{
    Solution sol;
    std::vector<int> nums = {1, 2, 3, 1}; // Example input
    std::cout << "Peak element: " << sol.findPeakElement(nums) << std::endl;
    return 0;
}

/ Java **********************************************************************************************************************************************************/


class Solution {
    public int findPeakElement(List<Integer> a) {
        int left = 0;
        int right = a.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (a.get(mid) > a.get(mid + 1)) {
                // The peak is in the left half (including mid)
                right = mid;
            } else {
                // The peak is in the right half (excluding mid)
                left = mid + 1;
            }
        }

        // When left == right, we've found the peak element
        return a.get(left);
    }
}

/ C# **********************************************************************************************************************************************************/
using System;
using System.Collections.Generic;

public class Solution
{
    public int FindPeakElement(List<int> a)
    {
        int left = 0;
        int right = a.Count - 1;

        while (left < right)
        {
            int mid = left + (right - left) / 2;

            if (a[mid] > a[mid + 1])
            {
                // The peak is in the left half (including mid)
                right = mid;
            }
            else
            {
                // The peak is in the right half (excluding mid)
                left = mid + 1;
            }
        }

        // When left == right, we've found the peak element
        return a[left];
    }
}
