/*     Scroll below to see JAVA code and C# also    */
/*
      Company Tags                : 
      GFG Link               : https://geeksforgeeks.org/problems/binary-representation-of-next-number3648/1
*/


/ C++ ************************************************************************************************************************/

// Time Complexity:- O(N)
// Space Complexity:- O(N)
  
class Solution {
    string binaryNextNumber(string s) {
        // code here.
        bool indication=true;
        for(int i=s.length();i>=0;i--){
            if(s[i]=='0'){
                indication=false;
                s[i]='1';
                break;
            }
            else s[i]='0';
        }
        if(indication){
            s='1'+s;
        }
        else{
            while(s[0]=='0')s.erase(s.begin());
        }
        return s;
    }
}
/ Java ************************************************************************************************************************/
// Time Complexity:- O(N)
// Space Complexity:- O(N)
class Solution {
    String binaryNextNumber(String s) {
        // code here.
        boolean indication=true;
        char[] temp = s.toCharArray();
        for(int i=s.length()-1;i>=0;i--){
            if(temp[i]=='0'){
                temp[i]='1';
                indication=false;
                break;
            }
            else temp[i]='0';
        }
        StringBuilder ans = new StringBuilder();
        if(indication==true){
            ans.append('1');
            ans.append(temp);
        }
        else{
            int index=0;
            while(index<s.length() && temp[index]=='0')index++;
            ans.append(temp,index,s.length()-index);
        }
        return ans.toString();
    }
}

/ C# ************************************************************************************************************************/

// Time Complexity:- O(N)
// Space Complexity:- O(N)
using System;
using System.Text;

public class Solution
{
    public string BinaryNextNumber(string s)
    {
        bool indication = true;
        char[] temp = s.ToCharArray();
        for (int i = s.Length - 1; i >= 0; i--)
        {
            if (temp[i] == '0')
            {
                temp[i] = '1';
                indication = false;
                break;
            }
            else
            {
                temp[i] = '0';
            }
        }

        StringBuilder ans = new StringBuilder();
        if (indication)
        {
            ans.Append('1');
            ans.Append(temp);
        }
        else
        {
            int index = 0;
            while (index < s.Length && temp[index] == '0')
            {
                index++;
            }
            ans.Append(temp, index, s.Length - index);
        }

        return ans.ToString();
    }

    static void Main(string[] args)
    {
        Solution solution = new Solution();
        string input = "11010";
        string nextNumber = solution.BinaryNextNumber(input);
        Console.WriteLine($"Next binary number: {nextNumber}");
    }
}
