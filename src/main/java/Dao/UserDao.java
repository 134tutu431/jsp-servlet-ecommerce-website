package Dao;

import DB.ConnectDB;
import Model.ProductsModel;
import Model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<UserModel> getUserModels(){
        try {
            String sql = "select * from ACCOUNTTB  ";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<UserModel> list = new ArrayList<>();
            while (rs.next()){
                UserModel userModel = new UserModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getInt(7) );
               list.add(userModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public UserModel Login(String email,String password){
        try {
            String sql = "select * from ACCOUNTTB where email =? and password=?";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,email);
            pstmt.setString(2,password);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                UserModel  userModel = new UserModel(rs.getString(2),rs.getString(3),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(1));
                return userModel;
            }
        }catch (Exception e){
        }
        return null;
    }
    public boolean addUser(UserModel userModel) {
        String sql = "Insert into ACCOUNTTB(email,password,confirmpass,name,phone,role)" + "values(?,?,?,?,?,0)";
        try {
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userModel.getUsername());
            pstmt.setString(2, userModel.getPassword());
            pstmt.setString(3, userModel.getConfirmpass());
            pstmt.setString(4, userModel.getName());
            pstmt.setString(5, userModel.getPhone());
            return pstmt.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public List<UserModel> getAllUserModels(){
        try {
            String sql = "select * from ACCOUNTTB EXCEPT SELECT * FROM ACCOUNTTB where role=1  ";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<UserModel> list = new ArrayList<>();
            while (rs.next()){
                UserModel userModel = new UserModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getInt(7) );
                list.add(userModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public int getTotalUsers(){
        try {
            String sql = "SELECT COUNT (*) FROM ACCOUNTTB  where role = 0 or role = 2 ";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        }catch (Exception e){
        }
        return 0;
    }
    public List<UserModel> getAllUserModelsbysearch(String search){
        try {
            String sql = "SELECT * FROM ACCOUNTTB WHERE name like ? EXCEPT SELECT * FROM ACCOUNTTB WHERE name like ? and id=1";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,"%"+search+"%");
            pstmt.setString(2,"%"+search+"%");
            ResultSet rs = pstmt.executeQuery();
            List<UserModel> list = new ArrayList<>();
            while (rs.next()){
                UserModel userModel = new UserModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getInt(7) );
                list.add(userModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public List<UserModel> getUserModelsoderbynameasc(){
        try {
            String sql = "SELECT * FROM ACCOUNTTB  EXCEPT SELECT * FROM ACCOUNTTB WHERE  role =1 ORDER BY name asc";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<UserModel> list = new ArrayList<>();
            while (rs.next()){
                UserModel userModel = new UserModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
                list.add(userModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public List<UserModel> getUserModelsoderbynamedesc(){
        try {
            String sql = "SELECT * FROM ACCOUNTTB  EXCEPT SELECT * FROM ACCOUNTTB WHERE  role=1 ORDER BY name desc";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<UserModel> list = new ArrayList<>();
            while (rs.next()){
                UserModel productsModel = new UserModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
                list.add(productsModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public List<UserModel> getUserModelsoderbypriceasc(){
        try {
            String sql = "SELECT * FROM ACCOUNTTB  EXCEPT SELECT * FROM ACCOUNTTB WHERE  role=1 ORDER BY id asc";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<UserModel> list = new ArrayList<>();
            while (rs.next()){
                UserModel productsModel = new UserModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
                list.add(productsModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public List<UserModel> getUserModelsoderbypricedesc(){
        try {
            String sql = "SELECT * FROM ACCOUNTTB  EXCEPT SELECT * FROM ACCOUNTTB WHERE  role=1 ORDER BY id desc";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<UserModel> list = new ArrayList<>();
            while (rs.next()){
                UserModel productsModel = new UserModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
                list.add(productsModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public void deleteUser(String userid){
        try {
            String sql = "DELETE  FROM ACCOUNTTB WHERE id = ?;";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,userid);
            pstmt.executeUpdate();
        }catch (Exception e){

        }
    }
    public UserModel getUserModelbyuserid(String userid){
        try {
            String sql = "SELECT * FROM ACCOUNTTB WHERE id = ? ";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,userid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                return new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getInt(7));
            }
        }catch (Exception e){
        }
        return null;
    }
    public void updateUser(String userid,String role) throws Exception {
        try {
            String sql = "UPDATE ACCOUNTTB SET role= ? where id= ?";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,role);
            pstmt.setString(2,userid);
            pstmt.executeUpdate();
        }catch (Exception e){
        }
    }
    public void updateUserbyid(int userid,String email,String pass,String confirmpass,String name,String phone) throws Exception {
        try {
            String sql = "UPDATE ACCOUNTTB SET email=?,password=?,confirmpass=?,name=?,phone=? where id= ?";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,email);
            pstmt.setString(2,pass);
            pstmt.setString(3,confirmpass);
            pstmt.setString(4,name);
            pstmt.setString(5,phone);
            pstmt.setInt(6,userid);
            pstmt.executeUpdate();
        }catch (Exception e){
        }
    }
}
