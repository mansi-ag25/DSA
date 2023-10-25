//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        if(source[0]==destination[0] && source[1]==destination[1]){
            return 0;
        }
        
        Queue<Pair> q=new LinkedList<>();
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        
        int n=grid.length;
        int m=grid[0].length;
        
        int vis[][]=new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                vis[i][j]=Integer.MAX_VALUE;
            }
        }
        
        vis[source[0]][source[1]]=0;
        
        q.add(new Pair(0,source[0],source[1]));
        
        while(!q.isEmpty()){
            Pair curr=q.remove();
            int src=curr.src;
            int first=curr.first;
            int second=curr.dest;
            
            for (int i=0;i<4;i++){
                int nr=first+drow[i];
                int nc=second+dcol[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1 && vis[nr][nc]>src+1){
                    vis[nr][nc]=src+1;
                    if(nr==destination[0] && nc==destination[1]){
                        return src+1;
                    }
                    
                    q.add(new Pair(src+1,nr,nc));
                }
            }
        }
        
        return -1;
    }
}
    
    class Pair{
        int src;
        int first;
        int dest;
        
        public Pair(int src,int first,int dest){
            this.src=src;
            this.first=first;
            this.dest=dest;
        }
    }

