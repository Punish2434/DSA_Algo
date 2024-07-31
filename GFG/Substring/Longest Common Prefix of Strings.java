/*         Scroll below to see JAVA code and C# also        */

    // Company Tags           : VMWare,Microsoft,Google
    // GFG Link               : https://www.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129/1
// C++ ********************************************************************************************************************************************/
//Approach (Using Substring)
// TC:𝑂(n * m) n: Number of strings in the array, m: Length of the smallest string in the array.
// SC:𝑂(m) m: Length of the smallest string in the array.
#include <iostream>
#include <vector>
#include <string>

class Solution {
public:
    std::string longestCommonPrefix(std::vector<std::string>& arr) {
        if (arr.empty()) return "-1";
        
        std::string prefix = arr[0];
        for (int i = 1; i < arr.size(); i++) {
            while (arr[i].find(prefix) != 0) {
                prefix = prefix.substr(0, prefix.size() - 1);
                if (prefix.empty()) return "-1";
            }
        }
        return prefix;
    }
};

int main() {
    Solution solution;
    std::vector<std::string> arr1 = {"geeksforgeeks", "geeks", "geek", "geezer"};
    std::cout << solution.longestCommonPrefix(arr1) << std::endl;  // Output: gee

    std::vector<std::string> arr2 = {"hello", "world"};
    std::cout << solution.longestCommonPrefix(arr2) << std::endl;  // Output: -1
}
// Java ********************************************************************************************************************************************/
//Approach (Using Substring)
// TC:𝑂(n * m) n: Number of strings in the array, m: Length of the smallest string in the array.
// SC:𝑂(m) m: Length of the smallest string in the array.
class Solution {
    public String longestCommonPrefix(String arr[]) {
        if (arr == null || arr.length == 0) {
            return "-1";
        }

        String prefix = arr[0];
        for (int i = 1; i < arr.length; i++) {
            while (arr[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "-1";
                }
            }
        }
        return prefix;
    }
}

// C# ********************************************************************************************************************************************/
//Approach (Using Substring)
// TC:𝑂(n * m) n: Number of strings in the array, m: Length of the smallest string in the array.
// SC:𝑂(m) m: Length of the smallest string in the array.
using System;

public class Solution {
    public string LongestCommonPrefix(string[] arr) {
        if (arr == null || arr.Length == 0) {
            return "-1";
        }

        string prefix = arr[0];
        for (int i = 1; i < arr.Length; i++) {
            while (arr[i].IndexOf(prefix) != 0) {
                prefix = prefix.Substring(0, prefix.Length - 1);
                if (prefix == "") {
                    return "-1";
                }
            }
        }
        return prefix;
    }

    public static void Main(string[] args) {
        Solution solution = new Solution();
        string[] arr1 = {"geeksforgeeks", "geeks", "geek", "geezer"};
        Console.WriteLine(solution.LongestCommonPrefix(arr1));  // Output: gee

        string[] arr2 = {"hello", "world"};
        Console.WriteLine(solution.LongestCommonPrefix(arr2));  // Output: -1
    }
}

// JavaScript ********************************************************************************************************************************************/
//Approach (Using Substring)
// TC:𝑂(n * m) n: Number of strings in the array, m: Length of the smallest string in the array.
// SC:𝑂(m) m: Length of the smallest string in the array.
class Solution {
    longestCommonPrefix(arr) {
        // code here
        if(arr === null || arr.legth === 0){
            return "-1"
        }
        
        let prefix = arr[0];
        for(let i = 0; i < arr.length; i++){
            while(arr[i].indexOf(prefix) !== 0){
                prefix = prefix.substring(0, prefix.length - 1);
                if(prefix === ""){
                    return "-1";
                }
            }
        }
        return prefix;
    }
}
