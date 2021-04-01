import java.util.*;

public class Solution14 {
    public static void main(String[] args){
        HashMap<String, List<Integer>> items = new HashMap<>();
        items.put("item1", Arrays.asList(10,15));
        items.put("item2",Arrays.asList(3,4));
        items.put("item3",Arrays.asList(17,8));
        int numOfitems = 3;
        int sortParameter = 1;
        int sortOrder = 0;
        int itemsPerPage = 2;
        int pageNum = 1;
        System.out.println(displayItems(numOfitems,items,sortParameter,sortOrder,itemsPerPage, pageNum));
    }

    public static List<String> displayItems(int numOfitems,HashMap<String,List<Integer>> items, int sortParameter, int sortOrder, int itemsPerpage, int pageNum){
        Comparator<Map.Entry<String,Integer>> cmp = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(sortOrder==0){
                    return o1.getValue()-o2.getValue(); //least is first
                }
                else{
                    return o2.getValue()-o1.getValue(); // bigger the value, later it will be
                }
            }
        };


        HashMap<String,Integer> newItems = new HashMap<>();
        for(Map.Entry<String,List<Integer>> item : items.entrySet()){
            String name = item.getKey();
            int val = item.getValue().get(sortParameter-1); // be careful with the sortParamenter, 1 means first index
            newItems.put(name,val);
        }

        TreeMap<Map.Entry<String,Integer>,Integer> tm = new TreeMap<>(cmp);
        for(Map.Entry<String,Integer> item : newItems.entrySet()){
            tm.put(item,0);
        }

        List<List<String>> webpage = new LinkedList<>();

        for(int i = 0;i<=pageNum;i++){
            List<String> curPage =new LinkedList<>();
            for(int j =0; j< itemsPerpage; j++ ){
                if(tm.size()>0){
                    String name  =tm.firstKey().getKey();  // first key to get
                    curPage.add(name);
                    tm.remove(tm.firstKey());
                }
            }
            webpage.add(curPage);
        }

        return webpage.get(pageNum);
    }
}
