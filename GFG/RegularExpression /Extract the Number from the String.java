/*     Scroll below to see JAVA code C# also    */
/*
    Company Tags                : 
    Leetcode Link               : https://leetcode.com/problems/count-number-of-nice-subarrays
*/

/ C++ ********************************************************************************************************************************/
//Approach-1 ()
//T.C : O(n)
//S.C : O(n)
  #include <iostream>
#include <string>
#include <regex>
using namespace std;

class Solution {
public:
    long long extractNumber(const string& sentence) {
        regex pattern("\\b\\d+\\b");
        sregex_iterator begin(sentence.begin(), sentence.end(), pattern), end;
        
        long long maxNumber = -1;
        
        for (auto it = begin; it != end; ++it) {
            string numberStr = it->str();
            if (numberStr.find('9') == string::npos) {
                long long number = stoll(numberStr);
                if (number > maxNumber) {
                    maxNumber = number;
                }
            }
        }
        
        return maxNumber;
    }
};

int main() {
    Solution solution;
    string sentence1 = "This is alpha 5057 and 97";
    string sentence2 = "Another input 9007";
    cout << solution.extractNumber(sentence1) << endl; // Output: 5057
    cout << solution.extractNumber(sentence2) << endl; // Output: -1
}
/ Java ********************************************************************************************************************************/
//T.C : O(n)
//S.C : O(n)
import java.util.regex.*;

class Solution {
    long ExtractNumber(String sentence) {
        // Use regular expression to find all numbers in the sentence
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(sentence);
        
        long maxNumber = -1;
        
        while (matcher.find()) {
            String numberStr = matcher.group();
            if (!numberStr.contains("9")) {
                long number = Long.parseLong(numberStr);
                if (number > maxNumber) {
                    maxNumber = number;
                }
            }
        }
        
        return maxNumber;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String sentence1 = "This is alpha 5057 and 97";
        String sentence2 = "Another input 9007";
        System.out.println(solution.ExtractNumber(sentence1)); // Output: 5057
        System.out.println(solution.ExtractNumber(sentence2)); // Output: -1
    }
}

/ C# ********************************************************************************************************************************/
//T.C : O(n)
//S.C : O(n)
using System;
using System.Text.RegularExpressions;

class Solution {
    public long ExtractNumber(string sentence) {
        Regex pattern = new Regex(@"\b\d+\b");
        MatchCollection matches = pattern.Matches(sentence);
        
        long maxNumber = -1;
        
        foreach (Match match in matches) {
            string numberStr = match.Value;
            if (!numberStr.Contains("9")) {
                long number = long.Parse(numberStr);
                if (number > maxNumber) {
                    maxNumber = number;
                }
            }
        }
        
        return maxNumber;
    }

    static void Main(string[] args) {
        Solution solution = new Solution();
        string sentence1 = "This is alpha 5057 and 97";
        string sentence2 = "Another input 9007";
        Console.WriteLine(solution.ExtractNumber(sentence1)); // Output: 5057
        Console.WriteLine(solution.ExtractNumber(sentence2)); // Output: -1
    }
}
