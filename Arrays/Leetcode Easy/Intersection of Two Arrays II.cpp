/*    Scroll below to see JAVA code and C# also   */

/*
    Company Tags                : META
    Leetcode Link               : https://leetcode.com/problems/intersection-of-two-arrays-ii/
*/


/ C++ *****************************************************************************************************************************/
//Approach-1 (Using map)
//T.C:  O(n)
//S.C : O(n)
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int, int> mp;

        for(int &num : nums1) {
            mp[num]++;
        }

        vector<int> result;
        for(int i = 0; i < nums2.size(); i++) {
            int num = nums2[i];

            if(mp[num] > 0) {
                mp[num]--;
                result.push_back(num);
            }
        }

        return result;

    }
};


//Approach-2 (Using sorting and 2-Pointers)
//T.C:  O(n)
//S.C : O(n)
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        sort(begin(nums1), end(nums1));
        sort(begin(nums2), end(nums2));

        int i = 0; // -> nums1
        int j = 0; // -> nums2

        vector<int> result;

        while(i < nums1.size() && j < nums2.size()) {
            if(nums1[i] == nums2[j]) {
                result.push_back(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
};



/ JAVA *****************************************************************************************************************************/
//Approach-1 (Using map)
//T.C:  O(n)
//S.C : O(n)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] intersection = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = result.get(i);
        }

        return intersection;
    }
}




//Approach-2 (Using sorting and 2-Pointers)
//T.C:  O(n)
//S.C : O(n)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] intersection = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            intersection[k] = result.get(k);
        }

        return intersection;
    }
}

/ C#  *****************************************************************************************************************************/
//Approach-1 (Using map)
//T.C:  O(n)
//S.C : O(n)

using System;
using System.Collections.Generic;

public class Solution
{
    public int[] Intersect(int[] nums1, int[] nums2)
    {
        // Create a dictionary to store counts of each element in nums1
        Dictionary<int, int> map = new Dictionary<int, int>();
        foreach (int num in nums1)
        {
            if (map.ContainsKey(num))
            {
                map[num]++;
            }
            else
            {
                map[num] = 1;
            }
        }

        // List to store the intersection result
        List<int> result = new List<int>();
        foreach (int num in nums2)
        {
            if (map.ContainsKey(num) && map[num] > 0)
            {
                result.Add(num);
                map[num]--;
            }
        }

        // Convert the result list to an array
        return result.ToArray();
    }
}

//Approach-2 (Using sorting and 2-Pointers)
//T.C:  O(n)
//S.C : O(n)
using System;
using System.Collections.Generic;

public class Solution
{
    public int[] Intersect(int[] nums1, int[] nums2)
    {
        // Sort both arrays
        Array.Sort(nums1);
        Array.Sort(nums2);

        int i = 0, j = 0;
        List<int> result = new List<int>();

        // Use two pointers to find the intersection
        while (i < nums1.Length && j < nums2.Length)
        {
            if (nums1[i] == nums2[j])
            {
                result.Add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j])
            {
                i++;
            }
            else
            {
                j++;
            }
        }

        // Convert the result list to an array
        return result.ToArray();
    }
}

