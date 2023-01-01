import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" "); // array created

        boolean isAlphabetical = true;
        for (int i = 0; i < array.length-1; i++) {
            int result = array[i].compareTo(array[i+1]);
            if (result > 0) {
                isAlphabetical = false;
                break;
            }
        }
        String output = isAlphabetical == true ? "true" : "false";
        System.out.println(output);

    }
}