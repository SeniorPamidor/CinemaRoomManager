import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();

        int[][] array = new int[arraySize][arraySize];

        for (int j = 0; j < arraySize; j++) {
            for (int i = 0; i < arraySize; i++) {
                array[j][i] = abs(j-i);
                System.out.print(array[j][i]+" ");
            }
            System.out.println();
        }
    }
}
