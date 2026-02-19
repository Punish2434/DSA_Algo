**Space:** O(n) — temporary arrays के लिए  
**Call Stack:** O(log n) — recursion depth

public class Solution {
    public int[] SortArray(int[] nums) {
        MergeSort(nums, 0, nums.Length - 1);
        return nums;
    }
    
    private void MergeSort(int[] arr, int left, int right) {
    
        if (left >= right) return;
        
        int mid = left + (right - left) / 2; 
        
        MergeSort(arr, left, mid);       
        MergeSort(arr, mid + 1, right); 
        Merge(arr, left, mid, right);  
    }
    
    private void Merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
    
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];
        
        int p = 0, q = 0, k = left;
        
        while (p < n1 && q < n2) {
            if (L[p] <= R[q])
                arr[k++] = L[p++];
            else
                arr[k++] = R[q++];
        }
        
        while (p < n1) arr[k++] = L[p++];
        while (q < n2) arr[k++] = R[q++];
    }
}
