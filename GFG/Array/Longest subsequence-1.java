/*     Scroll below to see JAVA code and C# also    */
/*
      Company Tags                : AMAZON
      Leetcode Link               : https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x
*/


/ C++ ******************************************************************************************************/
// Time Complexity:- O(N)
// Space Complexity:- O(N)

class Solution {
 
    int longestSubseq(int n, vector<int> &a) {
        // code here
        int ans=0;
        unordered_map<int,int> mm;
        for(int i=0;i<n;i++){
            mm[a[i]]=max(mm[a[i]-1],mm[a[i]+1])+1;
            ans=max(ans,mm[a[i]]);
        }
        return ans;
    }
}
/ Java ******************************************************************************************************/


class Solution {
 
    public static int longestSubseq(int n, int[] a) {
        // code here
        Map<Integer,Integer> mm = new HashMap<>();
        int ans=0;
        for(int i=0;i<n;i++){
            mm.put(a[i],1+Math.max(mm.getOrDefault(a[i]-1,0),mm.getOrDefault(a[i]+1,0)));
            ans=Math.max(ans,mm.get(a[i]));
        }
        return ans;
    }
}

// Time Complexity:- O(N)
// Space Complexity:- O(N)
/ C# ******************************************************************************************************/
using System;
using System.Collections.Generic;

public class Solution {
    public static int LongestSubseq(int n, int[] a) {
        // Create a dictionary to store the length of subsequences
        Dictionary<int, int> mm = new Dictionary<int, int>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            // Calculate the length of the subsequence ending at 'a[i]'
            mm[a[i]] = 1 + Math.Max(mm.GetValueOrDefault(a[i] - 1, 0), mm.GetValueOrDefault(a[i] + 1, 0));
            ans = Math.Max(ans, mm[a[i]]);
        }

        return ans;
    }
}
