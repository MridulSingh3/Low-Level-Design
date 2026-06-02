class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        System.out.println("Database Connection Created");
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}

public class Main {
    public static void main(String[] args) {
        DatabaseConnection d1 = DatabaseConnection.getInstance();

        DatabaseConnection d2 = DatabaseConnection.getInstance();

        System.out.println(d1 == d2);
    }
}