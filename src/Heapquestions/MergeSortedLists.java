package Heapquestions;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        // a min heap
        PriorityQueue<ListNode> minHeap= new PriorityQueue<>((a,b)-> a.val-b.val);

        int n= lists.length;

        // insert the first value of each list
        for( int i=0; i<n; i++){

            if( lists[i]!=null)
                minHeap.add( lists[i]);
        }

        // dummy node
        ListNode ans= new ListNode(0);
        // a pointer pointing to the head of the dummy node, we will use it later, to return the head of our new node
        ListNode ans_ret= ans;

        while( minHeap.isEmpty()==false){

            // get the smallest element
            ListNode t= minHeap.poll();

            // add the smallest element to our dummy node's next
            ans.next=t;

            // update the dummy pointer to its next
            ans = ans.next;

            // add the next node of the smallest node that we just popped provided it is not null
            if( t.next!=null)
                minHeap.add(t.next);

        }

        //return the next of the dummy node we created earlier
        return ans_ret.next;



    }
}
