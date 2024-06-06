/*   Scroll below to see JAVA code and C# also  */
/*
    Company Tags                : Google
    Leetcode Link               : https://leetcode.com/problems/hand-of-straights
*/

/ C++ ************************************************************************************************************************************/

//Approach (Simply using map)
//T.C  : O(nlogn) + O(n*groupSize)
//S.C  : O(n)
class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        int n = hand.size();

        if(n % groupSize) {
            return false;
        }

        map<int, int> mp;
        for(int &handNumber : hand) {
            mp[handNumber]++; //O(nlogn)
        }

        while(!mp.empty()) { //O(n*groupSize)

            int curr = mp.begin()->first; //->second : frequency

            for(int i = 0; i < groupSize; i++) {
                if(mp[curr + i] == 0) {
                    return false;
                }

                mp[curr+i]--;
                if(mp[curr+i] < 1) {
                    mp.erase(curr+i);
                }
            }

        }

        return true;
        
    }
};

/ Java ************************************************************************************************************************************/

//Approach (Simply using map)
//T.C  : O(nlogn) + O(n*groupSize)
//S.C  : O(n)
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if (n % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        while (!map.isEmpty()) {
            int curr = map.firstKey();

            for (int i = 0; i < groupSize; i++) {
                if (!map.containsKey(curr + i)) {
                    return false;
                }

                map.put(curr + i, map.get(curr + i) - 1);
                if (map.get(curr + i) == 0) {
                    map.remove(curr + i);
                }
            }
        }

        return true;
    }
}

/ C# ************************************************************************************************************************************/

//Approach (Simply using map)
//T.C  : O(nlogn) + O(n*groupSize)
//S.C  : O(n)

```csharp
using System;
using System.Collections.Generic;

public class Solution {
    public bool IsNStraightHand(int[] hand, int groupSize) {
        int n = hand.Length;

        if (n % groupSize != 0) {
            return false;
        }

        SortedDictionary<int, int> map = new SortedDictionary<int, int>();
        foreach (int card in hand) {
            if (!map.ContainsKey(card)) {
                map[card] = 0;
            }
            map[card]++;
        }

        while (map.Count > 0) {
            int curr = map.Keys.First();

            for (int i = 0; i < groupSize; i++) {
                if (!map.ContainsKey(curr + i) || map[curr + i] == 0) {
                    return false;
                }

                map[curr + i]--;
                if (map[curr + i] == 0) {
                    map.Remove(curr + i);
                }
            }
        }

        return true;
    }
}
```

// Here are the changes made:
// 1. Replaced `TreeMap` with `SortedDictionary` in C#.
// 2. Used `map.Keys.First()` to get the first key in the dictionary.
// 3. Adjusted the syntax for dictionary operations (`map[card]` and `map.Remove(curr + i)`).

// Feel free to test this C# code, and let me know if you have any further questions! 😊
