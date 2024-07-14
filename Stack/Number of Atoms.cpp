/*     Scroll below to see JAVA code and C# also    */
/*
        Company Tags                : GOOGLE
        Leetcode Link               : https://leetcode.com/problems/number-of-atoms
*/


/ C++ ********************************************************************************************************************************************/
//Using stack
//T.C : O(n^2)
//S.C : O(n)
class Solution {
public:
    typedef unordered_map<string, int> MAP;

    string countOfAtoms(string formula) {
        int n = formula.length();
        
        stack<MAP> st;
        st.push(MAP());

        int i = 0;

        while (i < n) {
            if (formula[i] == '(') {
                st.push(MAP());
                i++;
            } else if (formula[i] == ')') {
                MAP currMap = st.top();
                st.pop();
                i++;
                string multiplier;
                while (i < formula.length() && isdigit(formula[i])) {
                    multiplier += formula[i];
                    i++;
                }
                if (!multiplier.empty()) {
                    int mult = stoi(multiplier);
                    for (auto& [atom, count] : currMap) {
                        currMap[atom] = count * mult;
                    }
                }

                for (auto& [atom, count] : currMap) {
                    st.top()[atom] += count;
                }
            } else {
                string currAtom;
                currAtom += formula[i];
                i++;
                while (i < formula.length() && islower(formula[i])) {
                    currAtom += formula[i];
                    i++;
                }

                string currCount;
                while (i < formula.length() && isdigit(formula[i])) {
                    currCount += formula[i];
                    i++;
                }

                int count = currCount.empty() ? 1 : stoi(currCount);
                st.top()[currAtom] += count;
            }
 
        }
        
        map<string, int> sortedMap(begin(st.top()), end(st.top()));

        string result;
        for (auto& [atom, count] : sortedMap) {
            result += atom;
            if (count > 1) {
                result += to_string(count);
            }
        }

        return result;
    }
};


/ JAVA ********************************************************************************************************************************************/
//Using stack
//T.C : O(n^2)
//S.C : O(n)
class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();

        Stack<Map<String, Integer>> stack = new Stack<>();
        
        stack.push(new HashMap<>());

        int i = 0;
        while (i < n) {
            if (formula.charAt(i) == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = stack.pop();
                i++;
                StringBuilder sb = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    sb.append(formula.charAt(i));
                    i++;
                }
                int multiplier = sb.length() > 0 ? Integer.parseInt(sb.toString()) : 1;
                for (String key : top.keySet()) {
                    int value = top.get(key);
                    top.put(key, value * multiplier);
                }
                for (String key : top.keySet()) {
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0) + top.get(key));
                }
            } else {
                StringBuilder element = new StringBuilder();
                element.append(formula.charAt(i++));
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    element.append(formula.charAt(i++));
                }
                StringBuilder sb = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    sb.append(formula.charAt(i++));
                }
                int count = sb.length() > 0 ? Integer.parseInt(sb.toString()) : 1;
                stack.peek().put(element.toString(), stack.peek().getOrDefault(element.toString(), 0) + count);
            }
        }

        TreeMap<String, Integer> sortedMap = new TreeMap<>(stack.peek());
        StringBuilder result = new StringBuilder();
        for (String key : sortedMap.keySet()) {
            result.append(key);
            int count = sortedMap.get(key);
            if (count > 1) {
                result.append(count);
            }
        }
        return result.toString();
    }
}
/ C# ********************************************************************************************************************************************/
//Using stack
//T.C : O(n^2)
//S.C : O(n)

using System;
using System.Collections.Generic;
using System.Text;

public class Solution
{
    public string CountOfAtoms(string formula)
    {
        int n = formula.Length;

        Stack<Dictionary<string, int>> stack = new Stack<Dictionary<string, int>>();
        stack.Push(new Dictionary<string, int>());

        int i = 0;
        while (i < n)
        {
            if (formula[i] == '(')
            {
                stack.Push(new Dictionary<string, int>());
                i++;
            }
            else if (formula[i] == ')')
            {
                Dictionary<string, int> top = stack.Pop();
                i++;
                StringBuilder sb = new StringBuilder();
                while (i < n && Char.IsDigit(formula[i]))
                {
                    sb.Append(formula[i]);
                    i++;
                }
                int multiplier = sb.Length > 0 ? int.Parse(sb.ToString()) : 1;
                foreach (var key in new List<string>(top.Keys))
                {
                    int value = top[key];
                    top[key] = value * multiplier;
                }
                foreach (var key in top.Keys)
                {
                    if (stack.Peek().ContainsKey(key))
                    {
                        stack.Peek()[key] += top[key];
                    }
                    else
                    {
                        stack.Peek()[key] = top[key];
                    }
                }
            }
            else
            {
                StringBuilder element = new StringBuilder();
                element.Append(formula[i++]);
                while (i < n && Char.IsLower(formula[i]))
                {
                    element.Append(formula[i++]);
                }
                StringBuilder sb = new StringBuilder();
                while (i < n && Char.IsDigit(formula[i]))
                {
                    sb.Append(formula[i++]);
                }
                int count = sb.Length > 0 ? int.Parse(sb.ToString()) : 1;
                string elementStr = element.ToString();
                if (stack.Peek().ContainsKey(elementStr))
                {
                    stack.Peek()[elementStr] += count;
                }
                else
                {
                    stack.Peek()[elementStr] = count;
                }
            }
        }

        SortedDictionary<string, int> sortedMap = new SortedDictionary<string, int>(stack.Peek());
        StringBuilder result = new StringBuilder();
        foreach (var key in sortedMap.Keys)
        {
            result.Append(key);
            int count = sortedMap[key];
            if (count > 1)
            {
                result.Append(count);
            }
        }
        return result.ToString();
    }
}
