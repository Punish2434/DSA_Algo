/*   Scroll down to see JAVA code and C# also  */
/*
  Company Tags                :Yahoo
  Leetcode Qn Link            : https://www.geeksforgeeks.org/problems/three-way-partitioning/1
*/

/ C++ *****************************************************************************************************/

class Solution{
    void threeWayPartition(vector<int>& array,int a, int b)
    {
        // code here 
        int i=0,j=0,k=array.size()-1;
        while(i<=k){
            if(array[i]<a){
                swap(array[i++],array[j++]);
            }
            else if(array[i]>b){
                swap(array[i],array[k--]);
            }
            else i++;
        }
    }
}
/ Java *****************************************************************************************************/

class Solution{
    //Function to partition the array around the range such 
    //that array is divided into three parts.
    public void threeWayPartition(int array[], int a, int b)
    {
        // code here        
        int j=0,k=array.length-1,i=0;
        while(i<=k){
            if(array[i]<a){
                int temp = array[i];
                array[i]=array[j];
                array[j]=temp;
                j++;
                i++;
            }
            else if(array[i]>b){
                int temp = array[i];
                array[i]=array[k];
                array[k]=temp;
                k--;
            }
            else i++;
            
        }
    }

}
// Time Complexity:- O(N)
// Space Complexity:- O(1)
/ C# *****************************************************************************************************/


```csharp
using System;

public class Solution
{
    // Function to partition the array around the range such that
    // the array is divided into three parts.
    public void ThreeWayPartition(int[] array, int a, int b)
    {
        int j = 0, k = array.Length - 1, i = 0;
        while (i <= k)
        {
            if (array[i] < a)
            {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j++;
                i++;
            }
            else if (array[i] > b)
            {
                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;
                k--;
            }
            else
            {
                i++;
            }
        }
    }
}
```

