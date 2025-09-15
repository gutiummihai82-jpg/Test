import java.util.Scanner;

public class MainF {
    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        SignUp signUp = new SignUp(manager);
        Login login = new Login(manager);

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    signUp.createAccount();
                    break;
                case 2:
                    login.loginUser();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}

