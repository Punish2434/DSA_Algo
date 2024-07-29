/*         Scroll below to see JAVA code and C# also        */

    // Company Tags                : Goldman Sachs, Amazon, IBM
    // Leetcode Link               : https://leetcode.com/problems/count-number-of-teams/
// C++ ********************************************************************************************************************************************/
//Approach-1 (Using  brute-force approach)
// TC:𝑂((n3)
// SC:𝑂(1)
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int numTeams(vector<int>& rating) {
        int n = rating.size();
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((rating[i] < rating[j] && rating[j] < rating[k]) || (rating[i] > rating[j] && rating[j] > rating[k])) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
};

int main() {
    Solution sol;
    vector<int> rating1 = {2, 5, 3, 4, 1};
    vector<int> rating2 = {2, 1, 3};
    vector<int> rating3 = {1, 2, 3, 4};

    cout << sol.numTeams(rating1) << endl; // Output: 3
    cout << sol.numTeams(rating2) << endl; // Output: 0
    cout << sol.numTeams(rating3) << endl; // Output: 4

    return 0;
}
// Java ********************************************************************************************************************************************/
//Approach-1 (Using  dynamic programming approach)
// TC:𝑂((n2)
// SC:𝑂(1)
class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        if (n < 3) return 0;
        
        int[] leftLess = new int[n];
        int[] leftGreater = new int[n];
        int[] rightLess = new int[n];
        int[] rightGreater = new int[n];
        
        // Fill leftLess and leftGreater
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    leftLess[i]++;
                } else if (rating[j] > rating[i]) {
                    leftGreater[i]++;
                }
            }
        }
        
        // Fill rightLess and rightGreater
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rating[j] < rating[i]) {
                    rightLess[i]++;
                } else if (rating[j] > rating[i]) {
                    rightGreater[i]++;
                }
            }
        }
        
        int count = 0;
        // Count valid teams
        for (int i = 0; i < n; i++) {
            count += leftLess[i] * rightGreater[i];
            count += leftGreater[i] * rightLess[i];
        }
        
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] rating1 = {2, 5, 3, 4, 1};
        int[] rating2 = {2, 1, 3};
        int[] rating3 = {1, 2, 3, 4};
        
        System.out.println(sol.numTeams(rating1)); // Output: 3
        System.out.println(sol.numTeams(rating2)); // Output: 0
        System.out.println(sol.numTeams(rating3)); // Output: 4
    }
}

// C# ********************************************************************************************************************************************/
//Approach-1 (Using  dynamic programming approach)
// TC:𝑂((n2)
// SC:𝑂(1)
using System;

class Solution {
    public int NumTeams(int[] rating) {
        int n = rating.Length;
        if (n < 3) return 0;

        int[] leftLess = new int[n];
        int[] leftGreater = new int[n];
        int[] rightLess = new int[n];
        int[] rightGreater = new int[n];

        // Fill leftLess and leftGreater
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    leftLess[i]++;
                } else if (rating[j] > rating[i]) {
                    leftGreater[i]++;
                }
            }
        }

        // Fill rightLess and rightGreater
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rating[j] < rating[i]) {
                    rightLess[i]++;
                } else if (rating[j] > rating[i]) {
                    rightGreater[i]++;
                }
            }
        }

        int count = 0;
        // Count valid teams
        for (int i = 0; i < n; i++) {
            count += leftLess[i] * rightGreater[i];
            count += leftGreater[i] * rightLess[i];
        }

        return count;
    }

    static void Main() {
        Solution sol = new Solution();

        int[] rating1 = {2, 5, 3, 4, 1};
        int[] rating2 = {2, 1, 3};
        int[] rating3 = {1, 2, 3, 4};

        Console.WriteLine(sol.NumTeams(rating1)); // Output: 3
        Console.WriteLine(sol.NumTeams(rating2)); // Output: 0
        Console.WriteLine(sol.NumTeams(rating3)); // Output: 4
    }
}

