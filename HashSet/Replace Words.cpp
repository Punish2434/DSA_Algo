/*    Scroll below to see JAVA code also    */
/*
    Company Tags                : UBER
    Leetcode Link               : https://leetcode.com/problems/replace-words
*/


/ C++ *********************************************************************************************************************************************************************/
//Approach (Using normal hashset and generating all substrings)
//T.C : o(n*l + m*l^2) , n = number of words in the dictionary, m be the number of words in the sentence, and l be the average length of each word.
//S.C : O(n*l)
class Solution {
public:

    string findRoot(string& word, unordered_set<string>& st) {

        //try all length substring starting from 0th index
        for(int l = 1; l <= word.length(); l++) {
            string root = word.substr(0, l);
            if(st.count(root)) {
                return root;
            }
        }

        return word;

    }

    string replaceWords(vector<string>& dictionary, string sentence) {
        unordered_set<string> st(dictionary.begin(), dictionary.end());

        stringstream ss(sentence);
        string word;
        string result;

        while(getline(ss, word, ' ')) {
            result += findRoot(word, st) + " ";
        }

        result.pop_back();
        return result;

    }
};


/ JAVA *********************************************************************************************************************************************************************/
//Approach (Using normal hashset and generating all substrings)
//T.C : o(n*l + m*l^2) , n = number of words in the dictionary, m be the number of words in the sentence, and l be the average length of each word.
//S.C : O(n*l)
class Solution {
    private String findRoot(String word, Set<String> st) {
        // Try all length substring starting from 0th index
        for (int l = 1; l <= word.length(); l++) {
            String root = word.substring(0, l);
            if (st.contains(root)) {
                return root;
            }
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> st = new HashSet<>(dictionary);
        
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        
        for (String word : words) {
            result.append(findRoot(word, st)).append(" ");
        }
        
        // Remove the trailing space
        return result.toString().trim();
    }
}

/ C# *********************************************************************************************************************************************************************/
//Approach (Using normal hashset and generating all substrings)
//T.C : o(n*l + m*l^2) , n = number of words in the dictionary, m be the number of words in the sentence, and l be the average length of each word.
//S.C : O(n*l)
```csharp
using System;
using System.Collections.Generic;
using System.Text;

public class Solution
{
    private string FindRoot(string word, HashSet<string> st)
    {
        // Try all length substrings starting from 0th index
        for (int l = 1; l <= word.Length; l++)
        {
            string root = word.Substring(0, l);
            if (st.Contains(root))
            {
                return root;
            }
        }
        return word;
    }

    public string ReplaceWords(List<string> dictionary, string sentence)
    {
        HashSet<string> st = new HashSet<string>(dictionary);

        StringBuilder result = new StringBuilder();
        string[] words = sentence.Split(' ');

        foreach (string word in words)
        {
            result.Append(FindRoot(word, st)).Append(" ");
        }

        // Remove the trailing space
        return result.ToString().Trim();
    }
}
```

// In this C# version:
// - We use `HashSet<string>` instead of `Set<String>` for the dictionary.
// - The `FindRoot` method and the logic remain the same.
// - We split the sentence using `Split(' ')` instead of `split(" ")`.
// - The trailing space is removed using `Trim()`.

