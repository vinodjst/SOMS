package soms.service;

import soms.dao.UserDao;
import soms.flow.AdminFlow;
import soms.flow.CustomerFlow;
import soms.model.User;

import java.util.Scanner;
import java.util.logging.Logger;

public class UserService {
    final static Logger logger = Logger.getLogger(UserService.class.getName());

    UserDao userDao = new UserDao();

    public void login() {

        logger.info("Login process started...");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your details");

        System.out.println("Enter Email :");
        String email = scanner.next();

        System.out.println("Enter password :");
        String password = scanner.next();

        System.out.println("Enter userType :");
        String userType = scanner.next();

        User user = userDao.validateUser(email, password, userType);
        if (user.getName() != null) {

            System.out.println("Login successful");
            String userTyp = user.getUserType();

            if (userTyp.equalsIgnoreCase("customer")) {
                new CustomerFlow().customerFlow(user);
            } else if (userTyp.equalsIgnoreCase("admin")) {
                new AdminFlow().adminFlow();
            }
        } else {
            logger.warning("User object is null");
            System.out.println("User not found");
        }

        scanner.close();

    }

    public void register() {

        System.out.println("Register process started...");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your details");
        System.out.println("Enter Name :");
        String name = scanner.next();

        System.out.println("Enter Email :");
        String email = scanner.next();

        System.out.println("Enter password :");
        String password = scanner.next();

        System.out.println("Enter userType :");
        String userType = scanner.next();

        String response = userDao.saveUser(new User(name, email, password, userType));//it will save user into db

        System.out.println(response);

        scanner.close();
    }

    public void updateProfile(Long id) {

        System.out.println("Update process started...");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your details");
        System.out.println("Enter name :: ");
        String userName = scanner.next();
        System.out.println("Enter Email :: ");
        String userEmail = scanner.next();


        userDao.update(id, userName, userEmail);

        System.out.println("Profile updated successfully");

    }

}
