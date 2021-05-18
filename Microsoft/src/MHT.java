import java.util.*;

class MHT {
        public  List<Integer> findMinHeightTrees(int n, int[][] edges) {
            //base cases
            if(n == 1) return Collections.singletonList(0);


            //Build the graph with adjaceny list
            ArrayList<Set<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < n; i++) adj.add(new HashSet<>());

            for(int[] e : edges) {
                adj.get(e[0]).add(e[1]);
                adj.get(e[1]).add(e[0]);
            }


            //Initilaize the first layer of leaves
            List<Integer> leaves = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if(adj.get(i).size() == 1) {
                    leaves.add(i);
                }
            }
            //Trime the leaves until reaching to the center
            int remainNodes = n;
            while(remainNodes > 2) {
                remainNodes -= leaves.size();
                List<Integer> newLeaves = new ArrayList<>();
                //remove the current leaves along with the edges
                for(Integer leaf : leaves) {
                    Integer neighbor = adj.get(leaf).iterator().next();
                    //remove the edge along with the leaf node
                    adj.get(neighbor).remove(leaf);
                    if(adj.get(neighbor).size() == 1) {
                        newLeaves.add(neighbor);
                    }
                }
                leaves = newLeaves;
            }
            return leaves;
        }

        public static void main(String[] args) {
            int n = 6;
           // int n = 4;
            //int[][] edges = {{1,0}, {1,2}, {1,3}};
            int[][] edges = new int[][] {{3,0}, {3,1}, {3,2}, {3,4}, {5,4}};
            List<Integer> res = new ArrayList<>();
            MHT myMHT = new MHT();
            res = myMHT.findMinHeightTrees(n, edges);
            System.out.print("[");
            for(int i : res) {
                System.out.print(i + ",");
            }
            System.out.print("]");
        }
    }


