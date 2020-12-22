import java.util.*;

public class ShoppingPattern {
    public static int shoppingPatters(int products_nodes, int[] products_from, int[] products_to) {
        int len = products_from.length;
        int n = products_nodes;
        //build graph
        Map < Integer, Set < Integer > > graphS = new HashMap <>();
        Map < Integer, List < Integer > > graphL = new HashMap <>();
        for (int i = 1; i <= n; i++) {
            graphS.put(i, new HashSet <>());
            graphL.put(i, new ArrayList <>());
        }


        for (int i = 0; i < len; i++) {
            graphS.get(products_from[i]).add(products_to[i]);
            graphS.get(products_to[i]).add(products_from[i]);
            graphL.get(products_from[i]).add(products_to[i]);
            graphL.get(products_to[i]).add(products_from[i]);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            List < Integer > list = graphL.get(i);
            int l = list.size();
            //try all pairs
            for (int j = 0; j < l - 1; ++j) {
                for (int k = j + 1; k < l; ++k) {
                    if (!graphS.get(list.get(j)).contains(list.get(k))) {
                        //not a trio
                        continue;
                    }
                    //find a trio, update res
                    res = Math.min(res, list.size() + graphL.get(list.get(j)).size() + graphL.get(list.get(k)).size() - 6);
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
            //int products_nodes = 6;
            int products_nodes = 5;
            //int products_edges = 5;
          //int[] products_from = {1,2,2,3,4,5};
           //int[] products_to = {2,4,5,5,5,6};
            int[] products_from = {1,1,2,2,3,4};
            int[] products_to = {2,3,3,4,4,5,5};
            int res = ShoppingPattern.shoppingPatters(products_nodes, products_from, products_to);
            System.out.println(res);

    }
}