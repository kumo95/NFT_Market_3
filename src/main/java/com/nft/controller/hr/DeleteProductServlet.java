package com.nft.controller.hr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.dao.ProductDao;
import com.nft.dto.ProductVo;

@WebServlet("/deleteProduct.do")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿼리스트링으로 전달 받은 code를 획득
		String unique_no = request.getParameter("code");
		
		// 상품 삭제 링크 클릭시 이동하여 삭제할 상품 정보를 표시
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		
		// 데이터베이스에서 삭제할 데이터 정보 확인
		pVo = pDao.selectProductByCode(unique_no);
		
		request.setAttribute("product", pVo);
		
		// 페이지 이동 : 삭제 페이지
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/deleteProduct.jsp");
		dispatcher.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상품 삭제 코드 : 데이터베이스에서 상품 삭제
		
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		
		String unique_no = request.getParameter("unique_no");
		
		// 데이터베이스로부터 해당 코드의 정보를 삭제
		pDao.deleteProduct(unique_no);
		
//		삭제후 목록 페이지로 이동
		response.sendRedirect("productList.do");
		
	}

}
