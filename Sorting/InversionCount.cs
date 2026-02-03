Merge Sort
  T.C : (n log n)
  S.C :  O(n)
  
  BEST: Stable, predictable


    public class Solution
    {
        public int InversionCount(int[] arr)
        {
            if (arr == null || arr.Length <= 1)
                return 0;

            int[] temp = new int[arr.Length];
            return MergeSortAndCount(arr, temp, 0, arr.Length - 1);
        }

        private  int MergeSortAndCount(int[] arr, int[] temp, int left, int right)
        {
            int inversions = 0;
            
            if (left < right)
            {
                int mid = left + (right - left) / 2; 
                
                inversions += MergeSortAndCount(arr, temp, left, mid);
        
                inversions += MergeSortAndCount(arr, temp, mid + 1, right);
 
                inversions += MergeAndCount(arr, temp, left, mid, right);
            }
            
            return inversions;
        }
        
        private int MergeAndCount(int[] arr, int[] temp, int left, int mid, int right)
        {
            int i = left;      
            int j = mid + 1;   
            int k = left;      
            int inversions = 0;
            
            while (i <= mid && j <= right)
            {
                if (arr[i] <= arr[j])
                {
                    temp[k++] = arr[i++];
                }
                else
                {

                    temp[k++] = arr[j++];
                    inversions += (mid - i + 1);
                }
            }
            
            while (i <= mid)
                temp[k++] = arr[i++];
            
            while (j <= right)
                temp[k++] = arr[j++];
            
            for (i = left; i <= right; i++)
                arr[i] = temp[i];
            
            return inversions;
        }
        
       
    }
