import java.util.Scanner;

public class Login {
    private AccountManager manager;

    public Login(AccountManager manager) {
        this.manager = manager;
    }

    public void loginUser() {
        Scanner input = new Scanner(System.in);

        System.out.println("==================== LOGIN ====================");

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.println("============================================================");

        if (manager.login(username, password)) {
            System.out.println("✅ Login successful! Welcome " + username);
        } else {
            System.out.println("❌ Invalid username or password.");
        }
    }
}

