/*     Scroll below to see JAVA code and C# also  */
/*
    Company Tags                : DE-Shaw
    Leetcode Link               : https://leetcode.com/problems/number-of-wonderful-substrings/
*/


/ C++ ********************************************************************************************************************/
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    typedef long long ll;
    long long wonderfulSubstrings(string word) {
        unordered_map<ll, ll> mp;

        mp[0] = 1;
        int cum_xor = 0;

        ll result = 0;


        for(char &ch : word) {

            int shift = ch - 'a';

            cum_xor ^= (1 << shift);

            result += mp[cum_xor];

            for(char ch1 = 'a' ; ch1 <= 'j'; ch1++) {
                shift = ch1 - 'a';

                ll check_xor = (cum_xor ^ (1 << shift));

                result += mp[check_xor];
            }

            mp[cum_xor]++;

        }

        return result;
    }
};


/ JAVA ********************************************************************************************************************/
//T.C : O(n)
//S.C : O(1)
class Solution {
    public long wonderfulSubstrings(String word) {
        Map<Long, Long> mp = new HashMap<>();

        mp.put(0L, 1L);
        int cum_xor = 0;

        long result = 0;

        for (char ch : word.toCharArray()) {
            int shift = ch - 'a';

            cum_xor ^= (1 << shift);

            result += mp.getOrDefault((long) cum_xor, 0L);

            for (char ch1 = 'a'; ch1 <= 'j'; ch1++) {
                shift = ch1 - 'a';

                long check_xor = (cum_xor ^ (1 << shift));

                result += mp.getOrDefault(check_xor, 0L);
            }

            mp.put((long) cum_xor, mp.getOrDefault((long) cum_xor, 0L) + 1);
        }

        return result;
    }
}
/ C# ********************************************************************************************************************/

using System;
using System.Collections.Generic;

public class Solution
{
    public long WonderfulSubstrings(string word)
    {
        Dictionary<long, long> mp = new Dictionary<long, long>();

        mp[0L] = 1L;
        int cumXor = 0;
        long result = 0;

        foreach (char ch in word)
        {
            int shift = ch - 'a';
            cumXor ^= (1 << shift);
            result += mp.GetValueOrDefault((long)cumXor, 0L);

            for (char ch1 = 'a'; ch1 <= 'j'; ch1++)
            {
                shift = ch1 - 'a';
                long checkXor = cumXor ^ (1 << shift);
                result += mp.GetValueOrDefault(checkXor, 0L);
            }

            mp[cumXor] = mp.GetValueOrDefault(cumXor, 0L) + 1;
        }

        return result;
    }
}
```

// In the converted C# code:
// - We use `Dictionary<long, long>` instead of `Map<Long, Long>` for the frequency map.
// - The `GetValueOrDefault` method is used instead of `getOrDefault` to handle default values.
