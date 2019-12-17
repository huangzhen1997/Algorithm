import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.*;
import java.util.Map.Entry;


public class RelativeSort {

    public static void main(String[] args){

        int[] arr1= {28,6,22,8,44,17};
        int[] arr2= {22,28,8,6};
        int[] out = relativeSortArray(arr1,arr2);
        String output = outputformat(out);
        System.out.println(output);


    }


    public static int[] relativeSortArray(int[] arr1, int[] arr2) {


        Map<Integer, Integer> map = new LinkedHashMap<>();
        int max = arr1.length;
        for(int i = 0;i < arr1.length; i++ ){
            int ele = arr1[i];
            if (map.containsKey(ele)){
                int temp = map.get(ele);
                temp = temp+1;
                map.put(ele,temp);
            }
            else{
                map.put(ele,1);
            }
        }

        int[] output = new int[max];
        int counter = 0;

        for(int i = 0;i < arr2.length; i++){
            int len = map.get(arr2[i]);
            map.remove(arr2[i]);
            for(int j = 0; j < len;j++){
                output[counter] = arr2[i];
                counter = counter +1;
            }
        }


        System.out.println("----------------");
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }

        ArrayList<Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>() {

            @Override
            public int compare(Entry<Integer,Integer> o1, Entry<Integer,Integer> o2) {
                return ((o1.getKey() - o2.getKey() == 0) ?
                        0: (o1.getKey() - o2.getKey() > 0) ? 1: -1);
            }

        });

        LinkedHashMap<Integer,Integer> map2 = new LinkedHashMap<>();
        for (Map.Entry<Integer,Integer> entry : list) {
            map2.put(entry.getKey(), entry.getValue());
        }


        System.out.println("----------------");
        for(Map.Entry<Integer, Integer> entry:map2.entrySet()){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }

        for (Map.Entry<Integer,Integer> entry : map2.entrySet()) {

            for(int i = 0;i<entry.getValue();i++){
                output[counter]=entry.getKey();
                counter = counter +1;
            }

        }

        return output;
    }

    public static String outputformat(int[] array){
        String output = "[";
        for(int i=0;i<array.length;i++){
            output = output+(Integer.valueOf(array[i]));
            if(i!=array.length-1){
                output = output+",";
            }
            else{
                output=output+"]";
            }
        }
        return output;
    }

}
