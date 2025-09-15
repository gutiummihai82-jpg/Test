import java.util.Scanner;

public class SignUp {
    private AccountManager manager;

    public SignUp(AccountManager manager) {
        this.manager = manager;
    }

    public void createAccount() {
        Scanner input = new Scanner(System.in);

        System.out.println("==================== SIGN UP! ====================");

        System.out.print("Choose a username: ");
        String username = input.nextLine();

        System.out.print("Choose a password: ");
        String password = input.nextLine();

        System.out.println("============================================================");

        if (manager.signUp(username, password)) {
            System.out.println("✅ Account created successfully!");
        } else {
            System.out.println("❌ Username already exists!");
        }
    }
}

