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
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            minHeap.offer(intervals[i][1]);
            if (minHeap.peek() <= intervals[i][0]) {
                minHeap.poll();
            }
        }
        return minHeap.size();
    }
}
