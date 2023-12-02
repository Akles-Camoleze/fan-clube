package application;

import application.database.Migration;
import application.database.Seeder;
import application.ui.Login;
import application.ui.Register;

public class Main {
    public static void main(String[] args) {
        Migration.initDatabase();
        Seeder.run();
//        java.awt.EventQueue.invokeLater(() -> new Register().setVisible(true));
    }
}