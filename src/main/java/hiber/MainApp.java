package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Laputa", "Manuka", "lapki@milo.ru");
        User user2 = new User("Verda", "Mayskaya", "pux@mail.ru");

        Car bmw = new Car("bmw", 123);
        Car razvoluha = new Car("razvoluha", 13);

        user1.setCar(bmw);
        bmw.setUser(user1);

        user2.setCar(razvoluha);
        razvoluha.setUser(user2);

        userService.add(user1);
        userService.add(user2);

        User testUser = userService.getUserFromCar("razvoluha", 13);
        System.out.println("Id = " + testUser.getId());
        System.out.println("First Name = " + testUser.getFirstName());
        System.out.println("Last Name = " + testUser.getLastName());
        System.out.println("Email = " + testUser.getEmail());
        System.out.println(testUser.getCar().getSeries() + " " + testUser.getCar().getModel());
        System.out.println();

        context.close();
    }
}
