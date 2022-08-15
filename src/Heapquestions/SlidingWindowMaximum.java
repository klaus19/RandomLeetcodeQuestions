package Heapquestions;


import java.util.ArrayDeque;
import java.util.Deque;

//[1,3,-1,-3,5,3,6,7]

//You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the
// array to the very right. You can only see the k numbers in the window.
// Each time the sliding window moves right by one position.
//
//Return the max sliding window.

//
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

       int n = nums.length;
       int[]r = new int[n-k+1];
       int ri=0;

       //store index
        Deque<Integer>deque = new ArrayDeque<>();
        for (int i=0;i<nums.length;i++){
            //remove numbers of range k
            if (!deque.isEmpty() && deque.peek() ==i-k){
                deque.poll();
            }

            //Remove smaller numbers from K as the yare usless
            while (!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){   //peekLast() method in Java is used to retrieve or fetch the last element of the deque
                  deque.pollLast();    //pollLast() method in Java is used to retrieve or fetch and remove the last element of the Deque.
            }

            deque.offer(i);
            if (i>=k-1){
                r[ri++] = nums[deque.peek()];
            }
        }
        return  r;
    }
}
