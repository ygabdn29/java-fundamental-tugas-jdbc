package dao;

import java.util.List;

import models.Asset;

public interface AssetDAOInterface {
  public List<Asset> get();
  public Asset get(Integer id);
  public Asset get(String status);
  // public Integer insert(Asset asset);
  // public Integer update(Asset asset);
  // public Integer delete(Integer id);
}
