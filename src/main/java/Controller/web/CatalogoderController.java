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

@WebServlet("/Catalogoder")
public class CatalogoderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String oderby =req.getParameter("oderby");
        if(oderby.equals("nameasc")){
            ProductsDao productsDao = new ProductsDao();
            List<ProductsModel> list = productsDao.getProductsModelsoderbynameasc();
            session.setAttribute("list",list);
            session.setAttribute("checkedoder",oderby);
            req.getRequestDispatcher("/WebContent/views/Catalog.jsp").forward(req,resp);
        }else if(oderby.equals("namedesc")){
            ProductsDao productsDao = new ProductsDao();
            List<ProductsModel> list = productsDao.getProductsModelsoderbynamedesc();
            session.setAttribute("list",list);
            req.getRequestDispatcher("/WebContent/views/Catalog.jsp").forward(req,resp);
        }else if(oderby.equals("priceasc")){
            ProductsDao productsDao = new ProductsDao();
            List<ProductsModel> list = productsDao.getProductsModelsoderbypriceasc();
            session.setAttribute("list",list);
            req.getRequestDispatcher("/WebContent/views/Catalog.jsp").forward(req,resp);
        }else if(oderby.equals("pricedesc")){
            ProductsDao productsDao = new ProductsDao();
            List<ProductsModel> list = productsDao.getProductsModelsoderbypricedesc();
            session.setAttribute("list",list);
            req.getRequestDispatcher("/WebContent/views/Catalog.jsp").forward(req,resp);
        }
    }
}
