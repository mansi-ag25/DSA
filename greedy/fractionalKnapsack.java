import java.util.*;

public class fractionalKnapsack {
    public static void main(String args[]){
        int weight[]={10,20};
        int values[]={60,100};

        int W=50;

        double ratio[][]=new double[weight.length][2];
        for (int i=0;i<weight.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=values[i]/(double)weight[i];
        }

        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
        int capacity=W;
        double ans=0;
        for (int i=weight.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if(weight[idx]<=capacity){
                ans+=values[idx];
                capacity-=weight[idx];

            }
            else{
                ans+=ratio[i][1]*capacity;
            }
        }

        System.out.println(ans);
    }
}
