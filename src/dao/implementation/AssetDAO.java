package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AssetDAOInterface;
import models.Asset;
import models.User;

public class AssetDAO implements AssetDAOInterface{
  private Connection connection;

  public AssetDAO(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<Asset> get() {
    List<Asset> assets = new ArrayList<Asset>();
    String query  = "SELECT * FROM tb_m_asset";

    try {
      ResultSet result = connection.prepareStatement(query).executeQuery();

      while(result.next()) {
        Asset asset = new Asset( 
        result.getInt("id"), 
        result.getString("name"), 
        result.getInt("asset_type_id"), 
        result.getInt("asset_status_id"),
        result.getString("damageLevel"));
        assets.add(asset);
      }

        result.close();
      } catch (SQLException e) {
        System.out.println("BAD SQL: "+ e.getMessage());
      }
    return assets;
  }

  @Override
  public Asset get(Integer id) {
    Asset asset = null;
    String query  = "SELECT * FROM tb_m_asset WHERE id = ?";

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, id);
      ResultSet result = connection.prepareStatement(query).executeQuery();

      if(result.next()) {
        asset = new Asset( 
        result.getInt("id"), 
        result.getString("name"), 
        result.getInt("asset_type_id"), 
        result.getInt("asset_status_id"),
        result.getString("damageLevel"));
      }
      result.close();
      return asset;
      } catch (SQLException e) {
        System.out.println("BAD SQL: "+ e.getMessage());
      }

    return asset;
  }

  @Override
  public List<Asset> get(Integer asset_status_id, Integer asset_type_id) {
    List<Asset> assets = new ArrayList<Asset>();
    String query  = "SELECT * FROM tb_m_asset WHERE asset_status_id = ? AND asset_type_id = ?";

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, 1);
      preparedStatement.setInt(2, 1);
      ResultSet result = preparedStatement.executeQuery();

      while(result.next()) {
        Asset asset = new Asset( 
        result.getInt("id"), 
        result.getString("name"), 
        result.getInt("asset_type_id"), 
        result.getInt("asset_status_id"),
        result.getString("damageLevel"));
        assets.add(asset);
      }

        result.close();
      } catch (SQLException e) {
        System.out.println("BAD SQL: "+ e.getMessage());
      }

    return assets;
  }
  
}
