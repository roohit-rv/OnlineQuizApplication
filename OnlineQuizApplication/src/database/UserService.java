package database;

import model.User;
import model.User;
import org.mindrot.jbcrypt.BCrypt;
import database.DatabaseConnector;
import java.util.HashSet;
import java.util.Set;

public class UserService {
    private Set<String> users = new HashSet<>();
    public String getHashedPassword(String username) {
        return DatabaseConnector.getHashedPassword(username);
    }

    public void registerUser(String username, String password) {

        if (getHashedPassword(username) != null) {
            System.out.println("Username already exists.");
            return;
        }

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        DatabaseConnector.saveUser(username, hashedPassword);
    }
    public boolean checkUserCredentials(String username, String password) {
        String storedHashedPassword = DatabaseConnector.getHashedPassword(username);

        if (storedHashedPassword == null) {
            System.out.println("User not found.");
            return false;
        }

        return BCrypt.checkpw(password, storedHashedPassword);
    }
}