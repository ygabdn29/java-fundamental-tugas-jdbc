package dao;

import java.util.List;

import models.User;

public interface UserDAOInterface {
  public List<User> get();
  public User get(Integer id);
  public User get(String username, String password);
  // public Integer insert(User user);
  // public Integer update(User user);
  // public Integer delete(User user);
}
