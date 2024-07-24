package models;

import dao.UserDAOInterface;
import dao.implementation.AssetDAO;
import dao.implementation.UserDAO;

public class User{
  private Integer id;
  private Integer employee_id;
  private String username;
  private String password;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getEmployee_id() {
    return employee_id;
  }

  public void setEmployee_id(Integer employee_id) {
    this.employee_id = employee_id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }

  public User(Integer id, Integer employee_id, String username, String password) {
    this.id = id;
    this.employee_id = employee_id;
    this.username = username;
    this.password = password;
  }

}
