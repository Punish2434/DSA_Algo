/*         Scroll below to see JAVA code and C# also        */

    // Company Tags                : Amazon, Meta, Microsoft, Google, Apple, Adobe, Yahoo, Uber, Bloomberg
    // Leetcode Link               : https://leetcode.com/problems/sort-an-array/
// C++ ********************************************************************************************************************************************/
//Approach (using Merge Sort)
//T.C : O(nlogn)
//S.C : O(n) 
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        if (nums.empty()) {
            return nums;
        }
        mergeSort(nums, 0, nums.size() - 1);
        return nums;
    }

private:
    void mergeSort(vector<int>& nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    void merge(vector<int>& nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        vector<int> leftArray(n1);
        vector<int> rightArray(n2);

        for (int i = 0; i < n1; i++) {
            leftArray[i] = nums[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = nums[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k++] = leftArray[i++];
            } else {
                nums[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            nums[k++] = leftArray[i++];
        }

        while (j < n2) {
            nums[k++] = rightArray[j++];
        }
    }
};
// Java ********************************************************************************************************************************************/
//Approach (using Merge Sort)
//T.C : O(nlogn)
//S.C : O(n) 
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = nums[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = nums[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k++] = leftArray[i++];
            } else {
                nums[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            nums[k++] = leftArray[i++];
        }

        while (j < n2) {
            nums[k++] = rightArray[j++];
        }
    }
}

// C# ********************************************************************************************************************************************/
//Approach (using Merge Sort)
//T.C : O(nlogn)
//S.C : O(n) 
using System;

public class Solution {
    public int[] SortArray(int[] nums) {
        if (nums == null || nums.Length == 0) {
            return nums;
        }
        MergeSort(nums, 0, nums.Length - 1);
        return nums;
    }

    private void MergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            MergeSort(nums, left, mid);
            MergeSort(nums, mid + 1, right);
            Merge(nums, left, mid, right);
        }
    }

    private void Merge(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = nums[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = nums[mid + 1 + j];
        }

        int leftIndex = 0, rightIndex = 0, mergedIndex = left;
        while (leftIndex < n1 && rightIndex < n2) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                nums[mergedIndex++] = leftArray[leftIndex++];
            } else {
                nums[mergedIndex++] = rightArray[rightIndex++];
            }
        }

        while (leftIndex < n1) {
            nums[mergedIndex++] = leftArray[leftIndex++];
        }

        while (rightIndex < n2) {
            nums[mergedIndex++] = rightArray[rightIndex++];
        }
    }
}


// JavaScript ********************************************************************************************************************************************/
//Approach (using Merge Sort)
//T.C : O(nlogn)
//S.C : O(n) 
class Solution {
    sortArray(nums) {
        if (!nums || nums.length === 0) {
            return nums;
        }
        this.mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    mergeSort(nums, left, right) {
        if (left < right) {
            const mid = Math.floor((left + right) / 2);
            this.mergeSort(nums, left, mid);
            this.mergeSort(nums, mid + 1, right);
            this.merge(nums, left, mid, right);
        }
    }

    merge(nums, left, mid, right) {
        const n1 = mid - left + 1;
        const n2 = right - mid;

        const leftArray = nums.slice(left, mid + 1);
        const rightArray = nums.slice(mid + 1, right + 1);

        let i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k++] = leftArray[i++];
            } else {
                nums[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            nums[k++] = leftArray[i++];
        }

        while (j < n2) {
            nums[k++] = rightArray[j++];
        }
    }
}
