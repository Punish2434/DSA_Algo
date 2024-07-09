
/*     Scroll below to see JAVA code and C# also    */
/*
      Company Tags           : Amazon, Microsoft ,Google, Apple
      GFG Link               : https://www.geeksforgeeks.org/problems/three-sum-closest/1
*/


/ C++ ******************************************************************************************************************************/
//Two pointer
//T.C : O(n2)
//S.C : O(1)

class Solution {
  public:
    int threeSumClosest(vector<int> arr, int target) {
        // codeGenius
        int dif=INT_MAX , ans=INT_MAX;
        sort(arr.begin(),arr.end());
        for(int i=0;i<arr.size();i++){
            int s=i+1, e=arr.size()-1;
            while(s<e){
               int sum= arr[i]+arr[s]+arr[e];
               if(sum==target){
                   return sum;
               }else if(sum>target)
               e--;
               else
               s++;
               if(abs(sum-target)<dif){
                   dif=abs(sum-target);
                   ans=sum;
               }
               else if(abs(sum-target )== dif)
               ans=max(ans,sum);
            }
        }
        return ans;
    }
};

/ Java ******************************************************************************************************************************/
//Two pointer
//T.C : O(n2)
//S.C : O(1)
import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] arr, int target) {
        int dif = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int s = i + 1, e = arr.length - 1;
            while (s < e) {
                int sum = arr[i] + arr[s] + arr[e];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    e--;
                } else {
                    s++;
                }
                if (Math.abs(sum - target) < dif) {
                    dif = Math.abs(sum - target);
                    ans = sum;
                } else if (Math.abs(sum - target) == dif) {
                    ans = Math.max(ans, sum);
                }
            }
        }
        return ans;
    }
}

  
  / C# ******************************************************************************************************************************/
//Two pointer
//T.C : O(n2)
//S.C : O(1)

    using System;

public class Solution {
    public int ThreeSumClosest(int[] arr, int target) {
        int dif = int.MaxValue;
        int ans = int.MaxValue;
        Array.Sort(arr);
        for (int i = 0; i < arr.Length; i++) {
            int s = i + 1, e = arr.Length - 1;
            while (s < e) {
                int sum = arr[i] + arr[s] + arr[e];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    e--;
                } else {
                    s++;
                }
                if (Math.Abs(sum - target) < dif) {
                    dif = Math.Abs(sum - target);
                    ans = sum;
                } else if (Math.Abs(sum - target) == dif) {
                    ans = Math.Max(ans, sum);
                }
            }
        }
        return ans;
    }
}
