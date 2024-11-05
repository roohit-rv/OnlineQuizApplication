package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class DatabaseConnector {

    public static void saveUser(String username, String hashedPassword) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, hashedPassword);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getHashedPassword(String username) {
        String hashedPassword = null;
        String sql = "SELECT password FROM users WHERE username = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) { // If a result is found
                hashedPassword = rs.getString("password");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return hashedPassword;
    }



    private static final String URL = "jdbc:sqlite:D:/Innobyte Internship/Project/OnlineQuizApplication/quizz_app.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void initializeDatabase() {
        String usersTable = "CREATE TABLE IF NOT EXISTS users ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "username TEXT UNIQUE NOT NULL,"
                + "password TEXT NOT NULL,"
                + "score INTEGER DEFAULT 0);";

        String quizzesTable = "CREATE TABLE IF NOT EXISTS quizzes ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "title TEXT NOT NULL);";

        String questionsTable = "CREATE TABLE IF NOT EXISTS questions ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "quiz_id INTEGER,"
                + "question_text TEXT NOT NULL,"
                + "correct_answer TEXT NOT NULL,"
                + "FOREIGN KEY (quiz_id) REFERENCES quizzes(id));";

        String resultsTable = "CREATE TABLE IF NOT EXISTS results ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "user_id INTEGER,"
                + "quiz_id INTEGER,"
                + "score INTEGER,"
                + "attempt_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                + "FOREIGN KEY (user_id) REFERENCES users(id),"
                + "FOREIGN KEY (quiz_id) REFERENCES quizzes(id));";

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(usersTable);
            stmt.execute(quizzesTable);
            stmt.execute(questionsTable);
            stmt.execute(resultsTable);
            System.out.println("Tables created or already exist.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
