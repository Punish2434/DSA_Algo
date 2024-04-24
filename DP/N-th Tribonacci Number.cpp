/*    Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : AMAZON
    Leetcode Link               : https://leetcode.com/problems/n-th-tribonacci-number/
*/

/ C++ **********************************************************************************/
//Approach-1 (Recursion + Memoization)
//T.C : Without Memoization - O(3^n) and with Memoization - o(n)
//S.C : O(n) (But size of t is 38 which is constant hence O(1))
class Solution {
public:
    int t[38];
    int find(const int& n) {
        if(n == 0)           return 0;
        if(n == 1 || n == 2) return 1;
        if(t[n] != -1)       return t[n];
        
        int a = find(n-1);
        int b = find(n-2);
        int c = find(n-3);
            
        
        return t[n] = a+b+c;
    }
    int tribonacci(int n) {
        memset(t, -1, sizeof(t));
        
        return find(n);
    }
};


//Approach-2 (Using Bottom Up DP)
//T.C : O(n)
//S.C : O(n)  (But size of t is 38 which is constant hence O(1))
class Solution {
public:
    int tribonacci(int n) {
        int t[38];

        t[0] = 0;
        t[1] = 1;
        t[2] = 1;
        
        for (int i = 3; i <= 37; i++) {
            t[i] = t[i-1] + t[i - 2] + t[i - 3];
        }
        
        return t[n];
    }
};


//APproach-3 (Using constant space)
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        
        int a = 0;
        int b = 1;
        int c = 1
        int d;
        
        for(int i = 3; i <= n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        
        return d;
    }
};


/ JAVA **********************************************************************************/
// Approach-1 (Recursion + Memoization)
// T.C: Without Memoization - O(3^n) and with Memoization - O(n)
// S.C: O(n) (But size of t is 38 which is constant hence O(1))
class Solution {
    int[] t = new int[38];
    
    public int find(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (t[n] != -1) return t[n];
        
        int a = find(n - 1);
        int b = find(n - 2);
        int c = find(n - 3);
        
        return t[n] = a + b + c;
    }
    
    public int tribonacci(int n) {
        Arrays.fill(t, -1);
        return find(n);
    }
}

// Approach-2 (Using Bottom Up DP)
// T.C: O(n)
// S.C: O(n) (But size of t is 38 which is constant hence O(1))
class Solution {
    public int tribonacci(int n) {
        int[] t = new int[38];

        t[0] = 0;
        t[1] = 1;
        t[2] = 1;
        
        for (int i = 3; i <= 37; i++) {
            t[i] = t[i-1] + t[i - 2] + t[i - 3];
        }
        
        return t[n];
    }
}

// Approach-3 (Using constant space)
// T.C: O(n)
// S.C: O(1)
class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        
        int a = 0;
        int b = 1;
        int c = 1;
        int d = 0;
        
        for (int i = 3; i <= n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        
        return d;
    }
}
/ C# **********************************************************************************/
// Approach-1 (Recursion + Memoization)
// T.C: Without Memoization - O(3^n) and with Memoization - O(n)
// S.C: O(n) (But size of t is 38 which is constant hence O(1))

using System;

public class Solution {
    private int[] t = new int[38];

    public int Find(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (t[n] != -1) return t[n];

        int a = Find(n - 1);
        int b = Find(n - 2);
        int c = Find(n - 3);

        return t[n] = a + b + c;
    }

    public int Tribonacci(int n) {
        Array.Fill(t, -1);
        return Find(n);
    }
}

// Approach-2 (Using Bottom Up DP)
// T.C: O(n)
// S.C: O(n) (But size of t is 38 which is constant hence O(1))
using System;

public class Solution {
    public int Tribonacci(int n) {
        // Create an array to store Tribonacci numbers
        int[] t = new int[38];

        // Initialize the first three Tribonacci numbers
        t[0] = 0;
        t[1] = 1;
        t[2] = 1;

        // Compute the remaining Tribonacci numbers
        for (int i = 3; i <= 37; i++) {
            t[i] = t[i - 1] + t[i - 2] + t[i - 3];
        }

        // Return the Tribonacci number at index n
        return t[n];
    }
}


// Approach-3 (Using constant space)
// T.C: O(n)
// S.C: O(1)

using System;

public class Solution {
    public int Tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int a = 0;
        int b = 1;
        int c = 1;
        int d = 0;

        for (int i = 3; i <= n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }

        return d;
    }
}
