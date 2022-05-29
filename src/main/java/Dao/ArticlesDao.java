package Dao;

import DB.ConnectDB;
import Model.ArticlesModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticlesDao {
    public List<ArticlesModel> getArticlesModelsHome(){
        try {
            String sql = "select top(2) * from ARTICLESTB  ";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<ArticlesModel> list = new ArrayList<>();
            while (rs.next()){
                ArticlesModel articlesModel = new ArticlesModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(articlesModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public List<ArticlesModel> getArticlesModels(){
        try {
            String sql = "select * from ARTICLESTB  ";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<ArticlesModel> list = new ArrayList<>();
            while (rs.next()){
                ArticlesModel articlesModel = new ArticlesModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(articlesModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public ArticlesModel getArticlesModelbyid(String arid){
        try {
            String sql = "select * from ARTICLESTB where id = ? ";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,arid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
               return  new ArticlesModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
            }
        }catch (Exception e){
        }
        return null;
    }
}
