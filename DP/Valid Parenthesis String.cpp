/*     Scroll below to see JAVA code  and C# also   */
/*
    Company Tags                : META
    Leetcode Link               : https://leetcode.com/problems/valid-parenthesis-string/
*/

/ C++ ******************************************************************************************************************************/



// (Constant Space)
//T.C : O(n)
//S.C :O(1)
//NOTE : You can easily combine both for loops in just a single for loop. I have written them separately for sake of simplicity and understanding
class Solution {
public:
    bool checkValidString(string s) {
        int open = 0;
        int close = 0;
        int n = s.length();
        
        //Left to Right - Check Open Brackets
        for (int i = 0; i < n; i++) {

            if (s[i] == '(' || s[i] == '*') {
                open++;
            } else {
                open--;
            }
                
            if (open < 0) {
                return false;
            }
        }

        //Right to Left - Check CLose Brackets
        for (int i = n - 1; i >= 0; i--) {
            
            if (s[i] == ')' || s[i] == '*') {
                close++;
            } else {
                close--;
            }
            
            
            if (close < 0) {
                return false;
            }
        }
        
        return true;
    }
};


/ JAVA ******************************************************************************************************************************/


//(Constant Space)
//T.C : O(n)
//S.C :O(1)
//NOTE : You can easily combine both for loops in just a single for loop. I have written them separately for sake of simplicity and understanding
class Solution {
    public boolean checkValidString(String s) {
        int open = 0;
        int close = 0;
        int n = s.length();
        
        // Left to Right - Check Open Brackets
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                open++;
            } else {
                open--;
            }
                
            if (open < 0) {
                return false;
            }
        }

        // Right to Left - Check Close Brackets
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || s.charAt(i) == '*') {
                close++;
            } else {
                close--;
            }
            
            if (close < 0) {
                return false;
            }
        }
        
        return true;
    }
}


/ C# ******************************************************************************************************************************/
Certainly! Below is the equivalent C# code for the given Java code that checks the validity of a string containing parentheses and asterisks:

```csharp
public class Solution
{
    public bool CheckValidString(string s)
    {
        int open = 0;
        int close = 0;
        int n = s.Length;

        // Left to Right - Check Open Brackets
        for (int i = 0; i < n; i++)
        {
            if (s[i] == '(' || s[i] == '*')
            {
                open++;
            }
            else
            {
                open--;
            }

            if (open < 0)
            {
                return false;
            }
        }

        // Right to Left - Check Close Brackets
        for (int i = n - 1; i >= 0; i--)
        {
            if (s[i] == ')' || s[i] == '*')
            {
                close++;
            }
            else
            {
                close--;
            }

            if (close < 0)
            {
                return false;
            }
        }

        return true;
    }
}
```

// Explanation:
// - The `CheckValidString` method checks whether the input string `s` contains a valid combination of parentheses and asterisks.
// - It iterates through the string from left to right, tracking the count of open brackets (`(`) and asterisks (`*`).
// - If the count of open brackets becomes negative at any point, the method returns `false`.
// - It then iterates through the string from right to left, tracking the count of close brackets (`)`) and asterisks.
// - Again, if the count of close brackets becomes negative, the method returns `false`.
// - If both checks pass, the method returns `true`, indicating that the string is valid.
