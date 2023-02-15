package chap02;

public class MathTable {
    public static void main(String[] args) {
        int arr[][] = new int[10][10];
        for (int[] row : arr) {
            for (int value : row) {
                value = 0;
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("(" + i + "," + j + ")");
            }
            System.out.println();
        }
    }
}
