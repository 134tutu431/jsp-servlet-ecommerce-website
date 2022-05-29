package Dao;

import DB.ConnectDB;
import Model.ChitietModel;
import Model.ProductsModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductsDao {
    public List<ProductsModel> getProductsModelsHome(){
        try {
            String sql = "select top(4) * from PRODUCTSTB";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<ProductsModel> list = new ArrayList<>();
            while (rs.next()){
                ProductsModel productsModel = new ProductsModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(productsModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public List<ProductsModel> getProductsModels(){
        try {
            String sql = "select * from PRODUCTSTB";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<ProductsModel> list = new ArrayList<>();
            while (rs.next()){
                ProductsModel productsModel = new ProductsModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(productsModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public List<ProductsModel> getProductsModelsbyTypeid(String typeid){
        try {
            String sql = "select * from PRODUCTSTB where typeid = ? ";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,typeid);
            ResultSet rs = pstmt.executeQuery();
            List<ProductsModel> list = new ArrayList<>();
            while (rs.next()){
                ProductsModel productsModel = new ProductsModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(productsModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }

    public List<ProductsModel> getProductsModelsbyManuid(String manuid){
        try {
            String sql = "select * from PRODUCTSTB where manuid = ? ";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,manuid);
            ResultSet rs = pstmt.executeQuery();
            List<ProductsModel> list = new ArrayList<>();
            while (rs.next()){
                ProductsModel productsModel = new ProductsModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(productsModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public List<ProductsModel> getProductsModelsoderbynameasc(){
        try {
            String sql = "SELECT * FROM PRODUCTSTB\n" +
                    " ORDER BY proname ASC;";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<ProductsModel> list = new ArrayList<>();
            while (rs.next()){
                ProductsModel productsModel = new ProductsModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(productsModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public List<ProductsModel> getProductsModelsoderbynamedesc(){
        try {
            String sql = "SELECT * FROM PRODUCTSTB\n" +
                    " ORDER BY proname DESC;";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<ProductsModel> list = new ArrayList<>();
            while (rs.next()){
                ProductsModel productsModel = new ProductsModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(productsModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public List<ProductsModel> getProductsModelsoderbypriceasc(){
        try {
            String sql = "SELECT * FROM PRODUCTSTB ORDER BY proprice asc;";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<ProductsModel> list = new ArrayList<>();
            while (rs.next()){
                ProductsModel productsModel = new ProductsModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(productsModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public List<ProductsModel> getProductsModelsoderbypricedesc(){
        try {
            String sql = "SELECT * FROM PRODUCTSTB ORDER BY proprice desc;";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<ProductsModel> list = new ArrayList<>();
            while (rs.next()){
                ProductsModel productsModel = new ProductsModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(productsModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public List<ProductsModel> getProductsModelsoderbysellid(int sellid){
        try {
            String sql = "SELECT * FROM PRODUCTSTB WHERE sell_id = ?;";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,sellid);
            ResultSet rs = pstmt.executeQuery();
            List<ProductsModel> list = new ArrayList<>();
            while (rs.next()){
                ProductsModel productsModel = new ProductsModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(productsModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public void deleteProduct(String proid){
        try {
            String sql = "DELETE  FROM PRODUCTSTB WHERE id = ?;";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,proid);
            pstmt.executeUpdate();
        }catch (Exception e){

        }
    }
    public void addProduct(String proname, String proprice, String pricethrough,String type, String image, String decription,String typeid,String manuid, int id) throws Exception {
        try {
            String sql = "Insert into PRODUCTSTB(proname,proprice,pricethrough,type,image,description,typeid,manuid,sell_id)" + "values(?,?,?,?,?,?,?,?,?)";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,proname);
            pstmt.setString(2,proprice);
            pstmt.setString(3,pricethrough);
            pstmt.setString(4,type);
            pstmt.setString(5,image);
            pstmt.setString(6,decription);
            pstmt.setString(7,typeid);
            pstmt.setString(8,manuid);
            pstmt.setInt(9,id);
            pstmt.executeUpdate();
        }catch (Exception e){

        }
    }
    public List<ProductsModel> getProductsModelsbysearch(String search,int sellid){
        try {
            String sql = "SELECT * FROM PRODUCTSTB WHERE sell_id= ? and proname like ?;";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,sellid);
            pstmt.setString(2,"%"+search+"%");
            ResultSet rs = pstmt.executeQuery();
            List<ProductsModel> list = new ArrayList<>();
            while (rs.next()){
                ProductsModel productsModel = new ProductsModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(productsModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public List<ProductsModel> getProductsModelsbysearchnoid(String search){
        try {
            String sql = "SELECT * FROM PRODUCTSTB where proname like ?;";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,"%"+search+"%");
            ResultSet rs = pstmt.executeQuery();
            List<ProductsModel> list = new ArrayList<>();
            while (rs.next()){
                ProductsModel productsModel = new ProductsModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(productsModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public List<ProductsModel> getProductsModelsoderbynameascandsellid(int sellid){
        try {
            String sql = "SELECT * FROM PRODUCTSTB WHERE sell_id = ? \n" +
                    " ORDER BY proname ASC;";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,sellid);
            ResultSet rs = pstmt.executeQuery();
            List<ProductsModel> list = new ArrayList<>();
            while (rs.next()){
                ProductsModel productsModel = new ProductsModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(productsModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public List<ProductsModel> getProductsModelsoderbynamedescandsellid(int sellid){
        try {
            String sql = "SELECT * FROM PRODUCTSTB WHERE sell_id = ? \n" +
                    " ORDER BY proname DESC;";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,sellid);
            ResultSet rs = pstmt.executeQuery();
            List<ProductsModel> list = new ArrayList<>();
            while (rs.next()){
                ProductsModel productsModel = new ProductsModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(productsModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public List<ProductsModel> getProductsModelsoderbypriceascandsellid(int sellid){
        try {
            String sql = "SELECT * FROM PRODUCTSTB WHERE sell_id = ? \n" +
                    " ORDER BY proprice ASC;";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,sellid);
            ResultSet rs = pstmt.executeQuery();
            List<ProductsModel> list = new ArrayList<>();
            while (rs.next()){
                ProductsModel productsModel = new ProductsModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(productsModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public List<ProductsModel> getProductsModelsoderbypricedescandsellid(int sellid){
        try {
            String sql = "SELECT * FROM PRODUCTSTB WHERE sell_id = ? \n" +
                    " ORDER BY proprice DESC;";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,sellid);
            ResultSet rs = pstmt.executeQuery();
            List<ProductsModel> list = new ArrayList<>();
            while (rs.next()){
                ProductsModel productsModel = new ProductsModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(9));
                list.add(productsModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public ProductsModel getProductsModelsbyproid(String proid){
        try {
            String sql = "SELECT * FROM PRODUCTSTB WHERE id = ? ";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,proid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                return new ProductsModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(8), rs.getString(6), rs.getString(7));
            }
        }catch (Exception e){
        }
        return null;
    }
    public void updateProduct(String proid,String proname, String proprice, String pricethrough,String type, String image, String decription,String typeid,String manuid, int id) throws Exception {
        try {
            String sql = "UPDATE PRODUCTSTB set  proname=?,proprice=?,pricethrough =?,type=? ,image=?,description =?,typeid =?,manuid =?,sell_id =? where id=?";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,proname);
            pstmt.setString(2,proprice);
            pstmt.setString(3,pricethrough);
            pstmt.setString(4,type);
            pstmt.setString(5,image);
            pstmt.setString(6,decription);
            pstmt.setString(7,typeid);
            pstmt.setString(8,manuid);
            pstmt.setInt(9,id);
            pstmt.setString(10,proid);
            pstmt.executeUpdate();
        }catch (Exception e){
        }
    }
    public int getTotalProductbysellid(int sellid){
        try {
            String sql = "SELECT count(*) FROM PRODUCTSTB where sell_id = ?";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,sellid);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch (Exception e){
        }
        return 0;
    }
    public int getTotalProductbysellid(){
        try {
            String sql = "SELECT count(*) FROM PRODUCTSTB";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch (Exception e){
        }
        return 0;
    }
}
