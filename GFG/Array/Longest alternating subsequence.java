/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags           : 
    GFG Link               : https://www.geeksforgeeks.org/problems/longest-alternating-subsequence5951/1
*/


/ * C++ ***************************************************************************************************/
//Approch - longest length of a good alternating sequence in an array
//T.C : O(n)
//S.C : O(1)
  #include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int alternatingMaxLength(vector<int>& arr) {
        if (arr.empty()) return 0;

        int up = 1;
        int down = 1;

        for (size_t i = 1; i < arr.size(); ++i) {
            if (arr[i] > arr[i - 1]) {
                up = down + 1;
            } else if (arr[i] < arr[i - 1]) {
                down = up + 1;
            }
        }

        return max(up, down);
    }
};

int main() {
    Solution sol;

    vector<int> arr1 = {1, 5, 4};
    cout << sol.alternatingMaxLength(arr1) << endl; // Output: 3

    vector<int> arr2 = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
    cout << sol.alternatingMaxLength(arr2) << endl; // Output: 7

    return 0;
}
/ * Java ***************************************************************************************************/
//Approch - longest length of a good alternating sequence in an array
//T.C : O(n)
//S.C : O(1)
  class Solution {
    public int alternatingMaxLength(int[] arr) {
        if (arr.length == 0) return 0;

        int up = 1;
        int down = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                up = down + 1;
            } else if (arr[i] < arr[i - 1]) {
                down = up + 1;
            }
        }

        return Math.max(up, down);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] arr1 = {1, 5, 4};
        System.out.println(sol.alternatingMaxLength(arr1)); // Output: 3

        int[] arr2 = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(sol.alternatingMaxLength(arr2)); // Output: 7
    }
}


  / * C# ***************************************************************************************************/
//Approch - longest length of a good alternating sequence in an array
//T.C : O(n)
//S.C : O(1)
  public class Solution {
    // Complete this function
    public int alternatingMaxLength(List<int> arr) {
        // code here
        if(arr.Count == 0){
            return 0;
        }
        int up = 1;
        int down =1;
        
        for(int i = 1; i < arr.Count; i++){
            if(arr[i] > arr[i - 1])
            {
                up = down + 1;
            }
            else if(arr[i] < arr[i - 1])
            {
               down = up + 1; 
            }
        }
        
        return Math.Max(up, down);
    }
}

  / * JavaScript ***************************************************************************************************/
//Approch - longest length of a good alternating sequence in an array
//T.C : O(n)
//S.C : O(1)
    class Solution {
    alternatingMaxLength(arr) {
        if (arr.length === 0) return 0;

        let up = 1;
        let down = 1;

        for (let i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                up = down + 1;
            } else if (arr[i] < arr[i - 1]) {
                down = up + 1;
            }
        }

        return Math.max(up, down);
    }
}

// Example usage
const sol = new Solution();
console.log(sol.alternatingMaxLength([1, 5, 4])); // Output: 3
console.log(sol.alternatingMaxLength([1, 17, 5, 10, 13, 15, 10, 5, 16, 8])); // Output: 7
