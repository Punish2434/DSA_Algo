/*         Scroll below to see JAVA code and C# also        */

    // Company Tags                : 
    // Leetcode Link               : https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/
// Java ********************************************************************************************************************************************/
//Approach (Using iterate over the sorted frequency array)
// TC:𝑂(n) 
// SC:𝑂(1)
class Solution {
    public int minimumPushes(String word) {
        // Step 1: Frequency calculation
        int[] frequency = new int[26];
        for (char c : word.toCharArray()) {
            frequency[c - 'a']++;
        }
        
        // Step 2: Sort the letters by frequency in descending order
        Arrays.sort(frequency);
        
        // Step 3: Map the most frequent letters to keys with least pushes
        int totalPushes = 0;
        int push = 1;  // Initial push count starts at 1
        int lettersMapped = 0;
        
        for (int i = 25; i >= 0; i--) {
            if (frequency[i] == 0) break;  // No more letters to map
            totalPushes += frequency[i] * push;
            lettersMapped++;
            if (lettersMapped % 8 == 0) push++;  // Increase push count after every 8 letters
        }
        
        return totalPushes;
    }
}
// C# ********************************************************************************************************************************************/
//Approach (Using iterate over the sorted frequency array)
// TC:𝑂(n) 
// SC:𝑂(1)
public class Solution {
    public int MinimumPushes(string word) {
        //Step 1: Frequency calculation
        int[] frequency = new int[26];
        foreach(char c in word){
            frequency[c - 'a']++;
        }
        //Step 2: Sort the letters by frequency in descendig order
        Array.Sort(frequency);
        Array.Reverse(frequency);
        // Step 3: Map the most frequent letters to keys with least pushes
        int totalPushes = 0;
        int push = 1;
        for(int i = 0; i < 26; i++){
            if(frequency[i] == 0) break;
            totalPushes += frequency[i] * push;
            if((i + 1) % 8 == 0) push++;
        }
        return totalPushes;
    }
}
// JavaScript ********************************************************************************************************************************************/
//Approach (Using iterate over the sorted frequency array)
// TC:𝑂(n) 
// SC:𝑂(1)
class Solution {
    minimumPushes(word) {
        // Step 1: Frequency calculation
        let frequency = Array(26).fill(0);
        for (let c of word) {
            frequency[c.charCodeAt(0) - 97]++;
        }
        
        // Step 2: Sort the letters by frequency in descending order
        frequency.sort((a, b) => b - a);
        
        // Step 3: Map the most frequent letters to keys with least pushes
        let totalPushes = 0;
        let push = 1;  // Initial push count starts at 1
        
        for (let i = 0; i < 26; i++) {
            if (frequency[i] === 0) break;
            totalPushes += frequency[i] * push;
            if ((i + 1) % 8 === 0) push++;
        }
        
        return totalPushes;
    }
}
