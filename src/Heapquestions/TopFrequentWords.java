package Heapquestions;

import java.util.*;

//Given an array of strings words and an integer k, return the k most frequent strings.
//
//Return the answer sorted by the frequency from highest to lowest.
// Sort the words with the same frequency by their lexicographical order.

//Time complexity is O(N * log(K))

public class TopFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String,Integer>map = new HashMap<>();

        for (String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        //Create a Priority Queue and create a custom Comparator class

        PriorityQueue<String>pt = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                int frequency1 = map.get(word1);
                int frequency2 = map.get(word2);

                if (frequency1==frequency2)return word2.compareTo(word1);
                return frequency1-frequency2;
            }
        });

        for (Map.Entry<String,Integer>entry: map.entrySet()){
            pt.add(entry.getKey());      //log K comes into play
            if (pt.size()>k){
                pt.poll();
            }
        }

        List<String>list1 = new ArrayList<>();
        while (!pt.isEmpty()){
            list1.add(pt.poll());
            Collections.reverse(list1);
        }

       return list1;
    }
}
