package Controller.web;

import Dao.ManufacturerDao;
import Dao.ProductsDao;
import Dao.TypeDao;
import Model.ManufacturerModel;
import Model.ProductsModel;
import Model.TypeModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/EditProduct")
public class EditProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("proid");
        ProductsDao productsDao = new ProductsDao();
        ProductsModel productsModel = productsDao.getProductsModelsbyproid(id);
        ManufacturerDao manufacturerDao = new ManufacturerDao();
        List<ManufacturerModel> list2 = manufacturerDao.getManufacturerModels();
        TypeDao typeDao = new TypeDao();
        List<TypeModel> list1= typeDao.getTypeModels();
        req.setAttribute("listtype",list1);
        req.setAttribute("listmanu",list2);
        req.setAttribute("pro",productsModel);
        req.getRequestDispatcher("/WebContent/views/Edit_product.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
