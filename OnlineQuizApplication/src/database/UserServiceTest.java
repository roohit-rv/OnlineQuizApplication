package database;

public class UserServiceTest {
    public static void main(String[] args) {
        UserService userService = new UserService();

        System.out.println("Registering a new user...");
        userService.registerUser("testUser", "testPassword");

        System.out.println("Testing login with correct credentials...");
        boolean isValidUser = userService.checkUserCredentials("testUser", "testPassword");

        if (isValidUser) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }

        System.out.println("Testing login with incorrect credentials...");
        boolean isInvalidUser = userService.checkUserCredentials("testUser", "wrongPassword");

        if (isInvalidUser) {
            System.out.println("Login successful! (unexpected result)");
        } else {
            System.out.println("Invalid username or password. (expected result)");
        }

        System.out.println("Testing registration with existing username...");
        userService.registerUser("testUser", "anotherPassword");
    }
}