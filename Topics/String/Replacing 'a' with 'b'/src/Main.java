import java.util.Scanner;

class Main {

    public static void printNumberOfArguments(String... numbers) {
        System.out.println(numbers.length);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printNumberOfArguments("Hello", "Goodbye");
    }
}