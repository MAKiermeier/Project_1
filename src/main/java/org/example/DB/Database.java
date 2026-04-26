package org.example.DB;
import java.sql.*;
import java.util.Scanner;

public class Database {
    private static final String URL =
            "jdbc:postgresql://hera.hs-regensburg.de:5432/";

    public static Connection connect() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("DB username:");
        String username = scanner.nextLine();
        System.out.println("DB password:");
        String password = scanner.nextLine();
        return DriverManager.getConnection(URL+username, username, password);
    }
    public static void read_decks(Connection connection) throws SQLException {
        try (
             PreparedStatement stmt = connection.prepareStatement(
                     "SELECT id, name, created_at FROM decks");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " + rs.getString("name")+ rs.getString("created_at")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void read_cards(Connection connection, int deck_id_var) throws SQLException {
        String sql = "SELECT id, deck_id, question, answer, correct_count, wrong_count FROM cards WHERE deck_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, deck_id_var);

            try (ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " + rs.getString("question")+ rs.getString("answer")+ rs.getString("correct_count")+ rs.getString("wrong_count")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }    }
}
}