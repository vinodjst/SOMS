package soms.flow;

import soms.model.User;
import soms.service.ProductService;
import soms.service.UserService;

import java.util.Scanner;

public class CustomerFlow {

    UserService userService = new UserService();

    ProductService productService = new ProductService();

    public void customerFlow(User user){

        System.out.println("1.UPDATE PROFILE 2.VIEW PRODUCT");
        //view - read (select * from product)

        //selects 1

        System.out.println("Please select 1 or 2 ... options");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        //switch

        userService.updateProfile(user.getId());

        System.out.println("profile updated.....");
    }


}
