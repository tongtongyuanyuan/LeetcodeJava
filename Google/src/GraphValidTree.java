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

/*Union Find 解法：
 //判断输入的若干条边是否能构造出一棵树结构
         boolean validTree(int n, int[][] edges) {
         // 初始化 0...n-1 共 n 个节点
         UF uf = new UF(n);
         // 遍历所有边，将组成边的两个节点进行连接
         for (int[] edge : edges) {
         int u = edge[0];
         int v = edge[1];
         // 若两个节点已经在同一连通分量中，会产生环
         if (uf.connected(u, v)) {
         return false;
         }
         // 这条边不会产生环，可以是树的一部分
         uf.union(u, v);
         }
         // 要保证最后只形成了一棵树，即只有一个连通分量
         return uf.count() == 1;
         }

class UF {
    // 连通分量个数
    private int count;
    // 存储一棵树
    private int[] parent;
    // 记录树的「重量」
    private int[] size;

    // n 为图中节点的个数
    public UF(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // 将节点 p 和节点 q 连通
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;

        // 小树接到大树下面，较平衡
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        // 两个连通分量合并成一个连通分量
        count--;
    }

    // 判断节点 p 和节点 q 是否连通
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    // 返回节点 x 的连通分量根节点
    private int find(int x) {
        while (parent[x] != x) {
            // 进行路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    // 返回图中的连通分量个数
    public int count() {
        return count;
    }
}*/
