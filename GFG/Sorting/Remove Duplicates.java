/*         Scroll below to see JAVA code and C# also        */

    // Company Tags                : Microsoft
    // GFG Link               : https://www.geeksforgeeks.org/problems/remove-duplicates3034/1
// C++ ********************************************************************************************************************************************/
//Approach-1 (Using HashSet and StringBuilder)
// TC:𝑂(n)
// SC:𝑂(1)
#include <iostream>
#include <unordered_set>
#include <string>

class Solution {
public:
    std::string removeDups(const std::string& s) {
        std::unordered_set<char> seen;
        std::string result;

        for (char c : s) {
            if (seen.find(c) == seen.end()) {
                seen.insert(c);
                result += c;
            }
        }

        return result;
    }
};

// Test cases
int main() {
    Solution solution;
    std::cout << "Input: zvvo Output: " << solution.removeDups("zvvo") << std::endl; // Output: "zvo"
    std::cout << "Input: gfg Output: " << solution.removeDups("gfg") << std::endl;   // Output: "gf"
    return 0;
}


// Java ********************************************************************************************************************************************/
//Approach-1 (Using HashSet and StringBuilder)
// TC:𝑂(n)
// SC:𝑂(1)
import java.util.HashSet;

class Solution {
    String removeDups(String str) {
        // Use a HashSet to track seen characters
        HashSet<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();

        // Iterate over the characters in the string
        for (char c : str.toCharArray()) {
            // If the character has not been seen, append it to the result
            if (!seen.contains(c)) {
                seen.add(c);
                result.append(c);
            }
        }

        // Convert the StringBuilder to a String and return it
        return result.toString();
    }
    
    public static void main(String[] args) {
        // Test cases
        Solution solution = new Solution();
        String str1 = "zvvo";
        String str2 = "gfg";
        
        System.out.println("Input: " + str1 + " Output: " + solution.removeDups(str1)); // Output: "zvo"
        System.out.println("Input: " + str2 + " Output: " + solution.removeDups(str2)); // Output: "gf"
    }
}

// C# ********************************************************************************************************************************************/
//Approach-1 (Using HashSet and StringBuilder)
// TC:𝑂(n)
// SC:𝑂(1)
using System;
using System.Collections.Generic;
using System.Text;

class Solution {
    public string RemoveDups(string s) {
        HashSet<char> seen = new HashSet<char>();
        StringBuilder result = new StringBuilder();

        foreach (char c in s) {
            if (!seen.Contains(c)) {
                seen.Add(c);
                result.Append(c);
            }
        }

        return result.ToString();
    }

    static void Main(string[] args) {
        Solution solution = new Solution();
        Console.WriteLine("Input: zvvo Output: " + solution.RemoveDups("zvvo")); // Output: "zvo"
        Console.WriteLine("Input: gfg Output: " + solution.RemoveDups("gfg"));   // Output: "gf"
    }
}


// JavaScript ********************************************************************************************************************************************/
//Approach-1 (Using HashSet and StringBuilder)
// TC:𝑂(n)
// SC:𝑂(1)
class Solution {
    removeDups(s) {
        let seen = new Set();
        let result = [];

        for (let char of s) {
            if (!seen.has(char)) {
                seen.add(char);
                result.push(char);
            }
        }

        return result.join('');
    }
}

// Test cases
let solution = new Solution();
console.log(solution.removeDups("zvvo")); // Output: "zvo"
console.log(solution.removeDups("gfg"));  // Output: "gf"
