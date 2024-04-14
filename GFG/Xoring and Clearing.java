/*     Scroll below to see JAVA code and C#  also  */
/*
    Company Tags                : Amazon,Facebook,Google,Visa
    Leetcode Link               : https://www.geeksforgeeks.org/problems/xoring-and-clearing/1
*/


/ C++ *****************************************************************************************************************************/

 class Solution {
    void printArr(int n, int arr[]) {
        // Your code for printing array here
        for(int i=0;i<n;i++)cout<<arr[i]<<" ";
        cout<<endl;
    }

    void setToZero(int n, int arr[]) {
        // Use memset to set arr to zero
        for(int i=0;i<n;i++){
            arr[i]=0;
        }
    }

    void xor1ToN(int n, int arr[]) {
        // Xor arr[i]^i
        for(int i=0;i<n;i++)arr[i]=arr[i]^i;
    }
}
/ Java *****************************************************************************************************************************/

 class Solution {
    public void printArr(int n, int arr[]) {
        // Print the array elements
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // Newline
    }

    public void setToZero(int n, int arr[]) {
        // Set all elements of the array to zero
        for (int i = 0; i < n; i++) {
            arr[i] = 0;
        }
    }

    public void xor1ToN(int n, int arr[]) {
        // Calculate XOR of each element with its index
        for (int i = 0; i < n; i++) {
            arr[i] ^= i;
        }
    }
}


// Time Complexity:- O(N)
// Space Complexity:- O(1)
/ C# *****************************************************************************************************************************/


```csharp
using System;

public class Solution
{
    public void PrintArr(int n, int[] arr)
    {
        // Print the array elements
        for (int i = 0; i < n; i++)
        {
            Console.Write(arr[i] + " ");
        }
        Console.WriteLine(); // Newline
    }

    public void SetToZero(int n, int[] arr)
    {
        // Set all elements of the array to zero
        for (int i = 0; i < n; i++)
        {
            arr[i] = 0;
        }
    }

    public void Xor1ToN(int n, int[] arr)
    {
        // Calculate XOR of each element with its index
        for (int i = 0; i < n; i++)
        {
            arr[i] ^= i;
        }
    }
}
```


// - The `PrintArr` method prints the array elements.
// - The `SetToZero` method sets all elements of the array to zero.
// - The `Xor1ToN` method calculates the XOR of each element with its index.


  
