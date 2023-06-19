//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        
        ArrayList<Long> lst=new ArrayList<>();
         long ans=0;
         int flag=0,i=0,j=0;
        while(j<A.length){
            if(A[j]<0 && flag==0){
                ans=A[j];
                flag=1;

            }

            if((j-i+1)==K){
               // System.out.print(ans+" ")
                lst.add(ans);
                if(ans==A[i]){
                    flag=0;
                    ans=0;
                    for (int m=i+1;m<=j;m++){
                        if(A[m]<0 && flag==0){
                        ans=A[m];
                        flag=1;
                       }

                       

                    }
                   
                }
                i++;
            }

            j++;
        }
        
        long[] arr=new long[lst.size()];
        for (int z=0;z<lst.size();z++){
            arr[z]=lst.get(z);
        }
        
        return arr;
        
        
    }
}