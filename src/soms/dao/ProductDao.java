package soms.dao;

import soms.config.DbConnection;
import soms.model.Product;
import soms.model.User;
import soms.service.ProductService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProductDao {
    final static Logger logger = Logger.getLogger(ProductDao.class.getName());

    public String save(Product product){

        try {
            Connection dbConnection = DbConnection.getDbConnection();

            String sqlQuery = "INSERT INTO PRODUCTS(PName,PDesc,PPrice,PQty) values(?,?,?,?)";

            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlQuery);

            //set params
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getProductDesc());
            preparedStatement.setDouble(3, product.getProductPrice());
            preparedStatement.setInt(4, product.getProductQty());


            int i = preparedStatement.executeUpdate();

            if (i > 0) {
                System.out.println("Data inserted and row effected :: " + i);//Loggers - create log file
                return "Product Saved Successfully...";
            } else {
                return "Product not saved...";
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }


    //create a saveAll method
    //i have a list of product objects
    //when i call this saveAll and parameter List<Products>
    //it should insert all the product
    //Batch methods
    //may not directly insert the object
   public void saveAll(List<Product> productList){


       try {
           Connection dbConnection = DbConnection.getDbConnection();

           String sqlQuery = "INSERT INTO PRODUCTS(PName,PDesc,PPrice,PQty) values(?,?,?,?)";

           PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlQuery);

           //set params

           for(Product product : productList) {

               preparedStatement.setString(1, product.getProductName());
               preparedStatement.setString(2, product.getProductDesc());
               preparedStatement.setDouble(3, product.getProductPrice());
               preparedStatement.setInt(4, product.getProductQty());

               preparedStatement.addBatch();
           }



           int[] i = preparedStatement.executeBatch();

           System.out.println("Rows effected :: "+ i.length);

           System.out.println("Data saved successfully..");
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }



   }



    public void update(Product product){

    }

    public void delete(Long id){

    }

    public void readProducts(){

        String sqlQuery = "SELECT * FROM PRODUCTS";

        ArrayList<Product> products = new ArrayList<>();
        try {
            Connection connection = DbConnection.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println("Id : "+ resultSet.getLong("productId")
                        + " Product NAME : "+ resultSet.getString("PName")
                        + " Product DESC :"          + resultSet.getString("PDesc")
                        + " Product QTY :"          + resultSet.getInt("PQty")
                        + " Product PRICE :"        + resultSet.getDouble("PPrice"));

                Product product = new Product(resultSet.getString("PName"), resultSet.getString("PDesc"), resultSet.getDouble("PPrice"), resultSet.getInt("PQty"));
               products.add(product);
            }


            logger.info("Products "+products);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void readProductById(Long id){

    }

}
