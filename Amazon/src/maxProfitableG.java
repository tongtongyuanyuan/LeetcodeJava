public class maxProfitableG {
        public static int findMaxProfitableGroups(int[] stockPrices) {
            int n = stockPrices.length;
            int count = 0;

            if (n <= 2) {
                return count;
            }

            for (int i = 1; i < n - 1; i++) {
                if (stockPrices[i] > stockPrices[i - 1] && stockPrices[i] > stockPrices[i + 1]) {
                    count++;
                }
            }

            return count;
        }

        public static void main(String[] args) {
            int[] stockPrices = {2, 3, 2};
            int maxProfitableGroups = findMaxProfitableGroups(stockPrices);
            System.out.println(maxProfitableGroups);
        }
    }

