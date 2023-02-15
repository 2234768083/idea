package chap01;

public class TestDoubleArray {
    public static void main(String[] args) {
        int[][] arr = new int[10][10];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
} 