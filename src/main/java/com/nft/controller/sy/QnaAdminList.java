package com.nft.controller.sy;

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
		
		 // 모든 QnA 리스트를 DB로부터 조회하여 출력
		List<QnaVo> qnaList = qDao.selectAllQnaAdmin();	// 하나의 페이지에 표시할 데이터
		//List<QnaVo> qnaList = qDao.getQnaList(column, keyword, page);
		//int count = qDao.getQnaCount(); // 디비에서 검색한 게시물 수
		
		request.setAttribute("qnaList", qnaList);
		//request.setAttribute("count", count);
		
		System.out.println(qnaList.size());
		System.out.println("qnaList: "+ qnaList);
		
		
		// 리스트 페이지로 이동
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("qna/admin_list.jsp");
		dispatcher.forward(request, response);

		System.out.println("qna/list: " + qnaList);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
