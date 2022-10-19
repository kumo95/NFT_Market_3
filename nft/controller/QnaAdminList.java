package com.nft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.dao.QnaDao;
import com.nft.dto.QnaVo;


@WebServlet("/qnaAdminList.do")
public class QnaAdminList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QnaDao qDao = QnaDao.getInstance();
		/*
		 * String column = "bno"; // 검색 내용 String keyword = ""; int page = 1;
		 * 
		 * // 검색양식으로부터 받은 검색 대상과 내용을 가져옴 String t_column =
		 * request.getParameter("column"); String t_keyword =
		 * request.getParameter("keyword"); String t_page = request.getParameter("p");
		 * 
		 * // 검색 대상이 ""이 아니라면 사용 if(t_page!=null && t_page.equals("")) {
		 * page=Integer.parseInt(t_page); } if(t_keyword!=null && t_keyword.equals(""))
		 * { keyword=t_keyword; } if(t_page!=null && t_page.equals("")) {
		 * page=Integer.parseInt(t_page); }
		 */
		 // 모든 QnA 리스트를 DB로부터 조회하여 출력
		List<QnaVo> qnaList = qDao.selectAllQna();	// 하나의 페이지에 표시할 데이터
		//List<QnaVo> qnaList = qDao.getQnaList(column, keyword, page);
		//int count = qDao.getQnaCount(); // 디비에서 검색한 게시물 수
		
		request.setAttribute("qnaList", qnaList);
		//request.setAttribute("count", count);
		
		//System.out.println(qnaList.size());
		//System.out.println("qnaList: "+ qnaList);
		
		
		// 리스트 페이지로 이동
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("qna/admin_list.jsp");
		dispatcher.forward(request, response);

		//System.out.println("qna/list: " + qnaList);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
