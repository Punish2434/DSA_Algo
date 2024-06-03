/*     Scroll below to see JAVA code and C# also  */
/*
    Company Tags                : AMAZON
    Leetcode Link               : https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/
*/

/ C++ ********************************************************************************************************/
//Simple iteration
//T.C : O(n)
//S.C : O(1)
#include <iostream>
using namespace std;

class Solution {
public:
    int appendCharacters(string s, string t) {
        int sIndex = 0, tIndex = 0;
        int sLength = s.length(), tLength = t.length();

        // Traverse through the string s
        while (sIndex < sLength && tIndex < tLength) {
            // If characters match, move the pointer of t
            if (s[sIndex] == t[tIndex]) {
                tIndex++;
            }
            // Always move the pointer of s
            sIndex++;
        }

        // The number of characters needed to be appended is the remaining characters in t
        return tLength - tIndex;
    }
};

int main() {
    Solution sol;
    string s = "example"; // Replace with your input
    string t = "sample"; // Replace with your input
    cout << "Characters to append: " << sol.appendCharacters(s, t) << endl;
    return 0;
}


/Java ********************************************************************************************************/
//Simple iteration
//T.C : O(n)
//S.C : O(1)

class Solution {
    public int appendCharacters(String s, String t) {
        int sIndex = 0, tIndex = 0;
        int sLength = s.length(), tLength = t.length();
        
        // Traverse through the string s
        while (sIndex < sLength && tIndex < tLength) {
            // If characters match, move the pointer of t
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                tIndex++;
            }
            // Always move the pointer of s
            sIndex++;
        }
        
        // The number of characters needed to be appended is the remaining characters in t
        return tLength - tIndex;
    }
}

/C#  ********************************************************************************************************/
//Simple iteration
//T.C : O(n)
//S.C : O(1)
using System;

public class Solution {
    public int AppendCharacters(string s, string t) {
        int sIndex = 0, tIndex = 0;
        int sLength = s.Length, tLength = t.Length;

        // Traverse through the string s
        while (sIndex < sLength && tIndex < tLength) {
            // If characters match, move the pointer of t
            if (s[sIndex] == t[tIndex]) {
                tIndex++;
            }
            // Always move the pointer of s
            sIndex++;
        }

        // The number of characters needed to be appended is the remaining characters in t
        return tLength - tIndex;
    }

    public static void Main(string[] args) {
        Solution sol = new Solution();
        string s = "example"; // Replace with your input
        string t = "sample"; // Replace with your input
        Console.WriteLine("Characters to append: " + sol.AppendCharacters(s, t));
    }
}
