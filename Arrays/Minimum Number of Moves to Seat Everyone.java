/*    Scroll below to see JAVA code and C# also  */
/*
    Company Tags                : 
    Leetcode Link               : https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/
*/
/ C++ **************************************************************************************************************************/
// Time Complexity: O(n log n)
// Space Complexity: O(n)
  
#include <algorithm>
#include <vector>

class Solution {
public:
    int minMovesToSeat(std::vector<int>& seats, std::vector<int>& students) {
        std::sort(seats.begin(), seats.end());
        std::sort(students.begin(), students.end());
        
        int moves = 0;
        int n = seats.size();
        for (int i = 0; i < n; i++) {
            moves += std::abs(seats[i] - students[i]);
        }
        return moves;
    }
};
/ Java **************************************************************************************************************************/
// Time Complexity: O(n log n)
// Space Complexity: O(n)

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        
        int moves = 0;
        int n = seats.length;
        for(int i = 0; i < n; i++) { // Change the loop condition to i < n
            moves += Math.abs(seats[i] - students[i]);
        }
        return moves;
    }

}

/ C# **************************************************************************************************************************/
// Time Complexity: O(n log n)
// Space Complexity: O(n)
  
using System;
using System.Linq;

public class Solution {
    public int MinMovesToSeat(int[] seats, int[] students) {
        Array.Sort(seats);
        Array.Sort(students);
        
        int moves = 0;
        int n = seats.Length;
        for (int i = 0; i < n; i++) {
            moves += Math.Abs(seats[i] - students[i]);
        }
        return moves;
    }
}
