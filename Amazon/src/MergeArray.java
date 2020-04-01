
import java.util.Arrays;

public class MergeArray {

    public static Integer[] sortArrays(Integer[] flights, Integer[] flights2) {
        int n = flights.length;
        int m = flights2.length;
        Integer[] res = new Integer[m + n];
        bubblesort(flights);
        bubblesort(flights2);
        //merge two sorted arrays into res[]
        int i = 0, j = 0;
        int k = 0;
        while (i < n && j < m) {
            if(flights[i] < flights2[j]) {
                res[k] = flights[i];
                i++;
                k++;
            } else {
                res[k] = flights2[j];
                j++;
                k++;
            }
        }
        //merge remaning
        while (i < n) {
            res[k] = flights[i];
            i++;
            k++;
        }
        while (j < m) {
            res[k] = flights2[j];
            j++;
            k++;
        }
        return res;
    }

    public static void bubblesort(Integer arr[]) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    //swap arr[j] and arr[j+1]
                    int temp = arr[i];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Integer[] flights = {0, 50, 12, 8, 7, 35};
        Integer[] flights2 = {20, 12, 4, 8, 7, 40};
        int n = flights.length;
        int m = flights2.length;
        Integer[] sortedArray = sortArrays(flights, flights2);
        Integer[] res = new Integer[m + n];
        System.out.print("sorted and merge array :");
        for(int i = 0; i < n + m;i++){
            System.out.print(" " + res[i]);
        }
    }
}