/*     Scroll below to see JAVA code and C# also    */

/*
    Company Tags                : Amazon,Adobe, Paytm
    GfG Link                    : https://www.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion1638/1
*/
/ C++ ******************************************************************************************************************************************/
// Time Complexity:- O(N)
// Space Complexity:- O(1)
class Solution {
    void zigZag(int n, vector<int> &arr) {
        // code here
        for(int i=0;i<n-1;i++){
            if(i%2==0 and arr[i]>arr[i+1])swap(arr[i],arr[i+1]);
            else if(i%2==1 and arr[i]<arr[i+1])swap(arr[i],arr[i+1]);
        }
    }
}
/ Java ******************************************************************************************************************************************/

// Time Complexity:- O(N)
// Space Complexity:- O(1)
class Solution {
    public static void zigZag(int n, int[] arr) {
        // code here
        for(int i=0;i<n-1;i++){
	        if(i%2==0 && arr[i]>arr[i+1]){
	            int temp = arr[i];
	            arr[i]=arr[i+1];
	            arr[i+1]=temp;
	        }
	        else if(i%2==1 && arr[i]<arr[i+1]){
	            int temp = arr[i];
	            arr[i]=arr[i+1];
	            arr[i+1]=temp;
	        }
	    }
    }
}
/ C# ******************************************************************************************************************************************/
// Time Complexity:- O(N)
// Space Complexity:- O(1)
class Solution {
  public static void ZigZag(int n, int[] arr)
{
    for (int i = 0; i < n - 1; i++)
    {
        if (i % 2 == 0 && arr[i] > arr[i + 1])
        {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        else if (i % 2 == 1 && arr[i] < arr[i + 1])
        {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
}
}
