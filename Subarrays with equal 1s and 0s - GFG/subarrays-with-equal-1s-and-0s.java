//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] arr= new int[n];
	       for(int i=0;i<n;i++) {
	           arr[i] = in.nextInt();
	       }
	       System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
	   }
	 }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int val = 0;
        hm.put(0, 1);
        
        for(int i=0; i<n; i++) {
            if(arr[i] == 1) val++;
            else    val--;
            
            if(hm.containsKey(val)) {
                int value = hm.get(val);
                count += value;
                
                hm.put(val, value + 1);
            } else {
                hm.put(val, 1);
            }
        }
        
        return count;
    }
}


