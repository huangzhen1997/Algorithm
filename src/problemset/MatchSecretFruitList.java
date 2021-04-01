import java.util.*;

public class MatchSecretFruitList {
    public static void main(String[] args){
        List<List<String>> secreteFruitList = new ArrayList<>();
        List<String> first = Arrays.asList("apple","apple");
        List<String> second = Arrays.asList("apple","apple","banana");
        secreteFruitList.add(first);
        secreteFruitList.add(second);
        List<String> users = Arrays.asList("apple","apple","apple","apple","banana");
//        List<String> first = Arrays.asList("apple");
//        secreteFruitList.add(first);
//        List<String> users = Arrays.asList("orange");
        System.out.println(matchSecreteLists(secreteFruitList,users));
    }

    public static boolean matchSecreteLists(List<List<String>> secretFruitList, List<String> customerPurchasedList){

        HashMap<Integer,Integer> lookup = new HashMap<>();
        int counter = 0;
        for(List<String> secret : secretFruitList){

            int left = 0;
            int curIndex = 0;
            int secretSize = secret.size();

            while(left<=customerPurchasedList.size()-1 && curIndex <secretSize){

//                //finished checking
//                if(curIndex+1==secretSize){
//                    if(curIndex==0&&customerPurchasedList.get(left)!=secret.get(curIndex)){
//                        left++;
//                    }
//                    lookup.put(counter,left-secretSize+1);
//                    break;
//                }

                //match case
                if(customerPurchasedList.get(left)==secret.get(curIndex) || secret.get(curIndex)=="anything"){
                    curIndex++;
                    left++;
                }

                else{

                    curIndex=0;
                    if(!secret.get(curIndex).equals("anything") && customerPurchasedList.get(left)!=secret.get(curIndex) ) left++;
                }
            }

            //finished checking
            if(curIndex!=secretSize || curIndex == 0){
                return false;
            }
            else{
                lookup.put(counter,left-secretSize+1);
                counter++;
            }
        }

        int index = Integer.MIN_VALUE;
        for(int key : lookup.keySet()){
            int match_index = lookup.get(key);
            if(match_index<index){
                return false;
            }
            index = match_index;
        }
        return true;
    }
}
