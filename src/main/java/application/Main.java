package application;

import application.database.DataBase;
import application.database.Migration;

public class Main {
    public static void main(String[] args) {
        Migration.connectDatabase();
    }
}