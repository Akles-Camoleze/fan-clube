package application;

import application.database.Migration;
import application.database.Seeder;

public class Main {
    public static void main(String[] args) {
        Migration.initDatabase();
        Seeder.run();
    }
}