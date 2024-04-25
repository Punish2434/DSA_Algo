/*    Scroll below to see JAVA code also    */
/*
    Company Tags                : Will update soon
    Leetcode Link               : https://leetcode.com/problems/longest-ideal-subsequence/
*/


/ C++ ********************************************************************************************************************************/
//Approach-1 (Using LIS code eactly)
//T.C : O(n^2)
//S.C : O(n)
class Solution {
public:
    int longestIdealString(string s, int k) {
        int n = s.length();
        
        int result = 1;
        vector<int> t(n, 1);
        //t[i] = Longest Ideal Subsequence ending at index i
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                
                if(abs(s[j] - s[i]) <= k) {
                    t[i] = max(t[i], t[j]+1);
                }
            }
            result = max(result, t[i]);
        }
        
        return result;
    }
};


//Approach-2 (Optimised - Chec only those characters for s[i] such that abs(ch - s[i]) <=k)
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    int longestIdealString(string s, int k) {
        int n = s.length();
        
        vector<int> t(26, 0);
        
        int result = 0;
        
        for(int i = 0; i < n; i++) {
            
            int curr    = s[i]-'a';
            int left    = max(0, curr-k);
            int right   = min(25, curr+k);

            int longest = 0;
            for(int j = left; j <= right; j++) {
                longest = max(longest, t[j]);
            }
            
            t[curr] = max(t[curr], longest+1);
            result = max(result, t[curr]);
        }
        
        return result;
        
    }
};



/ JAVA ********************************************************************************************************************************/
//Approach-1 (Using LIS code eactly)
//T.C : O(n^2)
//S.C : O(n)
public class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        
        int result = 1;
        int[] t = new int[n];
        Arrays.fill(t, 1);
        // t[i] = Longest Ideal Subsequence ending at index i
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                
                if(Math.abs(s.charAt(j) - s.charAt(i)) <= k) {
                    t[i] = Math.max(t[i], t[j]+1);
                }
            }
            result = Math.max(result, t[i]);
        }
        
        return result;
    }
}


//Approach-2 (Optimised - Chec only those characters for s[i] such that abs(ch - s[i]) <=k)
//T.C : O(n)
//S.C : O(1)
public class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        
        int[] t = new int[26];
        
        int result = 0;
        
        for(int i = 0; i < n; i++) {
            
            int curr = s.charAt(i) - 'a';
            int left = Math.max(0, curr - k);
            int right = Math.min(25, curr + k);

            int longest = 0;
            for(int j = left; j <= right; j++) {
                longest = Math.max(longest, t[j]);
            }
            
            t[curr] = Math.max(t[curr], longest + 1);
            result = Math.max(result, t[curr]);
        }
        
        return result;
        
    }
}
/ C# ********************************************************************************************************************************/
//Approach-1 (Using LIS code eactly)
//T.C : O(n^2)
//S.C : O(n)


public class Solution {
    public int LongestIdealString(string s, int k) {
        int n = s.Length;
        int result = 1;
        int[] t = new int[n];
        
        // Initialize t[i] with 1 (Longest Ideal Subsequence ending at index i)
        for (int i = 0; i < n; i++) {
            t[i] = 1;
        }
        
        // Iterate through each character in s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // If the absolute difference between characters at indices i and j is <= k
                if (Math.Abs(s[j] - s[i]) <= k) {
                    // Update t[i] by taking the maximum of its current value and t[j] + 1
                    t[i] = Math.Max(t[i], t[j] + 1);
                }
            }
            // Update the overall result by taking the maximum of the current result and t[i]
            result = Math.Max(result, t[i]);
        }
        
        return result;
    }
}
```

// **Explanation**:
// - We are given a string `s` and an integer `k`.
// - The goal is to find the length of the longest ideal subsequence in `s`.
// - An ideal subsequence is one in which the absolute difference between adjacent characters is at most `k`.
// - The approach involves initializing an array `t` of size `n` (where `n` is the length of `s`) with all values set to 1. `t[i]` represents the length of the longest ideal subsequence ending at index `i`.
// - We iterate through each character in `s`:
//     - For each character at index `i`, we compare it with all characters before it (at indices `j` where `j < i`).
//     - If the absolute difference between the characters at indices `i` and `j` is less than or equal to `k`:
//         - Update `t[i]` by taking the maximum of its current value and `t[j] + 1`.
//     - Update the overall result by taking the maximum of the current result and `t[i]`.
// - Finally, we return the final result.





//Approach-2 (Optimised - Chec only those characters for s[i] such that abs(ch - s[i]) <=k)
//T.C : O(n)
//S.C : O(1)

```csharp
public class Solution
{
    public int LongestIdealString(string s, int k)
    {
        int n = s.Length;
        int[] t = new int[26]; // Initialize an array to store longest ideal subsequences for each character
        int result = 0; // Initialize the overall result

        for (int i = 0; i < n; i++)
        {
            int curr = s[i] - 'a'; // Calculate the index of the current character
            int left = Math.Max(0, curr - k); // Determine the left bound for valid characters
            int right = Math.Min(25, curr + k); // Determine the right bound for valid characters

            int longest = 0; // Initialize the length of the longest ideal subsequence
            for (int j = left; j <= right; j++)
            {
                longest = Math.Max(longest, t[j]); // Find the longest subsequence ending at index j
            }

            t[curr] = Math.Max(t[curr], longest + 1); // Update t[curr] with the maximum subsequence length
            result = Math.Max(result, t[curr]); // Update the overall result
        }

        return result; // Return the final result
    }
}

// Explanation:
// - We are given a string 's' and an integer 'k'.
// - The goal is to find the length of the longest ideal subsequence in 's'.
// - An ideal subsequence is one in which the absolute difference between adjacent characters is at most 'k'.
// - We maintain an array 't' of size 26 (representing the 26 lowercase letters) to store the longest ideal subsequence ending at each character.
// - For each character in 's':
//     - Calculate the current character index ('curr') by subtracting 'a' (ASCII value of 'a') from the character value.
//     - Determine the left and right bounds for valid characters (within the range [0, 25]).
//     - Iterate through the valid character indices and find the longest ideal subsequence ending at each index.
//     - Update 't[curr]' with the maximum of its current value and the longest subsequence found.
//     - Update the overall result with the maximum of the current result and 't[curr]'.
// - Finally, return the final result.
```
