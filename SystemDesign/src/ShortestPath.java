/* Unwighted graph---Dijkstra's Algorithm
https://www.geeksforgeeks.org/shortest-path-unweighted-graph/

BFS: store the processor of a given vertex while doing the bfs
dist[0,1,....v-1] stores the distance of vertex i from the source vertex and array pred[0,1,....v-1]，
pred[i] represents the immediate precessor of the vertex i in the bfs starting from the source

T = O(V+E), V is the size of array P,
 */

public class ShortestPath {

    //function to form edge bewteen two vertices: source->dest
    private static void addEdge(ArrayList<ArrayList<Integer>>adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

    //function to print the shortest distance and path between source vertex and destination vertex
    private static void printShortestPath(ArrayList<ArrayList<Integer>> adj, int s, int dest, int v) {
        int pred[] = new int[v];int dist[] = new int[v];

        
        if(BFS(adj, s, dest, v, pred, dist) == false) {
            System.out.println("Given source and destination" + "are not connected");
            return;
        }

        //LinkedList to store path
        LinkedList<Integer> path = new LinkedList<Integer>();
        int crawl = dest;
        path.add(crawl);
        while(pred[craw] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }

        //print the distance
        System.out.println("Shortest path length is:" + dist[dest]);

        //print path
        System.out.println("Path is :");
        for(int i = path.size() - 1; i >= 0; --i) {
            System.out.print(path.get(i) + " ");
        }
    }

    /*modified version of BFS that stores predecessor of each vertex in array pred and its distance from soucre
    in array dist
    */

    private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int src, int dest, int v, int pred[], int dist[]){
        LinkedList<Integer> queue = new LinkedList<Integer>();

        //boolean array visited[] which stores the information whether ith vertex is reached at leaset onece in the BFS
        boolean[] visited = new boolean[v];

        //initial all vertices are unvisited
        //so v[i] for all i is false, and so no path is yet constructed, dist[i] for all i set to infinity
        for(int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        //now source is first to be visited and distance from source to itself should be 0
        visited[src] = true;
        dist[src] = 0;
        queue.add(src);

        //bfs
        while(!queue.isEmpty()) {
            int u = queue.remove();
            for(int i = 0; i < adj.get(u).size(); i++) {
                if(visited[adj.get(u).get(i)] == false) {
                    visited[adj.get(u).get(i)] = dist[u] + 1;
                    pred[adj.get(u).get(j)] = u;
                    queue.add(adj.get(u).get(i));

                    //stopping condition when we find our destination
                    if(adj.get(u).get(i) == dest)
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int v = 8;
        ArrayList<ArrayList<Integet>> adj =
                new ArrayList<ArrayList<Integer>>(v);
        for(int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // Creating graph given in the above diagram.
        // add_edge function takes adjacency list, source
        // and destination vertex as argument and forms
        // an edge between them.
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 3, 4);
        addEdge(adj, 3, 7);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 4, 7);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 7);
        int source = 0, dest = 7;
        printShortestDistance(adj, source, dest, v);
        }
    }
}
