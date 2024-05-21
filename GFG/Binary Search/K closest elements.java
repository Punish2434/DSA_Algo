
/*                                       Scroll down to see JAVA code and C# also                                      /*
/*
    Company Tags                : Microsoft
    Leetcode Link               : https://leetcode.com/problems/subsets/
*/

/ C++ ************************************************************************************************************************/
//Time Complexity: O(log n + k)
//Space Complexity: O(k)
  
#include <iostream>
#include <vector>
#include <cmath>

std::vector<int> printKClosest(int arr[], int n, int k, int x) {
    std::vector<int> result;
    int left = 0, right = n - 1;

    // Binary search to find the closest element to x
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] >= x) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }

    // Initialize two pointers for the closest elements
    left--; // start from the element just before the closest greater or equal to x
    right = left + 1; // and the element just after

    // Finding k closest elements
    while (k > 0) {
        // Skip the element x if it's present
        if (left >= 0 && arr[left] == x) {
            left--;
            continue;
        }
        if (right < n && arr[right] == x) {
            right++;
            continue;
        }

        if (left < 0) {
            result.push_back(arr[right++]);
        } else if (right >= n) {
            result.push_back(arr[left--]);
        } else if (std::abs(arr[left] - x) > std::abs(arr[right] - x)) {
            result.push_back(arr[right++]);
        } else if (std::abs(arr[left] - x) < std::abs(arr[right] - x)) {
            result.push_back(arr[left--]);
        } else {
            if (arr[left] > arr[right]) {
                result.push_back(arr[left--]);
            } else {
                result.push_back(arr[right++]);
            }
        }
        k--;
    }

    return result;
}

int main() {
    // Example usage
    int arr[] = {1, 3, 6, 8, 10};
    int n = sizeof(arr) / sizeof(arr[0]);
    int k = 3;
    int x = 7;

    std::vector<int> closestElements = printKClosest(arr, n, k, x);
    for (int elem : closestElements) {
        std::cout << elem << " ";
    }
    std::cout << std::endl;

    return 0;
}
/ Java ************************************************************************************************************************/


class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = n - 1;

        // Binary search to find the closest element to x
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // Initialize two pointers for the closest elements
        left--; // start from the element just before the closest greater or equal to x
        right = left + 1; // and the element just after

        // Finding k closest elements
        while (k > 0) {
            // Skip the element x if it's present
            if (left >= 0 && arr[left] == x) {
                left--;
                continue;
            }
            if (right < n && arr[right] == x) {
                right++;
                continue;
            }

            if (left < 0) {
                result.add(arr[right++]);
            } else if (right >= n) {
                result.add(arr[left--]);
            } else if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                result.add(arr[right++]);
            } else if (Math.abs(arr[left] - x) < Math.abs(arr[right] - x)) {
                result.add(arr[left--]);
            } else {
                if (arr[left] > arr[right]) {
                    result.add(arr[left--]);
                } else {
                    result.add(arr[right++]);
                }
            }
            k--;
        }

        // Convert result to an array
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

   
}

/ C# ************************************************************************************************************************/

using System;
using System.Collections.Generic;

class Solution {
    public int[] PrintKClosest(int[] arr, int n, int k, int x) {
        List<int> result = new List<int>();
        int left = 0, right = n - 1;

        // Binary search to find the closest element to x
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // Initialize two pointers for the closest elements
        left--; // start from the element just before the closest greater or equal to x
        right = left + 1; // and the element just after

        // Finding k closest elements
        while (k > 0) {
            // Skip the element x if it's present
            if (left >= 0 && arr[left] == x) {
                left--;
                continue;
            }
            if (right < n && arr[right] == x) {
                right++;
                continue;
            }

            if (left < 0) {
                result.Add(arr[right++]);
            } else if (right >= n) {
                result.Add(arr[left--]);
            } else if (Math.Abs(arr[left] - x) > Math.Abs(arr[right] - x)) {
                result.Add(arr[right++]);
            } else if (Math.Abs(arr[left] - x) < Math.Abs(arr[right] - x)) {
                result.Add(arr[left--]);
            } else {
                if (arr[left] > arr[right]) {
                    result.Add(arr[left--]);
                } else {
                    result.Add(arr[right++]);
                }
            }
            k--;
        }

        return result.ToArray();
    }

    static void Main(string[] args) {
        // Example usage
        int[] arr = { 1, 3, 6, 8, 10 };
        int n = arr.Length;
        int k = 3;
        int x = 7;

        Solution solution = new Solution();
        int[] closestElements = solution.PrintKClosest(arr, n, k, x);
        foreach (int elem in closestElements) {
            Console.Write(elem + " ");
        }
        Console.WriteLine();
    }
}
``
