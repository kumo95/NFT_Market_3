package com.nft.controller.hr;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.dao.ProductDao;
import com.nft.dto.ProductVo;

@WebServlet("/productList.do")
public class ProductListServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		int page = 1;
		
		//기본값 설정 (검색) 
		String column= "p_name";	// 검색 대상(분야)
		String keyword = ""; 	// 검색 내용(검색어)
		// 기본 입력 양식으로 부터 받은 검색 대상과 내용을 가져옴
		String t_column = request.getParameter("column");
		String t_keyword = request.getParameter("keyword");
		//검색 대상, 내용이 null이거나 ""이 아니라면, 사용
		if(t_column != null && !t_column.equals(""))
			column = t_column;
		if(t_keyword != null && !t_keyword.equals(""))
			keyword = t_keyword;
		
		
		//기본값 설정 (페이지) 
		String t_page = request.getParameter("p");
		
		if(t_page != null && !t_page.equals("")) {
			page = Integer.parseInt(t_page);
		}
		
		// DB 데이터 조회
		//List<BoardVo> boardList = bDao.selectAllBoards(); // 모든 행 데이터 표시
		//List<BoardVo> boardList = bDao.getBoardList(page);		// 하나의 페이지에 표시할 데이터
		List<ProductVo> productList = pDao.getProductList(column, keyword, page);
		int count = pDao.getProductCount(column, keyword);					// 디비에서 검색한 게시물 수
		request.setAttribute("productList", productList);
		request.setAttribute("count", count);
		
		
		
		// 리스트 페이지로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/productList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
