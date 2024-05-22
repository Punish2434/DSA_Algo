/*         Scroll below to see JAVA Code and C#  also        */
/*
    Company Tags                : 
    GfG Link                    : https://www.geeksforgeeks.org/problems/minimize-max-distance-to-gas-station/1
*/

/ C++ ****************************************************************************************************************/
//Whenever a question asks for "Generating all possible" something, think about Backtracking once
//T.C : O(n * 2^n) 
class Solution {
    bool isPossible(vector<int> &stations,double mid,int k){
        int total=0;
        for(int i=1;i<stations.size();i++){
            int dis = stations[i]-stations[i-1];
            total+=ceil(dis/mid)-1;
        }
        return total<=k;
    }
    double findSmallestMaxDist(vector<int> &stations, int k) {
        // Code here
        int n=stations.size();
        double low=0,high=stations[n-1]-stations[0],mid=0,ans=stations[n-1]-stations[0];
        while(high-low>=1e-6){
            mid=(low+high)/2;
            if(isPossible(stations,mid,k)){
                ans=mid;
                high=mid;
            }
            else low=mid;
        }
        return ans;
    }

}
/ Java ****************************************************************************************************************/
class Solution {
    static boolean isPossible(int stations[],double mid,int k){
        int total=0;
        for(int i=1;i<stations.length;i++){
            int dis = stations[i]-stations[i-1];
            total+=Math.ceil(dis/mid)-1;
        }
        return total<=k;
    }
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        int n = stations.length;
        double low=0,high=stations[n-1]-stations[0],mid=0,ans=0;
        ans=high;
        while(high-low>=1e-6){
            mid=(low+high)/2.0;
            if(isPossible(stations,mid,k)){
                ans=mid;
                high=mid;
            }
            else low=mid;
        }
        return ans;
    }
}

// Time Complexity:- O(NLog(M))
// Space Complexity:- O(1)

class Solution {
    public static double findSmallestMaxDist(int[] stations, int k) {
        double low = 0, high = 1e9;
        while (high - low > 1e-6) {  // binary search until the precision is reached
            double mid = (low + high) / 2;
            if (canPlace(stations, k, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return Math.round(high * 100.0) / 100.0;  // round to 2 decimal places
    }
    
    private static boolean canPlace(int[] stations, int k, double maxDist) {
        int count = 0;
        for (int i = 1; i < stations.length; i++) {
            double dist = stations[i] - stations[i - 1];
            count += (int) (dist / maxDist);
        }
        return count <= k;
    }
    
    public static void main(String[] args) {
        // Example 1
        int[] stations1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k1 = 9;
        System.out.println(findSmallestMaxDist(stations1, k1));  // Output: 0.50

        // Example 2
        int[] stations2 = {3, 6, 12, 19, 33, 44, 67, 72, 89, 95};
        int k2 = 2;
        System.out.println(findSmallestMaxDist(stations2, k2));  // Output: 14.00
    }
}

/ C# ****************************************************************************************************************/

```csharp
using System;

public class Solution {
    public static double FindSmallestMaxDist(int[] stations, int k) {
        double low = 0, high = 1e9;
        while (high - low > 1e-6) {  // binary search until the precision is reached
            double mid = (low + high) / 2;
            if (CanPlace(stations, k, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return Math.Round(high * 100.0) / 100.0;  // round to 2 decimal places
    }

    private static bool CanPlace(int[] stations, int k, double maxDist) {
        int count = 0;
        for (int i = 1; i < stations.Length; i++) {
            double dist = stations[i] - stations[i - 1];
            count += (int)(dist / maxDist);
        }
        return count <= k;
    }

    public static void Main(string[] args) {
        // Example 1
        int[] stations1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k1 = 9;
        Console.WriteLine(FindSmallestMaxDist(stations1, k1));  // Output: 0.50

        // Example 2
        int[] stations2 = { 3, 6, 12, 19, 33, 44, 67, 72, 89, 95 };
        int k2 = 2;
        Console.WriteLine(FindSmallestMaxDist(stations2, k2));  // Output: 14.00
    }
}
```

// Explanation:
// - I've translated the Java code to C# while maintaining the same logic.
// - The method names (`CanPlace`, `FindSmallestMaxDist`, and `Main`) follow C# naming conventions (PascalCase).
// - The `Console.WriteLine` method is used instead of Java's `System.out.println`.
