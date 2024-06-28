/*     Scroll below to see JAVA and C# code  also   */
/*
    Company Tags                : ADOBE
    Leetcode Link               : https://leetcode.com/problems/maximum-total-importance-of-roads
*/


/ C++ **********************************************************************************************************************************************************/
//Approach (
// Time Complexity: O(n2)
// Auxiliary Space: O(1)
  
#include <iostream>
#include <vector>
using namespace std;

class Solution {
private:
    bool isPalindrome(vector<int>& array) {
        int start = 0;
        int end = array.size() - 1;
        while (start < end) {
            if (array[start] != array[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
public:
    string pattern(vector<vector<int>>& arr) {
        int n = arr.size();
        
        // Check rows for palindrome
        for (int i = 0; i < n; i++) {
            if (isPalindrome(arr[i])) {
                return to_string(i) + " R";
            }
        }
        
        // Check columns for palindrome
        for (int j = 0; j < n; j++) {
            vector<int> column(n);
            for (int i = 0; i < n; i++) {
                column[i] = arr[i][j];
            }
            if (isPalindrome(column)) {
                return to_string(j) + " C";
            }
        }
        
        // If no palindrome is found
        return "-1";
    }
};

int main() {
    Solution solution;
    vector<vector<int>> arr = {
        {1, 0, 0},
        {0, 1, 0},
        {1, 1, 0}
    };
    cout << solution.pattern(arr) << endl;
    return 0;
}




  / Java **********************************************************************************************************************************************************/
//Approach (
// Time Complexity: O(n2)
// Auxiliary Space: O(1)
class Solution {
    // Helper function to check if an array is a palindrome
    private boolean isPalindrome(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if (array[start] != array[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    public String pattern(int[][] arr) {
        int n = arr.length;
        
        // Check rows for palindrome
        for (int i = 0; i < n; i++) {
            if (isPalindrome(arr[i])) {
                return i + " R";
            }
        }
        
        // Check columns for palindrome
        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = arr[i][j];
            }
            if (isPalindrome(column)) {
                return j + " C";
            }
        }
        
        // If no palindrome is found
        return "-1";
    }
}





  / C# **********************************************************************************************************************************************************/
//Approach (
// Time Complexity: O(n2)
// Auxiliary Space: O(1)
    
  using System;
using System.Collections.Generic;

class Solution {
    private bool IsPalindrome(List<int> array) {
        int start = 0;
        int end = array.Count - 1;
        while (start < end) {
            if (array[start] != array[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    public string Pattern(int[][] arr) {
        int n = arr.Length;
        
        // Check rows for palindrome
        for (int i = 0; i < n; i++) {
            if (IsPalindrome(new List<int>(arr[i]))) {
                return i + " R";
            }
        }
        
        // Check columns for palindrome
        for (int j = 0; j < n; j++) {
            List<int> column = new List<int>();
            for (int i = 0; i < n; i++) {
                column.Add(arr[i][j]);
            }
            if (IsPalindrome(column)) {
                return j + " C";
            }
        }
        
        // If no palindrome is found
        return "-1";
    }
    
    static void Main(string[] args) {
        Solution solution = new Solution();
        int[][] arr = {
            new int[] { 1, 0, 0 },
            new int[] { 0, 1, 0 },
            new int[] { 1, 1, 0 }
        };
        Console.WriteLine(solution.Pattern(arr));
    }
}
