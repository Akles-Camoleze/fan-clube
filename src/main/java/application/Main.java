package application;

import application.database.Migration;
import application.database.Seeder;
import application.ui.Login;

public class Main {
    public static void main(String[] args) {
        Migration.initDatabase();
        Seeder.run();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}