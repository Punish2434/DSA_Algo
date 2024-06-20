/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : 
    GFG Link               : https://www.geeksforgeeks.org/problems/integral-points-in-triangle5026/1
*/


/ C++ ******************************************************************************************************************************************/

// Expected Time Complexity: O(Log2109)
// Expected Auxillary Space: O(1)
  
#include <iostream>
#include <cmath>
using namespace std;

class Solution {
public:
    long internalCount(long p[], long q[], long r[]) {
        long area = abs(p[0] * (q[1] - r[1]) + q[0] * (r[1] - p[1]) + r[0] * (p[1] - q[1]));
        long boundaryPoints = gcd(abs(p[0] - q[0]), abs(p[1] - q[1])) +
                              gcd(abs(q[0] - r[0]), abs(q[1] - r[1])) +
                              gcd(abs(r[0] - p[0]), abs(r[1] - p[1]));
        return (area - boundaryPoints + 2) / 2;
    }

private:
    long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
};

int main() {
    Solution solution;
    long p1[] = {0, 0};
    long p2[] = {0, 5};
    long p3[] = {5, 0};
    cout << solution.internalCount(p1, p2, p3) << endl; // Output: 6

    long p4[] = {62, -3};
    long p5[] = {5, -45};
    long p6[] = {-19, -23};
    cout << solution.internalCount(p4, p5, p6) << endl; // Output: 1129

    return 0;
}

/ Java ******************************************************************************************************************************************/


// Expected Time Complexity: O(Log2109)
// Expected Auxillary Space: O(1)
class Solution {

    public long InternalCount(long p[], long q[], long r[]) {
        // Calculate the area of the triangle using the determinant method
        long area = Math.abs(p[0]*(q[1] - r[1]) + q[0]*(r[1] - p[1]) + r[0]*(p[1] - q[1]));

        // Calculate the number of boundary points using the GCD method
        long boundaryPoints = gcd(Math.abs(p[0] - q[0]), Math.abs(p[1] - q[1])) +
                              gcd(Math.abs(q[0] - r[0]), Math.abs(q[1] - r[1])) +
                              gcd(Math.abs(r[0] - p[0]), Math.abs(r[1] - p[1]));

        // Use Pick's Theorem to calculate the number of interior points
        return (area - boundaryPoints + 2) / 2;
    }

    // Helper function to calculate gcd of two numbers
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
   }
/ C# ******************************************************************************************************************************************/

// Expected Time Complexity: O(Log2109)
// Expected Auxillary Space: O(1)
  using System;

public class Solution {

    public long InternalCount(long[] p, long[] q, long[] r) {
        long area = Math.Abs(p[0] * (q[1] - r[1]) + q[0] * (r[1] - p[1]) + r[0] * (p[1] - q[1]));
        long boundaryPoints = Gcd(Math.Abs(p[0] - q[0]), Math.Abs(p[1] - q[1])) +
                              Gcd(Math.Abs(q[0] - r[0]), Math.Abs(q[1] - r[1])) +
                              Gcd(Math.Abs(r[0] - p[0]), Math.Abs(r[1] - p[1]));
        return (area - boundaryPoints + 2) / 2;
    }

    private long Gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void Main(string[] args) {
        Solution solution = new Solution();
        long[] p1 = {0, 0};
        long[] p2 = {0, 5};
        long[] p3 = {5, 0};
        Console.WriteLine(solution.InternalCount(p1, p2, p3)); // Output: 6

        long[] p4 = {62, -3};
        long[] p5 = {5, -45};
        long[] p6 = {-19, -23};
        Console.WriteLine(solution.InternalCount(p4, p5, p6)); // Output: 1129
    }
}


    
