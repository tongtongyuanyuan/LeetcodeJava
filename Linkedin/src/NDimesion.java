import java.util.List;

/* You are given an N-Dimensional list with 2 methods:
i) getDim -> returns the dimensions .e.g [5,4,3].
ii) getElement([i,j,k]) -> return list[i][j][k] . You have to implement a method to sum all elements in the list.
Ex:- If we have 3D list of dimensions [2,2,3]
        # We will have a total of 2*2*3 = 12 elements
        # To get the correspoding indices for these elements
        # 0 0 0
        # 0 0 1
        # 0 0 2
        # 0 1 0
        # ...
        # ...
        # 1 1 1
        # 1 1 2
        # The strategy is to increment the last index value and once
        # we hit the dimension length of that particular index we mark it as zero
        # and increment the prior index value and if reaches end as well, we continue
        # to increment its prev index; the moment we reach a index which doesn't overflow
        032 >> 033 > 0 40 >> 100

        */
// T = O(N  * M) S= O(M) Iterative
    public class NDimesion {


        public List<Integer> getDim(List<Integer> dimesion) {
            for(int idx = 0; idx < dimesion.size(); idx++) {
                dimesion.get(idx)--;
            }
            List<Integer> res = dimesion;
            long retSum = 0;
            //update the index array
            while(true) {
                int idx = 0;
                while(true) {
                    if(idx >= dimesion.size()) {
                        return retSum;
                    }
                    if(res.get(idx) == 0) {
                        res.get(idx) = dimesion.get(idx);

                    }
                }

            }
        }
        public List<Integer> getElements() {


        }

}
