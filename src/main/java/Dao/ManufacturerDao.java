package Dao;

import DB.ConnectDB;
import Model.ManufacturerModel;
import Model.TypeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerDao {
    public List<ManufacturerModel> getManufacturerModels(){
        try {
            String sql = "select * from MANUFACTURERTB  ";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<ManufacturerModel> list = new ArrayList<>();
            while (rs.next()){
                ManufacturerModel manufacturerModel = new ManufacturerModel(rs.getInt(1),rs.getString(2));
                list.add(manufacturerModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
}
