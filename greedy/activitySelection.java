import java.util.*;

public class ActivitySelection {
    public static void main(String args[]){
        int start[]={1,3,2,5};
        int end[]={2,4,3,6};

        int activities[][]=new int[start.length][3];

        for (int i=0;i<start.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }

        Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));

        int count=1;
        int last=activities[0][2];

        for (int i=1;i<start.length;i++){
            while(activities[i][1]>=last){
                count++;
                last=activities[i][2];
            }
        }

        System.out.println(count);
    }
}
