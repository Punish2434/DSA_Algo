/*        Scroll below to see JAVA code also        */
/*
    Company Tags                      : Accolite, Adobe, Amazon, D-E-Shaw, MakeMyTrip, Microsoft, Payu
    Leetcode Link                     : https://leetcode.com/problems/trapping-rain-water/
*/


/ C++ ********************************************************************************************************************/
//T.C : O(n)
//S.C : O(n)
class Solution {
public:
    vector<int> getLeftMax(vector<int>& height, int n) {
        vector<int> leftMax(n);
        leftMax[0] = height[0];
        for(int i = 1; i<n; i++) {
            leftMax[i] = max(leftMax[i-1], height[i]);
        }
        return leftMax;
    }
    vector<int> getRightMax(vector<int>& height, int n) {
        vector<int> rightMax(n);
        rightMax[n-1] = height[n-1];
        for(int i = n-2; i>=0; i--) {
            rightMax[i] = max(rightMax[i+1], height[i]);
        }
        return rightMax;
    } 
    int trap(vector<int>& height) {
        int n = height.size();
        if(n == 1 || n == 0)
            return 0;
        vector<int> leftMax = getLeftMax(height, n);
        vector<int> rightMax = getRightMax(height, n);
        int sum = 0;
        for(int i = 0; i<n; i++) {
            sum += min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }
};



/ JAVA ********************************************************************************************************************/
//T.C : O(n)
//S.C : O(n)
public class Solution {
    public int[] getLeftMax(int[] height, int n) {
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        return leftMax;
    }

    public int[] getRightMax(int[] height, int n) {
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        return rightMax;
    }

    public int trap(int[] height) {
        int n = height.length;
        if (n == 1 || n == 0)
            return 0;
        
        int[] leftMax = getLeftMax(height, n);
        int[] rightMax = getRightMax(height, n);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }
}

/ C# ********************************************************************************************************************/


```csharp
public class Solution
{
    public int[] GetLeftMax(int[] height, int n)
    {
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++)
        {
            leftMax[i] = Math.Max(leftMax[i - 1], height[i]);
        }
        return leftMax;
    }

    public int[] GetRightMax(int[] height, int n)
    {
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--)
        {
            rightMax[i] = Math.Max(rightMax[i + 1], height[i]);
        }
        return rightMax;
    }

    public int Trap(int[] height)
    {
        int n = height.Length;
        if (n == 1 || n == 0)
            return 0;

        int[] leftMax = GetLeftMax(height, n);
        int[] rightMax = GetRightMax(height, n);

        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += Math.Min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }
}
```


// - The method names follow C# naming conventions (camelCase).
// - The `Math.Max` function remains the same.
// - The `length` property is replaced with `Length` for arrays.
// - The `getLeftMax` and `getRightMax` methods are renamed to `GetLeftMax` and `GetRightMax`.
// - The `trap` method is renamed to `Trap`.
