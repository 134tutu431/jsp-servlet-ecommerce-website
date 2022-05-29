package Controller.web;

import Dao.ManufacturerDao;
import Dao.ProductsDao;
import Dao.TypeDao;
import Dao.UserDao;
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
@WebServlet("/Catalog")
public class CatalogAllController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ProductsDao productsDao = new ProductsDao();
        TypeDao typeDao = new TypeDao();
        ManufacturerDao manufacturerDao = new ManufacturerDao();
        List<ProductsModel> list = productsDao.getProductsModels();
        List<TypeModel> listtype = typeDao.getTypeModels();
        List<ManufacturerModel> listmanu = manufacturerDao.getManufacturerModels();
        session.setAttribute("list",list);
        session.setAttribute("listtype",listtype);
        session.setAttribute("listmanu",listmanu);
        session.removeAttribute("typeid");
        req.getRequestDispatcher("/WebContent/views/Catalog.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

}
