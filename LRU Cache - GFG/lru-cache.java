//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

  public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class LRUCache

{
     Node head=new Node(0,0);
     Node tail=new Node(0,0);
    
     Map<Integer,Node> mp=new HashMap<>();
     int capacity;
    
    
    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap)
    {
        //code here
        this.capacity=cap;
        head.next=tail;
        tail.prev=head;
    }

    //Function to return value corresponding to the key.
    public  int get(int key)
    {
        // your code here
        if(mp.containsKey(key)){
            Node node=mp.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        
        else{
            return -1;
        }
        
        
    }

    //Function for storing key-value pair.
    public  void set(int key, int value)
    {
        // your code here
        if(mp.containsKey(key)){
            remove(mp.get(key));
        }
        
        if(mp.size()==capacity){
            remove(tail.prev);
        }
        
        insert(new Node(key,value));
    }
    
    public  void remove(Node node){
        mp.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    
    public  void insert(Node node){
        mp.put(node.key,node);
        Node headnext=head.next;
        node.prev=head;
        head.next=node;
        headnext.prev=node;
        node.next=headnext;
        
    }
    
     class Node{
        Node next,prev;
        int val,key;
        public Node(int k,int v){
            this.key=k;
            this.val=v;
        
        }
    }
}
