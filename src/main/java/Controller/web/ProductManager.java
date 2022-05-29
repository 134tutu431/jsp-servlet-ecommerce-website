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

@WebServlet("/Productmanageroder")
public class ProductManager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String oderby =req.getParameter("oderby");
        UserModel userModel = (UserModel) session.getAttribute("user");
        ProductsDao productsDao = new ProductsDao();
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
            if(oderby.equals("nameasc")){
                List<ProductsModel> list = productsDao.getProductsModelsoderbynameasc();
                session.setAttribute("list",list);
                req.setAttribute("total",total);
                req.getRequestDispatcher("/WebContent/views/Product_manager.jsp").forward(req,resp);
            }else if(oderby.equals("namedesc")){
                List<ProductsModel> list = productsDao.getProductsModelsoderbynamedesc();
                session.setAttribute("list",list);
                req.setAttribute("total",total);
                req.getRequestDispatcher("/WebContent/views/Product_manager.jsp").forward(req,resp);
            }else if(oderby.equals("priceasc")){
                List<ProductsModel> list = productsDao.getProductsModelsoderbypriceasc();
                session.setAttribute("list",list);
                req.setAttribute("total",total);
                req.getRequestDispatcher("/WebContent/views/Product_manager.jsp").forward(req,resp);
            }else if(oderby.equals("pricedesc")){
                List<ProductsModel> list = productsDao.getProductsModelsoderbypricedesc();
                session.setAttribute("list",list);
                req.setAttribute("total",total);
                req.getRequestDispatcher("/WebContent/views/Product_manager.jsp").forward(req,resp);
            }
        }else{
            total = productsDao.getTotalProductbysellid(id);
            if(oderby.equals("nameasc")){
                List<ProductsModel> list = productsDao.getProductsModelsoderbynameascandsellid(id);
                session.setAttribute("list",list);
                req.setAttribute("total",total);
                req.getRequestDispatcher("/WebContent/views/Product_manager.jsp").forward(req,resp);
            }else if(oderby.equals("namedesc")){
                List<ProductsModel> list = productsDao.getProductsModelsoderbynamedescandsellid(id);
                session.setAttribute("list",list);
                req.setAttribute("total",total);
                req.getRequestDispatcher("/WebContent/views/Product_manager.jsp").forward(req,resp);
            }else if(oderby.equals("priceasc")){
                List<ProductsModel> list = productsDao.getProductsModelsoderbypriceascandsellid(id);
                session.setAttribute("list",list);
                req.setAttribute("total",total);
                req.getRequestDispatcher("/WebContent/views/Product_manager.jsp").forward(req,resp);
            }else if(oderby.equals("pricedesc")){
                List<ProductsModel> list = productsDao.getProductsModelsoderbypricedescandsellid(id);
                session.setAttribute("list",list);
                req.setAttribute("total",total);
                req.getRequestDispatcher("/WebContent/views/Product_manager.jsp").forward(req,resp);

            }

        }

    }
}
