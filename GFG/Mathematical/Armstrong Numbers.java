
/*     Scroll below to see JAVA code and C#    */
/*
    Company Tags                : VMWare,Oracle
    GFG Link                    :https://www.geeksforgeeks.org/problems/armstrong-numbers2727/1
*/


/ C++ ****************************************************************************************************************************************/

//T.C : O(1)
//S.C : O(1)
  
#include <iostream>
#include <cmath>
#include <string>

class Solution {
public:
    static std::string armstrongNumber(int n) {
        int originalNumber = n;
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += std::pow(digit, 3);
            n /= 10;
        }
        return (sum == originalNumber) ? "true" : "false";
    }
};

int main() {
    int n = 153; // Example number
    std::cout << Solution::armstrongNumber(n) << std::endl;
    return 0;
}

  
/ Java ****************************************************************************************************************************************/

//T.C : O(1)
//S.C : O(1)

class Solution {
    static String armstrongNumber(int n) {
        int originalNumber = n;
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, 3);
            n /= 10;
        }
        return (sum == originalNumber) ? "true" : "false";
    }

    
}

/ C# ****************************************************************************************************************************************/


//T.C : O(1)
//S.C : O(1)
using System;

public class Solution {
    public static string ArmstrongNumber(int n) {
        int originalNumber = n;
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += (int)Math.Pow(digit, 3);
            n /= 10;
        }
        return (sum == originalNumber) ? "true" : "false";
    }
}

class Program {
    static void Main() {
        int n = 153; // Example number
        Console.WriteLine(Solution.ArmstrongNumber(n));
    }
}
// Key Changes:
// Language Syntax: Adapted the syntax to fit C++ and C# conventions.
// Math Functions: Used std::pow in C++ and Math.Pow in C# for calculating the power of digits.
// Return Type: Both C++ and C# methods return std::string and string respectively.
// Main Function: Added a main function to demonstrate the usage in both languages.
// Type Casting: In C#, added an explicit cast (int) for the result of Math.Pow to ensure the sum is correctly calculated as an integer.
