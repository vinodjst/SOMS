package soms.flow;

import soms.model.Product;
import soms.service.ProductService;
import soms.service.UserService;

import java.util.Scanner;
import java.util.logging.Logger;

public class AdminFlow {

    final static Logger logger = Logger.getLogger(AdminFlow.class.getName());

    public void adminFlow(){

        UserService userService = new UserService();

        ProductService productService = new ProductService();


        System.out.println("1.REMOVE USER " +
                " 2.ADD PRODUCT " +
                " 3.ADD MULTIPLE PRODUCTS " +
                " 4.DELETE PRODUCT " +
                " 5.UPDATE PRODUCT" +
                " 6.VIEW PRODUCTS " +
                " 7.OFFERS");


        System.out.println("Please choose an option by number 1 2 3 ....");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option){

            case 1 -> logger.info("removing user  -- Yet to implement");
            case 2 -> {
                logger.info("Adding product process - STARTED");
                productService.addProduct();
            }
            case 3 -> {
                logger.info("Adding products batch process - STARTED");
                productService.addAllProducts();
            }
            case 4 -> logger.info("deleting product");
                      //productService.delete();
            case 5 -> logger.info("updating product process - STARTED");
                     //productService.update();
            case 6 -> {
                logger.info("showing products process - STARTED");
                productService.showProducts();
            }
            case 7 -> logger.info("offers process - STARTED");
                   //proiductservice.offers()
        }

    }
}
