import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args){
        String input = "aab";
        System.out.println(partition(input));
    }
    public static List<List<String>> partition(String s){
        List<String> curList = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        DFS(curList,s,0,res);
        return res;
    }

    public static void DFS(List<String> curList,String s, int l, List<List<String>> res){
        if(l>=s.length() && curList.size()>0) res.add(new ArrayList<>(curList));
        for(int i = l; i<s.length();i++){
            if(isPal(s,l,i)){
                curList.add(s.substring(l,i+1));
                DFS(curList,s,l+1,res);
                curList.remove(curList.size()-1);
            }
        }
    }

    public static boolean isPal(String s, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(s.charAt(l) != s.charAt(r)) return  false;
            l++;
            r--;
        }
        return true;
    }
}
