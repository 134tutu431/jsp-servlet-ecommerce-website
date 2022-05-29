package Controller.web;

import Dao.ManufacturerDao;
import Dao.ProductsDao;
import Dao.TypeDao;
import Model.ManufacturerModel;
import Model.ProductsModel;
import Model.TypeModel;
import Model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ManagerProduct")
public class ManagerproController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserModel userModel = (UserModel) session.getAttribute("user");
        int id = userModel.getId();
        int role = userModel.getRole();
        if (role != 0){
            ManufacturerDao manufacturerDao = new ManufacturerDao();
            List<ManufacturerModel> list2 = manufacturerDao.getManufacturerModels();
            TypeDao typeDao = new TypeDao();
            List<TypeModel> list1= typeDao.getTypeModels();
            ProductsDao productsDao = new ProductsDao();
            List<ProductsModel> list;
            if(userModel.getRole()==1){
                list = productsDao.getProductsModels();
                int total = productsDao.getTotalProductbysellid();
                req.setAttribute("total",total);
            }else{
                list = productsDao.getProductsModelsoderbysellid(id);
                int total = productsDao.getTotalProductbysellid(id);
                req.setAttribute("total",total);
            }
            req.setAttribute("listtype",list1);
            req.setAttribute("listmanu",list2);
            req.setAttribute("list",list);
            req.getRequestDispatcher("/WebContent/views/Product_manager.jsp").forward(req,resp);
        }


    }
}
