/*         Scroll below to see C# code and JavaScript also        */

    // Company Tags                : Zoho,Amazon,Microsoft,Qualcomm
    // Leetcode Link               : https://www.geeksforgeeks.org/problems/validate-an-ip-address-1587115621/1
// Java ********************************************************************************************************************************************/
//Approach (Using iterate over the sorted frequency array)
// TC:𝑂(n) 
// SC:𝑂(1)
class Solution {

    public boolean isValid(String str) {
        // Split the string by the dots
        String[] parts = str.split("\\.");

        // Check if the IP address is divided into exactly four parts
        if (parts.length != 4) {
            return false;
        }

        // Iterate over each part of the IP address
        for (String part : parts) {
            // Check if the part is empty or if it has leading zeros
            if (part.isEmpty() || (part.length() > 1 && part.charAt(0) == '0')) {
                return false;
            }

            try {
                // Convert the part to an integer
                int num = Integer.parseInt(part);

                // Check if the integer is within the valid range for an IPv4 address
                if (num < 0 || num > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                // If parsing fails, it's not a valid integer, hence not a valid IP part
                return false;
            }
        }

        // If all checks pass, the IP address is valid
        return true;
    }

}
// C# ********************************************************************************************************************************************/
//Approach (Using iterate over the sorted frequency array)
// TC:𝑂(n) 
// SC:𝑂(1)
using System;

class Solution
{
    public bool IsValid(string str)
    {
        // Split the string by the dots
        string[] parts = str.Split('.');

        // Check if the IP address is divided into exactly four parts
        if (parts.Length != 4)
        {
            return false;
        }

        // Iterate over each part of the IP address
        foreach (string part in parts)
        {
            // Check if the part is empty or has leading zeros
            if (string.IsNullOrEmpty(part) || (part.Length > 1 && part[0] == '0'))
            {
                return false;
            }

            int num;
            // Try parsing the part to an integer
            if (!int.TryParse(part, out num) || num < 0 || num > 255)
            {
                return false;
            }
        }

        // If all checks pass, the IP address is valid
        return true;
    }

    static void Main(string[] args)
    {
        Solution solution = new Solution();

        // Test cases
        Console.WriteLine(solution.IsValid("222.111.111.111")); // true
        Console.WriteLine(solution.IsValid("5555..555")); // false
        Console.WriteLine(solution.IsValid("172.16.254.1")); // true
        Console.WriteLine(solution.IsValid("0.0.0.0")); // true
        Console.WriteLine(solution.IsValid("256.256.256.256")); // false
        Console.WriteLine(solution.IsValid("192.168.1.01")); // false
    }
}


// JavaScript ********************************************************************************************************************************************/
//Approach (Using iterate over the sorted frequency array)
// TC:𝑂(n) 
// SC:𝑂(1)
class Solution {
    isValid(str) {
        // code here
       const parts = str.split('.');
       
       if(parts.length !== 4){
           return false;
       }
       for(const part of parts){
           if(part === '' || (part.length > 1 && part[0] === '0')){
               return false;
           }
            const num = Number(part);
       if(isNaN(num) || num < 0 || num > 255){
           return false;
       }
    }
    return true;
       }
      
}
