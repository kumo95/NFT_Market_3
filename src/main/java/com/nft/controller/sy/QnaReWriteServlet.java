package com.nft.controller.sy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.dao.QnaDao;
import com.nft.dto.QnaVo;


@WebServlet("/qnaReWrite.do")
public class QnaReWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("qna/reWrite.jsp");
		dispatcher.forward(request, response); // 포워드 방식으로 페이지 이동
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // post방식 한글 처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// QNA 등록 데이터 처리
		QnaDao qDao = QnaDao.getInstance();
		QnaVo qVo = new QnaVo();

		qDao.reInsertQna(qVo);
		
		response.sendRedirect("qnaList.do"); // 상품 등록 후 리스트 확인 위해 페이지 이동
		
		
		
		
	}

}
