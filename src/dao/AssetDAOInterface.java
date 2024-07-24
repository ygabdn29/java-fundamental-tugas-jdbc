package dao;

import java.util.List;

import models.Asset;

public interface AssetDAOInterface {
  public List<Asset> get();
  public Asset get(Integer id);
  public List<Asset> get(Integer asset_status_id, Integer type_status_id);
  // public Integer insert(Asset asset);
  // public Integer update(Asset asset);
  // public Integer delete(Integer id);
}
