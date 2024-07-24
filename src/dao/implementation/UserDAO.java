package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDAOInterface;
import models.User;

public class UserDAO implements UserDAOInterface{
  private Connection connection;


  public UserDAO(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<User> get() {
    List<User> users = new ArrayList<User>();
    String query  = "SELECT * FROM tb_m_user";

    try {
      ResultSet result = connection.prepareStatement(query).executeQuery();

      while(result.next()) {
        User user = new User(
          result.getInt("id"), 
          result.getInt("employee_id"), 
          result.getString("username"), 
          result.getString("password"));
          users.add(user);
        }
        result.close();
      } catch (SQLException e) {
        System.out.println("BAD SQL: "+ e.getMessage());
      }
    return users;
  }

  @Override
  public User get(Integer id) {
    User user = null;
    String query = "SELECT * FROM tb_m_user WHERE id = ?";

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, id);

      ResultSet result = preparedStatement.executeQuery();
      if(result.next()){
        user = new User(
          result.getInt("id"), 
          result.getInt("employee_id"), 
          result.getString("username"), 
          result.getString("password"));
      }
      return user;
    } catch (SQLException e) {
      System.out.println("BAD SQL: " + e.getMessage());
    }

    return user;
  }

  @Override
  public User get(String username, String password) {
    User user = null;
    String query = "SELECT * FROM tb_m_user WHERE username = ? AND password = ?";

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, password);

      ResultSet result = preparedStatement.executeQuery();
      if(result.next()){
        user = new User(
          result.getInt("id"), 
          result.getInt("employee_id"), 
          result.getString("username"), 
          result.getString("password"));
      }
      return user;
    } catch (SQLException e) {
      System.out.println("BAD SQL: " + e.getMessage());
    }

    return user;
  }
  
}
