//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        long p=arr.length;
        long Sn1=(p*(p+1))/2;
        long Sn2=(p*(p+1)*(2*n+1))/6;
        long s1=0, s2=0;
        
        for (int i=0;i<arr.length;i++){
            s1+=(long)arr[i];
            s2+=(long)arr[i]*(long)arr[i];
        }
        
        long x=s1-Sn1;
        long y=s2-Sn2;
        y=y/x;
        
        long m=(x+y)/2;
        long o=m-x;
        
        int r=(int)m;
        int q=(int)o;
        
        int brr[]=new int[2];
        brr[0]=r;
        brr[1]=q;
        
        return brr;
        
    }
}