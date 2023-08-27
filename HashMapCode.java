import java.util.*;
public class HashMapCode {
    static class HashMap<K,V>{
        class Node{
            K key;
            V value;
            public Node(K key,V val){
                this.key=key;
                this.value=val;
            }
        }

        int N;
        int n;
        LinkedList<Node> buckets[];

        public HashMap(){
            this.N=4;
            buckets=new LinkedList[4];
            for (int i=0;i<4;i++){
                this.buckets[i]=new LinkedList<>();
            }
        }

        public int hashfunction(K key){
            int bi=key.hashCode();
            return Math.abs(bi)%N;
        }

        public int searchLL(K key,int bi){
            int size=buckets[bi].size();
            for (int i=0;i<size;i++){
                if(buckets[bi].get(i).key==key){
                    return i;
                }
            }

            return -1;
        }

        public void put(K key,V value){
            int bi=hashfunction(key);
            int idx=searchLL(key,bi);

            if(idx==-1){
                buckets[bi].add(new Node(key,value));
                n++;
            }
            else{
                Node node=buckets[bi].get(idx);
                node.value=value;
            }
        }

        public V get(K key){
             int bi=hashfunction(key);
            int idx=searchLL(key,bi);

            if(idx==-1){
               return null;
            }
            else{
                Node node=buckets[bi].get(idx);
                return node.value;
            }
        }

        public V remove(K key){
             int bi=hashfunction(key);
            int idx=searchLL(key,bi);

            if(idx==-1){
               
               return null;
            }
            else{
                Node node=buckets[bi].remove(idx);
                n--;
                return node.value;
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String,Integer> mp=new HashMap<>();
        mp.put("mansi",21);
        mp.put("ankita",16);
        mp.put("ayush",11);

        System.out.println(mp.get("ankita"));
        System.out.println(mp.remove("mansi"));
        System.out.println(mp.remove("renu"));
    }
}
