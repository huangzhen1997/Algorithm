import java.util.*;

public class CourseScheduleII {

    public static  void main(String[] args){
        int[][] prerequisites = new int[][]{{1,0},{2,1}};
        int numCourses = 3;
        int[] output = findOrder(numCourses,prerequisites);
        for(int i : output){
            System.out.println(i);
        }
    }

    public static class Node{
        int inDegree = 0;
        List<Integer> outEdges = new LinkedList<>();
    }

//    public static int[] findOrder(int numCourses, int[][] prerequisites) {
//        HashMap<Integer,Node> graph = new HashMap<>();
//        for(int[] pair : prerequisites){
//            Node pre = getCreateNode(graph,pair[1]);
//            Node nex = getCreateNode(graph,pair[0]);
//            pre.outEdges.add(pair[0]);
//            nex.inDegree++;
//        }
//        Queue<Integer> S = new LinkedList<>();//nodes with inDegree == 0;
//        for(Map.Entry<Integer,Node> entry : graph.entrySet()){
//            if(entry.getValue().inDegree==0){
//                S.offer(entry.getKey());
//            }
//        }
//
//        int totalEdges = prerequisites.length;
//        int edgeCount = 0;
//        int[] output = new int[numCourses];
//        int countering = 0;
//        while(S.size()>0){
//            int n = S.remove();
//            output[countering++] = n;
//            for(int neighbor : graph.get(n).outEdges){
//                Node nei = graph.get(neighbor);
//                nei.inDegree--;
//                edgeCount++;
//                if(nei.inDegree==0){
//                    S.offer(neighbor);
//                }
//            }
//        }
//        if(totalEdges==edgeCount){
//            if(edgeCount<numCourses){
//                int counter = graph.size();
//                for(int i =0 ; i < numCourses; i++){
//                    if(!graph.containsKey(i)){
//                        output[counter++] = i;
//                    }
//                }
//            }
//            return output;
//        }
//        else{
//            return new int[]{};
//        }
//    }

    static  int counter = 0;
    public static int[] findOrder(int numCourses, int[][] prerequisites){

        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge : prerequisites){
            int from = edge[0];
            int to = edge[1];
            List<Integer> list = graph.getOrDefault(from,new LinkedList<Integer>());
            list.add(to);
            graph.put(from,list);
        }

        int[] output = new int[numCourses];
        boolean[] explored = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];

        for(Map.Entry<Integer,List<Integer>> entry : graph.entrySet()){
            if(!isAcylic(graph,entry.getKey(),explored,visiting,output)){
                return new int[]{};
            }
        }

        for(int i = 0; i< numCourses; i++){
            if(!explored[i]){
                output[counter++]=i;
            }
        }

        return output;
    }

    public static  boolean isAcylic(HashMap<Integer,List<Integer>> graph,int node,boolean[] explored,boolean[] visiting, int[] output){

        if(explored[node]){
            return true;
        }

        if(visiting[node]){
            return false;
        }

        if(!graph.containsKey(node)){
            output[counter++] = node;
            explored[node] = true;
            return true;
        }

        else{
            visiting[node] = true;
            for(Integer neighbor : graph.get(node)){
                if(!isAcylic(graph,neighbor, explored,visiting,output)){
                    return false;
                }
                visiting[neighbor] = false;
            }
            visiting[node] = false;
            explored[node] = true;
            output[counter++] = node;
            return true;
        }
    }

    public static Node getCreateNode(HashMap<Integer,Node> graph, int node){
        if(graph.containsKey(node)){
            return graph.get(node);
        }
        else{
            Node n = new Node();
            graph.put(node,n);
            return n;
        }
    }
}
