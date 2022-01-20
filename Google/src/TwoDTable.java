public class TwoDTable {
    //Constructor for a fixed-size table of m rows and n columns
    public TwoDTable(int m, int n) {
        //code here
    }

    //Set the cell at index(x, y) to value
    void set(int x, int y, int value) {

    }

    //Compute the sum of values from index(0, 0) to index(x, y), inclusive
    //Imagine a sub matrix from 0, 0 as origin to index(x,y). This is the sum of that sub-matrix
    int sum(int x, int y) {
        return 0;
    }
}


/*There can be endless stream of Set() and Sum() calls to the table
There is no guarantee on ordering eg:
1) Sum(x, y) can be called before Set(x, y.val) is called
2) Either of them may not be called at all

Example:
1 2 3
4 5 6
7 8 9

This matrix was constructed by such set() calls:
set(0, 0, 1)
set(1, 0, 4)
set(2, 1, 8)
...........

examples of sum() calls and their expected output
sum(0, 0) ==> 1
sum(1, 1) ==> 1 + 2 + 4 + 5 =>12
sum(2, 1) ==> 1 + 2 + 4 + 5 + 7 => 27

Part1 : Implement this interface given that set() is called more often than sum()
Part2 : Implement this interface given that sum() is called more often than set()
Part3: Implement this interface given that sum() and set() are called equally frequently
308. Range Sum Query 2D - Mutable
 */