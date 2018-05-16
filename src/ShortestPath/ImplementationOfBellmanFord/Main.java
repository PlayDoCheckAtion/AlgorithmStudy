package ShortestPath.ImplementationOfBellmanFord;

public class Main {

    // �������ǵ�Bellman-Ford���·���㷨
    public static void main(String[] args) {

        String filename = "src/ShortestPath/ImplementationOfBellmanFord/testG2.txt";
        //String filename = "src/ShortestPath/ImplementationOfBellmanFord/testG_negative_circle.txt";
        int V = 5;

        SparseWeightedGraph<Integer> g = new SparseWeightedGraph<Integer>(V, true);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        System.out.println("Test Bellman-Ford:\n");

        int s = 0;
        BellmanFord<Integer> bellmanFord = new BellmanFord<Integer>(g, s);
        if( bellmanFord.negativeCycle() )
            System.out.println("The graph contain negative cycle!");
        else
            for( int i = 0 ; i < V ; i ++ ){
                if(i == s)
                    continue;

                if(bellmanFord.hasPathTo(i)) {
                    System.out.println("Shortest Path to " + i + " : " + bellmanFord.shortestPathTo(i));
                    bellmanFord.showPath(i);
                }
                else
                    System.out.println("No Path to " + i );

            System.out.println("----------");
        }

    }
}