/*         Scroll below to see JAVA code and C# also        */

    // Company Tags                : 
    // Leetcode Link               : https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
// JavaScript ********************************************************************************************************************************************/
//Approach (Using array)
// TC:𝑂((n)
// SC:𝑂(n)
class Solution {
    minimumDeletions(s) {
        const n = s.length;
        const prefixB = new Array(n + 1).fill(0);
        const suffixA = new Array(n + 1).fill(0);
        
        for (let i = 0; i < n; i++) {
            prefixB[i + 1] = prefixB[i] + (s[i] === 'b' ? 1 : 0);
        }
        
        for (let i = n - 1; i >= 0; i--) {
            suffixA[i] = suffixA[i + 1] + (s[i] === 'a' ? 1 : 0);
        }
        
        let minDeletions = Infinity;
        for (let i = 0; i <= n; i++) {
            minDeletions = Math.min(minDeletions, prefixB[i] + suffixA[i]);
        }
        
        return minDeletions;
    }
}



// Java ********************************************************************************************************************************************/
//Approach (Using array)
// TC:𝑂((n)
// SC:𝑂(n)
class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] prefixB = new int[n + 1];
        int[] suffixA = new int[n + 1];

        // Fill prefixB array: number of 'b's from start to current index
        for (int i = 0; i < n; i++) {
            prefixB[i + 1] = prefixB[i] + (s.charAt(i) == 'b' ? 1 : 0);
        }

        // Fill suffixA array: number of 'a's from current index to end
        for (int i = n - 1; i >= 0; i--) {
            suffixA[i] = suffixA[i + 1] + (s.charAt(i) == 'a' ? 1 : 0);
        }

        // Find the minimum deletions by trying to balance at each point
        int minDeletions = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            minDeletions = Math.min(minDeletions, prefixB[i] + suffixA[i]);
        }

        return minDeletions;
    }
}


// C# ********************************************************************************************************************************************/
//Approach (Using array)
// TC:𝑂((n)
// SC:𝑂(n)
public class Solution {
    public int MinimumDeletions(string s) {
        int n = s.Length;
        int[] prefixB = new int[n + 1];
        int[] suffixA = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefixB[i + 1] = prefixB[i] + (s[i] == 'b' ? 1 : 0);
        }
        
        for (int i = n - 1; i >= 0; i--) {
            suffixA[i] = suffixA[i + 1] + (s[i] == 'a' ? 1 : 0);
        }
        
        int minDeletions = int.MaxValue;
        for (int i = 0; i <= n; i++) {
            minDeletions = Math.Min(minDeletions, prefixB[i] + suffixA[i]);
        }
        
        return minDeletions;
    }
}
