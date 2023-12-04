package application.database;

import jakarta.annotation.PostConstruct;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {

    @PostConstruct
    @Order(1)
    public void initDatabase() {
        try {
            Migration.initDatabase();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @PostConstruct
    @Order(2)
    public void seedDatabase() {
        try {
            Seeder.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}