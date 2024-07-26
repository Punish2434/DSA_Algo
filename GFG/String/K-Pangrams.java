/*         Scroll below to see JAVA code and C# also        */

    // Company Tags                : Zoho,Snapdeal
    // GFG Link               : https://www.geeksforgeeks.org/problems/k-pangrams0909/1
// C++ ********************************************************************************************************************************************/
//Approach (using Loop through the string)
// Time Complexity: O(n) 
// Space Complexity: O(1) 

class Solution {
  public:

    bool kPangram(string str, int k) {
        // codeGenius
        int arr[26]={0}, count =0, op=0;
        for(int i=0;i<str.size();i++){
            if(str[i]!= ' '){
                arr[str[i]-'a']++;
                count++;
            }
        }
        for(int i=0;i<26;i++){
            if(arr[i]==0){
                op++;
            }
        }
        return (op <= k) &&(count>=26);
    }
};
// Java ********************************************************************************************************************************************/
//Approach (using Loop through the string)
// Time Complexity: O(n) 
// Space Complexity: O(1) 
class Solution {
    public boolean kPangram(String str, int k) {
        int[] arr = new int[26];
        int count = 0, op = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                arr[str.charAt(i) - 'a']++;
                count++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                op++;
            }
        }
        return (op <= k) && (count >= 26);
    }
}


// C# ********************************************************************************************************************************************/
//Approach (using Loop through the string)
// Time Complexity: O(n) 
// Space Complexity: O(1) 
using System;

public class Solution {
    public bool kPangram(string str, int k) {
        int[] arr = new int[26];
        int count = 0, op = 0;
        foreach (char c in str) {
            if (c != ' ') {
                arr[c - 'a']++;
                count++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                op++;
            }
        }
        return (op <= k) && (count >= 26);
    }
}


// JavaScript ********************************************************************************************************************************************/
//Approach (using Loop through the string)
// Time Complexity: O(n) 
// Space Complexity: O(1) 
class Solution {
    kPangram(str, k) {
        let arr = new Array(26).fill(0);
        let count = 0;
        let op = 0;
        for (let i = 0; i < str.length; i++) {
            if (str[i] !== ' ') {
                arr[str.charCodeAt(i) - 'a'.charCodeAt(0)]++;
                count++;
            }
        }
        for (let i = 0; i < 26; i++) {
            if (arr[i] === 0) {
                op++;
            }
        }
        return (op <= k) && (count >= 26);
    }
}

