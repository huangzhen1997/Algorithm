import java.util.ArrayList;
import java.util.List;

public class CriticalConnection {
    public static void main(String[] args){
        int n = 4;
        List<List<Integer>> edges = new ArrayList<>();
        List<Integer> edge = new ArrayList<>();
        edge.add(0);
        edge.add(1);
        edges.add(edge);
        edge = new ArrayList<>();
        edge.add(1);
        edge.add(2);
        edges.add(edge);
        edge = new ArrayList<>();
        edge.add(2);
        edge.add(0);
        edges.add(edge);
        edge = new ArrayList<>();
        edge.add(1);
        edge.add(3);
        edges.add(edge);

        List<List<Integer>> output = criticalConnections(n,edges);
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections){

        List<List<Integer>> output = new ArrayList<>();


        return output;
    }
}
