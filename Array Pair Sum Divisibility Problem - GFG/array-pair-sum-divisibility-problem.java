//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean canPair(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int remainder = (nums[i] % k + k) % k; // Handle negative numbers
            hm.put(remainder, hm.getOrDefault(remainder, 0) + 1);
        }
        
        if (k % 2 == 0) {
            for (int i = 1; i <= (k - 1) / 2; i++) {
                if (!hm.getOrDefault(i, 0).equals(hm.getOrDefault(k - i, 0))) {
                    return false;
                }
            }
            
            if (hm.getOrDefault(k / 2, 0) % 2 != 0) {
                return false;
            }
        } else {
            for (int i = 1; i <= k / 2; i++) {
                if (!hm.getOrDefault(i, 0).equals(hm.getOrDefault(k - i, 0))) {
                    return false;
                }
            }
        }
        
        if (hm.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }
        
        return true;
    }
}