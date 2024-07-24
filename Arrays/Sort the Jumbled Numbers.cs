/*         Scroll below to see JAVA code and C# also        */

    // Company Tags                : 
    // Leetcode Link               : https://leetcode.com/problems/sort-the-jumbled-numbers/
// C++ ********************************************************************************************************************************************/
//Approach (using Mapping Digits)
//T.C : O(n×m+nlogn)
//S.C : O(n) 
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<int> sortJumbled(vector<int>& mapping, vector<int>& nums) {
        vector<pair<int, int>> mapped_pairs;
        for (int num : nums) {
            mapped_pairs.push_back({num, mapNumber(num, mapping)});
        }

        sort(mapped_pairs.begin(), mapped_pairs.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
            return a.second < b.second;
        });

        vector<int> sorted_nums;
        for (const auto& pair : mapped_pairs) {
            sorted_nums.push_back(pair.first);
        }

        return sorted_nums;
    }

private:
    int mapNumber(int num, const vector<int>& mapping) {
        string num_str = to_string(num);
        string mapped_value;
        for (char c : num_str) {
            mapped_value += to_string(mapping[c - '0']);
        }
        return stoi(mapped_value);
    }
};

// Time Complexity: O(n * m + n log n), where n is the length of nums and m is the maximum number of digits in any number in nums
// Space Complexity: O(n), for storing the mapped_pairs array
// Java ********************************************************************************************************************************************/
//Approach (using Mapping Digits)
//T.C : O(n×m+nlogn)
//S.C : O(n) 
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // Create an array of pairs (original number, mapped value)
        int n = nums.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = mapNumber(nums[i], mapping);
        }

        // Sort the pairs based on the mapped value, maintaining relative order for equal mapped values
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return 0;
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            }
        });

        // Extract the sorted original numbers
        int[] sortedNums = new int[n];
        for (int i = 0; i < n; i++) {
            sortedNums[i] = pairs[i][0];
        }

        return sortedNums;
    }

    // Helper function to map a number according to the mapping array
    private int mapNumber(int num, int[] mapping) {
        StringBuilder mappedValue = new StringBuilder();
        String numStr = String.valueOf(num);
        for (char c : numStr.toCharArray()) {
            mappedValue.append(mapping[c - '0']);
        }
        return Integer.parseInt(mappedValue.toString());
    }
}

// Time Complexity: O(n * m + n log n), where n is the length of nums and m is the maximum number of digits in any number in nums
// Space Complexity: O(n), for storing the pairs array


// C# ********************************************************************************************************************************************/
//Approach (using Mapping Digits)
//T.C : O(n×m+nlogn)
//S.C : O(n) 
public class Solution {
    public int[] SortJumbled(int[] mapping, int[] nums) {
        var mappedPairs = nums.Select(num => new {
            Original = num,
            Mapped = MapNumber(num, mapping)
        }).ToList();

        mappedPairs.Sort((a, b) => a.Mapped.CompareTo(b.Mapped));

        return mappedPairs.Select(pair => pair.Original).ToArray();
    }

    private int MapNumber(int num, int[] mapping) {
        var numStr = num.ToString();
        var mappedValue = string.Concat(numStr.Select(c => mapping[c - '0'].ToString()));
        return int.Parse(mappedValue);
    }
}

// Time Complexity: O(n * m + n log n), where n is the length of nums and m is the maximum number of digits in any number in nums
// Space Complexity: O(n), for storing the mappedPairs array

// JavaScript ********************************************************************************************************************************************/
//Approach (using Mapping Digits)
//T.C : O(n×m+nlogn)
//S.C : O(n) 
var sortJumbled = function(mapping, nums) {
    const mapNumber = (num) => {
        return parseInt(num.toString().split('').map(digit => mapping[digit]).join(''));
    };

    const mappedPairs = nums.map(num => [num, mapNumber(num)]);
    mappedPairs.sort((a, b) => a[1] - b[1]);

    return mappedPairs.map(pair => pair[0]);
};

// Time Complexity: O(n * m + n log n), where n is the length of nums and m is the maximum number of digits in any number in nums
// Space Complexity: O(n), for storing the mappedPairs array
