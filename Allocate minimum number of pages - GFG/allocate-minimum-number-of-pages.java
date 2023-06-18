//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    
      public static boolean isValid(int[] arr,int k,int mid){
        int sum=0;
        int student=1;
        for (int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>mid){
                student++;
                sum=arr[i];
            }
        }

        if(student>k){
            return false;
        }
        return true;
    }
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
         int max=0;
        int sum=0;

        for (int i=0;i<A.length;i++){
            if(A[i]>max){
                max=A[i];
            }
            sum+=A[i];
        }
        
        int start=max;
        int end=sum;
        int res=-1;
        
        if(M>N){
            return res;
        }
        while(start<=end){
            int mid=start+((end-start)/2);
            if(isValid(A,M,mid)){
                res=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        
        return res;

    }
};