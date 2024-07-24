import java.sql.Connection;

import dao.implementation.UserDAO;
import models.User;

public class UserToUserDAO {
  private static Connection connection;

  public UserToUserDAO(Connection connection) {
    this.connection = connection;
  }

  public User login(String username, String password){
    UserDAO userDAO = new UserDAO(connection);
    User user = null;

    if(username.length() == 0 || password.length() == 0) return user;
    
    user = userDAO.get(username, password);
    return user;
  }

}
