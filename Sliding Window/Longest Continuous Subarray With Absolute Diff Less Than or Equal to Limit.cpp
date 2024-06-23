/*     Scroll below to see JAVA code   */
/*
    Company Tags                : Uber
    Leetcode Link               : https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
*/


/ C++ ************************************************************************************************************************/
//Approach-1 (Using sliding window + heap)
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
public:
    typedef pair<int, int> P;

    int longestSubarray(vector<int>& nums, int limit) {
        int n = nums.size();
        priority_queue<P> maxPq;
        priority_queue<P, vector<P>, greater<P>> minPq;

        int i = 0;
        int j = 0;
        int maxLength = 0;

        while (j < n) {
            maxPq.push({nums[j], j});
            minPq.push({nums[j], j});

            while (maxPq.top().first - minPq.top().first > limit) {
                i = min(maxPq.top().second, minPq.top().second) + 1;

                while (maxPq.top().second < i) {
                    maxPq.pop();
                }
                while (minPq.top().second < i) {
                    minPq.pop();
                }
            }

            // Update maxLength with the length of the current valid window
            maxLength = max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;
    }
};


//Approach-2 (Using sliding window + multiset)
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        int n = nums.size();

        multiset<int> st;
        int i = 0;
        int j = 0;
        int maxLength = 0;

        while (j < n) {
            st.insert(nums[j]);

            while (*st.rbegin() - *st.begin() > limit) {
                st.erase(st.find(nums[i]));
                ++i;
            }

            maxLength = max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;
    }
};



/ JAVA ************************************************************************************************************************/
//Approach-1 (Using sliding window + heap)
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        PriorityQueue<int[]> maxPq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // max-heap
        PriorityQueue<int[]> minPq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // min-heap

        int i = 0; // Left boundary of the sliding window
        int j = 0; // Right boundary of the sliding window
        int maxLength = 0;

        while (j < n) {
            maxPq.offer(new int[]{nums[j], j});
            minPq.offer(new int[]{nums[j], j});

            while (maxPq.peek()[0] - minPq.peek()[0] > limit) {
                i = Math.min(maxPq.peek()[1], minPq.peek()[1]) + 1;

                while (maxPq.peek()[1] < i) {
                    maxPq.poll();
                }
                while (minPq.peek()[1] < i) {
                    minPq.poll();
                }
            }

            // Update maxLength with the length of the current valid window
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;
    }
}


//Approach-2 (Using sliding window + multiset)
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;

        TreeMap<Integer, Integer> st = new TreeMap<>();
        int i = 0;
        int j = 0;
        int maxLength = 0;

        while (j < n) {
            st.put(nums[j], st.getOrDefault(nums[j], 0) + 1);

            while (st.lastKey() - st.firstKey() > limit) {
                st.put(nums[i], st.get(nums[i]) - 1);
                if (st.get(nums[i]) == 0) {
                    st.remove(nums[i]);
                }
                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;
    }
}
//Approach-3 (TreeMap)
//T.C : O(nlogn)
//S.C : O(n)
import java.util.TreeMap;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {8, 2, 4, 7};
        int limit1 = 4;
        System.out.println(solution.longestSubarray(nums1, limit1)); // Output: 2

        int[] nums2 = {10, 1, 2, 4, 7, 2};
        int limit2 = 5;
        System.out.println(solution.longestSubarray(nums2, limit2)); // Output: 4

        int[] nums3 = {4, 2, 2, 2, 4, 4, 2, 2};
        int limit3 = 0;
        System.out.println(solution.longestSubarray(nums3, limit3)); // Output: 3
    }
}


/ C# ************************************************************************************************************************/

//Approach-3 (TreeMap)
//T.C : O(nlogn)
//S.C : O(n)


using System;
using System.Collections.Generic;

public class Solution {
    public int LongestSubarray(int[] nums, int limit) {
        SortedDictionary<int, int> map = new SortedDictionary<int, int>();
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < nums.Length; right++) {
            if (!map.ContainsKey(nums[right])) {
                map[nums[right]] = 0;
            }
            map[nums[right]]++;
            
            while (map.Keys[^1] - map.Keys[0] > limit) {
                map[nums[left]]--;
                if (map[nums[left]] == 0) {
                    map.Remove(nums[left]);
                }
                left++;
            }
            
            maxLength = Math.Max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    public static void Main(string[] args) {
        Solution solution = new Solution();
        int[] nums1 = {8, 2, 4, 7};
        Console.WriteLine(solution.LongestSubarray(nums1, 4)); // Output: 2

        int[] nums2 = {10, 1, 2, 4, 7, 2};
        Console.WriteLine(solution.LongestSubarray(nums2, 5)); // Output: 4

        int[] nums3 = {4, 2, 2, 2, 4, 4, 2, 2};
        Console.WriteLine(solution.LongestSubarray(nums3, 0)); // Output: 3
    }
}

