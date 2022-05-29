package Dao;

import DB.ConnectDB;
import Model.NewProductsModel;
import Model.QuangCaoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NewProductsDao {
    public List<NewProductsModel> getNewProductsModels(){
        try {
            String sql = "select top(3) * from PRODUCTSTB ORDER BY ID DESC ";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<NewProductsModel> list = new ArrayList<>();
            while (rs.next()){
                NewProductsModel newProductsModel = new NewProductsModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(newProductsModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
}
