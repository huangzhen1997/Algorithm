//LeetCode #207
//Course Schedule, using DFS to check whether there is a cycle

import java.util.ArrayList;

public class CourseSchedule {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean[] explored;

    public static void main(String[] args){
        int numCourse =4;
        int[][] prerequisites = {{0,1},{1,2},{2,3},{0,2}};
        boolean output = canFinish(numCourse,prerequisites);
        System.out.print(output);
    }

    public static boolean canFinish(int numCourse,int[][] prerequisites){

        graph = new ArrayList[numCourse];
        visited = new boolean[numCourse];
        explored = new boolean[numCourse];

        for(int i = 0; i<numCourse; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<prerequisites.length; i++){ //adding all direct edge into graph

            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourse; i++){
            if(isacylic(i)){
                    return false;
            }
        }

        return true;
    }

    public static boolean isacylic(int node){

        visited[node] = true;

        for(Integer neighbor : graph[node]){
            if(!visited[neighbor]){
                if(isacylic(neighbor)){
                    return true;
                }
            }
            else if(!explored[neighbor]){
                return true;
            }
        }

        explored[node] = true;
        return false;
    }
}
