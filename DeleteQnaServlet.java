package com.nft.controller;

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

@WebServlet("/deleteQna.do")
public class DeleteQnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// QNA 삭제 링크 클릭시 삭제할 정보 표시
		QnaDao qDao = QnaDao.getInstance();
		QnaVo qVo = new QnaVo();

		// 퀘리 스트링으로 전달 받은 no를 획득
		String no = request.getParameter("no");

		// DB에서 삭제할 데이터 정보 확인
		qVo = qDao.getQna(no);

		System.out.println("삭제할 정보 확인: " + no);

		request.setAttribute("qna", qVo);

		// 페이지 이동 : 삭제 페이지
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin_qna/delete.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 상품 삭제 코드 : DB에서 상품 삭제
		request.setCharacterEncoding("UTF-8"); // 포스트 방식 한글 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String no = request.getParameter("no");
		System.out.println("no 삭제: " + no);

		QnaDao qDao = QnaDao.getInstance();
		QnaVo qVo = new QnaVo();

		// DB로부터 해당 코드의 정보 삭제
		qDao.deleteQna(no);

		// 삭제 후 목록 페이지로 이동
		response.sendRedirect("qnaList.do");
	}

}
