package Dao;

import DB.ConnectDB;
import Model.GalleryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GalleryDao {
    public List<GalleryModel> getGalleryModels(){
        try {
            String sql = "select * from GALLERYTB ";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<GalleryModel> list = new ArrayList<>();
            while (rs.next()){
                GalleryModel galleryModel = new GalleryModel(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4));
                list.add(galleryModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
}
