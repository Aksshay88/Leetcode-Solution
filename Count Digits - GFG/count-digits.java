//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.evenlyDivides(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    static int evenlyDivides(int N) {
        int c = 0;
        int n = N;

        while (N != 0) {
            int digit = N % 10;
            if (digit != 0 && n % digit == 0) {
                c++;
            }
            N /= 10;
        }

        return c;
    }
}