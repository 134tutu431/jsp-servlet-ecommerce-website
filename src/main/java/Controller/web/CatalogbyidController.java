package Controller.web;

import Dao.ProductsDao;
import Model.ProductsModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Catalogbyid")
public class CatalogbyidController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String typeid =req.getParameter("typeid");
        String manuid = req.getParameter("manuid");
        ProductsDao productsDao = new ProductsDao();
        List<ProductsModel> list = productsDao.getProductsModelsbyTypeid(typeid);
        List<ProductsModel> list1 = productsDao.getProductsModelsbyManuid(manuid);
        if(typeid==null){
            req.setAttribute("list",list1);
        }else {
            req.setAttribute("list",list);
        }
        req.setAttribute("checked",typeid);
        req.setAttribute("checkedmanu",manuid);
        req.getRequestDispatcher("/WebContent/views/Catalog.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
