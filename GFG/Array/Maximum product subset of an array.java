/*         Scroll below to see JAVA code and C# also        */

    // Company Tags           : 
    // GFG Link               : https://www.geeksforgeeks.org/problems/maximum-product-subset-of-an-array/1


// C++ ********************************************************************************************************************************************/
//Approach (Iterate through the array)
//T.C : O(n)
//S.C : O(1) 
class Solution {
  public:
    long long int findMaxProduct(vector<int>& arr) {
        // Write your code here
        if(arr.size()==1) return arr[0];
        long long int prod=1;
        int zero=0,non_zero=0,maxi=INT_MIN;
        
        for(int i=0;i<arr.size();i++)
        {
            if(arr[i]!=0){
                prod=(prod*arr[i])%1000000007;
                non_zero=1;
            }
            else{ zero=1;}
            if(arr[i]<0 and arr[i]>maxi)
            maxi=arr[i];
        }
        if(non_zero!=1) return 0;
        if(arr.size()==2 and zero==1 and prod<0) return 0;
        if(prod<0) prod/=maxi;
        return prod;
    }
};
// Java ********************************************************************************************************************************************/
//Approach (Iterate through the array)
//T.C : O(n)
//S.C : O(1) 

class Solution {
    public long findMaxProduct(List<Integer> arr) {
        int n = arr.size();
        long MOD = 1000000007;

        // If the array contains only one element
        if (n == 1) {
            return arr.get(0) % MOD;
        }

        // Initialize variables
        long maxProduct = 1;
        int negativeCount = 0;
        int zeroCount = 0;
        long maxNegative = Long.MIN_VALUE;
        long minPositive = Long.MAX_VALUE;

        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
            } else {
                if (num < 0) {
                    negativeCount++;
                    maxNegative = Math.max(maxNegative, num);
                } else {
                    minPositive = Math.min(minPositive, num);
                }
                maxProduct = (maxProduct * Math.abs(num)) % MOD;
            }
        }

        // If there are all zeros in the array
        if (zeroCount == n) {
            return 0;
        }

        // If there is one negative number and all others are zeros
        if (negativeCount == 1 && zeroCount + negativeCount == n) {
            return 0;
        }

        // If the count of negative numbers is odd, divide by the largest negative number
        if (negativeCount % 2 != 0) {
            maxProduct = (maxProduct * modInverse(Math.abs(maxNegative), MOD)) % MOD;
        }

        return maxProduct;
    }

    // Function to find modular inverse of a under modulo MOD using Fermat's little theorem
    // Assumption: MOD is prime
    private long modInverse(long a, long MOD) {
        return power(a, MOD - 2, MOD);
    }

    // Function to compute a^b under modulo MOD
    private long power(long a, long b, long MOD) {
        long result = 1;
        a = a % MOD;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }
            b = b >> 1;
            a = (a * a) % MOD;
        }
        return result;
    }

}
// C# ********************************************************************************************************************************************/
//Approach (Iterate through the array)
//T.C : O(n)
//S.C : O(1) 

using System;
using System.Collections.Generic;

public class Solution {
    public long FindMaxProduct(List<int> arr) {
        if (arr.Count == 1) return arr[0];
        long prod = 1;
        bool zero = false;
        bool nonZero = false;
        int maxi = int.MinValue;
        
        foreach (int num in arr) {
            if (num != 0) {
                prod = (prod * num) % 1000000007;
                nonZero = true;
            } else {
                zero = true;
            }
            if (num < 0 && num > maxi) {
                maxi = num;
            }
        }
        
        if (!nonZero) return 0;
        if (arr.Count == 2 && zero && prod < 0) return 0;
        if (prod < 0) prod /= maxi;
        return prod;
    }
}
// JavaScript ********************************************************************************************************************************************/
//Approach (Iterate through the array)
//T.C : O(n)
//S.C : O(1) 

class Solution {
    findMaxProduct(arr) {
        if (arr.length === 1) return arr[0];
        let prod = 1;
        let zero = false;
        let nonZero = false;
        let maxi = Number.MIN_SAFE_INTEGER;
        
        for (let num of arr) {
            if (num !== 0) {
                prod = (prod * num) % 1000000007;
                nonZero = true;
            } else {
                zero = true;
            }
            if (num < 0 && num > maxi) {
                maxi = num;
            }
        }
        
        if (!nonZero) return 0;
        if (arr.length === 2 && zero && prod < 0) return 0;
        if (prod < 0) prod = Math.floor(prod / maxi);
        return prod;
    }
}
