//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        // code here 
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int i = 0;
        
        for(; i<k; i++) {
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }
        ans.add(hm.size());
        
        for(; i<A.length; i++) {
            hm.put(A[i-k], hm.get(A[i-k]) - 1);
            if(hm.get(A[i-k]) == 0) hm.remove(A[i-k]);
            
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
            ans.add(hm.size());
        }
        
        return ans;
    }
}

