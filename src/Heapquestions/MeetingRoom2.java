package Heapquestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


//Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
// return the minimum number of conference rooms required.
//
//
public class MeetingRoom2 {

    public int minMeetingRooms(int [][]intervals){

           if (intervals==null ||intervals.length==0){
               return 0;
           }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });

        PriorityQueue<int[]>pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1]=b[1];
            }
        });

        pq.add(intervals[0]);
        for (int i=1;i<intervals.length;i++){
            int []curr = intervals[i];

            int[]prev = pq.poll();
            if (curr[0]<prev[1]){
                pq.add(prev);
                pq.add(curr);

            }else{
                prev[1]=curr[1];
                pq.add(prev);
            }
        }
         return pq.size();
    }
}
