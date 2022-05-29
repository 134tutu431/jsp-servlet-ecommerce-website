package Dao;

import DB.ConnectDB;
import Model.QuangCaoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuangCaoDao {
    public List<QuangCaoModel> getQuangCaoModels(){
        try {
            String sql = "select * from QUANGCAOTB  ";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<QuangCaoModel> list = new ArrayList<>();
            while (rs.next()){
                QuangCaoModel quangCaoModel = new QuangCaoModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
                list.add(quangCaoModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
}
