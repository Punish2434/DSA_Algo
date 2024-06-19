/*    Scroll below to see JAVA code and C# also    */
/*
    Company Tags                : 
    GFG Link               : https://www.geeksforgeeks.org/problems/magical-box5306/1
*/

/ C++ ******************************************************************************************************************************/
//T.C : O(1) 
//S.C : O(1)


class Solution {
  public:
    double maxVolume(double perimeter, double area) {
        double ans =
            (pow((perimeter - (sqrt(pow(perimeter, 2) - (24 * area)))) / 12, 2) *
             ((perimeter / 4) -
              (2 * ((perimeter - (sqrt(pow(perimeter, 2) - (24 * area)))) / 12))));

        return ans;
    }
};

/ Java ******************************************************************************************************************************/
//T.C : O(1) 
//S.C : O(1)
class Solution {
    public double maxVolume(double perimeter, double area) {
        double sqrtTerm = Math.sqrt(Math.pow(perimeter, 2) - (24 * area));
        double side = (perimeter - sqrtTerm) / 12;
        double height = (perimeter / 4) - (2 * side);
        double ans = Math.pow(side, 2) * height;
        return ans;
    }
}


  
/ C# ******************************************************************************************************************************/
//T.C : O(1) 
//S.C : O(1)
  
 class Solution {
    public double MaxVolume(double perimeter, double area) {
        double sqrtTerm = Math.Sqrt(Math.Pow(perimeter, 2) - (24 * area));
        double side = (perimeter - sqrtTerm) / 12;
        double height = (perimeter / 4) - (2 * side);
        double ans = Math.Pow(side, 2) * height;
        return ans;
    }
}
