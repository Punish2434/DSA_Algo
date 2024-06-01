/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                :
    Leetcode Link               : https://leetcode.com/problems/largest-local-values-in-a-matrix
*/


/ C++ ***************************************************************************************************************************************/
//T.C : O(n)
//S.C : O(1) 
  
#include <iostream>
#include <string>
#include <cmath>

class Solution {
public:
    int scoreOfString(const std::string& s) {
        int score = 0;
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            score += std::abs(s[i] - s[i + 1]);
        }
        return score;
    }
};

int main() {
    Solution solution;
    std::cout << "Score for \"hello\": " << solution.scoreOfString("hello") << std::endl; // Output: 13
    std::cout << "Score for \"zaz\": " << solution.scoreOfString("zaz") << std::endl;     // Output: 50
    return 0;
}

/ Java ***************************************************************************************************************************************/

//T.C : O(n)
//S.C : O(1) 
class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        int n = s.length();
        for (int i = 0; i < n-1; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return score;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.scoreOfString("hello")); // Output: 13
        System.out.println(solution.scoreOfString("zaz"));   // Output: 50
    }
}
/ C# ***************************************************************************************************************************************/
//T.C : O(n)
//S.C : O(1) 
using System;

class Solution {
    public int ScoreOfString(string s) {
        int score = 0;
        for (int i = 0; i < s.Length - 1; i++) {
            score += Math.Abs(s[i] - s[i + 1]);
        }
        return score;
    }

    static void Main(string[] args) {
        Solution solution = new Solution();
        Console.WriteLine($"Score for \"hello\": {solution.ScoreOfString("hello")}"); // Output: 13
        Console.WriteLine($"Score for \"zaz\": {solution.ScoreOfString("zaz")}");     // Output: 50
    }
}
