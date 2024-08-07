/*         Scroll below to see C# code and JavaScript also        */

    // Company Tags                : Flipkart,Microsoft
    // GFG Link               : https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
// Java ********************************************************************************************************************************************/
//Approach (Using Binary Search)
// TC:O(log(n) + log(m))
// SC:O(log (n))
class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        
        // Make sure that arr1 is the smaller array
        if (n > m) {
            return kthElement(k, arr2, arr1);
        }
        
        int low = Math.max(0, k - m), high = Math.min(k, n);
        
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;
            
            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];
            
            int right1 = (cut1 == n) ? Integer.MAX_VALUE : arr1[cut1];
            int right2 = (cut2 == m) ? Integer.MAX_VALUE : arr2[cut2];
            
            if (left1 <= right2 && left2 <= right1) {
                return Math.max(left1, left2);
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        
        return 1; // This will never be reached due to problem constraints
    }
}
// C# ********************************************************************************************************************************************/
//Approach (Using Binary Search)
// TC:O(log(n) + log(m))
// SC:O(log (n))
class Solution {
    public long KthElement(int k, int[] arr1, int[] arr2) {
        int n = arr1.Length;
        int m = arr2.Length;
        
        if (n > m) {
            return KthElement(k, arr2, arr1);
        }
        
        int low = Math.Max(0, k - m), high = Math.Min(k, n);
        
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;
            
            int left1 = (cut1 == 0) ? int.MinValue : arr1[cut1 - 1];
            int left2 = (cut2 == 0) ? int.MinValue : arr2[cut2 - 1];
            
            int right1 = (cut1 == n) ? int.MaxValue : arr1[cut1];
            int right2 = (cut2 == m) ? int.MaxValue : arr2[cut2];
            
            if (left1 <= right2 && left2 <= right1) {
                return Math.Max(left1, left2);
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        
        return 1;
    }
}

// JavaScript ********************************************************************************************************************************************/
//Approach (Using Binary Search)
// TC:O(log(n) + log(m))
// SC:O(log (n))
class Solution {
    kthElement(k, arr1, arr2) {
        let n = arr1.length;
        let m = arr2.length;
        
        if (n > m) {
            return this.kthElement(k, arr2, arr1);
        }
        
        let low = Math.max(0, k - m), high = Math.min(k, n);
        
        while (low <= high) {
            let cut1 = Math.floor((low + high) / 2);
            let cut2 = k - cut1;
            
            let left1 = (cut1 === 0) ? -Infinity : arr1[cut1 - 1];
            let left2 = (cut2 === 0) ? -Infinity : arr2[cut2 - 1];
            
            let right1 = (cut1 === n) ? Infinity : arr1[cut1];
            let right2 = (cut2 === m) ? Infinity : arr2[cut2];
            
            if (left1 <= right2 && left2 <= right1) {
                return Math.max(left1, left2);
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        
        return 1;
    }
}
