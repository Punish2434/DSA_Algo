/*         Scroll down to see JAVA code  and C# also        */
/*
    Company Tags  : Snapchat, Microsoft, Google, Meta
    Leetcode Link : https://leetcode.com/problems/remove-k-digits/
*/


/ C++ ********************************************************************************************************************************/
//Using simple Monotonic Nature of Numbers
//T.C : O(n)
//S.C : O(1) - I am ignoring the space taken for result variable
class Solution {
public:
    string removeKdigits(string num, int k) {
        
        string result = ""; //it will act like a stack
        int n = num.length();
        
        for(int i = 0; i < n; i++) {
            
            while(result.length() > 0 && result.back() > num[i] && k > 0) {
                result.pop_back();
                k--;
            }
            
            if(result.length() > 0 || num[i] != '0') {
                result.push_back(num[i]); //to avoid the case when we have preceeding zeros
            }
            
        }
        
        
        while(result.length() > 0 && k > 0) {
            result.pop_back();
            k--;
        }

        if(result == "") {
            return "0";
        }
        
        return result;
        
    }
};


/ JAVA *****************************************************************************************************************/
//T.C : O(n)
//S.C : O(n)
public class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder result = new StringBuilder(); // it will act like a stack
        int n = num.length();
        
        for(int i = 0; i < n; i++) {
            while(result.length() > 0 && result.charAt(result.length() - 1) > num.charAt(i) && k > 0) {
                result.deleteCharAt(result.length() - 1);
                k--;
            }
            
            if(result.length() > 0 || num.charAt(i) != '0') {
                result.append(num.charAt(i)); // to avoid the case when we have preceding zeros
            }
        }
        
        while(result.length() > 0 && k > 0) {
            result.deleteCharAt(result.length() - 1);
            k--;
        }

        if(result.length() == 0) {
            return "0";
        }
        
        return result.toString();
    }
}

/ C# *****************************************************************************************************************/


public class Solution
{
    public string RemoveKdigits(string num, int k)
    {
        StringBuilder result = new StringBuilder(); // It will act like a stack
        int n = num.Length;

        // Iterate through each digit in the input number
        for (int i = 0; i < n; i++)
        {
            // While the result stack is not empty, the current digit is smaller than the top of the stack,
            // and we still have remaining removals (k > 0), remove the top element from the stack.
            while (result.Length > 0 && result[result.Length - 1] > num[i] && k > 0)
            {
                result.Remove(result.Length - 1, 1);
                k--;
            }

            // Append the current digit to the result stack if it is not a leading zero.
            if (result.Length > 0 || num[i] != '0')
            {
                result.Append(num[i]);
            }
        }

        // If there are still remaining removals (k > 0), remove digits from the end of the result stack.
        while (result.Length > 0 && k > 0)
        {
            result.Remove(result.Length - 1, 1);
            k--;
        }

        // If the result stack is empty, return "0"; otherwise, convert it to a string and return.
        if (result.Length == 0)
        {
            return "0";
        }

        return result.ToString();
    }
}


// Explanation:
// 1. The `RemoveKdigits` function takes two parameters: `num` (the input number as a string) and `k` (the number of digits to remove).
// 2. We use a `StringBuilder` named `result` to simulate a stack. It will store the digits of the smallest possible number.
// 3. The loop iterates through each digit in the input number (`num`).
// 4. Inside the loop:
//    - We compare the current digit with the top of the stack (if the stack is not empty).
//    - If the current digit is smaller than the top of the stack and we have remaining removals (`k > 0`), we remove the top element from the stack.
//    - We append the current digit to the stack if it is not a leading zero (i.e., the stack is not empty or the digit is not '0').
// 5. After processing all digits, we handle any remaining removals by removing digits from the end of the stack.
// 6. Finally, we check if the stack is empty. If so, we return "0"; otherwise, we convert the stack to a string and return it.




// - The `StringBuilder` class in C# is used to build and manipulate strings efficiently.
// - The `result.Remove(result.Length - 1, 1)` removes the last character from the `result` string.
