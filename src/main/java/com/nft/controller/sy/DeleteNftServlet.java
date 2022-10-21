package com.nft.controller.sy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.dao.ProductDao;
import com.nft.dto.ProductVo;


@WebServlet("/deleteNft.do")
public class DeleteNftServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상품 삭제 링크 클릭시 삭제할 상품 정보 표시
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		
		// 퀘리 스트링으로 전달 받은 code를 획득
		String unique_no = request.getParameter("unique_no");

		// DB에서 삭제할 데이터 정보 확인
		pVo = pDao.selectProductByCode(unique_no);

		request.setAttribute("product", pVo);

		// 페이지 이동 : 삭제 페이지
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("nft/deleteNft.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상품 삭제 코드 : 데이터베이스에서 상품 삭제
		request.setCharacterEncoding("UTF-8");		// 포스트 방식 한글 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();	
		
		String unique_no = request.getParameter("unique_no");
		System.out.println("unique_no 삭제: "+ unique_no);
		
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();

		
		// DB로부터 해당 코드의 정보 삭제
		pDao.deleteProduct(unique_no);

		// 삭제 후 목록 페이지로 이동
		response.sendRedirect("nftList.do");
		
	}

}
