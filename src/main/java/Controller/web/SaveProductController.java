package Controller.web;

import Dao.ManufacturerDao;
import Dao.ProductsDao;
import Dao.TypeDao;
import Model.ManufacturerModel;
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

@WebServlet("/SaveProduct")
public class SaveProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("ManagerProduct").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String proid = req.getParameter("id");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String pricethrought = req.getParameter("pricethrought");
        String image = req.getParameter("image");
        String description = req.getParameter("description");
        String typeid = req.getParameter("type");
        String type = null;
        if(typeid.equalsIgnoreCase("1")){
            type = "Laptops";
        }else if(typeid.equalsIgnoreCase("2")){
            type = "Hybrids";
        }else {
            type = "Tablets";
        }
        String manuid = req.getParameter("manuid");
        HttpSession session = req.getSession();
        UserModel userModel = (UserModel) session.getAttribute("user");
        int id = userModel.getId();
        ProductsDao productsDao = new ProductsDao();
        try {
            productsDao.updateProduct(proid,name,price,pricethrought,type,image,description,typeid,manuid,id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("ManagerProduct");
    }
}
