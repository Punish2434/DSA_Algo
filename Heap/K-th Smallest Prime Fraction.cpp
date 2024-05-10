/*         Scroll below to see JAVA code and C# also        */
/*
    Company Tags                : Pony.ai
    Leetcode Link               : https://leetcode.com/problems/k-th-smallest-prime-fraction/
*/

/ C++ ***********************************************************************************************************************************/
//Approach-1 (Using simple Heap solution as it's asking for kth smallest)
//T.C : O(n^2 * log(k))
//S.C : O(k)
class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        priority_queue<vector<double>> pq;

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i+1; j < arr.size(); j++) {
                double div = (double) arr[i] / arr[j];
                pq.push(vector<double>{div, (double)arr[i], (double)arr[j]});
                if(pq.size() > k)
                    pq.pop();
            }
        }

        auto vec  = pq.top();
        vector<int> result(2);
        result[0] = vec[1];
        result[1] = vec[2];
        return result;
    }
};


//Approach-2 (Optimising Approach-1)
//T.C : O((n+k)logn)
//S.C : O(n)
class Solution {
public:
    typedef vector<double> V;
    
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        int n = arr.size();
        priority_queue<V, vector<V>, greater<V>> pq;
        
        for(int i = 0; i < n; i++)
            pq.push({1.0*arr[i]/arr.back(), (double)(i), (double)(n-1)});
        
        int smallest = 1;
        
        while(smallest < k) {
            V vec = pq.top();
            pq.pop();
            
            int i = vec[1];
            int j = vec[2]-1;

            
            pq.push({1.0*arr[i]/arr[j], (double)(i), (double)(j)});
            smallest++;
        }
        
        V vec = pq.top();
        int i = vec[1];
        int j = vec[2];
        return {arr[i], arr[j]};
    }
};



/ JAVA ************************************************************************************************************************************/
//Approach-1 (Using simple Heap solution as it's asking for kth smallest)
//T.C : O(n^2 * log(k))
//S.C : O(k)
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                double div = (double) arr[i] / arr[j];
                pq.offer(new double[]{div, (double) arr[i], (double) arr[j]});
                if (pq.size() > k)
                    pq.poll();
            }
        }

        double[] vec = pq.peek();
        int[] result = new int[2];
        result[0] = (int) vec[1];
        result[1] = (int) vec[2];
        return result;
    }
}


//Approach-2 (Optimising Approach-1)
//T.C : O((n+k)logn)
//S.C : O(n)
import java.util.*;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a[0]));

        for (int i = 0; i < n; i++)
            pq.offer(new double[]{1.0 * arr[i] / arr[n - 1], (double) i, (double) (n - 1)});

        int smallest = 1;

        while (smallest < k) {
            double[] vec = pq.poll();

            int i = (int) vec[1];
            int j = (int) vec[2] - 1;

            pq.offer(new double[]{1.0 * arr[i] / arr[j], (double) i, (double) j});
            smallest++;
        }

        double[] vec = pq.peek();
        int i = (int) vec[1];
        int j = (int) vec[2];
        return new int[]{arr[i], arr[j]};
    }
}

/ C# ************************************************************************************************************************************/
//Approach-1  
  public class Solution {
    public int[] KthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.Length;
        double left = 0, right = 1;
        int[] result = new int[2];

        while (right - left > 1e-9) {
            double mid = (left + right) / 2;
            int count = 0;
            double maxFraction = 0;
            int numerator = 0, denominator = 0;

            for (int i = 0, j = 1; i < n - 1; i++) {
                while (j < n && arr[i] > mid * arr[j]) {
                    j++;
                }
                count += n - j;
                if (j < n && maxFraction < (double)arr[i] / arr[j]) {
                    maxFraction = (double)arr[i] / arr[j];
                    numerator = arr[i];
                    denominator = arr[j];
                }
            }

            if (count == k) {
                result[0] = numerator;
                result[1] = denominator;
                break;
            }
            else if (count < k) {
                left = mid;
            }
            else {
                right = mid;
            }
        }

        return result;
    }
}



//Approach-2 (Optimising Approach-1)
  public class Solution {
    public int[] KthSmallestPrimeFraction(int[] arr, int k) {
        List<int[]> fractions = new List<int[]>();
        
        for (int i = 0; i < arr.Length - 1; i++) {
            for (int j = i + 1; j < arr.Length; j++) {
                fractions.Add(new int[] { arr[i], arr[j] });
            }
        }
        
        fractions.Sort((a, b) => a[0] * b[1] - a[1] * b[0]);
        
        return fractions[k - 1];
    }
}

