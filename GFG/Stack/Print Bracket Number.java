
/*     Scroll below to see JAVA code and C# also  */
/*
    Company Tags                : Flipkart
    Leetcode Link               : https://www.geeksforgeeks.org/problems/print-bracket-number4058/1


/ C++ ************************************************************************************************************************/
//Approach-1 (each opening and closing bracket pair)
// Time Complexity: O(n)
// Space Complexity: O(n)

#include <iostream>
#include <vector>
#include <stack>
using namespace std;

vector<int> bracketNumbers(string str) {
    vector<int> result;
    stack<int> stack;
    int counter = 1;

    for (char ch : str) {
        if (ch == '(') {
            stack.push(counter);
            result.push_back(counter);
            counter++;
        } else if (ch == ')') {
            if (!stack.empty()) {
                result.push_back(stack.pop());
            }
        }
    }

    return result;
}

int main() {
    string str = "(d(())l()()m()(())(na(q)h)(c)qzk(fo(q()((((csba()";
    vector<int> result = bracketNumbers(str);
    for (int num : result) {
        cout << num << " ";
    }
    cout << endl;
    return 0;
}

/ Java ************************************************************************************************************************/
//Approach-1 (each opening and closing bracket pair)
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.ArrayList;
import java.util.Stack;

class Solution {
    ArrayList<Integer> bracketNumbers(String str) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int counter = 1;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(counter);
                result.add(counter);
                counter++;
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    result.add(stack.pop());
                }
            }
        }

        return result;
    }
}

/ C# ************************************************************************************************************************/
//Approach-1 (each opening and closing bracket pair)
// Time Complexity: O(n)
// Space Complexity: O(n)

using System;
using System.Collections.Generic;

class Solution {
    public List<int> BracketNumbers(string str) {
        List<int> result = new List<int>();
        Stack<int> stack = new Stack<int>();
        int counter = 1;

        foreach (char ch in str) {
            if (ch == '(') {
                stack.Push(counter);
                result.Add(counter);
                counter++;
            } else if (ch == ')') {
                if (stack.Count > 0) {
                    result.Add(stack.Pop());
                }
            }
        }

        return result;
    }
}

class Program {
    static void Main() {
        string str = "(d(())l()()m()(())(na(q)h)(c)qzk(fo(q()((((csba()";
        Solution sol = new Solution();
        List<int> result = sol.BracketNumbers(str);
        foreach (int num in result) {
            Console.Write(num + " ");
        }
    }
}


