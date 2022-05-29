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
import java.util.List;

@WebServlet("/Productmanagersearch")
public class ProductManagerOderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WebContent/views/Product_manager.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        HttpSession session = req.getSession();
        ProductsDao productsDao = new ProductsDao();
        UserModel userModel = (UserModel) session.getAttribute("user");
        int id = userModel.getId();
        int total;
        ManufacturerDao manufacturerDao = new ManufacturerDao();
        List<ManufacturerModel> list2 = manufacturerDao.getManufacturerModels();
        TypeDao typeDao = new TypeDao();
        List<TypeModel> list1= typeDao.getTypeModels();
        req.setAttribute("listtype",list1);
        req.setAttribute("listmanu",list2);
        if(userModel.getRole()==1){
            total = productsDao.getTotalProductbysellid();
            List<ProductsModel> list = productsDao.getProductsModelsbysearchnoid(search);
            req.setAttribute("list",list);
        }else{
            total = productsDao.getTotalProductbysellid(id);
            List<ProductsModel> list = productsDao.getProductsModelsbysearch(search,id);
            req.setAttribute("list",list);
        }
        req.setAttribute("total",total);
        req.getRequestDispatcher("/WebContent/views/Product_manager.jsp").forward(req,resp);

    }
}
