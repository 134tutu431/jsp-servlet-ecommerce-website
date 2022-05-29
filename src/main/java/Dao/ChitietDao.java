package Dao;

import DB.ConnectDB;
import Model.CarouselModel;
import Model.ChitietModel;
import Model.ProductsModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChitietDao {
    public List<ChitietModel> getChitietModels(){
        try {
            String sql = "select * from CHITIETTB  ";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<ChitietModel> list = new ArrayList<>();
            while (rs.next()){
                ChitietModel chitietModel = new ChitietModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20));
                list.add(chitietModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
    public ChitietModel getChitietModelsbyid(String id){
        try {
            String sql = "select * from CHITIETTB where id = ? ";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                return new ChitietModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20));

            }

        }catch (Exception e){
        }
        return null;
    }
}
