package in.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dao.ProdDao;
import in.dto.ProdDTO;

@WebServlet("/productsearch")
public class ProdSearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		List<ProdDTO> prodList = null;
		// call dao method
		ProdDao dao = new ProdDao();
		// capture data based on ProductId
		String pid = req.getParameter("Product_Id");
		// condition if pid != null and empty then list will get based on Id
		if (pid != null && !pid.equals("")) {
			int prodId = Integer.parseInt(pid);
			prodList = dao.getProds(prodId);
		} else {
			prodList = dao.getProds(null);
		}
		// sending data to jsp
		req.setAttribute("prods", prodList);
		// redirect req
		req.getRequestDispatcher("search.jsp").include(req, res);
	}

}
