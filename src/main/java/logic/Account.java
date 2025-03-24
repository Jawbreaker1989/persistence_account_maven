package logic;

public class Account {
    private Integer id;
    private String username;
    private String email;
    private double balance;
    private boolean isActive;

    public Account(Integer id, String username, String email, double balance, boolean isActive) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.balance = balance;
        this.isActive = isActive;
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return isActive;
    }
}