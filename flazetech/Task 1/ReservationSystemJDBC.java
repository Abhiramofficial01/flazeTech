import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReservationSystemJDBC {
    private static final String JDBC_URL = "jdbc:sqlite:reservations.db";

    public static void main(String[] args) {
        try {
            createTableIfNotExists();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to the Online Reservation System");

            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Enter the reservation date (YYYY-MM-DD): ");
            String date = scanner.nextLine();

            System.out.print("Enter the reservation time: ");
            String time = scanner.nextLine();

            // Save reservation to the database
            saveReservation(name, date, time);

            // Display all reservations
            displayReservations();

            System.out.println("\nThank you for using the Online Reservation System!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTableIfNotExists() throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement statement = connection.prepareStatement(
                     "CREATE TABLE IF NOT EXISTS reservations (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(255) NOT NULL, date DATE NOT NULL, time TIME NOT NULL)"
             )) {
            statement.executeUpdate();
        }
    }

    private static void saveReservation(String name, String date, String time) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO reservations (name, date, time) VALUES (?, ?, ?)"
             )) {
            statement.setString(1, name);
            statement.setString(2, date);
            statement.setString(3, time);
            statement.executeUpdate();
        }
    }

    private static void displayReservations() throws SQLException {
        System.out.println("\nReservation Details:");
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM reservations");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String date = resultSet.getString("date");
                String time = resultSet.getString("time");

                System.out.println("ID: " + id + ", Name: " + name + ", Date: " + date + ", Time: " + time);
            }
        }
    }
}
