import java.util.Scanner;
public class RestaurantManagement {
    int Total_Tables = 32;
    char[] status = new char[Total_Tables];

    static final int MAX_ORDERS = 100;
    static int[] orderNumbers = new int[MAX_ORDERS];
    static int[] orderTablesList = new int[MAX_ORDERS];
    static String[] orderFoodList = new String[MAX_ORDERS];
    static double[] orderTotals = new double[MAX_ORDERS];
    static String[] orderStatus = new String[MAX_ORDERS];
    static int orderRecordCount = 0;

    public void initStatus() {
        for (int i = 0; i < Total_Tables; i++) {
            status[i] = 'A';
        }
    }

    public void DisplayTable(int[] table, int row) {
        System.out.print("Row" + row + ":  ");
        for (int x : table) {
            System.out.print(x + ":" + status[x - 1] + " | ");
        }
        System.out.println("\n--------------------------------------------------");
    }
    public boolean BookTable(int tableNo) {
        int index = tableNo - 1;
        if (index < 0 || index >= Total_Tables) {
            return false;
        }
        if (status[index] == 'X') {
            return false;
        }
        status[index] = 'X';
            return true;
    }
        static int OrderNum() {
        int newnum;
        boolean isduplicate;
        do {
            newnum = (int) (Math.random() * 9000) + 1000;
            isduplicate = false;
            for (int i = 0; i < orderRecordCount; i++) {
                if (orderNumbers[i] == newnum) {
                    isduplicate = true;
                    break;
                }
            }
        } while (isduplicate);
        return newnum;
    }
static void saveOrderRecord(int orderNo, int tables, String food, double total) {
        orderNumbers[orderRecordCount] = orderNo;
        orderTablesList[orderRecordCount] = tables;
        orderFoodList[orderRecordCount] = food;
        orderTotals[orderRecordCount] = total;
        orderStatus[orderRecordCount] = "Pending";
        orderRecordCount++;
    }
    static void printOrderDetails(int index) {
    System.out.println("Order #" + orderNumbers[index]);
    System.out.println("Tables: " + orderTablesList[index]);
    System.out.println("Food:\n" + orderFoodList[index]);
    System.out.println("-----------------------------");
}
        void newCustomerOrder(Scanner yuvaraj, RestaurantManagement RM) {
        int[] tablesr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] tablesr2 = {9, 10, 11, 12, 13, 14, 15, 16};
        int[] tablesr3 = {17, 18, 19, 20, 21, 22, 23, 24};
        int[] tablesr4 = {25, 26, 27, 28, 29, 30, 31, 32};
        int[] finalchoice = new int[32];
        int bookedcount = 0;
        double totalbill;

        System.out.println("-----------------Displaying tables----------------\n");

        RM.DisplayTable(tablesr1, 1);
        RM.DisplayTable(tablesr2, 2);
        RM.DisplayTable(tablesr3, 3);
        RM.DisplayTable(tablesr4, 4);

        System.out.println("Please note\n(A) refers available\n(X) refers unavailable");

        int tables = 0;
        while (tables < 32) {
        System.out.print("\nEnter table number to book (Enter 0 after selecting your tables to proceed): ");
        int choice = yuvaraj.nextInt();
        tables++;
        if (choice == 0) {
            break;
        }
        boolean success = RM.BookTable(choice);
        if (success) {
            System.out.println("\nTable " + choice + " reserved.\n");
            finalchoice[bookedcount] = choice;
            bookedcount++;
        } else {
            System.out.println("Table " + choice + " unavailable or invalid.\n");
        }
    }

        System.out.println("-----------------Updated tables-----------------\n");
        RM.DisplayTable(tablesr1, 1);
        RM.DisplayTable(tablesr2, 2);
        RM.DisplayTable(tablesr3, 3);
        RM.DisplayTable(tablesr4, 4);
        System.out.println("Tables selected:");
        for (int i = 0; i < bookedcount; i++) {
        System.out.println("Table " + finalchoice[i]);
}

        double grandsubtotal = 0;
        double burgersubtotal = 0;
        double friessubtotal = 0;
        double sodasubtotal = 0;
        double chipssubtotal = 0;
        String foodsummary = "";
        System.out.println("-----Items Menu-----");
        System.out.println("1) Burger: 3.59$");
        System.out.println("2) Fries: 1.79$");
        System.out.println("3) Soda: 1.29$");
        System.out.println("4) Potato chips: 2.19$");
        System.out.println("0) Done (Generate bill)");

