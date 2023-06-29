//{ Driver Code Starts
import java.util.*;

class suffix
{
     int index;  
    int rank[] = new int[2];
}

class UniqueSubStr
{
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            GfG g = new GfG();
            System.out.println(g.countDistinctSubstring(st));
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
/*You are required to complete this method */
class GfG
{
    Node root;
    public GfG(){
        root=new Node();
    }
    
   public int countDistinctSubstring(String st)
   {
       //your code here
       for (int i=0;i<st.length();i++){
           insert(st.substring(i));
       }
      Node curr=root; 
      int m=count( curr);
      return m;

   }
   
   
   public int count(Node curr){
       if(curr==null){
           return 0;
       }
       
       int c=0;
       for (int i=0;i<26;i++){
           if(curr.children[i]!=null){
               c+=count(curr.children[i]);
           }
       }
       
       return c+1;
   }
   
   public void insert(String s){
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