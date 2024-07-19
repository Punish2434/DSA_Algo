/*     Scroll below to see JAVA code and C# also    */

    // Company Tags           : Google,Codenation
    // GFG Link               : https://www.geeksforgeeks.org/problems/count-smaller-elements2214/1



/ C++ *************************************************************************************************************************************************/
// Time Complexity:- O(NlogN)
// Space Complexity:- O(N)
class Solution {
  public:
  int binarySearch(vector<int> &temp,int key){
        int index=-1,low=0,high=temp.size()-1,mid;
        while(low<=high){
            mid=(low+high)/2;
            if(temp[mid]==key){
                index=mid;
                high=mid-1;
            }
            else if(temp[mid]>key)high=mid-1;
            else low=mid+1;
        }
        return index;
    }
    vector<int> constructLowerArray(vector<int> &arr) {
        // code here
        vector<int> ans;
        vector<int> temp;
        for(auto x:arr)temp.push_back(x);
        sort(temp.begin(),temp.end());
        for(int i=0;i<arr.size();i++){
            int index = binarySearch(temp,arr[i]);
            ans.push_back(index);
            temp.erase(temp.begin()+index);
        }
        return ans;
    }
};

/ Java *************************************************************************************************************************************************/
// Time Complexity:- O(NlogN)
// Space Complexity:- O(N)

  class Solution {
     int binarySearch(ArrayList<Integer> temp,int element){
        int index=-1;
        int low=0,high=temp.size()-1,mid;
        while(low<=high){
            mid=(low+high)/2;
            if(temp.get(mid)==element){
                index=mid;
                high=mid-1;
            }
            else if(temp.get(mid)>element) high=mid-1;
            else low=mid+1;
        }
        return index;
    }
    int[] constructLowerArray(int[] arr) {
        // code here
        int ans[] = new int[arr.length];
	    ArrayList<Integer> temp = new ArrayList<>();
	    for(int i=0;i<arr.length;i++)temp.add(arr[i]);
	    Collections.sort(temp);
	    for(int i=0;i<arr.length;i++){
	        int index = binarySearch(temp,arr[i]);
	        ans[i]=index;
	        temp.remove(index);
	    }
	    return ans;
    }
}

/ C# *************************************************************************************************************************************************/
// Time Complexity:- O(NlogN)
// Space Complexity:- O(N)

using System;
using System.Collections.Generic;

public class Solution
{
    private int BinarySearch(List<int> temp, int element)
    {
        int index = -1;
        int low = 0, high = temp.Count - 1, mid;
        while (low <= high)
        {
            mid = (low + high) / 2;
            if (temp[mid] == element)
            {
                index = mid;
                high = mid - 1;
            }
            else if (temp[mid] > element)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return index;
    }

    public int[] ConstructLowerArray(int[] arr)
    {
        int[] ans = new int[arr.Length];
        List<int> temp = new List<int>(arr);
        temp.Sort();
        for (int i = 0; i < arr.Length; i++)
        {
            int index = BinarySearch(temp, arr[i]);
            ans[i] = index;
            temp.RemoveAt(index);
        }
        return ans;
    }
}