        while (true) {
            System.out.println("Enter your choice (0-4): ");
            int Foodchoice = yuvaraj.nextInt();

            if (Foodchoice == 0) {
                break;
            }

            System.out.println("Enter quantity(less than 10): ");
            byte quantity = yuvaraj.nextByte();

            if (quantity > 10) {
                System.out.println("Invalid quantity!");
                return;
            }

            switch (Foodchoice) {
                case 1:
                    grandsubtotal += 3.59 * quantity;
                    foodsummary += "--> Burger: " + "(" + quantity + ")" + " subtotal: " + (burgersubtotal+3.59*quantity) + "$" + "\n";
                    break;
                case 2:
                    grandsubtotal += 1.79 * quantity;
                    foodsummary += "--> Fries: " + "(" + quantity + ")" + " subtotal: " + (friessubtotal+1.79*quantity) + "$" + "\n";
                    break;
                case 3:
                    grandsubtotal += 1.29 * quantity;
                    foodsummary += "--> Soda: " + "(" + quantity + ")" + " subtotal: " + (sodasubtotal+1.29*quantity) + "$" + "\n";
                    break;
                case 4:
                    grandsubtotal += 2.19 * quantity;
                    foodsummary += "--> Potato Chips: " + "(" + quantity + ")" + " subtotal: " + (chipssubtotal+2.19*quantity) + "$" + "\n";
                    break;
                default:
                    System.out.println("Invalid input, Enter (1,2,3,4 or 0)");
                    continue;
            }

            System.out.println("You have chosen: " + foodsummary);
        }
        double CGST = grandsubtotal*0.05;
        double SGST = grandsubtotal*0.05;
        totalbill = grandsubtotal + CGST + SGST;

        int ordernum = OrderNum();
        saveOrderRecord(ordernum, bookedcount, foodsummary, totalbill);

        System.out.println("    X Restaurant");
        System.out.println("-------Receipt-------");
        System.out.println("Order number: " + ordernum);
        System.out.println("\nTables selected:");
        for (int i = 0; i < bookedcount; i++) {
        System.out.println("Table " + finalchoice[i]);
}
        System.out.println("\nFood item, quantity, cost: " + "\n" + foodsummary + "$");
        System.out.printf("Subtotal: %.2f$%n", grandsubtotal);
        System.out.println("----------------------------");
        System.out.printf("CGST @ 5%%: %.2f$%n", CGST);
        System.out.printf("SGST @ 5%%: %.2f$%n", SGST);
        System.out.println("----------------------------");
        System.out.printf("Total amount: %.2f$%n", totalbill);
}

public static void main(String[] args) {
    Scanner yuvaraj = new Scanner(System.in);
    RestaurantManagement RM = new RestaurantManagement();
    RM.initStatus();
    boolean running = true;
    while (running) {
    System.out.println("\n1) New customer order");
    System.out.println("2) View kitchen queue");
    System.out.println("3) Mark order as done (chef)");
    System.out.println("4) Check order records");
    System.out.println("5) Exit");
    int menuChoice = yuvaraj.nextInt();

    switch (menuChoice) {
        case 1:
            RestaurantManagement order = new RestaurantManagement();
            order.newCustomerOrder(yuvaraj, RM);
            break;

        case 2:
            if (orderRecordCount == 0) {
                System.out.println("Kitchen queue empty");
            } else {
                System.out.println("--------Kitchen Queue---------");
                for (int i = 0; i < orderRecordCount; i++) {
                    printOrderDetails(i);
                }
            }
            break;

        case 3:
            System.out.println("Currently stored order numbers: ");
            for (int i = 0; i < orderRecordCount; i++) {
            System.out.println(orderNumbers[i]);
            }
            System.out.print("Enter order number to mark as done: ");
            int doneNum = yuvaraj.nextInt();
            boolean doneFound = false;
            for (int i = 0; i < orderRecordCount; i++) {
                if (orderNumbers[i] == doneNum) {
                    doneFound = true;
                    if (orderStatus[i].equals("Done")) {
                        System.out.println("Order #" + doneNum + " was already marked as done.");
                    } else {
                        orderStatus[i] = "Done";
                        System.out.println("Order #" + doneNum + " marked as done.");
                    }
                    break;
                }
            }
            if (!doneFound) {
                System.out.println("Order not found!");
            }
            break;

        case 4:
            System.out.println("Enter order number: ");
            int num = yuvaraj.nextInt();
            boolean found = false;
            for (int i = 0; i < orderRecordCount; i++) {
                if (orderNumbers[i] == num) {
                    found = true;
                    System.out.println("\n------Displaying order details------");
                    System.out.println("[Stored record check] Order #" + orderNumbers[i]
        + " -> Tables: " + orderTablesList[i] + " | Food list: " + orderFoodList[i] + " | Total: $" + orderTotals[i]);
            break;
                }
            }
                if (!found) { 
                    System.out.println("Order not found!");
                break;
            }
        
        case 5:
            running = false;            
            break;
    }
}

    }
}