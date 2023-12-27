package in.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dao.ProdDao;
import in.dto.ProdDTO;

@WebServlet("/product")
public class ProdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// call dao method
		ProdDao dao = new ProdDao();
		List<ProdDTO> prodList = dao.getProds(null);// for id taking null as an parameter in dao.getProds()

		// sending data to jsp
		req.setAttribute("prods", prodList);

		// redirect req
		RequestDispatcher dispatcher = req.getRequestDispatcher("search.jsp");
		dispatcher.include(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// capture form data
		String pname = req.getParameter("Product_Name");
		String pprice = req.getParameter("Product_Price");
		String qty = req.getParameter("Product_Qty");

		// convert data into dto
		ProdDTO dto = new ProdDTO();
		dto.setProdName(pname);
		dto.setProdPrice(Integer.parseInt(pprice));
		dto.setProdQty(Integer.parseInt(qty));

		// call dao method
		ProdDao dao = new ProdDao();
		// save product using dao
		boolean isSaved = dao.saveProd(dto);

		if (isSaved) {
			req.setAttribute("success", "Inserted Successfully!!!!");
			RequestDispatcher dispatcher = req.getRequestDispatcher("productForm.jsp");
			dispatcher.include(req, res);
		} else {
			req.setAttribute("error", "ERROR OCURRING....");
			RequestDispatcher dispatcher = req.getRequestDispatcher("errorPage.jsp");
			dispatcher.include(req, res);
		}
	}
}
