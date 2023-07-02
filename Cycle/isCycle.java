import java.util.ArrayList;
import java.util.Stack;
class Edge{
    int src;
    int dest;
    public Edge(int s,int d){
        this.src=s;
        this.dest=d;
    }

 }


public class directedcycle {

    public static void create(ArrayList<Edge> graph[]){
        for (int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
       graph[1].add(new Edge(1,0));

       graph[0].add(new Edge(0,2));

       graph[2].add(new Edge(2,3));

      // graph[3].add(new Edge(3,0));
    }


    public static boolean cycle(ArrayList<Edge> graph[],boolean vis[],int curr,int parent){
        vis[curr]=true;

        for (int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);

            if(!vis[e.dest]){
                if(cycle(graph,vis,e.dest,curr)){
                    return true;
                }
            }

            else if(vis[e.dest] && parent!=e.dest){
                return true;
            }
        }

        return false;
    }

    public static boolean isCycle(ArrayList<Edge> graph[],boolean vis[],boolean rec[],int curr){
        vis[curr]=true;
        rec[curr]=true;

        for (int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(rec[e.dest]){
                return true;
            }

            else if(!vis[e.dest]){
               if( isCycle(graph, vis, rec, e.dest)){
                    return true;
               }
            }
        }

        rec[curr]=false;
        return false;
    }
  
    public static void main(String args[]){
        int v=4;
        ArrayList<Edge> graph[]=new ArrayList[v];
        create(graph);
        boolean vis[]=new boolean[v];
        boolean rec[]=new boolean[v];
        for (int i=0;i<v;i++){
            if(!vis[i]){
               boolean ans=isCycle(graph,vis,rec,i);
               if(ans){
                System.out.println(true);
                break;
               }
            }
        }


        
    } 
}
