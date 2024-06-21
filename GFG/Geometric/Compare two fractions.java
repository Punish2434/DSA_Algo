/*     Scroll below to see JAVA code also    */
/*
    Company Tags                : will soon update
    Leetcode Link               : https://leetcode.com/problems/grumpy-bookstore-owner
*/


/ C++ ***********************************************************************************************************************************************/
//T.C : O(n)
//S.C : O(1)
  
#include <iostream>
#include <string>
#include <sstream>

using namespace std;

class Solution {
public:
    string compareFrac(string str) {
        stringstream ss(str);
        string frac1, frac2;
        
        getline(ss, frac1, ',');
        ss.ignore(1, ' ');
        getline(ss, frac2);
        
        int a, b, c, d;
        sscanf(frac1.c_str(), "%d/%d", &a, &b);
        sscanf(frac2.c_str(), "%d/%d", &c, &d);
        
        int lhs = a * d;
        int rhs = b * c;
        
        if (lhs > rhs) {
            return frac1;
        } else if (lhs < rhs) {
            return frac2;
        } else {
            return "equal";
        }
    }
};

// Test cases
int main() {
    Solution sol;
    cout << sol.compareFrac("5/6, 11/45") << endl;  // Output: 5/6
    cout << sol.compareFrac("8/1, 8/1") << endl;    // Output: equal
    cout << sol.compareFrac("10/17, 9/10") << endl; // Output: 9/10
    return 0;
}
/ Java ***********************************************************************************************************************************************/
//T.C : O(n)
//S.C : O(1)
class Solution {

    String compareFrac(String str) {
        // Split the input string by ", "
        String[] fractions = str.split(", ");
        
        // Split the fractions into numerator and denominator
        String[] fraction1 = fractions[0].split("/");
        String[] fraction2 = fractions[1].split("/");
        
        // Parse the numerators and denominators
        int a = Integer.parseInt(fraction1[0]);
        int b = Integer.parseInt(fraction1[1]);
        int c = Integer.parseInt(fraction2[0]);
        int d = Integer.parseInt(fraction2[1]);
        
        // Compare the fractions by cross multiplication to avoid floating point precision issues
        int lhs = a * d; // left hand side of the comparison (a/b > c/d is equivalent to a*d > c*b)
        int rhs = b * c; // right hand side of the comparison
        
        // Return the result based on the comparison
        if (lhs > rhs) {
            return fractions[0];
        } else if (lhs < rhs) {
            return fractions[1];
        } else {
            return "equal";
        }
    }
  
/ C# ***********************************************************************************************************************************************/
//T.C : O(n)
//S.C : O(1)
  
using System;

public class Solution {
    public string CompareFrac(string str) {
        string[] fractions = str.Split(", ");
        string[] fraction1 = fractions[0].Split('/');
        string[] fraction2 = fractions[1].Split('/');
        
        int a = int.Parse(fraction1[0]);
        int b = int.Parse(fraction1[1]);
        int c = int.Parse(fraction2[0]);
        int d = int.Parse(fraction2[1]);
        
        int lhs = a * d;
        int rhs = b * c;
        
        if (lhs > rhs) {
            return fractions[0];
        } else if (lhs < rhs) {
            return fractions[1];
        } else {
            return "equal";
        }
    }
    
    public static void Main(string[] args) {
        Solution sol = new Solution();
        Console.WriteLine(sol.CompareFrac("5/6, 11/45"));  // Output: 5/6
        Console.WriteLine(sol.CompareFrac("8/1, 8/1"));    // Output: equal
        Console.WriteLine(sol.CompareFrac("10/17, 9/10")); // Output: 9/10
    }
}

  
