/*     Scroll below to see JAVA Code and C# also    */
/*
      Company Tags                : 
      Leetcode Link               : https://leetcode.com/problems/robot-collisions/description
*/


/ C++ *******************************************************************************************************************************************************/
//Using Stack
//T.C : O(nlogn)
//T.C : O(n)
class Solution {
public:
    vector<int> survivedRobotsHealths(vector<int>& positions, vector<int>& healths, string directions) {
        int n = positions.size();
        vector<int> indices(n);
        
        iota(indices.begin(), indices.end(), 0); //This will fill the array as -> 0, 1, 2, 3, 4, n-1
        stack<int> st;

        auto lambda = [&](int i, int j) {
            return positions[i] < positions[j];
        };

        sort(begin(indices), end(indices), lambda);

        vector<int> result;
        for (int currentIndex : indices) {
            if (directions[currentIndex] == 'R') {
                st.push(currentIndex);
            } else {
                while (!st.empty() && healths[currentIndex] > 0) {
                    int topIndex = st.top();
                    st.pop();

                    if (healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        st.push(topIndex);
                    } else if (healths[topIndex] < healths[currentIndex]) {
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;
                    } else {
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            if (healths[i] > 0) {
                result.push_back(healths[i]);
            }
        }
        return result;
    }
};




/ JAVA *******************************************************************************************************************************************************/
//Using Stack
//T.C : O(nlogn)
//T.C : O(n)
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Stack<Integer> stack = new Stack<>();

        Arrays.sort(indices, (i, j) -> Integer.compare(positions[i], positions[j]));

        List<Integer> result = new ArrayList<>();
        
        for (int currentIndex : indices) {
            if (directions.charAt(currentIndex) == 'R') {
                stack.push(currentIndex);
            } else {
                while (!stack.isEmpty() && healths[currentIndex] > 0) {
                    int topIndex = stack.pop();

                    if (healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        stack.push(topIndex);
                    } else if (healths[topIndex] < healths[currentIndex]) {
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;
                    } else {
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                result.add(healths[i]);
            }
        }

        return result;
    }
}

/ C# *******************************************************************************************************************************************************/
//Using Stack
//T.C : O(nlogn)
//T.C : O(n)
using System;
using System.Collections.Generic;

public class Solution
{
    public IList<int> SurvivedRobotsHealths(int[] positions, int[] healths, string directions)
    {
        int n = positions.Length;
        int[] indices = new int[n];

        for (int i = 0; i < n; i++)
        {
            indices[i] = i;
        }

        Stack<int> stack = new Stack<int>();

        Array.Sort(indices, (i, j) => positions[i].CompareTo(positions[j]));

        List<int> result = new List<int>();

        foreach (int currentIndex in indices)
        {
            if (directions[currentIndex] == 'R')
            {
                stack.Push(currentIndex);
            }
            else
            {
                while (stack.Count > 0 && healths[currentIndex] > 0)
                {
                    int topIndex = stack.Pop();

                    if (healths[topIndex] > healths[currentIndex])
                    {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        stack.Push(topIndex);
                    }
                    else if (healths[topIndex] < healths[currentIndex])
                    {
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;
                    }
                    else
                    {
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++)
        {
            if (healths[i] > 0)
            {
                result.Add(healths[i]);
            }
        }

        return result;
    }
}
