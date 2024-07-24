import dao.AssetDAOInterface;
import dao.implementation.AssetDAO;
import dao.implementation.UserDAO;
import models.Asset;
import models.User;
import tools.DbConnection;

public class App {
    public static void main(String[] args) throws Exception {
        DbConnection connection = new DbConnection();
        // System.out.println(connection.getConnection());

        // UserDAO userDao = new UserDAO(connection.getConnection());
        // for(User user : userDao.get()){
        //     System.out.println(user.getUsername());
        // }
        // User userKevinn = new User(1, 1, "kevinn", "kevin123");
        // User selectedUser = userDao.get(userKevinn.getUsername(), userKevinn.getPassword());    
        // System.out.println(selectedUser.getUsername());

        // Login: 
        // - Memasukkan username dan password
        // - Mengecek record database
        // - Apabila tidak ditemukan login gagal, apabila ada return user yang ditemukan

        // Membuat UserToUserDAO yang didalamnya terdapat method login. 
        // UserToUserDAO membuat instance UserDAO lalu menggunakannya untuk mengecek record database
        // Method login melakukan return User yang berhasil login
        UserToUserDAO userToUserDAO  = new UserToUserDAO(connection.getConnection());
        User userLogin = userToUserDAO.login("kevinn", "kevin123");

        if(userLogin != null){
            System.out.println("Login successful! Currently logged in as: " + userLogin.getUsername());
        }
        else {
            System.out.println("Login failed!");
        }

        AssetDAOInterface assetDAO = new AssetDAO(connection.getConnection());
        // Menampilkan semua asset
        System.err.println("List Semua Asset");
        for(Asset asset : assetDAO.get()){
            System.out.println("Asset ID: " + asset.getId());
            System.out.println("Asset Name: " + asset.getName());
            System.out.println("Asset Type: " + asset.getAsset_type_id());
            System.out.println("Asset Status: " + asset.getAsset_status_id());
            System.out.println("Asset Damage Level: " + asset.getDamageLevel());
            System.out.println("-----------------------------------------------------");
        }
        System.out.println("======================================================================");
        // Menampilkan semua asset berdasarkan tipe dan status
        System.out.println("List semua asset berdasarkan tipe dan status");
        for(Asset asset : assetDAO.get(1, 1)){
            System.out.println("Asset ID: " + asset.getId());
            System.out.println("Asset Name: " + asset.getName());
            System.out.println("Asset Type: " + asset.getAsset_type_id());
            System.out.println("Asset Status: " + asset.getAsset_status_id());
            System.out.println("Asset Damage Level: " + asset.getDamageLevel());
            System.out.println("-----------------------------------------------------");
        }
    }
}
