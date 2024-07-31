/*         Scroll below to see JAVA code and C# also        */

    // Company Tags                : Google , Amazon, Yahoo
    // Leetcode Link               : https://leetcode.com/problems/filling-bookcase-shelves/
// C++ ********************************************************************************************************************************************/
//Approach (Using Recusison- memoiztion(DP) --> Top-down(DP))
// TC:𝑂(n^2)
// SC:𝑂(n)
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

class Solution {
public:
    vector<int> memo;

    int minHeightShelves(vector<vector<int>>& books, int shelfWidth) {
        int n = books.size();
        memo.assign(n, -1);
        return dp(books, shelfWidth, 0);
    }

    int dp(vector<vector<int>>& books, int shelfWidth, int i) {
        if (i == books.size()) return 0;
        if (memo[i] != -1) return memo[i];

        int width = 0, height = 0, minHeight = INT_MAX;

        for (int j = i; j < books.size(); ++j) {
            width += books[j][0];
            if (width > shelfWidth) break;
            height = max(height, books[j][1]);
            minHeight = min(minHeight, height + dp(books, shelfWidth, j + 1));
        }

        memo[i] = minHeight;
        return minHeight;
    }
};

// Example usage:
int main() {
    Solution solution;

    vector<vector<int>> books1 = {{1,1}, {2,3}, {2,3}, {1,1}, {1,1}, {1,1}, {1,2}};
    int shelfWidth1 = 4;
    printf("%d\n", solution.minHeightShelves(books1, shelfWidth1));  // Output: 6

    vector<vector<int>> books2 = {{1,3}, {2,4}, {3,2}};
    int shelfWidth2 = 6;
    printf("%d\n", solution.minHeightShelves(books2, shelfWidth2));  // Output: 4

    return 0;
}
// Java ********************************************************************************************************************************************/
//Approach (Using Recusison- memoiztion(DP) --> Top-down(DP))
// TC:𝑂(n^2)
// SC:𝑂(n)
import java.util.Arrays;

class Solution {
    private int[] memo;

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dp(books, shelfWidth, 0);
    }

    private int dp(int[][] books, int shelfWidth, int i) {
        if (i == books.length) return 0;
        if (memo[i] != -1) return memo[i];

        int width = 0, height = 0, minHeight = Integer.MAX_VALUE;
        
        for (int j = i; j < books.length; ++j) {
            width += books[j][0];
            if (width > shelfWidth) break;
            height = Math.max(height, books[j][1]);
            minHeight = Math.min(minHeight, height + dp(books, shelfWidth, j + 1));
        }
        
        memo[i] = minHeight;
        return minHeight;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] books1 = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        int shelfWidth1 = 4;
        System.out.println(solution.minHeightShelves(books1, shelfWidth1)); // Output: 6

        int[][] books2 = {{1,3},{2,4},{3,2}};
        int shelfWidth2 = 6;
        System.out.println(solution.minHeightShelves(books2, shelfWidth2)); // Output: 4
    }
}
// Java ********************************************************************************************************************************************/
//Approach (Using Recusison-  --> Top-down(DP))
// TC:𝑂(n^2)
// SC:𝑂(n)
import java.util.Arrays;

class Solution {
    private int[] memo;

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dp(books, shelfWidth, 0);
    }

    private int dp(int[][] books, int shelfWidth, int i) {
        if (i == books.length) return 0;
        if (memo[i] != -1) return memo[i];

        int width = 0, height = 0, minHeight = Integer.MAX_VALUE;
        
        for (int j = i; j < books.length; ++j) {
            width += books[j][0];
            if (width > shelfWidth) break;
            height = Math.max(height, books[j][1]);
            minHeight = Math.min(minHeight, height + dp(books, shelfWidth, j + 1));
        }
        
        memo[i] = minHeight;
        return minHeight;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] books1 = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        int shelfWidth1 = 4;
        System.out.println(solution.minHeightShelves(books1, shelfWidth1)); // Output: 6

        int[][] books2 = {{1,3},{2,4},{3,2}};
        int shelfWidth2 = 6;
        System.out.println(solution.minHeightShelves(books2, shelfWidth2)); // Output: 4
    }
}


// C# ********************************************************************************************************************************************/
//Approach (Using Recusison- memoiztion(DP) )
// TC:𝑂(n^2)
// SC:𝑂(n)
using System;
using System.Collections.Generic;

public class Solution {
    private int[] memo;

    public int MinHeightShelves(int[][] books, int shelfWidth) {
        int n = books.Length;
        memo = new int[n];
        Array.Fill(memo, -1);
        return Dp(books, shelfWidth, 0);
    }

    private int Dp(int[][] books, int shelfWidth, int i) {
        if (i == books.Length) return 0;
        if (memo[i] != -1) return memo[i];

        int width = 0, height = 0, minHeight = int.MaxValue;

        for (int j = i; j < books.Length; ++j) {
            width += books[j][0];
            if (width > shelfWidth) break;
            height = Math.Max(height, books[j][1]);
            minHeight = Math.Min(minHeight, height + Dp(books, shelfWidth, j + 1));
        }

        memo[i] = minHeight;
        return minHeight;
    }

    public static void Main(string[] args) {
        Solution solution = new Solution();

        int[][] books1 = new int[][] { new int[] { 1, 1 }, new int[] { 2, 3 }, new int[] { 2, 3 }, new int[] { 1, 1 }, new int[] { 1, 1 }, new int[] { 1, 1 }, new int[] { 1, 2 } };
        int shelfWidth1 = 4;
        Console.WriteLine(solution.MinHeightShelves(books1, shelfWidth1));  // Output: 6

        int[][] books2 = new int[][] { new int[] { 1, 3 }, new int[] { 2, 4 }, new int[] { 3, 2 } };
        int shelfWidth2 = 6;
        Console.WriteLine(solution.MinHeightShelves(books2, shelfWidth2));  // Output: 4
    }
}
