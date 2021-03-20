package programs;

import java.util.Scanner;

public class Arrays {
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
    public static void print2DArray(int[][] arr, int rows){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {

        //keyboard input
        int[] A = new int[10];
        System.out.println("Zadaj cisla:");
        for (int i = 0; i < A.length; i++) {
            Scanner number = new Scanner(System.in);
            A[i] = number.nextInt();
        }
        printArray(A);

        //init
        int[] B = new int[]{5,4,3,2,1};
        printArray(B);

        //sort
        for (int i=0;i<A.length;i++){
            for(int j=0;j<A.length-1;j++){
                if (A[j]>A[j+1]){
                    int tmp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = tmp;
                }
            }
        }
        printArray(A);

        //2D array
        int[][] C = new int[][]{{1,1,1},{2,2,2},{3,3,3},{4,4,4}};
        print2DArray(C,4);

    }
}
