/*    Scroll below to see JAVA code and C# also  */
/*
    Company Tags                : 
    Leetcode Link               : https://leetcode.com/problems/relative-sort-array/
*/
/ C++ **************************************************************************************************************************/
// Time Complexity: O(N)
// Space Complexity: O(N)
  #include <vector>
#include <algorithm>

class Solution {
public:
    std::vector<int> relativeSortArray(std::vector<int>& arr1, std::vector<int>& arr2) {
        int maxe = 0;
        for (int i = 0; i < arr1.size(); ++i) {
            maxe = std::max(arr1[i], maxe);
        }

        std::vector<int> count(maxe + 1, 0);
        for (int i = 0; i < arr1.size(); ++i) {
            ++count[arr1[i]];
        }

        std::vector<int> ans(arr1.size());
        int index = 0;
        for (int i = 0; i < arr2.size(); ++i) {
            while (count[arr2[i]] > 0) {
                ans[index] = arr2[i];
                --count[arr2[i]];
                ++index;
            }
        }

        for (int i = 0; i < count.size(); ++i) {
            while (count[i] > 0) {
                ans[index] = i;
                --count[i];
                ++index;
            }
        }

        return ans;
    }
};
/ Java **************************************************************************************************************************/
// Time Complexity: O(N)
// Space Complexity: O(N)
  
  class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
       int maxe = 0;
        for( int i=0; i<arr1.length; i++){
            maxe = Math.max(arr1[i], maxe);
        }
        
        int[] count = new int[maxe+1];
        for(int i=0; i<arr1.length; i++){
            count[arr1[i]]++;
        }
        int[] ans = new int[arr1.length];
        int index =0;
        for(int i=0;i<arr2.length; i++){
            while(count[arr2[i]]>0){
                ans[index] = arr2[i];
                count[arr2[i]]--;
                index++;
            }
        }
        for(int i=0;i<count.length; i++){
            while(count[i]>0){
               ans[index]=i;
                count[i]--;
                index++;
            }
        }
        return ans;
    }
}
/ C# **************************************************************************************************************************/
// Time Complexity: O(N)
// Space Complexity: O(N)
  public class Solution {
    public int[] RelativeSortArray(int[] arr1, int[] arr2) {
        int maxe = 0;
        foreach (int num in arr1) {
            maxe = Math.Max(num, maxe);
        }

        int[] count = new int[maxe + 1];
        foreach (int num in arr1) {
            count[num]++;
        }

        int[] ans = new int[arr1.Length];
        int index = 0;
        foreach (int num in arr2) {
            while (count[num] > 0) {
                ans[index] = num;
                count[num]--;
                index++;
            }
        }

        for (int i = 0; i < count.Length; i++) {
            while (count[i] > 0) {
                ans[index] = i;
                count[i]--;
                index++;
            }
        }

        return ans;
    }
}
