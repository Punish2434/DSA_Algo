/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                :
    GFG Link               : https://www.geeksforgeeks.org/problems/help-nobita0532/1
*/


/ C++ ***************************************************************************************************************************************/
//Time Complexity: O(|s|)
//Auxiliary Space: O(1) 
#include <iostream>
#include <string>
#include <cmath>

class Solution {
public:
    std::string oddEven(const std::string& s) {
        int freq[26] = {0}; // Initialize frequency array with zeros
        
        // Count frequency of each character in the string
        for (char c : s) {
            freq[c - 'a']++;
        }
        
        int x = 0; // count of distinct characters that occupy even positions and have even frequency
        int y = 0; // count of distinct characters that occupy odd positions and have odd frequency
        
        for (int i = 0; i < 26; i++) {
            int position = i + 1; // 1-based position in the alphabet
            int frequency = freq[i];
            
            if (frequency > 0) {
                if (position % 2 == 0 && frequency % 2 == 0) {
                    x++;
                } else if (position % 2 != 0 && frequency % 2 != 0) {
                    y++;
                }
            }
        }
        
        int sum = x + y;
        return (sum % 2 == 0) ? "EVEN" : "ODD";
    }
};

int main() {
    Solution solution;
    std::cout << "Result for \"hello\": " << solution.oddEven("hello") << std::endl; // Output: ODD
    std::cout << "Result for \"zaz\": " << solution.oddEven("zaz") << std::endl;     // Output: EVEN
    return 0;
}

/ Java ***************************************************************************************************************************************/
//Time Complexity: O(|s|)
//Auxiliary Space: O(1) 
class Solution {
    public String oddEven(String s) {
        int[] freq = new int[26];
        
        // Count frequency of each character in the string
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        int x = 0; // count of distinct characters that occupy even positions and have even frequency
        int y = 0; // count of distinct characters that occupy odd positions and have odd frequency
        
        for (int i = 0; i < 26; i++) {
            int position = i + 1; // 1-based position in the alphabet
            int frequency = freq[i];
            
            if (frequency > 0) {
                if (position % 2 == 0 && frequency % 2 == 0) {
                    x++;
                } else if (position % 2 != 0 && frequency % 2 != 0) {
                    y++;
                }
            }
        }
        
        int sum = x + y;
        return sum % 2 == 0 ? "EVEN" : "ODD";
    }
}
  / C# ***************************************************************************************************************************************/
//Time Complexity: O(|s|)
//Auxiliary Space: O(1) 
    using System;

class Solution {
    public string OddEven(string s) {
        int[] freq = new int[26]; // Initialize frequency array with zeros
        
        // Count frequency of each character in the string
        foreach (char c in s) {
            freq[c - 'a']++;
        }
        
        int x = 0; // count of distinct characters that occupy even positions and have even frequency
        int y = 0; // count of distinct characters that occupy odd positions and have odd frequency
        
        for (int i = 0; i < 26; i++) {
            int position = i + 1; // 1-based position in the alphabet
            int frequency = freq[i];
            
            if (frequency > 0) {
                if (position % 2 == 0 && frequency % 2 == 0) {
                    x++;
                } else if (position % 2 != 0 && frequency % 2 != 0) {
                    y++;
                }
            }
        }
        
        int sum = x + y;
        return (sum % 2 == 0) ? "EVEN" : "ODD";
    }

    static void Main(string[] args) {
        Solution solution = new Solution();
        Console.WriteLine($"Result for \"hello\": {solution.OddEven("hello")}"); // Output: ODD
        Console.WriteLine($"Result for \"zaz\": {solution.OddEven("zaz")}");     // Output: EVEN
    }
}


