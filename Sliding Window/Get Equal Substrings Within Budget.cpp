/*   Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : 
    Leetcode Link               : https://leetcode.com/problems/get-equal-substrings-within-budget
*/


/ C++ ************************************************************************************************************/
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        int n = s.length();
        
        int maxLen = 0;
        int currCost = 0;
        
        int i = 0, j = 0;
        while(j < n) {
            currCost += abs(s[j] - t[j]);
            
            while (currCost > maxCost) {
                currCost -= abs(s[i] - t[i]);
                i++;
            }
            
            maxLen = max(maxLen, j - i + 1);
            j++;
        }
        
        return maxLen;
    }
};


/ JAVA ************************************************************************************************************/
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        
        int maxLen = 0;
        int currCost = 0;
        
        int i = 0, j = 0;
        while (j < n) {
            currCost += Math.abs(s.charAt(j) - t.charAt(j));
            
            while (currCost > maxCost) {
                currCost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
            
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        
        return maxLen;
    }
}
/ C# ************************************************************************************************************/

```csharp
public class Solution {
    public int EqualSubstring(string s, string t, int maxCost) {
        int n = s.Length;
        
        int maxLen = 0;
        int currCost = 0;
        
        int i = 0, j = 0;
        while (j < n) {
            currCost += Math.Abs(s[j] - t[j]);
            
            while (currCost > maxCost) {
                currCost -= Math.Abs(s[i] - t[i]);
                i++;
            }
            
            maxLen = Math.Max(maxLen, j - i + 1);
            j++;
        }
        
        return maxLen;
    }
}
```

// In this C# code:
// - We use `string.Length` instead of `s.length()` to get the length of the strings.
// - We access characters in the strings using `s[j]` and `t[j]` instead of `s.charAt(j)` and `t.charAt(j)`.
// - The logic remains the same, where we maintain a sliding window and update the `maxLen` based on the current cost.
