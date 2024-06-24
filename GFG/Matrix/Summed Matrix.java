/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : 
    GFG Link               : https://www.geeksforgeeks.org/problems/summed-matrix5834/1
*/

/ C++ ********************************************************************************************************************************************/
// Time Complexity: 𝑂 ( 1 ) 
// Space Complexity: 𝑂 ( 1 ) 
  
  #include <iostream>
#include <algorithm>
using namespace std;

class Solution {
public:
    static long long sumMatrix(long long n, long long q) {
        long long start = max(1LL, q - n);
        long long end = min(n, q - 1);

        if (start > end) {
            return 0;
        }
        return end - start + 1;
    }
};

int main() {
    cout << Solution::sumMatrix(4, 7) << endl; // Output: 2
    cout << Solution::sumMatrix(5, 4) << endl; // Output: 3
    return 0;
}

/ Java ********************************************************************************************************************************************/
// Time Complexity: 𝑂 ( 1 ) 
// Space Complexity: 𝑂 ( 1 ) 

class Solution {
    static long sumMatrix(long n, long q) {
        long start = Math.max(1, q - n);
        long end = Math.min(n, q - 1);

        if (start > end) {
            return 0;
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        System.out.println(sumMatrix(4, 7)); // Output: 2
        System.out.println(sumMatrix(5, 4)); // Output: 3
    }
}
/ C# ********************************************************************************************************************************************/
// Time Complexity: 𝑂 ( 1 ) 
// Space Complexity: 𝑂 ( 1 ) 

using System;

class Solution {
    public static long SumMatrix(long n, long q) {
        long start = Math.Max(1, q - n);
        long end = Math.Min(n, q - 1);

        if (start > end) {
            return 0;
        }
        return end - start + 1;
    }

    public static void Main(string[] args) {
        Console.WriteLine(SumMatrix(4, 7)); // Output: 2
        Console.WriteLine(SumMatrix(5, 4)); // Output: 3
    }
}
