/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : Google, facebook(Meta),Amazon, Microsoft, Apple
    Leetcode Link               : https://leetcode.com/problems/sum-of-square-numbers/
*/

/ C++ ******************************************************************************************************************************************/
//Using simple Two Pointers

//T.C : O(sqrt(c)) 
//S.C : O(1)
#include <iostream>
#include <cmath>
using namespace std;

bool judgeSquareSum(int c) {
    if (c < 0) {
        return false;
    }
    
    long left = 0;
    long right = static_cast<long>(sqrt(c));

    while (left <= right) {
        long sum = left * left + right * right;
        if (sum == c) {
            return true;
        } else if (sum < c) {
            left++;
        } else {
            right--;
        }
    }
    return false;
}

int main() {
    cout << judgeSquareSum(5) << endl;       // Output: 1 (true)
    cout << judgeSquareSum(3) << endl;       // Output: 0 (false)
    cout << judgeSquareSum(2147483600) << endl;  // Output: 1 (true)
    return 0;
}



/ Java ******************************************************************************************************************************************/
//Using simple Two Pointers

//T.C : O(sqrt(c)) 
//S.C : O(1)

class Solution {
    public static boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        
        long left = 0;
        long right = (long) Math.sqrt(c);

        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test cases
        int c1 = 5;
        int c2 = 3;

        System.out.println("Input: " + c1);
        System.out.println("Output: " + judgeSquareSum(c1)); // Output: true

        System.out.println("Input: " + c2);
        System.out.println("Output: " + judgeSquareSum(c2)); // Output: false
    }
}
/ C# ******************************************************************************************************************************************/
//Using simple Two Pointers

//T.C : O(sqrt(c)) 
//S.C : O(1)
using System;

public class Solution {
    public static bool JudgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        
        long left = 0;
        long right = (long)Math.Sqrt(c);

        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void Main() {
        Console.WriteLine(JudgeSquareSum(5));       // Output: True
        Console.WriteLine(JudgeSquareSum(3));       // Output: False
        Console.WriteLine(JudgeSquareSum(2147483600));  // Output: True
    }
}

