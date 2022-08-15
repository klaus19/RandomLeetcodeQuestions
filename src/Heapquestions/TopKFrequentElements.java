package Heapquestions;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

            if(nums.length==0)
            {
                return new int[k];
            }
            HashMap<Integer,Integer> map= new HashMap<>();
            for(int numb : nums)
            {
                map.put(numb,map.getOrDefault(numb,0)+1);
            }
            PriorityQueue<Integer> Que = new PriorityQueue<>((a, b)->map.get(a)-map.get(b));
            for(int n: map.keySet())
            {
                Que.add(n);
                if(Que.size()>k)
                {
                    Que.poll();
                }
            }
            int[] ans = new int[k];
            int i=0;
            while(!Que.isEmpty())
            {
                int b=Que.poll();
                ans[i++]=b;
            }
            return ans;
        }

}
