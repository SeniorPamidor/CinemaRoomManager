import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int squirrelsAmount = scanner.nextInt();
        int nutsAmount = scanner.nextInt();

        int cut = nutsAmount / squirrelsAmount;
        System.out.println(cut);
    }
}