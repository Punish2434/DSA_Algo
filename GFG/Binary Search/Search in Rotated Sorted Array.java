/*      					Scroll down to see JAVA code C#  also 					*/
/*
    	Company Tags 		    : Paytm,Flipkart,Amazon,Microsoft,Snapdeal,D-E-Shaw,FactSetHike,MakeMyTrip,Intuit,Adobe,Google,BankBazaar,Times Internet
      GFG Link		    : https://www.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1
     							

*/

/ C++ ******************************************************************************************************************************/
//Approach- (Modification in binary search)
//T.C : O(log n)
//S.C : O(1)
#include <iostream>
#include <vector>

class Solution {
public:
    int search(std::vector<int>& arr, int key) {
        int left = 0, right = arr.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[left] <= arr[mid]) {
                if (arr[left] <= key && key < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arr[mid] < key && key <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
};



  / Java ******************************************************************************************************************************/
//Approach- (Modification in binary search)
//T.C : O(log n)
//S.C : O(1)
class Solution {
    int search(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[left] <= arr[mid]) {
                if (arr[left] <= key && key < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arr[mid] < key && key <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key1 = 10;
        System.out.println(sol.search(arr1, key1)); // Output: 5

        int[] arr2 = {3, 5, 1, 2};
        int key2 = 6;
        System.out.println(sol.search(arr2, key2)); // Output: -1
    }
}



  / C# ******************************************************************************************************************************/
//Approach- (Modification in binary search)
//T.C : O(log n)
//S.C : O(1)
    using System;

class Solution {
    public int Search(int[] arr, int key) {
        int left = 0, right = arr.Length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[left] <= arr[mid]) {
                if (arr[left] <= key && key < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arr[mid] < key && key <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    static void Main() {
        Solution sol = new Solution();
        int[] arr1 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key1 = 10;
        Console.WriteLine(sol.Search(arr1, key1)); // Output: 5

        int[] arr2 = {3, 5, 1, 2};
        int key2 = 6;
        Console.WriteLine(sol.Search(arr2, key2)); // Output: -1
    }
}


  / JavaScript ******************************************************************************************************************************/
//Approach- (Modification in binary search)
//T.C : O(log n)
//S.C : O(1)
    class Solution {
    search(arr, key) {
        let left = 0, right = arr.length - 1;

        while (left <= right) {
            const mid = Math.floor((left + right) / 2);

            if (arr[mid] === key) {
                return mid;
            }

            if (arr[left] <= arr[mid]) {
                if (arr[left] <= key && key < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arr[mid] < key && key <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}

// Example usage
const sol = new Solution();
const arr1 = [5, 6, 7, 8, 9, 10, 1, 2, 3];
const key1 = 10;
console.log(sol.search(arr1, key1)); // Output: 5

const arr2 = [3, 5, 1, 2];
const key2 = 6;
console.log(sol.search(arr2, key2)); // Output: -1
