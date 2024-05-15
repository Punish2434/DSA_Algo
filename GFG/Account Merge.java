/*     Scroll below to see JAVA code and C# also   */
/*
    Company Tags                : 
    GFG Link               : https://www.geeksforgeeks.org/problems/account-merge/1
*/

/ C++ ************************************************************************************************************************************/
// Time Complexity: 𝑂 ( 𝑚 𝑛 ⋅ 𝛼 ( 𝑛 ) ) O(mn⋅α(n)) 
// Space Complexity: 𝑂 ( 𝑝 ) O(p)
  
class Solution {
public:
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        unordered_map<string, string> emailToName;
        unordered_map<string, string> parent;

        // Step 1: Union emails and map email to name
        for (auto& account : accounts) {
            string name = account[0];
            for (int i = 1; i < account.size(); i++) {
                emailToName[account[i]] = name;
                if (!parent.count(account[i])) {
                    parent[account[i]] = account[i];
                }
                if (!parent.count(account[1])) {
                    parent[account[1]] = account[1];
                }
                unionOp(parent, account[1], account[i]);
            }
        }

        // Step 2: Group emails by their root parent
        unordered_map<string, vector<string>> rootToEmails;
        for (auto& entry : emailToName) {
            string email = entry.first;
            string root = find(parent, email);
            rootToEmails[root].push_back(email);
        }

        // Step 3: Format the result
        vector<vector<string>> mergedAccounts;
        for (auto& emails : rootToEmails) {
            sort(emails.second.begin(), emails.second.end());
            string name = emailToName[emails.second[0]];
            vector<string> account;
            account.push_back(name);
            account.insert(account.end(), emails.second.begin(), emails.second.end());
            mergedAccounts.push_back(account);
        }

        return mergedAccounts;
    }

private:
    string find(unordered_map<string, string>& parent, string s) {
        if (s != parent[s]) {
            parent[s] = find(parent, parent[s]);
        }
        return parent[s];
    }

    void unionOp(unordered_map<string, string>& parent, string s1, string s2) {
        string root1 = find(parent, s1);
        string root2 = find(parent, s2);
        if (root1 != root2) {
            parent[root1] = root2;
        }
    }
};

/ Java ************************************************************************************************************************************/

class Solution {
    static class UnionFind {
        private Map<String, String> parent;

        public UnionFind() {
            parent = new HashMap<>();
        }

        public String find(String s) {
            if (!parent.containsKey(s)) {
                parent.put(s, s);
            }
            if (!s.equals(parent.get(s))) {
                parent.put(s, find(parent.get(s)));
            }
            return parent.get(s);
        }

        public void union(String s1, String s2) {
            String root1 = find(s1);
            String root2 = find(s2);
            if (!root1.equals(root2)) {
                parent.put(root1, root2);
            }
        }
    }

    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind();
        Map<String, String> emailToName = new HashMap<>();

        // Step 1: Union emails and map email to name
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                emailToName.put(account.get(i), name);
                uf.union(account.get(1), account.get(i));
            }
        }

        // Step 2: Group emails by their root parent
        Map<String, List<String>> rootToEmails = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String root = uf.find(email);
            rootToEmails.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        // Step 3: Format the result
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> emails : rootToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            mergedAccounts.add(account);
        }

        return mergedAccounts;
    }
}
   

/ C# ************************************************************************************************************************************/


using System;
using System.Collections.Generic;
using System.Linq;

public class Solution {
    private class UnionFind {
        private Dictionary<string, string> parent;

        public UnionFind() {
            parent = new Dictionary<string, string>();
        }

        public string Find(string s) {
            if (!parent.ContainsKey(s)) {
                parent[s] = s;
            }
            if (s != parent[s]) {
                parent[s] = Find(parent[s]);
            }
            return parent[s];
        }

        public void Union(string s1, string s2) {
            string root1 = Find(s1);
            string root2 = Find(s2);
            if (root1 != root2) {
                parent[root1] = root2;
            }
        }
    }

    public static List<List<string>> AccountsMerge(List<List<string>> accounts) {
        UnionFind uf = new UnionFind();
        Dictionary<string, string> emailToName = new Dictionary<string, string>();

        // Step 1: Union emails and map email to name
        foreach (List<string> account in accounts) {
            string name = account[0];
            for (int i = 1; i < account.Count; i++) {
                string email = account[i];
                emailToName[email] = name;
                uf.Union(account[1], email);
            }
        }

        // Step 2: Group emails by their root parent
        Dictionary<string, List<string>> rootToEmails = new Dictionary<string, List<string>>();
        foreach (var entry in emailToName) {
            string email = entry.Key;
            string root = uf.Find(email);
            if (!rootToEmails.ContainsKey(root)) {
                rootToEmails[root] = new List<string>();
            }
            rootToEmails[root].Add(email);
        }

        // Step 3: Format the result
        List<List<string>> mergedAccounts = new List<List<string>>();
        foreach (var emails in rootToEmails.Values) {
            emails.Sort();
            string name = emailToName[emails[0]];
            List<string> account = new List<string>();
            account.Add(name);
            account.AddRange(emails);
            mergedAccounts.Add(account);
        }

        return mergedAccounts;
    }
}
