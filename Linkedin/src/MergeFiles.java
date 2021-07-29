import java.util.TreeMap;

public class MergeFiles {

    TreeMap<Integer, Integer> intervals = new TreeMap<>();

    /**
     * Adds the new interval to the list of intervals and merges the new list if possible
     */
    public void addRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);
        if(start != null && intervals.get(start) >= left){
            left = start;
        }
        if(end != null && intervals.get(end) > right){ //如果是overlap的话就找到最大的right
            right = intervals.get(end);
        }
        intervals.put(left, right);

        //subMap
        //0000
        //floorkey
        //https://www.geeksforgeeks.org/treemap-floorkey-in-java-with-examples/
        intervals.subMap(left, false, right, true).clear();

        System.out.println(intervals);
    }

    /**
     * Computes the sum of the difference between the each disjoint interval in the lnterval list
     */
    int getTotalIntervalCoverage(){
        int size = 0;
        for(int key : intervals.keySet()){
            size+= intervals.get(key) - key;
        }

        return size;
    }

    public static void main(String[] args) {
        MergeFiles task = new MergeFiles();

        task.addRange(3,6);
        System.out.println(task.getTotalIntervalCoverage()); //3

        task.addRange(8,9);
        System.out.println(task.getTotalIntervalCoverage()); //4


        task.addRange(1,5);
        System.out.println(task.getTotalIntervalCoverage()); //6

    }

}