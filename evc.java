import java.util.Scanner;

public class evc {
    private static final String CORRECT_PIN = "1234";
    private static double balance = 500.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Fadlan geli *770#: ");
        String startCode = scanner.nextLine();

        if (!startCode.equals("*770#")) {
            System.out.println("Code khaldan. Fadlan isku day mar kale.");
            return;
        }

        System.out.print("Fadlan geli PIN-kaaga (4-digit): ");
        String enteredPin = scanner.nextLine();

        while (!enteredPin.equals(CORRECT_PIN)) {
            System.out.println("PIN khaldan. Fadlan isku day mar kale.");
            System.out.print("Fadlan geli PIN-kaaga (4-digit): ");
            enteredPin = scanner.nextLine();
        }

        boolean continueLoop = true;
        while (continueLoop) {
            displayMainMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.printf("Haraagaaga waa: $%.2f%n", balance);
                    continueLoop = false;
                }
                case 6 -> {
                    showSalaamBankMenu(scanner);
                    continueLoop = false;
                }
                case 7 -> {
                    showMaareyntaMenu(scanner);
                    continueLoop = false;
                }
                case 8 -> {
                    showBillPaymentMenu(scanner);
                    continueLoop = false;
                }
                case 0 -> {
                    System.out.println("Nabad gelyo!");
                    continueLoop = false;
                }
                default -> System.out.println("Xulasho khaldan. Fadlan dooro sax ah.");
            }
        }

        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\nEVCPPlus Menu:");
        System.out.println("1. Itus Haraaga");
        System.out.println("2. Kaarka hadalka");
        System.out.println("3. Bixi Biil");
        System.out.println("4. U wareeji EVCPPlus");
        System.out.println("5. Warbixin Kooban");
        System.out.println("6. Salaam Bank");
        System.out.println("7. Maareynta");
        System.out.println("8. Bill Payment");
        System.out.println("0. Exit");
        System.out.print("Dooro (0-8): ");
    }

    private static void showSalaamBankMenu(Scanner scanner) {
        System.out.println("\nSalaam Bank Menu:");
        System.out.println("1. Itus Haraaga");
        System.out.println("2. Lacag Dhigasho");
        System.out.println("3. Qaadasho");
        System.out.println("4. Ka Wareeji EVC");
        System.out.println("0. Exit Salaam Bank");
        System.out.print("Dooro (0-4): ");
        int bankChoice = scanner.nextInt();

        switch (bankChoice) {
            case 1 -> System.out.printf("Haraagaaga Salaam Bank waa: $%.2f%n", balance);
            case 2 -> depositMoney(scanner);
            case 3 -> withdrawMoney(scanner);
            case 4 -> transferMoney(scanner);
            case 0 -> System.out.println("Ka bax Salaam Bank.");
            default -> System.out.println("Xulasho khaldan. Fadlan dooro sax ah.");
        }
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Geli qadarka aad dhigeyso: ");
        double deposit = scanner.nextDouble();
        if (deposit <= 0) {
            System.out.println("Qadarka waa inuu ahaadaa mid togan!");
        } else {
            balance += deposit;
            System.out.printf("Waxaad dhigatay $%.2f. Haraaga cusub: $%.2f%n", deposit, balance);
        }
    }

    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Geli qadarka aad qaadaneyso: ");
        double withdraw = scanner.nextDouble();
        if (withdraw > balance) {
            System.out.println("Haraagaaga kuma filna.");
        } else {
            balance -= withdraw;
            System.out.printf("Waxaad ka qaaday $%.2f. Haraaga cusub: $%.2f%n", withdraw, balance);
        }
    }

    private static void transferMoney(Scanner scanner) {
        System.out.print("Geli lambarka aad u wareejinayso: ");
        String number = scanner.next();
        System.out.print("Geli qadarka: ");
        double amount = scanner.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            System.out.printf("Waxaad u wareejisay $%.2f lambar %s. Haraaga cusub: $%.2f%n", amount, number, balance);
        } else {
            System.out.println("Haraagaaga kuma filna.");
        }
    }

    private static void showMaareyntaMenu(Scanner scanner) {
        System.out.println("\nMaareynta Menu:");
        System.out.println("1. Badal Lambarka");
        System.out.println("2. Badal Luuqada");
        System.out.println("3. Wargalin Mobile");
        System.out.println("4. Lacag Xirasho");
        System.out.println("5. Uceli Lacag Qaldanty");
        System.out.println("0. Exit Maareynta");
        System.out.print("Dooro (0-5): ");
        int manageChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (manageChoice) {
            case 1 -> changePhoneNumber(scanner);
            case 2 -> changeLanguage(scanner);
            case 3 -> setNotificationNumber(scanner);
            case 4 -> lockMoney(scanner);
            case 5 -> refundMoney(scanner);
            case 0 -> System.out.println("Ka bax Maareynta.");
            default -> System.out.println("Xulasho khaldan. Fadlan dooro sax ah.");
        }
    }

    private static void changePhoneNumber(Scanner scanner) {
        System.out.print("Geli lambarka cusub: ");
        String newNumber = scanner.nextLine();
        System.out.println("Lambarkaaga cusub waa: " + newNumber);
    }

    private static void changeLanguage(Scanner scanner) {
        System.out.println("Dooro luuqada:");
        System.out.println("1. Somali");
        System.out.println("2. English");
        System.out.print("Dooro (1-2): ");
        int languageChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (languageChoice == 1) {
            System.out.println("Luuqadaada waa Somali.");
        } else if (languageChoice == 2) {
            System.out.println("Luuqadaada waa English.");
        } else {
            System.out.println("Xulasho khaldan.");
        }
    }

    private static void setNotificationNumber(Scanner scanner) {
        System.out.print("Geli lambarka mobile-ka wargalinta: ");
        String notificationNumber = scanner.nextLine();
        System.out.println("Wargalinta mobile-ka waa loo dirayaa lambarka: " + notificationNumber);
    }

    private static void lockMoney(Scanner scanner) {
        System.out.print("Geli qadarka lacagta aad xirayso: ");
        double lockAmount = scanner.nextDouble();
        if (lockAmount <= 0 || lockAmount > balance) {
            System.out.println("Qadarka khaldan ama haraaga kuma filna.");
        } else {
            balance -= lockAmount;
            System.out.printf("Waxaad xirtay $%.2f. Haraaga cusub: $%.2f%n", lockAmount, balance);
        }
    }

    private static void refundMoney(Scanner scanner) {
        System.out.print("Geli qadarka lacagta aad ucelinayso: ");
        double refundAmount = scanner.nextDouble();
        if (refundAmount <= 0 || refundAmount > balance) {
            System.out.println("Qadarka khaldan ama haraaga kuma filna.");
        } else {
            balance -= refundAmount;
            System.out.printf("Waxaad ucelisay $%.2f. Haraaga cusub: $%.2f%n", refundAmount, balance);
        }
    }

    private static void showBillPaymentMenu(Scanner scanner) {
        System.out.println("\nBill Payment Menu:");
        System.out.println("1. Itus Haraaga Biilka");
        System.out.println("2. Wada Bixi Biilka");
        System.out.println("3. Qayb Ka Bixi Biilka");
        System.out.println("0. Exit Bill Payment");
        System.out.print("Dooro (0-3): ");
        int billChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (billChoice) {
            case 1 -> System.out.printf("Haraaga biilka waa: $%.2f%n", balance);
            case 2 -> payFullBill(scanner);
            case 3 -> payPartialBill(scanner);
            case 0 -> System.out.println("Ka bax Bill Payment.");
            default -> System.out.println("Xulasho khaldan. Fadlan dooro sax ah.");
        }
    }

    private static void payFullBill(Scanner scanner) {
        System.out.print("Geli qadarka biilka oo buuxa: ");
        double fullBill = scanner.nextDouble();
        if (fullBill <= balance) {
            balance -= fullBill;
            System.out.printf("Waxaad bixisay biilka oo buuxa: $%.2f. Haraaga cusub: $%.2f%n", fullBill, balance);
        } else {
            System.out.println("Haraagaaga kuma filna.");
        }
    }

    private static void payPartialBill(Scanner scanner) {
        System.out.print("Geli qadarka qaybta biilka: ");
        double partialBill = scanner.nextDouble();
        if (partialBill <= balance) {
            balance -= partialBill;
            System.out.printf("Waxaad bixisay qayb ka mid ah biilka: $%.2f. Haraaga cusub: $%.2f%n", partialBill, balance);
        } else {
            System.out.println("Haraagaaga kuma filna.");
        }
    }
}