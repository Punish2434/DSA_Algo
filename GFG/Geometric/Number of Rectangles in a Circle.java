/*     Scroll below to see JAVA code and C#  also      */
/*
    Comoany Tags                :
    GFG Link                    : https://leetcode.com/problems/most-profit-assigning-work/description/
*/


/ C++ *************************************************************************************************************************/

// Time Complexity: 𝑂 ( 𝑟 2 ) O(r 2 )
// Space Complexity: 𝑂 ( 1 ) O(1)
#include <iostream>
#include <cmath>

class Solution {
public:
    int rectanglesInCircle(int r) {
        int count = 0;

        // Iterate over possible width and height values
        for (int width = 1; width <= 2 * r; width++) {
            for (int height = 1; height <= 2 * r; height++) {
                // Calculate half width and half height
                double halfWidth = width / 2.0;
                double halfHeight = height / 2.0;

                // Calculate the diagonal distance from center to a corner
                double diagonal = std::sqrt(halfWidth * halfWidth + halfHeight * halfHeight);

                // Check if the diagonal is within the circle's radius
                if (diagonal <= r) {
                    count++;
                }
            }
        }

        return count;
    }
};

int main() {
    Solution sol;
    std::cout << sol.rectanglesInCircle(1) << std::endl; // Output: 1
    std::cout << sol.rectanglesInCircle(2) << std::endl; // Output: 8
    return 0;
}


/ Java *************************************************************************************************************************/
// Time Complexity: 𝑂 ( 𝑟 2 ) O(r 2 )
// Space Complexity: 𝑂 ( 1 ) O(1)


class Solution {
    int rectanglesInCircle(int r) {
        int count = 0;
        
        // Iterate over possible width and height values
        for (int width = 1; width <= 2 * r; width++) {
            for (int height = 1; height <= 2 * r; height++) {
                // Calculate half width and half height
                double halfWidth = width / 2.0;
                double halfHeight = height / 2.0;
                
                // Calculate the diagonal distance from center to a corner
                double diagonal = Math.sqrt(halfWidth * halfWidth + halfHeight * halfHeight);
                
                // Check if the diagonal is within the circle's radius
                if (diagonal <= r) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    
}
/ C# *************************************************************************************************************************/
// Time Complexity: 𝑂 ( 𝑟 2 ) O(r 2 )
// Space Complexity: 𝑂 ( 1 ) O(1)
using System;

class Solution {
    public int RectanglesInCircle(int r) {
        int count = 0;

        // Iterate over possible width and height values
        for (int width = 1; width <= 2 * r; width++) {
            for (int height = 1; height <= 2 * r; height++) {
                // Calculate half width and half height
                double halfWidth = width / 2.0;
                double halfHeight = height / 2.0;

                // Calculate the diagonal distance from center to a corner
                double diagonal = Math.Sqrt(halfWidth * halfWidth + halfHeight * halfHeight);

                // Check if the diagonal is within the circle's radius
                if (diagonal <= r) {
                    count++;
                }
            }
        }

        return count;
    }

    static void Main(string[] args) {
        Solution sol = new Solution();
        Console.WriteLine(sol.RectanglesInCircle(1)); // Output: 1
        Console.WriteLine(sol.RectanglesInCircle(2)); // Output: 8
    }
}

