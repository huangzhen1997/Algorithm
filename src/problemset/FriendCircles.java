import java.util.Arrays;

public class FriendCircles {
    public static void main(String[] args){
        int[][] input= {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(input));
    }

    public static int findCircleNum(int[][] M){

        int count = 0;
        int[] visited = new int[M.length];
        Arrays.fill(visited,0);

        for(int i = 0; i< M.length;i++){
            if(visited[i]==0){
                dfs(i,visited,M);
                count++;
            }
        }

        return count;
    }

    public static void dfs(int index,int[] visited,int[][] matrix){
        for(int i = 0; i < matrix[index].length; i++){
            if(matrix[index][i]==1 && visited[i]==0){
                visited[index]=1;
                dfs(i,visited,matrix);
            }
        }
    }
}
