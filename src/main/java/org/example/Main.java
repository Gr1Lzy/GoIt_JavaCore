package org.example;

import org.example.model.Address;
import org.example.model.Company;
import org.example.model.Geo;
import org.example.model.User;
import org.example.module13_1.HttpUserUtilities;

public class Main {
    public static void main(String[] args) {
        User newUser = new User(11,
                "Test",
                "TEST",
                "test@test.com",
                new Address("Kulas Light",
                        "Apt. 556",
                        "Gwenborough",
                        "92998-3874",
                        new Geo("-37.3159", "81.1496")),
                "1-770-736-8031 x56442",
                "hildegard.org",
                new Company("Romaguera-Crona",
                        "Multi-layered client-server neural-net",
                        "harness real-time e-markets"));

        HttpUserUtilities httpUserUtilities = new HttpUserUtilities();
        System.out.println(httpUserUtilities.createUser(newUser));

        newUser.setId(10);
        newUser.setName("Changed Name");
        newUser.setEmail("email@email.com");

        System.out.println(httpUserUtilities.updateUser(newUser));

        System.out.println(httpUserUtilities.deleteUser(1));

        for (User user : httpUserUtilities.getAllUsers()) {
            System.out.println(user);
        }

        System.out.println(httpUserUtilities.getUserById(2));

        System.out.println(httpUserUtilities.getUserByUsername("Bret"));
    }
}