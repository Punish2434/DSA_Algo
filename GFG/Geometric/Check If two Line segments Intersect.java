/*     Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : Snapdeal,Adobe,Zomato
    GFG Link                    : https://www.geeksforgeeks.org/problems/check-if-two-line-segments-intersect0017/1
*/

/ C++ ******************************************************************************************************************************************/
//Using simple Geometric

//T.C : O(1) 
//S.C : O(1)
class Solution {
  public:
    string doIntersect(int p1[], int p2[], int q1[], int q2[]) {
        // code here
        double m1=(p2[1]-p1[1])/double(p2[0]-p1[0]);
        double m2=(q2[1]-q1[1])/double(q2[0]-q1[0]);

        double check1=m1*(p1[0]-q1[0])-(p1[1]-q1[1]);
        double check2=m1*(p1[0]-q2[0])-(p1[1]-q2[1]);
        double check3=m2*(q1[0]-p1[0])-(q1[1]-p1[1]);
        double check4=m2*(q1[0]-p2[0])-(q1[1]-p2[1]);

        if(check1*check2>0 || check3*check4>0)return "false";
        return "true";
    }
};


/ Java ******************************************************************************************************************************************/
//Using simple Geometric

//T.C : O(1) 
//S.C : O(1)
  class Solution {
    public String doIntersect(int[] p1, int[] p2, int[] q1, int[] q2) {
        double m1 = (p2[1] - p1[1]) / (double)(p2[0] - p1[0]);
        double m2 = (q2[1] - q1[1]) / (double)(q2[0] - q1[0]);

        double check1 = m1 * (p1[0] - q1[0]) - (p1[1] - q1[1]);
        double check2 = m1 * (p1[0] - q2[0]) - (p1[1] - q2[1]);
        double check3 = m2 * (q1[0] - p1[0]) - (q1[1] - p1[1]);
        double check4 = m2 * (q1[0] - p2[0]) - (q1[1] - p2[1]);

        if (check1 * check2 > 0 || check3 * check4 > 0) return "false";
        return "true";
    }
}
/ C# ******************************************************************************************************************************************/
//Using simple Geometric

//T.C : O(1) 
//S.C : O(1)
class Solution {
    public string DoIntersect(int[] p1, int[] p2, int[] q1, int[] q2) {
        double m1 = (p2[1] - p1[1]) / (double)(p2[0] - p1[0]);
        double m2 = (q2[1] - q1[1]) / (double)(q2[0] - q1[0]);

        double check1 = m1 * (p1[0] - q1[0]) - (p1[1] - q1[1]);
        double check2 = m1 * (p1[0] - q2[0]) - (p1[1] - q2[1]);
        double check3 = m2 * (q1[0] - p1[0]) - (q1[1] - p1[1]);
        double check4 = m2 * (q1[0] - p2[0]) - (q1[1] - p2[1]);

        if (check1 * check2 > 0 || check3 * check4 > 0) return "false";
        return "true";
    }
}
