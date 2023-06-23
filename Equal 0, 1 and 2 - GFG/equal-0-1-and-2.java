//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int count = 0;
        
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("0#0", 1);
        
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '0')  count0++;
            else if(str.charAt(i) == '1') count1++;
            else count2++;
            
            String diff = Integer.toString(count1 - count0) + "#" + Integer.toString(count2 - count1);
            
            if(hm.containsKey(diff)) {
                count += hm.get(diff);
                hm.put(diff, hm.get(diff) + 1);
            } else {
                hm.put(diff, 1);
            }
        }
        
        return count;
    }
} 