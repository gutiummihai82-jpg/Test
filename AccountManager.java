import java.util.HashMap;

public class AccountManager {
    private HashMap<String, String> accounts = new HashMap<>();

    // Sign up (create account)
    public boolean signUp(String username, String password) {
        if (accounts.containsKey(username)) {
            return false; // already exists
        }
        accounts.put(username, password);
        return true;
    }

    // Login (verify credentials)
    public boolean login(String username, String password) {
        return accounts.containsKey(username) && accounts.get(username).equals(password);
    }
}


