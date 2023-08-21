//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum=0;
	    for (int i=0;i<n;i++){
	        sum+=arr[i];
	    }
	    int W=sum/2;
	    int dp[][]=new int[n+1][W+1];
	    for (int i=0;i<dp.length;i++){
	        for (int j=0;j<dp[0].length;j++){
	            dp[i][j]=-1;
	        }
	    }
	    
	    int sum1= minDiff(arr,W,dp,n);
	    //System.out.println(sum1);
	   int sum2=Math.abs(sum-sum1);
	    return Math.abs(sum2-sum1);
	} 
	
	public int minDiff(int arr[],int W,int dp[][],int n){
	    if(n==0 || W==0){
	        return 0;
	    }
	    
	    if(dp[n][W]!=-1){
	        return dp[n][W];
	    }
	    
	     if(arr[n-1]<=W){
            int ans1=arr[n-1]+minDiff(arr,W-arr[n-1],dp,n-1);
            
            int ans2=minDiff(arr,W,dp,n-1);
            dp[n][W]= Math.max(ans1,ans2);
            return dp[n][W];
        }
        
        else{
            dp[n][W]= minDiff(arr,W,dp,n-1);
            return dp[n][W];
        }
	}
	
}
