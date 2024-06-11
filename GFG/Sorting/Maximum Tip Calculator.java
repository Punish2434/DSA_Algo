/*    Scroll below to see JAVA code and C# also  */
/*
    Company Tags                : Amazon,TCS
    GFG Link               :https://www.geeksforgeeks.org/problems/maximum-tip-calculator2631/1
*/
/ C++ **************************************************************************************************************************/
// Time Complexity: O(n*logn)
//  Auxiliary Space: O(n)
  #include <iostream>
#include <vector>
#include <algorithm>

class Solution {
public:
    static long maxTip(int n, int x, int y, std::vector<int>& arr, std::vector<int>& brr) {
        std::vector<std::vector<int>> a(n, std::vector<int>(3));
        for (int i = 0; i < n; ++i) {
            a[i][0] = arr[i];
            a[i][1] = brr[i];
            a[i][2] = std::abs(arr[i] - brr[i]);
        }

        std::sort(a.begin(), a.end(),  {
            return q[2] < p[2];
        });

        long res = 0;
        for (int i = 0; i < n; ++i) {
            if (x == 0)
                res += a[i][1];
            else if (y == 0)
                res += a[i][0];
            else {
                if (a[i][0] >= a[i][1]) {
                    res += a[i][0];
                    --x;
                } else {
                    res += a[i][1];
                    --y;
                }
            }
        }
        return res;
    }
};

int main() {
    int n, x, y;
    std::cin >> n >> x >> y;
    std::vector<int> arr(n), brr(n);
    for (int i = 0; i < n; ++i) {
        std::cin >> arr[i];
    }
    for (int i = 0; i < n; ++i) {
        std::cin >> brr[i];
    }
    std::cout << Solution::maxTip(n, x, y, arr, brr) << std::endl;
    return 0;
}
/ Java **************************************************************************************************************************/
// Time Complexity: O(n*logn)
//  Auxiliary Space: O(n)
  class Solution {
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        // code here
        int a[][] = new int [n][3];
        for(int i=0; i<n; i++){
            a[i][0]=arr[i];
            a[i][1]=brr[i];
            a[i][2]= Math.abs(arr[i]-brr[i]);
        }
     
          Arrays.sort(a, (p,q) -> q[2] - p[2]);
        
        long res=0;
        for(int i=0; i<n; i++){
            if(x==0)
            res+=a[i][1];
            else if(y==0)
            res+= a[i][0];
            
            else{
                if(a[i][0]>=a[i][1]){
                    res+=a[i][0]; x--;
                    
                } else{
                    res+= a[i][1]; y--;
                }
            }
        }
        return res;
        
    }
}
/ C# **************************************************************************************************************************/
// Time Complexity: O(n*logn)
//  Auxiliary Space: O(n)
  
using System;
using System.Linq;

public class Solution {
    public static long MaxTip(int n, int x, int y, int[] arr, int[] brr) {
        int[][] a = new int[n][];
        for (int i = 0; i < n; ++i) {
            a[i] = new int[3];
            a[i][0] = arr[i];
            a[i][1] = brr[i];
            a[i][2] = Math.Abs(arr[i] - brr[i]);
        }

        Array.Sort(a, (p, q) => q[2].CompareTo(p[2]));

        long res = 0;
        for (int i = 0; i < n; ++i) {
            if (x == 0)
                res += a[i][1];
            else if (y == 0)
                res += a[i][0];
            else {
                if (a[i][0] >= a[i][1]) {
                    res += a[i][0];
                    --x;
                } else {
                    res += a[i][1];
                    --y;
                }
            }
        }
        return res;
    }

    public static void Main(string[] args) {
        int n = int.Parse(Console.ReadLine());
        int x = int.Parse(Console.ReadLine());
        int y = int.Parse(Console.ReadLine());
        int[] arr = Console.ReadLine().Split().Select(int.Parse).ToArray();
        int[] brr = Console.ReadLine().Split().Select(int.Parse).ToArray();
        Console.WriteLine(MaxTip(n, x, y, arr, brr));
    }
}

