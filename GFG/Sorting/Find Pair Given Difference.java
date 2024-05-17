/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags           : Amazon,Visa
    GFG Link               : https://www.geeksforgeeks.org/problems/find-pair-given-difference1559/1
*/


/ C++ ************************************************************************************************************************/
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int findPair(int n, int x, vector<int>& arr) {
    // Sort thethe array
    sort(arr.begin(), arr.end());

    // Use two pointers to find the pair with the given absolute difference
    int left = 0;
    int right = 1;

    while (left < n && right < n) {
        int diff = arr[right] - arr[left];

        if (left != right && diff == x) {
            return 1;
        } else if (diff < x) {
            right++;
        } else {
            left++;
        }
    }

    return -1;
}

int main() {
    int n = 5; // Example size of the array
    int x = 3; // Example target difference
    vector<int> arr = {2, 5, 1, 8, 4}; // Example array

    int result = findPair(n, x, arr);
    cout << "Result in C++: " << result << endl;

    return 0;
}



/ Java ************************************************************************************************************************/


  class Solution {
    public int findPair(int n, int x, int[] arr) {
        // Sort the array
        Arrays.sort(arr);

        // Use two pointers to find the pair with the given absolute difference
        int left = 0;
        int right = 1;

        while (left < n && right < n) {
            int diff = arr[right] - arr[left];

            if (left != right && diff == x) {
                return 1;
            } else if (diff < x) {
                right++;
            } else {
                left++;
            }
        }

        return -1;
    }
}
/ C# ************************************************************************************************************************/
using System;
using System.Linq;

public class Solution {
    public int FindPair(int n, int x, int[] arr) {
        // Sort the array
        Array.Sort(arr);

        // Use two pointers to find the pair with the given absolute difference
        int left = 0;
        int right = 1;

        while (left < n && right < n) {
            int diff = arr[right] - arr[left];

            if (left != right && diff == x) {
                return 1;
            } else if (diff < x) {
                right++;
            } else {
                left++;
            }
        }

        return -1;
    }

    public static void Main(string[] args) {
        int n = 5; // Example size of the array
        int x = 3; // Example target difference
        int[] arr = { 2, 5, 1, 8, 4 }; // Example array

        Solution solution = new Solution();
        int result = solution.FindPair(n, x, arr);
        Console.WriteLine($"Result in C#: {result}");
    }
}

