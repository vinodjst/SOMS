package soms.service;

import soms.dao.ProductDao;
import soms.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class ProductService {

    final static Logger logger = Logger.getLogger(ProductService.class.getName());

    ProductDao productDao = new ProductDao();

    public String addProduct(){


        productDao.save(getProduct());

        logger.info("Process completed - Product added");
        return "Product saved";
    }

    public String addAllProducts(){

        //loop getProduct();
        Product product1 = new Product("mouse", "working fine", 5000.00, 2);
        Product product2 = new Product("keyboard", "working fine", 4000.00, 2);
        Product product3 = new Product("laptop", "working fine", 300.00, 2);
        Product product4 = new Product("phone", "working fine", 2000.00, 2);
        Product product5 = new Product("watch", "working fine", 700.00, 2);

        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        productDao.saveAll(products);

        return "Products added successfully";


    }

    
    public void showProducts(){

       productDao.readProducts();

    }
    
    
    private Product getProduct(){

        logger.info("Enter product details");
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter PRODUCT NAME :");
        String productName = scanner.next();

        logger.info("Enter PRODUCT DESC :");
        String productDesc = scanner.next();


        logger.info("Enter PRODUCT PRICE :");
        double productPrice = scanner.nextDouble();

        logger.info("Enter PRODUCT QTY :");
        int productQty = scanner.nextInt();

        scanner.close();
        return new Product(productName,productDesc,productPrice,productQty);

    }


}
