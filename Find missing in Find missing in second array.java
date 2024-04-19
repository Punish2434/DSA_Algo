/*     Scroll below to see JAVA code and C# also    */
/*

    Company Tags                : Zoho,Accolite,Microsoft,Snapdeal
   GFG Link               : https://www.geeksforgeeks.org/problems/in-first-but-second5423/1
*/

*/ BruteForceApproach: java *************************************************************************************************/
//T.C : O(n*n)
//S.C : O(1)
  class Solution
{
   
    ArrayList<Integer> findMissing(int a[], int b[], int n, int m)
    {
         ArrayList<Integer> al = new ArrayList<>();
         for(int i=0; i<n; i++){
             int found=1;
             for(int j=0; j<m; j++){
                 if(a[i]==b[j]){
                     found=0;
                    break;
                 }
             }
             if(found==1)
             al.add(a[i]);
         }
         return al;
    }
}

*/ OptimizedApproach(DynamicProgramming): java *************************************************************************************************/
//T.C : O(n)
//S.C : O(n)
class Solution
{
   
    ArrayList<Integer> findMissing(int a[], int b[], int n, int m)
    {
         ArrayList<Integer> al = new ArrayList<>();
         Set<Integer> set = new HashSet<>();
         for(int x : b){
             set.add(x);
         }
         for(int x: a){
             if(!set.contains(x))
             al.add(x);
         }
         return al;
    }
}

*/ OptimizedApproach(DynamicProgramming): C# *************************************************************************************************/
//T.C : O(n)
//S.C : O(n

```csharp
using System;
using System.Collections.Generic;

public class Solution
{
    public List<int> FindMissing(int[] a, int[] b, int n, int m)
    {
        List<int> al = new List<int>();
        HashSet<int> set = new HashSet<int>();

        foreach (int x in b)
        {
            set.Add(x);
        }

        foreach (int x in a)
        {
            if (!set.Contains(x))
            {
                al.Add(x);
            }
        }

        return al;
    }
}
```

// - The `ArrayList` is replaced with `List`.
// - The `HashSet` is used for efficient storage and checking existence of elements.
// - The `FindMissing` method corresponds to the original Java method.
