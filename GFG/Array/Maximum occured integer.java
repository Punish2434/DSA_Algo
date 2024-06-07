/*    Scroll below to see JAVA code and C# also    */
/*
    Company Tags                :
    GFG Link               : https://www.geeksforgeeks.org/problems/maximum-occured-integer4602/1
*/


/ C++ *********************************************************************************************************************************************************************/
// Expected Time Complexity: O(n+maxx).
// Expected Auxiliary Space: O(maxx), maxx is maximum element in r[]
  
  class Solution {
  public:
    // l and r are input array
    // maxx : maximum in r[]
    // n: size of array
    // arr[] : declared globally with size equal to maximum in l[] and r[]
    // Function to find the maximum occurred integer in all ranges.
    int maxOccured(int n, int l[], int r[], int maxx) {

        int count[maxx+1]={0};
        for(int i=0;i<n;i++){
            count[l[i]]++;
            count[r[i]+1]--;
        }
        int max=0;
        int maxCount=0;
        for(int i=1;i<maxx;i++){
            count[i]+=count[i-1];
            if(maxCount<count[i]){
                max=i;
                maxCount=count[i];
            }
        }
        return max;
    }
};

/ Java *********************************************************************************************************************************************************************/
// Expected Time Complexity: O(n+maxx).
// Expected Auxiliary Space: O(maxx), maxx is maximum element in r[]
  public class Solution {
    public int maxOccured(int n, int[] l, int[] r, int maxx) {
        int[] count = new int[maxx + 1];
        for (int i = 0; i < n; i++) {
            count[l[i]]++;
            count[r[i] + 1]--;
        }
        int max = 0;
        int maxCount = 0;
        for (int i = 1; i < maxx; i++) {
            count[i] += count[i - 1];
            if (maxCount < count[i]) {
                max = i;
                maxCount = count[i];
            }
        }
        return max;
    }
}
/ C# *********************************************************************************************************************************************************************/
// Expected Time Complexity: O(n+maxx).
// Expected Auxiliary Space: O(maxx), maxx is maximum element in r[]
  public class Solution {
    public int MaxOccured(int n, int[] l, int[] r, int maxx) {
        int[] count = new int[maxx + 1];
        for (int i = 0; i < n; i++) {
            count[l[i]]++;
            count[r[i] + 1]--;
        }
        int max = 0;
        int maxCount = 0;
        for (int i = 1; i < maxx; i++) {
            count[i] += count[i - 1];
            if (maxCount < count[i]) {
                max = i;
                maxCount = count[i];
            }
        }
        return max;
    }
}
