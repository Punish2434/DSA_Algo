/*         Scroll below to see JAVA code and C# also        */

    // Company Tags                : Amazon, Apple, Oracle, Uber, Bloomberg
    // Leetcode Link               : https://leetcode.com/problems/sort-array-by-increasing-frequency/
// C++ ********************************************************************************************************************************************/
//Approach (using Priority Queue)
//T.C : O(nlogn)
//S.C : O(n) 
#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>
#include <algorithm>

using namespace std;

vector<int> frequencySort(vector<int>& nums) {
    unordered_map<int, int> frequencyMap;
    for (int num : nums) {
        frequencyMap[num]++;
    }

    auto comp = [&frequencyMap](int a, int b) {
        if (frequencyMap[a] != frequencyMap[b])
            return frequencyMap[a] > frequencyMap[b];
        return a < b;
    };
    priority_queue<int, vector<int>, decltype(comp)> pq(comp);

    for (int num : nums) {
        pq.push(num);
    }

    vector<int> result;
    while (!pq.empty()) {
        result.push_back(pq.top());
        pq.pop();
    }

    return result;
}

// Test cases
int main() {
    vector<int> nums1 = {1, 1, 2, 2, 2, 3};
    vector<int> result1 = frequencySort(nums1);
    for (int num : result1) {
        cout << num << " ";
    }
    cout << endl;

    vector<int> nums2 = {2, 3, 1, 3, 2};
    vector<int> result2 = frequencySort(nums2);
    for (int num : result2) {
        cout << num << " ";
    }
    cout << endl;

    vector<int> nums3 = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
    vector<int> result3 = frequencySort(nums3);
    for (int num : result3) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}

// Java ********************************************************************************************************************************************/
//Approach (using Priority Queue)
//T.C : O(nlogn)
//S.C : O(n) 
import java.util.*;

public class Solution {
    public int[] FrequencySort(int[] nums) {
        // Step 1: Create a frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a priority queue with custom comparator
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);
            if (freqA != freqB) {
                return freqA - freqB; // Increasing order of frequency
            } else {
                return b - a; // Decreasing order of value if frequencies are the same
            }
        });

        // Step 3: Add all elements to the priority queue
        for (int num : nums) {
            pq.add(num);
        }

        // Step 4: Extract elements from the priority queue to form the result array
        int[] result = new int[nums.length];
        int index = 0;
        while (!pq.isEmpty()) {
            result[index++] = pq.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 1, 2, 2, 2, 3};
        System.out.println(Arrays.toString(solution.FrequencySort(nums1))); // Output: [3, 1, 1, 2, 2, 2]

        int[] nums2 = {2, 3, 1, 3, 2};
        System.out.println(Arrays.toString(solution.FrequencySort(nums2))); // Output: [1, 3, 3, 2, 2]

        int[] nums3 = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
        System.out.println(Arrays.toString(solution.FrequencySort(nums3))); // Output: [5, -1, 4, 4, -6, -6, 1, 1, 1]
    }
}


// C# ********************************************************************************************************************************************/
//Approach (using Priority Queue)
//T.C : O(nlogn)
//S.C : O(n) 
using System;
using System.Collections.Generic;

public class Solution {
    public int[] FrequencySort(int[] nums) {
        Dictionary<int, int> frequencyMap = new Dictionary<int, int>();
        foreach (int num in nums) {
            if (!frequencyMap.ContainsKey(num)) {
                frequencyMap[num] = 0;
            }
            frequencyMap[num]++;
        }

        PriorityQueue<int, (int frequency, int value)> pq = new PriorityQueue<int, (int, int)>();
        foreach (int num in nums) {
            pq.Enqueue(num, (frequencyMap[num], -num));
        }

        int[] result = new int[nums.Length];
        for (int i = 0; i < nums.Length; i++) {
            result[i] = pq.Dequeue();
        }

        return result;
    }

    public static void Main(string[] args) {
        Solution solution = new Solution();

        int[] nums1 = { 1, 1, 2, 2, 2, 3 };
        Console.WriteLine(string.Join(", ", solution.FrequencySort(nums1))); // Output: [3, 1, 1, 2, 2, 2]

        int[] nums2 = { 2, 3, 1, 3, 2 };
        Console.WriteLine(string.Join(", ", solution.FrequencySort(nums2))); // Output: [1, 3, 3, 2, 2]

        int[] nums3 = { -1, 1, -6, 4, 5, -6, 1, 4, 1 };
        Console.WriteLine(string.Join(", ", solution.FrequencySort(nums3))); // Output: [5, -1, 4, 4, -6, -6, 1, 1, 1]
    }
}
