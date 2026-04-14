package soms.dao;

import soms.config.DbConnection;
import soms.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserDao {


    final static Logger logger = Logger.getLogger(UserDao.class.getName());

    public String saveUser(User user) {

        try {
            Connection dbConnection = DbConnection.getDbConnection();

            String sqlQuery = "INSERT IN USER(name,email,password,usertype) values(?,?,?,?)";

            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlQuery);

            //set params
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getUserType());

            int i = preparedStatement.executeUpdate();

            if (i > 0) {
                //log.debug()
                System.out.println("Data inserted and row effected :: " + i);
                return "User Saved Successfully...";
            } else {
                return "User not saved...";
            }

        } catch (SQLException e) {

            logger.severe("Error while saving user "+ e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public User validateUser(String email,String password, String usertype){
        System.out.println("validating user");
        String sqlQuery = "SELECT * FROM USER where email=? and password =? and usertype=?";

        try {
            Connection connection = DbConnection.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,usertype);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = new User();
            while (resultSet.next()){
                System.out.println("Id : "+ resultSet.getLong("id")
                        + " Name : "+ resultSet.getString("name")
                        + " Email :"          + resultSet.getString("email")
                        + " UserType :"        + resultSet.getString("userType"));

                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setUserType(resultSet.getString("usertype"));

            }

            return  user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void update(Long id,String name, String email){

        String sqlQuery ="update user set name=? ,email = ? where id=?";

        try {
            Connection connection = DbConnection.getDbConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);
            preparedStatement.setLong(3,id);

            int i = preparedStatement.executeUpdate();

            System.out.println("Data Updated successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
