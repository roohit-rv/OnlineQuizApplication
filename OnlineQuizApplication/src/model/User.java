package model;

public class User {
    private int id;
    private String username;
    private String password;
    private int score;

    public User(int id, String username, String password, int score) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.score = score;
    }

}
