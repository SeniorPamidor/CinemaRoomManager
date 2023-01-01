import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String text = scanner.nextLine();
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        System.out.println(text.substring(num1,num2+1));
    }
}