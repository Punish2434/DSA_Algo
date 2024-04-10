
/ C++ ********************************************************************************************/
 class Solution{
    int findSingle(int n, int arr[]){
        // code here
        int x=0;
        for(int i=0;i<n;i++)x^=arr[i];
        return x;
    }
 }

/ Java ********************************************************************************************/

 class Solution{
 
    static int findSingle(int n, int arr[]){
        // code here
        int x=0;
        for(int i=0;i<n;i++)x^=arr[i];
        return x;
    }
}

// Time Complexity:- O(N)
// Space Complexity:- O(1)



// 1. **Method Signature**:
//     - The code defines a class named `Solution`.
//     - Inside this class, there is a static method called `findSingle`.
//     - The method takes two parameters: an integer `n` and an array of integers `arr`.

// 2. **Bitwise XOR Operation**:
//     - The variable `x` is initialized to `0`.
//     - A loop iterates through each element of the array `arr`.
//     - For each element, the bitwise XOR operation (`^`) is applied with the current value of `x`.
//     - The result is stored back in `x`.
//     - This operation effectively finds the unique element in the array because XORing an element with itself cancels out, leaving only the unique value.

// 3. **Return Value**:
//     - After processing all elements, the method returns the final value of `x`.

// 4. **Purpose**:
//     - The purpose of this method is to find the single non-repeating element in the given array.

// In summary, the `findSingle` method efficiently identifies the unique element using bitwise XOR. 🧩🔍.


/ C# ********************************************************************************************/
 

```csharp
public class Solution
{
    public static int FindSingle(int n, int[] arr)
    {
        int x = 0;
        for (int i = 0; i < n; i++)
        {
            x ^= arr[i];
        }
        return x;
    }
}
 ```

// In this C# version:
// - I've changed the method name from `findSingle` to `FindSingle` to follow C# naming conventions.
// - The rest of the logic remains the same.

