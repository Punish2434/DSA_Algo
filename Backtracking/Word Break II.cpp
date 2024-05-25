/*     Scroll below to see JAVA code and C# also    */
/*
        Company Tags                : Meta Phone Screen Interview, Twitter, Snapchat, Dropbox, Uber, Google
        Leetcode Link               : https://leetcode.com/problems/word-break-ii/description
*/


/ C++ **************************************************************************************************************/
//Approach-1 (Using simple backtracking)
//T.C : O(2^n)
//S.C : max depth of recursion is n (length of string s). You can say O(n) . You also have to store those sentences which is O(2^n)
class Solution {
public:
    vector<string> result;
    unordered_set<string> dict;

    void solve(int i, string& currSentence, string &s) {
        if(i >= s.length()) {
            result.push_back(currSentence);
            return;
        }

        for(int j = i; j < s.length(); j++) {

            string tempWord = s.substr(i, j-i+1);

            if(dict.find(tempWord) != dict.end()) {
                string origSentence = currSentence;
                if(!currSentence.empty())
                    currSentence += " ";
                
                currSentence += tempWord;

                solve(j+1, currSentence, s);

                currSentence = origSentence;

            }

        }
    }

    vector<string> wordBreak(string s, vector<string>& wordDict) {
        for(string &word : wordDict) {
            dict.insert(word);
        }

        string currSentence = "";
        solve(0, currSentence, s);

        return result;
    }
};



//Approach-2 (Using simple backtracking)
//T.C : O(2^n)
//S.C : max depth of recursion is n (length of string s). You can say O(n) . You also have to store those sentences which is O(2^n)
class Solution {
public:
    unordered_set<string> dict;
    unordered_map<string, vector<string>> mp;

    vector<string> solve(string &s) {
       if(s.empty()) {
            return {""};
       }
      
       if(mp.count(s))
            return mp[s];

        if(mp.count(s))
            return mp[s];
        
        vector<string> result;
        for(int l = 1; l <= s.length(); l++) {
            string currWord   = s.substr(0, l);
            if(dict.count(currWord)) {
                string remainWord = s.substr(l);
                vector<string> remainResult = solve(remainWord);
                for(string &w : remainResult) {
                    string toAdd = currWord + (w.empty() ? "" : " ") + w;
                    result.push_back(toAdd);
                }
            }
        }


        return mp[s] = result;
    }

    vector<string> wordBreak(string s, vector<string>& wordDict) {
        for(string &word : wordDict) {
            dict.insert(word);
        }

        return solve(s);
    }
};



/ JAVA **************************************************************************************************************/
//Approach-1 (Using simple backtracking)
//T.C : O(2^n)
//S.C : max depth of recursion is n (length of string s). You can say O(n) . You also have to store those sentences which is O(2^n)
public class Solution {
    private List<String> result;
    private Set<String> dict;

    private void solve(int i, String currSentence, String s) {
        if (i >= s.length()) {
            result.add(currSentence.trim());
            return;
        }

        for (int j = i; j < s.length(); j++) {
            String tempWord = s.substring(i, j + 1);

            if (dict.contains(tempWord)) {
                String originalSentence = currSentence;
                if (!currSentence.isEmpty()) {
                    currSentence += " ";
                }
                currSentence += tempWord;

                solve(j + 1, currSentence, s);

                currSentence = originalSentence;
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<>();
        dict = new HashSet<>(wordDict);

        String currSentence = "";
        solve(0, currSentence, s);

        return result;
    }
}


//Approach-2 (Using simple backtracking)
//T.C : O(2^n)
//S.C : max depth of recursion is n (length of string s). You can say O(n) . You also have to store those sentences which is O(2^n)
public class Solution {
    private Set<String> dict;
    private Map<String, List<String>> memo;

    private List<String> solve(String s) {
        if (s.isEmpty()) {
            return Arrays.asList("");
        }
        
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();
        for (int l = 1; l <= s.length(); l++) {
            String currWord = s.substring(0, l);
            if (dict.contains(currWord)) {
                String remainWord = s.substring(l);
                List<String> remainResult = solve(remainWord);
                for (String w : remainResult) {
                    String toAdd = currWord + (w.isEmpty() ? "" : " ") + w;
                    result.add(toAdd);
                }
            }
        }

        memo.put(s, result);
        return result;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        memo = new HashMap<>();

        return solve(s);
    }
}

/ C# **************************************************************************************************************/
  //Approach-1 (Using simple backtracking)
//T.C : O(2^n)
//S.C : max depth of recursion is n (length of string s). You can say O(n) . You also have to store those sentences which is O(2^n)
using System;
using System.Collections.Generic;

public class Solution
{
    private List<string> result;
    private HashSet<string> dict;

    private void Solve(int i, string currSentence, string s)
    {
        if (i >= s.Length)
        {
            result.Add(currSentence.Trim());
            return;
        }

        for (int j = i; j < s.Length; j++)
        {
            string tempWord = s.Substring(i, j - i + 1);

            if (dict.Contains(tempWord))
            {
                string originalSentence = currSentence;
                if (!string.IsNullOrEmpty(currSentence))
                {
                    currSentence += " ";
                }
                currSentence += tempWord;

                Solve(j + 1, currSentence, s);

                currSentence = originalSentence;
            }
        }
    }

    public IList<string> WordBreak(string s, IList<string> wordDict)
    {
        result = new List<string>();
        dict = new HashSet<string>(wordDict);

        string currSentence = "";
        Solve(0, currSentence, s);

        return result;
    }
}
//Approach-2 (Using simple backtracking)
//T.C : O(2^n)
//S.C : max depth of recursion is n (length of string s). You can say O(n) . You also have to store those sentences which is O(2^n)
using System;
using System.Collections.Generic;
using System.Linq;

public class Solution
{
    private HashSet<string> dict;
    private Dictionary<string, List<string>> memo;

    private List<string> Solve(string s)
    {
        if (string.IsNullOrEmpty(s))
        {
            return new List<string> { "" };
        }

        if (memo.ContainsKey(s))
        {
            return memo[s];
        }

        List<string> result = new List<string>();
        for (int l = 1; l <= s.Length; l++)
        {
            string currWord = s.Substring(0, l);
            if (dict.Contains(currWord))
            {
                string remainWord = s.Substring(l);
                List<string> remainResult = Solve(remainWord);
                foreach (string w in remainResult)
                {
                    string toAdd = currWord + (string.IsNullOrEmpty(w) ? "" : " ") + w;
                    result.Add(toAdd);
                }
            }
        }

        memo[s] = result;
        return result;
    }

    public IList<string> WordBreak(string s, IList<string> wordDict)
    {
        dict = new HashSet<string>(wordDict);
        memo = new Dictionary<string, List<string>>();

        return Solve(s);
    }
}

