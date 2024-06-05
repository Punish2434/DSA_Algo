/*     Scroll below to see JAVA code and C# also    */
/*
      Company Tags                : 
      Leetcode Link               : https://leetcode.com/problems/find-common-characters
*/


/ C++ ********************************************************************************************************************************/
//Approach (Simple iteration)
//T.C : O(n*w) , w = average length of each word. and n = number of words
//S.C : O(1)
class Solution {
public:
    void fillCountArray(string &word, int count[26]) {
        for(char &ch : word) {
            count[ch-'a']++;
        }
    }
    vector<string> commonChars(vector<string>& words) {
        vector<string> result;
        
        int n = words.size();
        
        int count[26] = {0};
        
        fillCountArray(words[0], count);

        for(int i = 1; i<n; i++) {
            int temp[26] = {0};
            
            fillCountArray(words[i], temp);

            for(int i = 0; i<26; i++) {
                if(count[i] != temp[i])
                    count[i] = min(count[i], temp[i]);
            }
            
        }
        
        for(int i = 0; i<26; i++) {
            if(count[i] != 0) {
                int c = count[i];
                while(c--) {
                    result.push_back(string(1, i+'a'));
                }
            }
        }
        
        return result;
    }
};


/ JAVA ********************************************************************************************************************************/
//Approach (Simple iteration)
//T.C : O(n*w) , w = average length of each word. and n = number of words
//S.C : O(1)
class Solution {
    public void fillCountArray(String word, int[] count) {
        for (char ch : word.toCharArray()) {
            count[ch - 'a']++;
        }
    }

    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();

        int n = words.length;
        
        // Initialize the count array for the first word
        int[] count = new int[26];
        fillCountArray(words[0], count);

        // Iterate through the rest of the words and update the count array
        for (int i = 1; i < n; i++) {
            int[] temp = new int[26];
            fillCountArray(words[i], temp);

            for (int j = 0; j < 26; j++) {
                count[j] = Math.min(count[j], temp[j]);
            }
        }

        // Collect the common characters based on the count array
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) {
                    result.add(String.valueOf((char) (i + 'a')));
                }
            }
        }

        return result;
    }
}
/ C# ********************************************************************************************************************************/
//Approach (Simple iteration)
//T.C : O(n*w) , w = average length of each word. and n = number of words
//S.C : O(1)
```csharp
using System;
using System.Collections.Generic;

public class Solution {
    public void FillCountArray(string word, int[] count) {
        foreach (char ch in word) {
            count[ch - 'a']++;
        }
    }

    public IList<string> CommonChars(string[] words) {
        List<string> result = new List<string>();

        int n = words.Length;

        // Initialize the count array for the first word
        int[] count = new int[26];
        FillCountArray(words[0], count);

        // Iterate through the rest of the words and update the count array
        for (int i = 1; i < n; i++) {
            int[] temp = new int[26];
            FillCountArray(words[i], temp);

            for (int j = 0; j < 26; j++) {
                count[j] = Math.Min(count[j], temp[j]);
            }
        }

        // Collect the common characters based on the count array
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) {
                    result.Add(((char)(i + 'a')).ToString());
                }
            }
        }

        return result;
    }
}
```

// In the C# code:
// - The `FillCountArray` method remains the same.
// - The `CommonChars` method now returns an `IList<string>` instead of a `List<String>`.
// - We use `List<string>` instead of `ArrayList` for better type safety.
// - The syntax for `foreach` and array initialization remains consistent with C# conventions.
