package Dao;

import DB.ConnectDB;
import Model.GalleryModel;
import Model.RoleModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDao {
    public List<RoleModel> getRoleModels(){
        try {
            String sql = "select * from ROLETB EXCEPT select * from ROLETB WHERE id =1 ";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<RoleModel> list = new ArrayList<>();
            while (rs.next()){
                RoleModel roleModel = new RoleModel(rs.getInt(1),rs.getString(2));
                list.add(roleModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
}
