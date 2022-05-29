package Dao;

import DB.ConnectDB;
import Model.QuangCaoModel;
import Model.TypeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TypeDao {
    public List<TypeModel> getTypeModels(){
        try {
            String sql = "select * from TYPETB  ";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<TypeModel> list = new ArrayList<>();
            while (rs.next()){
                TypeModel typeModel = new TypeModel(rs.getInt(1),rs.getString(2));
                list.add(typeModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
}
