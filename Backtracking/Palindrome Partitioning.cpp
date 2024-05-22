/*         Scroll below to see JAVA Code and C#  also        */
/*
    Company Tags                : Google, Amazon, Microsoft, Meta
    Leetcode Link               : https://leetcode.com/problems/palindrome-partitioning/
    GfG Link                    : https://practice.geeksforgeeks.org/problems/find-all-possible-palindromic-partitions-of-a-string/1
*/

/ C++ ****************************************************************************************************************/
//Whenever a question asks for "Generating all possible" something, think about Backtracking once
//T.C : O(n * 2^n) - For a string of length n, there are 2^(𝑛 − 1) potential ways to partition it (since each position can either be a cut or not). and we also check palindrome O(n)
//S.C : O(n * 2^n) - Number of partitions * their length
class Solution {
public:
    int n;
    
    bool isPalindrome(string &s, int l, int r) {
        
        while(l < r) {
            if(s[l] != s[r])
                return false;
            l++;
            r--;
        }
        
        return true;
        
    }
    
    void backtrack(string &s, int idx, vector<string> curr, vector<vector<string>> &result) {
        
        if(idx == n) {
            result.push_back(curr);
            return;
        }
        
        
        for(int i = idx; i<n; i++) {
            
            if(isPalindrome(s, idx, i)) {
                
                curr.push_back(s.substr(idx, i-idx+1));
                
                backtrack(s, i+1, curr, result);
                
                curr.pop_back();
                
            }
            
        }
        
    }
    
    vector<vector<string>> partition(string s) {
        n = s.length();
        vector<vector<string>> result;
        vector<string> curr;
        
        backtrack(s, 0, curr, result);
        
        return result;
        
    }
};


/ JAVA ****************************************************************************************************************/
//Whenever a question asks for "Generating all possible" something, think about Backtracking once
//T.C : O(n * 2^n) - For a string of length n, there are 2^(𝑛 − 1) potential ways to partition it (since each position can either be a cut or not). and we also check palindrome O(n)
//S.C : O(n * 2^n) - Number of partitions * their length
class Solution {
    private int n;
    
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
    
    private void backtrack(String s, int idx, List<String> curr, List<List<String>> result) {
        if (idx == n) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = idx; i < n; i++) {
            if (isPalindrome(s, idx, i)) {
                curr.add(s.substring(idx, i + 1));
                backtrack(s, i + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        n = s.length();
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        
        backtrack(s, 0, curr, result);
        
        return result;
    }
}


/ C# ****************************************************************************************************************/

```csharp
using System;
using System.Collections.Generic;

public class Solution {
    private int n;

    private bool IsPalindrome(string s, int l, int r) {
        while (l < r) {
            if (s[l] != s[r])
                return false;
            l++;
            r--;
        }
        return true;
    }

    private void Backtrack(string s, int idx, List<string> curr, List<List<string>> result) {
        if (idx == n) {
            result.Add(new List<string>(curr));
            return;
        }

        for (int i = idx; i < n; i++) {
            if (IsPalindrome(s, idx, i)) {
                curr.Add(s.Substring(idx, i - idx + 1));
                Backtrack(s, i + 1, curr, result);
                curr.RemoveAt(curr.Count - 1);
            }
        }
    }

    public IList<IList<string>> Partition(string s) {
        n = s.Length;
        var result = new List<List<string>>();
        var curr = new List<string>();

        Backtrack(s, 0, curr, result);

        return result;
    }
}
```

// Explanation:
// - I've translated the Java code to C# while maintaining the same logic.
// - The method names (`IsPalindrome`, `Backtrack`, and `Partition`) have been adjusted to follow C# naming conventions (PascalCase).
// - The `List` and `string` types are used instead of Java's `ArrayList` and `String`.
// - The `Substring` method in C# uses `(start, length)` instead of `(start, end)`.
// - The `IList<IList<string>>` return type corresponds to a list of lists of strings.

