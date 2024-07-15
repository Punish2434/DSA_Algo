/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags           : OYO Rooms,MAQ Software
    GFG Link               : https://www.geeksforgeeks.org/problems/smallest-number5829/1
*/


/ C++ ****************************************************************************************************************/
//T.C : O(d)
//S.C : O(1)

  class Solution {
  public:
    string smallestNumber(int s, int d) {
        if((9*d)<s) return "-1";
        string ans="";
        for(int i= d-1;i>=0;i--){
            if(s>9){
                ans='9'+ans;
                s-=9;
            }
            else{
                if(i==0){
                    ans=to_string(s)+ans;
                }
                else{
            
                ans=to_string(s-1)+ans;
                i--;
                while(i>0){
                    ans='0'+ans;
                    i--;
                }
                ans='1'+ans;
                break;
                
            }
        }
    }
    return ans;
    }
};

/ Java ****************************************************************************************************************/
//T.C : O(d)
//S.C : O(1)
class Solution {
    public String smallestNumber(int s, int d) {
        if ((9 * d) < s) return "-1";
        String ans = "";
        for (int i = d - 1; i >= 0; i--) {
            if (s > 9) {
                ans = '9' + ans;
                s -= 9;
            } else {
                if (i == 0) {
                    ans = s + ans;
                } else {
                    ans = (s - 1) + ans;
                    i--;
                    while (i > 0) {
                        ans = '0' + ans;
                        i--;
                    }
                    ans = '1' + ans;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestNumber(9, 2));  // Output: 18
        System.out.println(solution.smallestNumber(20, 3));  // Output: 299
    }
}
/ C# ****************************************************************************************************************/
//T.C : O(d)
//S.C : O(1)
using System;

public class Solution {
    public string SmallestNumber(int s, int d) {
        if ((9 * d) < s) return "-1";
        string ans = "";
        for (int i = d - 1; i >= 0; i--) {
            if (s > 9) {
                ans = '9' + ans;
                s -= 9;
            } else {
                if (i == 0) {
                    ans = s.ToString() + ans;
                } else {
                    ans = (s - 1).ToString() + ans;
                    i--;
                    while (i > 0) {
                        ans = '0' + ans;
                        i--;
                    }
                    ans = '1' + ans;
                    break;
                }
            }
        }
        return ans;
    }

    public static void Main(string[] args) {
        Solution solution = new Solution();
        Console.WriteLine(solution.SmallestNumber(9, 2));  // Output: 18
        Console.WriteLine(solution.SmallestNumber(20, 3));  // Output: 299
    }
  / JavaScript ****************************************************************************************************************/
//T.C : O(d)
//S.C : O(1)
class Solution {
    smallestNumber(s, d) {
        if ((9 * d) < s) return "-1";
        let ans = "";
        for (let i = d - 1; i >= 0; i--) {
            if (s > 9) {
                ans = '9' + ans;
                s -= 9;
            } else {
                if (i === 0) {
                    ans = s.toString() + ans;
                } else {
                    ans = (s - 1).toString() + ans;
                    i--;
                    while (i > 0) {
                        ans = '0' + ans;
                        i--;
                    }
                    ans = '1' + ans;
                    break;
                }
            }
        }
        return ans;
    }
}

// Example usage
const solution = new Solution();
console.log(solution.smallestNumber(9, 2));  // Output: 18
console.log(solution.smallestNumber(20, 3));  // Output: 299

