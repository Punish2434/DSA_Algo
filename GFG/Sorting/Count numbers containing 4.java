/*            Scroll below to see JAVA and C# Code also                */
/*
    Company Tags           : Drishti-Soft
    GFG Link               : https://www.geeksforgeeks.org/problems/count-numbers-containing-43022/1
*/


/ C++ ********************************************************************************************************/
 // Time Complexity: O(nlogn)
 // Auxiliary Space: O(1)

class Solution {
  public:
  int find(int n){
            while(n){
                if(n%10 ==4)
                return 1;
             n/=10;
            }
            return 0;
        }
    int countNumberswith4(int n) {
        int count =0;
        for(int i=0;i<=n;i++){
            if(find(i))
            count++;
        }
        return count;
    }
};
/ Java ********************************************************************************************************/
 // Time Complexity: O(nlogn)
 // Auxiliary Space: O(1)
  public class Solution {
    public int find(int n) {
        while (n != 0) {
            if (n % 10 == 4)
                return 1;
            n /= 10;
        }
        return 0;
    }

    public int countNumberswith4(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            if (find(i))
                count++;
        }
        return count;
    }
}

  
/ C# ********************************************************************************************************/
 // Time Complexity: O(nlogn)
 // Auxiliary Space: O(1)
  public class Solution {
    public int Find(int n) {
        while (n != 0) {
            if (n % 10 == 4)
                return 1;
            n /= 10;
        }
        return 0;
    }

    public int CountNumbersWith4(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            if (Find(i) == 1)
                count++;
        }
        return count;
    }
}
