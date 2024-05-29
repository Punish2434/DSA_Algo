/*    Scroll below to see JAVA code and C# also    */
/*
  
    Company Tags                : 
    Leetcode Link               : https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one
*/

/ C++ **********************************************************************************************************************************/
//Approach-1 (Simple simulation - Do what is beinhg asked)
//T.C : O(n^2)
//S.C : O(1)
class Solution {
public:
    void addOne(string &s) {
        int i = s.length()-1;

        while(i >= 0 && s[i] != '0') {
            s[i] = '0';
            i--;
        }

        if(i < 0) {
            s = '1' + s;
        } else {
            s[i] = '1';
        }
    }

    int numSteps(string s) {
        int op = 0;

        while(s.length() > 1) {
            int n = s.length();

            if(s[n-1] == '0') {
                s.pop_back();
            } else {
                addOne(s);
            }

            op++;
        }

        return op;
    }
};


//Approach-2 (Simply calculating for odd and even)
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    int numSteps(string s) {
        int n = s.length();

        int op = 0;
        int carry = 0;

        for(int i = n-1; i >= 1; i--) {
            if(((s[i] - '0') + carry) % 2 == 1) { //odd
                op += 2;
                carry = 1;
            } else {
                op += 1;
            }
        }

        return op + carry;
    }
};


/ JAVA **********************************************************************************************************************************/
//Approach-1 (Simple simulation - Do what is beinhg asked)
//T.C : O(n^2)
//S.C : O(1)
public class Solution {
    public void addOne(StringBuilder s) {
        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) != '0') {
            s.setCharAt(i, '0');
            i--;
        }

        if (i < 0) {
            s.insert(0, '1');
        } else {
            s.setCharAt(i, '1');
        }
    }

    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int op = 0;

        while (sb.length() > 1) {
            int n = sb.length();

            if (sb.charAt(n - 1) == '0') {
                sb.deleteCharAt(n - 1);
            } else {
                addOne(sb);
            }

            op++;
        }

        return op;
    }
}


//Approach-2 (Simply calculating for odd and even)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int numSteps(String s) {
        int n = s.length();
        int op = 0;
        int carry = 0;

        for (int i = n - 1; i >= 1; i--) {
            if (((s.charAt(i) - '0') + carry) % 2 == 1) { // odd
                op += 2;
                carry = 1;
            } else {
                op += 1;
            }
        }

        return op + carry;
    }
}
/ C# **********************************************************************************************************************************/
//Approach-1 (Simple simulation - Do what is beinhg asked)
//T.C : O(n^2)
//S.C : O(1)
public class Solution {
    public void AddOne(ref StringBuilder s) {
        int i = s.Length - 1;

        while (i >= 0 && s[i] != '0') {
            s[i] = '0';
            i--;
        }

        if (i < 0) {
            s.Insert(0, '1');
        } else {
            s[i] = '1';
        }
    }

    public int NumSteps(string s) {
        StringBuilder sb = new StringBuilder(s);
        int op = 0;

        while (sb.Length > 1) {
            int n = sb.Length;

            if (sb[n - 1] == '0') {
                sb.Remove(n - 1, 1);
            } else {
                AddOne(ref sb);
            }

            op++;
        }

        return op;
    }
}
//Approach-2 (Simply calculating for odd and even)
//T.C : O(n)
//S.C : O(1)

public class Solution {
    public int NumSteps(string s) {
        int n = s.Length;
        int op = 0;
        int carry = 0;

        for (int i = n - 1; i >= 1; i--) {
            if (((s[i] - '0') + carry) % 2 == 1) { // odd
                op += 2;
                carry = 1;
            } else {
                op += 1;
            }
        }

        return op + carry;
    }
}

