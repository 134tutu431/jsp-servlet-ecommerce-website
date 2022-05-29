package Controller.web;

import Dao.ProductsDao;
import Model.ProductsModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteProduct")
public class ProductDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String proid = req.getParameter("proid");
        ProductsDao productsDao = new ProductsDao();
        productsDao.deleteProduct(proid);
        resp.sendRedirect("ManagerProduct");
    }
}
