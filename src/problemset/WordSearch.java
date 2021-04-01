//Leetcode #79
package problemset;
public class WordSearch {
    public static void main(String[] args){
        char[][] board = new char[3][];
        board[0] = new char[]{'A','B','C','D'};
        board[1] = new char[]{'S','F','C','S'};
        board[2] = new char[]{'A','D','E','E'};

        System.out.println(exist(board,"ABCCED"));
    }

    public static boolean exist(char[][] board, String word){
//        boolean[][] visitedTable = new boolean[][];
//        for(int i = 0;i < board[0].length; i++){
//            for(int j=0 ; j< board.length; j++){
//
//            }
//        }
          return true;
    }

    public static boolean searchChar(char c, String word, boolean[][] visitedTable){
        return true;
    }
}
