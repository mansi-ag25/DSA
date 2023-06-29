//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            String res = obj.longestString(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

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
class Solution {
     Node root;
    public Solution(){
        root=new Node();
    }
    
     String ans="";
    public  String longestString(int n, String[] arr) {
        // code here
        for (int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
        
        Node curr=root;
        longest(curr,new StringBuilder(""));
        
        return ans;
    }
    
    
    public  void longest(Node curr,StringBuilder s){
        if(curr==null){
            return;
        }
        
        for (int i=0;i<26;i++){
            if(curr.children[i]!=null && curr.children[i].eow==true){
                s.append((char)(i+'a'));
                
                if(ans.length()<s.length()){
                    ans=s.toString();
                }
                
                longest(curr.children[i],s);
                s.deleteCharAt(s.length()-1);
            }
            
            
        }
    }
    
    
    public  void insert(String s){
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
}
        
