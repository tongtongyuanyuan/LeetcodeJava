import java.util.Scanner;

public class Fibonacci {
    //iteration
//    public static void main(String args[]) {
//        //int size = 10;
//
//        int previousNumber = 0;
//        int nextNumber = 1;
//        //System.out.println("Fibonacci Series of: " + size);
//        Scanner scanner = new Scanner(System.in);
//        int size = scanner.nextInt();
//        System.out.print("Fibonacci Series of " + size + "numbers: " );
//
//        for(int i = 1; i <= size; ++i){
//            System.out.print(previousNumber + " ");
//
//            int sum = previousNumber + nextNumber;
//            previousNumber = nextNumber;
//            nextNumber = sum;
//        }
//    }
    //recursion
    public static int fibonacciRecursion(int n) {
        if(n==0) return 0;
        if(n == 1 || n == 2) return 1;
        return fibonacciRecursion(n - 2) + fibonacciRecursion(n - 1);
    }
    public static void main(String[] args){
        int size = 10;
//        Scanner scanner = new Scanner(System.in);
//        int size = scanner.nextInt();
        System.out.print("Fibonacci Series of " + size + " numbers: ");
        for(int i = 0; i < size; i++) {
            System.out.print(fibonacciRecursion(i) + " ");
        }
    }
}
