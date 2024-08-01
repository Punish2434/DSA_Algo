/*         Scroll below to see JAVA code and C# also        */

    // Company Tags                : 
    // Leetcode Link               : https://leetcode.com/problems/number-of-senior-citizens/
// C++ ********************************************************************************************************************************************/
//Approach (Using Substring)
// TC:𝑂(n)
// SC:𝑂(1)
#include <iostream>
#include <vector>
#include <string>

class Solution {
public:
    int countSeniors(std::vector<std::string>& details) {
        int count = 0;
        for (const std::string& passenger : details) {
            int age = std::stoi(passenger.substr(11, 2));
            if (age > 60) {
                count++;
            }
        }
        return count;
    }
};

int main() {
    Solution solution;

    std::vector<std::string> details1 = {"7868190130M7522", "5303914400F9211", "9273338290F4010"};
    std::cout << solution.countSeniors(details1) << std::endl;  // Output: 2

    std::vector<std::string> details2 = {"1313579440F2036", "2921522980M5644"};
    std::cout << solution.countSeniors(details2) << std::endl;  // Output: 0

    return 0;
}
// Java ********************************************************************************************************************************************/
//Approach (Using Substring)// TC:𝑂(n)
// SC:𝑂(1)

class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String passenger : details) {
            int age = Integer.parseInt(passenger.substring(11, 13));
            if (age > 60) {
                count++;
            }
        }
        return count;
    }
}

// C# ********************************************************************************************************************************************/
//Approach (Using Substring)// TC:𝑂(n)
// SC:𝑂(1)
public class Solution {
    public int CountSeniors(string[] details) {
        int count = 0;
        foreach(string passenser in details){
            int age = int.Parse(passenser.Substring(11, 2));
            if(age > 60){
                count ++;
            }
        }
        return count;
    }
}
