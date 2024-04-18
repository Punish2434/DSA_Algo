/*     Scroll below to see JAVA code and C# also    */
/*

    Company Tags                : Amazon,Facebook,Google,Visa
   GFG Link               : https://www.geeksforgeeks.org/problems/two-repeated-elements-1587115621/1
*/

*/ BruteForceApproach: *************************************************************************************************/


class Solution
{
    //Function to find two repeated elements.
    public int[] twoRepeated(int arr[], int n)
    {
        // Your code here
        int ans[] = new int[2];
        int k=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : arr){
            map.put(x, map.getOrDefault(x,0)+1);
            if(map.get(x)==2)
            ans[k++] = x;
        }
        return ans;
        
    }

    
}

*/ OptimizedApproach(DynamicProgramming): *************************************************************************************************/


class Solution
{
    //Function to find two repeated elements.
    public int[] twoRepeated(int arr[], int n)
    {
        // Your code here
        //s1
         int ans[] = new int[2];
        int k=0;
        int flag = 0;

        //s2 traverse in arr
        for(int i=0; i<n+2;i++){
            if(arr[Math.abs(arr[i])] >0){
                arr[Math.abs(arr[i])] = - arr[Math.abs(arr[i])];
                
            }
            else{
                if(flag==0){
                    ans[k++] = Math.abs(arr[i]);
                    flag=1;
                }
                else{
                    ans[k++]  =  Math.abs(arr[i]);
                }
            }
        }
         return ans;

    
    }
}
