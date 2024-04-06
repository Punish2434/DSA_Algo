/*    Scroll down to see JAVA and C# code also    */
/*

    Company Tags  : Facebook, Amazon, Bloomberg, Google, tiktok, Adobe
    Frequency     : Facebook(111), Amazon(7), Bloomberg(4), Google(3), tiktok(2), Adobe(2) - I got this information from my friends. Please verify
    Leetcode Link : https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
*/

/***************************************************************************** C++ **********************************************************************/
//(Simplified : Playing smart and keeping it simple)
//T.C : O(n)
//S.C : O(n)
class Solution {
public:
    string minRemoveToMakeValid(string s) {
        int open = 0;
        string temp = "";
        
        for(char c:s) {
            if(c == '(') {
                open++;
            } else if(c == ')') {
                if(open == 0)
                    continue;
                open--;
            }
            
            temp.push_back(c);
        }
        
        int n = temp.length();
        string result = "";
        for(int i = n-1; i>=0; i--) {
            if(temp[i] == '(' && open-- > 0)
                continue;
            result.push_back(temp[i]);
        }
        
        reverse(result.begin(), result.end());
        return result;
    }
};



/***************************************************************************** Java **********************************************************************/


//(Simplified : Playing smart and keeping it simple)
//T.C : O(n)
//S.C : O(n)
class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        StringBuilder temp = new StringBuilder();
        
        for(char c: s.toCharArray()) {
            if(c == '(') 
                open++;
            else if(c == ')') {
                if(open == 0)
                    continue;
                open--;
            }
            
            temp.append(c);
        }
        
        StringBuilder result = new StringBuilder();
        for(int i = temp.length() - 1; i >= 0; i--) {
            if(temp.charAt(i) == '(' && open-- > 0)
                continue;
            result.insert(0, temp.charAt(i));
        }
        
        return result.toString();
    }
}

/***************************************************************************** C# **********************************************************************/
using System.Text;

public class Solution {
    public string MinRemoveToMakeValid(string s) {
        int open = 0;
        StringBuilder temp = new StringBuilder();

        foreach (char c in s) {
            if (c == '(')
                open++;
            else if (c == ')') {
                if (open == 0)
                    continue;
                open--;
            }

            temp.Append(c);
        }

        StringBuilder result = new StringBuilder();
        for (int i = temp.Length - 1; i >= 0; i--) {
            if (temp[i] == '(' && open-- > 0)
                continue;
            result.Insert(0, temp[i]);
        }

        return result.ToString();
    }
}

