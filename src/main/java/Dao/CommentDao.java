package Dao;

import DB.ConnectDB;
import Model.ArticlesModel;
import Model.CommentModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    public List<CommentModel> commentModelsbyproid(String proid){
        try {
            String sql = "select  * from COMMENTTB where proid = ? order by date desc";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,proid);
            ResultSet rs = pstmt.executeQuery();
            List<CommentModel> list = new ArrayList<>();
            while (rs.next()){
                CommentModel commentModel = new CommentModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
                list.add(commentModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public void addComment(String comment, String name, String proid,String date) throws Exception {
        try {
            String sql = "Insert into COMMENTTB(comment,name,proid,date)" + "values(?,?,?,?)";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,comment);
            pstmt.setString(2,name);
            pstmt.setString(3,proid);
            pstmt.setString(4,date);
            pstmt.executeUpdate();
        }catch (Exception e){

        }
    }
}
