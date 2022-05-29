package Dao;

import DB.ConnectDB;
import Model.CarouselModel;
import Model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarouselDao
{
    public List<CarouselModel> getCarouselModels(){
        try {
            String sql = "select * from CAROUSELTB  ";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<CarouselModel> list = new ArrayList<>();
            while (rs.next()){
                CarouselModel carouselModel = new CarouselModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(carouselModel);
            }
            return list;
        }catch (Exception e){
        }
        return null;
    }
}

