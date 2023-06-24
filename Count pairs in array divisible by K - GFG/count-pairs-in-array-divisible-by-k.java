//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    int k = Integer.parseInt(br.readLine().trim());
		    
		    Solution ob= new Solution();
		    System.out.println(ob.countKdivPairs(arr, n, k));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long countKdivPairs(int nums[], int n, int k)
    {
        //code here
        long count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int rem = nums[i]%k;
            
            hm.put(rem, hm.getOrDefault(rem, 0) + 1);
        }
        
        for(int i=1; i<k/2; i++) {
            if(hm.containsKey(i) && hm.containsKey(k-i)) {
                count += hm.get(i) * hm.get(k-i);
            }
        }

        if(hm.containsKey(0))   count += counter(hm.get(0));
        if(k%2 == 0) {
            if(hm.containsKey(k/2))
                count += counter(hm.get(k/2));
        } else {
            int num = k/2;
            if(hm.containsKey(num) && hm.containsKey(k-num))
                count += hm.get(num) * hm.get(k-num);
        }

        return count;
    }
    
    public static long counter(int num) {
        return num*(num-1) / 2;
    } 
}