package org.example;

import org.example.view.main_menu.Main_menu;

import java.sql.SQLException;
import java.util.Scanner;

import static org.example.DB.Database.connect;
import static org.example.DB.Database.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Main_menu main_menu = new Main_menu();
        try{
        Connection connection = connect();
        read_decks(connection);
        }catch (SQLException e){
            e.printStackTrace();

        }
        main_menu.main_menu_launch();

    }
}