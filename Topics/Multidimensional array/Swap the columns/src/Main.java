import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] array = new int[n][m];

        // - reading the array
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                array[j][i] = scanner.nextInt();
            }
        }

        // - working with the array
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        int temp;

        for (int column = 0; column < n; column++) {
            temp = array[column][i];
            array[column][i] = array[column][j];
            array[column][j] = temp;
        }

        // - printing the array
        for (int o = 0; o < n; o++) {
            for (int p = 0; p < m; p++) {
                System.out.print(array[o][p] + " ");
            }
            System.out.println();
        }
    }
}