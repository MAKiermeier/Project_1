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
    //*************************************************************
    public static void read_decks(Connection connection) throws SQLException {
        //************test
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
        //*************
    }
    //***************************************************
}