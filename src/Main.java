import soms.service.UserService;
import soms.model.User;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    final static Logger logger = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {
        startProcess();
    }


    public static void startProcess() {

        logger.info("Welcome to SOMS");
        logger.info("1.Login 2.Register");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        UserService userService = new UserService();
        System.out.println(" Hi ");
        Scanner scanner1 = new Scanner(System.in);

        switch (option) {

            case 1:
                userService.login();
                break;
            case 2:
                userService.register();
                break;
            default:
                logger.info("Invalid Option");
        }


    }


}