//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java
class Node{
    Node[] children;
    boolean eow;
    public Node(){
        children=new Node[26];
        for (int i=0;i<26;i++){
            children[i]=null;
        }

        eow=false;
    }
}
class Solution
{
    static Node root;
    public Solution(){
        root=new Node();
    }
    public static int wordBreak(String A, ArrayList<String> B )
    {
        //code here
        
        for (int i=0;i<B.size();i++){
            insert(B.get(i));
        }

        boolean ans=wordbreak(A);
        if(ans==true){
            return 1;
        }
        
        return 0;
        
    }
     public static void insert(String s){
        Node curr=root;
        for (int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            if(i==s.length()-1){
                curr.children[idx].eow=true;
            }

            curr=curr.children[idx];
        }
    }

    public static boolean wordbreak(String s){
        if(s.length()==0){
            return true;
        }

        for (int i=1;i<=s.length();i++){
            String first=s.substring(0,i);
            String second=s.substring(i);

            if(search(first) && wordbreak(second)){
                return true;
            }
        }

        return false;
    }


    public static boolean search(String s){
        Node curr=root;
        for (int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }

            if(i==s.length()-1 && curr.children[idx].eow==false){
                return false;
            }

            curr=curr.children[idx];
        }

        return true;
    }
}