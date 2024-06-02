/*    Scroll below to see JAVA code and C# also  */
/*
    Company Tags           : Amazon,Google
    GFG Link               : https://www.geeksforgeeks.org/problems/construct-list-using-given-q-xor-queries/1
*/

/ C++ **************************************************************************************************************************/
//T.C : O(q*log(q))
//S.C : O(l)
#include <vector>
#include <algorithm>

class Solution {
public:
    std::vector<int> constructList(int q, std::vector<std::vector<int>>& queries) {
        std::vector<int> s;
        s.push_back(0);  // Initial value in the list
        int cumulativeXor = 0;  // Track the cumulative XOR value

        for (int i = 0; i < q; i++) {
            int type = queries[i][0];
            int x = queries[i][1];

            if (type == 0) {
                // Insert x into the list
                s.push_back(x ^ cumulativeXor);
            } else if (type == 1) {
                // Update the cumulative XOR value
                cumulativeXor ^= x;
            }
        }

        // Apply the cumulative XOR to all elements in the list
        for (int j = 0; j < s.size(); j++) {
            s[j] ^= cumulativeXor;
        }

        // Sort the final list
        std::sort(s.begin(), s.end());
        return s;
    }
};

/ Java **************************************************************************************************************************/
//T.C : O(q*log(q))
//S.C : O(l)
class Solution {
    public ArrayList<Integer> constructList(int q, int[][] queries) {
        ArrayList<Integer> s = new ArrayList<>();
        s.add(0);  // Initial value in the list
        int cumulativeXor = 0;  // Track the cumulative XOR value

        for (int i = 0; i < q; i++) {
            int type = queries[i][0];
            int x = queries[i][1];

            if (type == 0) {
                // Insert x into the list
                s.add(x ^ cumulativeXor);
            } else if (type == 1) {
                // Update the cumulative XOR value
                cumulativeXor ^= x;
            }
        }

        // Apply the cumulative XOR to all elements in the list
        for (int j = 0; j < s.size(); j++) {
            s.set(j, s.get(j) ^ cumulativeXor);
        }

        // Sort the final list
        Collections.sort(s);
        return s;
    }
}
/ C# **************************************************************************************************************************/
//T.C : O(q*log(q))
//S.C : O(l)
using System;
using System.Collections.Generic;

public class Solution {
    public List<int> ConstructList(int q, int[][] queries) {
        List<int> s = new List<int>();
        s.Add(0);  // Initial value in the list
        int cumulativeXor = 0;  // Track the cumulative XOR value

        for (int i = 0; i < q; i++) {
            int type = queries[i][0];
            int x = queries[i][1];

            if (type == 0) {
                // Insert x into the list
                s.Add(x ^ cumulativeXor);
            } else if (type == 1) {
                // Update the cumulative XOR value
                cumulativeXor ^= x;
            }
        }

        // Apply the cumulative XOR to all elements in the list
        for (int j = 0; j < s.Count; j++) {
            s[j] ^= cumulativeXor;
        }

        // Sort the final list
        s.Sort();
        return s;
    }
}

