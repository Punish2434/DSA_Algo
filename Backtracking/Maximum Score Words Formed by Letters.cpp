/*     Scroll below to see JAVA code and C# also    */
/*

    Company Tags                : will update soon
    Leetcode Link               : https://leetcode.com/problems/maximum-score-words-formed-by-letters
*/


/ C++ ******************************************************************************************************************************************/
//Using simple backtracking
//T.C : O(2^n) where n is the total number of words
//S.C : O(n)
class Solution {
public:
    int n;
    int maxScore;

    void solve(int i, vector<int>& score, vector<string>& words, int currScore, vector<int>& freq){
          
        maxScore = max(maxScore, currScore);

        if(i >= n)
            return;

        vector<int> tempFreq = freq;

        int j         = 0;
        int tempScore = 0;

        while(j < words[i].length()) {
            char ch = words[i][j];

            tempFreq[ch - 'a']--;
            tempScore += score[ch - 'a'];

            if(tempFreq[ch-'a'] < 0)
                break;

            j++;
        }

        //Take words[i]
        if(j == words[i].length()) { //It means we could form the word words[i]
            solve(i+1, score, words, currScore + tempScore, tempFreq);
        }

        //Not Take words[i]
        solve(i+1, score, words, currScore, freq);
    }
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        vector<int> freq(26, 0);

        for(char &ch : letters){
            freq[ch - 'a']++;
        }
        maxScore = INT_MIN;
        n        = words.size();

        solve(0, score, words, 0, freq);
        
        return maxScore;
    }
};



/ JAVA ******************************************************************************************************************************************/
//Using simple backtracking
//T.C : O(2^n) where n is the total number of words
//S.C : O(n)
class Solution {
    int n;
    int maxScore;

    void solve(int i, int[] score, String[] words, int currScore, int[] freq) {
        maxScore = Math.max(maxScore, currScore);

        if (i >= n)
            return;

        int[] tempFreq = Arrays.copyOf(freq, freq.length);

        int j = 0;
        int tempScore = 0;

        while (j < words[i].length()) {
            char ch = words[i].charAt(j);

            tempFreq[ch - 'a']--;
            tempScore += score[ch - 'a'];

            if (tempFreq[ch - 'a'] < 0)
                break;

            j++;
        }

        // Take words[i]
        if (j == words[i].length()) { // It means we could form the word words[i]
            solve(i + 1, score, words, currScore + tempScore, tempFreq);
        }

        // Not Take words[i]
        solve(i + 1, score, words, currScore, freq);
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];

        for (char ch : letters) {
            freq[ch - 'a']++;
        }
        maxScore = Integer.MIN_VALUE;
        n = words.length;

        solve(0, score, words, 0, freq);

        return maxScore;
    }
}

/ C# ******************************************************************************************************************************************/
//Using simple backtracking
//T.C : O(2^n) where n is the total number of words
//S.C : O(n)

```csharp
using System;

public class Solution
{
    private int n;
    private int maxScore;

    private void Solve(int i, int[] score, string[] words, int currScore, int[] freq)
    {
        maxScore = Math.Max(maxScore, currScore);

        if (i >= n)
            return;

        int[] tempFreq = (int[])freq.Clone();

        int j = 0;
        int tempScore = 0;

        while (j < words[i].Length)
        {
            char ch = words[i][j];

            tempFreq[ch - 'a']--;
            tempScore += score[ch - 'a'];

            if (tempFreq[ch - 'a'] < 0)
                break;

            j++;
        }

        // Take words[i]
        if (j == words[i].Length)
        {
            Solve(i + 1, score, words, currScore + tempScore, tempFreq);
        }

        // Not Take words[i]
        Solve(i + 1, score, words, currScore, freq);
    }

    public int MaxScoreWords(string[] words, char[] letters, int[] score)
    {
        int[] freq = new int[26];

        foreach (char ch in letters)
        {
            freq[ch - 'a']++;
        }

        maxScore = int.MinValue;
        n = words.Length;

        Solve(0, score, words, 0, freq);

        return maxScore;
    }
}
```

// In the converted C# code:
// - I've changed the method names to follow C# naming conventions (e.g., `Solve` instead of `solve`).
// - Used `string` instead of `String`.
// - Cloned the `freq` array using `(int[])freq.Clone()` to avoid modifying the original array.
// - Replaced `words[i].length()` with `words[i].Length`.
// - Changed the `foreach` loop for iterating over `letters`.

