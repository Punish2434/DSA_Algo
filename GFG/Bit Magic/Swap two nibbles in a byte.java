/*     Scroll below to see JAVA code and C#  also  */
/*
    Company Tags                : Accolite,Samsung,Cisco,Qualcomm
    Leetcode Link               : https://www.geeksforgeeks.org/problems/swap-two-nibbles-in-a-byte0446/1

*/
/ C++ ********************************************************************************************************************************/
//Approach (Optimal)
// Time Complexity:- O(1)
// Space Complexity:- O(1)

#include <iostream>

int swapNibbles(int n) {
    // Extract lower nibble and shift left by 4 bits
    int lowerNibble = (n & 0x0F) << 4;
    // Extract upper nibble and shift right by 4 bits
    int upperNibble = (n & 0xF0) >> 4;
    // Combine the two shifted nibbles
    return lowerNibble | upperNibble;
}

int main() {
    std::cout << swapNibbles(100) << std::endl; // Output: 70
    std::cout << swapNibbles(129) << std::endl; // Output: 24
    return 0;
}
/ Java ********************************************************************************************************************************/


// Time Complexity:- O(1)
// Space Complexity:- O(1)
class Solution {
    public int swapNibbles(int n) {
        // Extract lower nibble and shift left by 4 bits
        int lowerNibble = (n & 0x0F) << 4;
        // Extract upper nibble and shift right by 4 bits
        int upperNibble = (n & 0xF0) >> 4;
        // Combine the two shifted nibbles
        return lowerNibble | upperNibble;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.swapNibbles(100)); // Output: 70
        System.out.println(sol.swapNibbles(129)); // Output: 24
    }
}
/ C# ********************************************************************************************************************************/

// Time Complexity:- O(1)
// Space Complexity:- O(1)
using System;

class Solution {
    public int SwapNibbles(int n) {
        // Extract lower nibble and shift left by 4 bits
        int lowerNibble = (n & 0x0F) << 4;
        // Extract upper nibble and shift right by 4 bits
        int upperNibble = (n & 0xF0) >> 4;
        // Combine the two shifted nibbles
        return lowerNibble | upperNibble;
    }

    static void Main(string[] args) {
        Solution sol = new Solution();
        Console.WriteLine(sol.SwapNibbles(100)); // Output: 70
        Console.WriteLine(sol.SwapNibbles(129)); // Output: 24
    }
}

