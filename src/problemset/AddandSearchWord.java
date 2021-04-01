import java.util.HashMap;
import java.util.Map;

public class AddandSearchWord {
    public static void main(String[] args) {
        String outpu = "a";
        System.out.println(outpu.substring(1));
    }
}

class TrieNode{
    Map<Character,TrieNode> children = new HashMap();
    boolean word = false;
    public TrieNode(){}
}

class WordDictionary {

    /** Initialize your data structure here. */
    TrieNode root;

    public WordDictionary() {
        TrieNode root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){

            if(!node.children.containsKey(ch)){
                node.children.put(ch,new TrieNode());
            }
            else{
                node = node.children.get(ch);
            }
        }
        node.word = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchInWord(word,root);
    }

    public static boolean searchInWord(String word,TrieNode node){
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i)=='.'){
                for(char c : node.children.keySet()){
                    if(searchInWord(word.substring(i,word.length()+1),node.children.get(c))){
                        return true;
                    }
                }
            }
            else{
                if(node.children.containsKey(word.charAt(i))){
                    node = node.children.get(word.charAt(i));
                }
                else{
                    return false;
                }
            }
        }
        return node.word;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
