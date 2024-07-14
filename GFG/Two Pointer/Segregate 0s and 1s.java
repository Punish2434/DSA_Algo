/*     Scroll below to see JAVA code and C# also    */
/*
        Company Tags           : Paytm,Goldman Sachs,Fab.com
        GFG Link               : https://www.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1
*/


/ C++ ********************************************************************************************************************************************/
//Using stack
//T.C : O(n)
//S.C : O(1)


#include <iostream>
#include <vector>

void segregate0and1(std::vector<int>& arr) {
    int left = 0, right = arr.size() - 1;

    while (left < right) {
        while (arr[left] == 0 && left < right) left++;
        while (arr[right] == 1 && left < right) right--;

        if (left < right) {
            arr[left] = 0;
            arr[right] = 1;
            left++;
            right--;
        }
    }
}

int main() {
    std::vector<int> arr1 = {0, 0, 1, 1, 0};
    segregate0and1(arr1);
    for (int i : arr1) std::cout << i << " ";  // Output: 0 0 0 1 1
    std::cout << std::endl;

    std::vector<int> arr2 = {1, 1, 1, 1};
    segregate0and1(arr2);
    for (int i : arr2) std::cout << i << " ";  // Output: 1 1 1 1
    std::cout << std::endl;

    return 0;
}

/ Java ********************************************************************************************************************************************/
//Using stack
//T.C : O(n)
//S.C : O(1)
class Solution {
    void segregate0and1(int[] arr) {
        // code here
        
        int left = 0;
        int right = arr.length - 1;
        
        while(left < right){
            // Increment left index while we see 0 at left
            while(arr[left] == 0 && left < right){
                left++;
            }
            
            // Decreement right index we see 1 at right
            while(arr[right] == 1 && left < right){
                right--;
            }
            
            // If left is smaller thabn right then there is a 1 at left
            // and a 0 at right. Exchanfe arr[left] and arr[right]
            
            if(left < right){
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
    }
}


/ C# ********************************************************************************************************************************************/
//Using stack
//T.C : O(n)
//S.C : O(1)
using System;

class Solution
{
    public void Segregate0and1(int[] arr)
    {
        int left = 0, right = arr.Length - 1;

        while (left < right)
        {
            while (arr[left] == 0 && left < right) left++;
            while (arr[right] == 1 && left < right) right--;

            if (left < right)
            {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
    }

    public static void Main(string[] args)
    {
        Solution solution = new Solution();

        int[] arr1 = { 0, 0, 1, 1, 0 };
        solution.Segregate0and1(arr1);
        Console.WriteLine(string.Join(", ", arr1)); // Output: 0, 0, 0, 1, 1

        int[] arr2 = { 1, 1, 1, 1 };
        solution.Segregate0and1(arr2);
        Console.WriteLine(string.Join(", ", arr2)); // Output: 1, 1, 1, 1
    }
}

/ JavaScript ********************************************************************************************************************************************/
//Using stack
//T.C : O(n)
//S.C : O(1)
function segregate0and1(arr) {
    let left = 0, right = arr.length - 1;

    while (left < right) {
        while (arr[left] === 0 && left < right) left++;
        while (arr[right] === 1 && left < right) right--;

        if (left < right) {
            arr[left] = 0;
            arr[right] = 1;
            left++;
            right--;
        }
    }
}

// Example usage
let arr1 = [0, 0, 1, 1, 0];
segregate0and1(arr1);
console.log(arr1);  // Output: [0, 0, 0, 1, 1]

let arr2 = [1, 1, 1, 1];
segregate0and1(arr2);
console.log(arr2);  // Output: [1, 1, 1, 1]
