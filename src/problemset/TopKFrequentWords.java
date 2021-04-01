import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
import java.util.List;

public class TopKFrequentWords {
    public static void main(String[] args){
        String[] input = new String[]{"i","love","leetcode","i","love","coding"};
        int k = 2;

        List<String> output = topKFrequent(input, 2);
        for (String i : output){
            System.out.println(i);
        }

    }

    public static List<String> topKFrequent(String[] words, int k){
        String[] output = new String[k];

        TreeMap<String,Integer> mapping = new TreeMap<>();
        for(String i : words){

            if(mapping.containsKey(i)){
                mapping.put(i,mapping.get(i)+1);
            }
            else{
                mapping.put(i,1);
            }
            //System.out.println(mapping.get(i));
        }

        List<String> sorted = new ArrayList(mapping.keySet());
        Collections.sort(sorted,(w1,w2)-> mapping.get(w1).equals(mapping.get(w2))  ? w1.compareTo(w2) : mapping.get(w2) - mapping.get(w1));


        return sorted.subList(0,k);
    }
}
