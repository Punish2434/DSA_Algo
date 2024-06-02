/*    Scroll below to see JAVA code and C# also  */
/*
    Company Tags                : 
    Leetcode Link               : https://leetcode.com/problems/reverse-string/
*/

/ C++ **************************************************************************************************************************/
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    void reverseString(vector<char>& s) {
        int left = 0;
        int right = s.size() - 1;
        
        while (left < right) {
            // Swap the characters at the left and right indices
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            // Move the indices towards the center
            left++;
            right--;
        }
    }
};
/ Java **************************************************************************************************************************/
//T.C : O(n)
//S.C : O(1)
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        
        while (left < right) {
            // Swap the characters at the left and right indices
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            // Move the indices towards the center
            left++;
            right--;
        }
    }
}

/ C# **************************************************************************************************************************/
//T.C : O(n)
//S.C : O(1)
public class Solution {
    public void ReverseString(char[] s) {
        int left = 0;
        int right = s.Length - 1;
        
        while (left < right) {
            // Swap the characters at the left and right indices
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            // Move the indices towards the center
            left++;
            right--;
        }
    }
}
