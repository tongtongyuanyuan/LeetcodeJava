import java.util.*;

public class GraphValidTree {
    public static boolean validTree(int n, int[][] edges) {
        if (n == 0) return false;
        if (edges.length != n - 1) {
            return false;
        }

        //key: node, value: set<Integer>里面存所有的neighbor
        Map < Integer, Set < Integer > > graph = initializeGraph(n, edges);

        Queue < Integer > queue = new LinkedList <>();
        Set < Integer > hash = new HashSet <>();

        queue.offer(0);
        hash.add(0);


        //BFS
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer neigh : graph.get(node)) {
                if (hash.contains(neigh)) {
                    continue; //访问过
                }
                hash.add(neigh); //没有访问过
                queue.offer(neigh);
            }
        }
        return (hash.size() == n);
    }

    private static Map < Integer, Set < Integer > > initializeGraph(int n, int[][] edges) {
        Map < Integer, Set < Integer > > graph = new HashMap <>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet < Integer >());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v); //graph.get(u)对应一个set，add(v)是一个set
            graph.get(v).add(u);
        }
        return graph;
    }

    public static void main(String[] args) {
            int n = 5;
            int[][]edges = new int[][] {{0,1},{0,2},{0,3}, {1,4}};
            System.out.println(validTree(n, edges));
            int[][]edges1 = new int[][]{{0,1}, {1,2}, {2,3}, {1,3},{1,4}};
            System.out.println(validTree(n, edges1));
    }
}
