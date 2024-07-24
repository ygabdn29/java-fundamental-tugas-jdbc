package tools;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
  private Connection connection;
  private String dbURL = "jdbc:mysql://localhost:3306/db_asset_management";
  private String user = "root";
  private String userPassword = "Mysql29!";

  public Connection getConnection(){
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      this.connection = DriverManager.getConnection(dbURL, user, userPassword);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }

    return connection;
  }
}
