/*      Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : GOOGLE, and some other company Online Assessment problem
    Leetcode Link               : https://leetcode.com/problems/crawler-log-folder
*/


/ C++ ******************************************************************************************************/
//Approach-1 (Using simple simulation)
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    int minOperations(vector<string>& logs) {
        int depth = 0;

        for(string &s : logs) {
            if(s == "../") {
                depth = max(0, depth-1);
            } else if(s == "./") {
                continue;
            } else {
                depth++;
            }
        }

        return depth;
    }
};


//Approach-2 (Using Stack for simulation)
//T.C : O(n)
//S.C : O(n)
class Solution {
public:
    int minOperations(vector<string>& logs) {
        stack<string> st;

        for (const string& currentOperation : logs) {
            if (currentOperation == "../") {
                if (!st.empty()) {
                    st.pop();
                }
            } else if (currentOperation != "./") {
                st.push(currentOperation);
            }
        }

        return st.size();
    }
};



/ JAVA *******************************************************************************************************/
//Approach-1 (Using simple simulation)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;

        for (String s : logs) {
            if (s.equals("../")) {
                depth = Math.max(0, depth - 1);
            } else if (!s.equals("./")) {
                depth++;
            }
        }

        return depth;
    }
}


//Approach-2 (Using Stack for simulation)
//T.C : O(n)
//S.C : O(n)
class Solution {
    public int minOperations(String[] logs) {
        Stack<String> st = new Stack<>();

        for (String currentOperation : logs) {
            if (currentOperation.equals("../")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if (!currentOperation.equals("./")) {
                st.push(currentOperation);
            }
        }

        return st.size();
    }
}


/ C# ****************************************************************************************************/

// Approach-1 (Using simple simulation)
// T.C : O(n)
// S.C : O(1)
public class Solution {
    public int MinOperations(string[] logs) {
        int depth = 0;

        foreach (string s in logs) {
            if (s.Equals("../")) {
                depth = Math.Max(0, depth - 1);
            } else if (!s.Equals("./")) {
                depth++;
            }
        }

        return depth;
    }
}



// Approach-2 (Using Stack for simulation)
// T.C : O(n)
// S.C : O(n)
using System.Collections.Generic;

public class Solution {
    public int MinOperations(string[] logs) {
        Stack<string> st = new Stack<string>();

        foreach (string currentOperation in logs) {
            if (currentOperation.Equals("../")) {
                if (st.Count > 0) {
                    st.Pop();
                }
            } else if (!currentOperation.Equals("./")) {
                st.Push(currentOperation);
            }
        }

        return st.Count;
    }
}
