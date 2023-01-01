package cinema;
import java.util.Scanner;

public class Cinema {
    static Scanner scanner = new Scanner(System.in);
    static int rows;
    static int columns;
    static int rowCount = 1;
    static int columnCount = 1;
    static int totalSeats;
    static int currentIncome = 0;
    static int potentialIncome;
    static int purchasedTickets = 0;
    static float percentageTickets;
    static int price = 10;
    static boolean differentHalves = false;

    static boolean isRunning = true;
    static char[][] cinemaRoom;

    public static void createRoom(int rows, int columns) {
        totalSeats = rows * columns;
        if (totalSeats <= 60) {
            price = 10;
        } else {
            differentHalves = true;
        }

        // - Filling the Cinema Array
        cinemaRoom = new char[rows][columns];

        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < columns; i++) {
                cinemaRoom[j][i] = 'S';
            }
        }
    }
    public static void showRoom(int rows, int columns, char[][] cinemaRoom) {
        columnCount = 1;
        System.out.println("Cinema:");
        System.out.print("  ");
        while (columnCount != columns+1) {
            System.out.print(columnCount + " ");
            columnCount++;
        }
        System.out.println();  // end of column display

        rowCount = 1;

        for (int j = 0; j < rows; j++) {  // Displaying rows
            System.out.print(rowCount + " ");
            rowCount++;
            for (int i = 0; i < columns; i++) {
                System.out.print(cinemaRoom[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void buyTicket(char[][] cinemaRoom) {
        price = 10;
        boolean buying = true;
        while (buying) {
            System.out.println("Enter a row number:");
            int userRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int userColumn = scanner.nextInt();

            if (userRow > rows || userRow < 0 || userColumn > columns || userColumn < 0) {
                System.out.println("Wrong input!");
            } else if (cinemaRoom[userRow-1][userColumn-1] == 'B') {
                    System.out.println("That ticket has already been purchased!");
                } else {
                    if (differentHalves) {
                        int firstHalf = rows / 2;
                        if (userRow > firstHalf) {
                            price = 8;
                        }
                    }

                    System.out.println();
                    System.out.print("Ticket price: ");
                    System.out.println("$" + price);
                    currentIncome += price;
                    purchasedTickets += 1;
                    System.out.println();

                    cinemaRoom[userRow-1][userColumn-1] = 'B';
                    buying = false;
                }
            }
        }

    public static void showStatistics() {
        //purchased tickets aka B
        /*for (char[] e: cinemaRoom) {
            for (char elem: e) {
                if (elem == 'B') {
                    purchasedTickets += 1;
                }
            }
        }*/
        System.out.println("Number of purchased tickets: " + purchasedTickets);

        // tickets percentage
        percentageTickets = (float) purchasedTickets / (float) totalSeats * 100;
        System.out.printf("Percentage: %.2f%%", percentageTickets);
        System.out.println();
        // Income
        System.out.println("Current income: $" + currentIncome);

        // Potential Income
        if (differentHalves) {
            potentialIncome = totalSeats / 2 * 8 + totalSeats / 2 * 10;
        } else {
            potentialIncome = (totalSeats / 2 + 1) * 8 + totalSeats / 2 * 10;
        }
        System.out.println("Total income: $" + potentialIncome);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");

        rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        columns = scanner.nextInt();

        createRoom(rows, columns);

        while (isRunning) {
            System.out.println("""
                1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit
                """);
            int menu = scanner.nextInt();
            switch (menu) {
                case (1): {
                    //1. Show the seats
                    showRoom(rows, columns, cinemaRoom);
                    break;
                }
                case (2): {
                    //2. Buy a ticket
                    buyTicket(cinemaRoom);
                    break;
                }
                case (3): {
                    //3. Statistics
                    showStatistics();
                    break;
                }
                default: {
                    isRunning = false;
                    return;
                }
            }
        }
    }
}