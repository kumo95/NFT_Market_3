package com.nft.controller.hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.dao.ProductDao;
import com.nft.dto.ProductVo;

@WebServlet("/productDetail.do")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String unique_no = request.getParameter("unique_no");
//		out.println("상품코드"+code);
		
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		
		pVo = pDao.selectProductByCode(unique_no);
		System.out.println(pVo);
		
		request.setAttribute("product", pVo);
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("product/productDetail.jsp");
//		dispatcher.forward(request, response);
		
		
		String creator = pVo.getCreator();
		// 관련상품		
		// 모든 상품 리스트를 디비로부터 조회하여 저장		
//		ProductVo[] productList = pDao.selectAllProducts();
		List<ProductVo> productList = pDao.selectCreatorProducts(creator);
		request.setAttribute("productList", productList);
		System.out.println();
		
		
		
		// 상품디테일 페이지로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/productDetail.jsp");
		dispatcher.forward(request, response);
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
