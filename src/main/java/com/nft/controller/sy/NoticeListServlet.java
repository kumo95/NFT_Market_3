package com.nft.controller.sy;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.dao.NoticeDao;
import com.nft.dto.NoticeVo;

@WebServlet("/noticeList.do")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeDao nDao = NoticeDao.getInstance();

		// 모든 QnA 리스트를 DB로부터 조회하여 출력
		//List<NoticeVo> noticeList = nDao.selectAllNotice();
		
		
		//System.out.println(noticeList.size());
		//System.out.println("noticeList: " + noticeList);

		// 하나의 페이지에 표시할 데이터
		List<NoticeVo> noticeList = nDao.getNoticeList();
		request.setAttribute("noticeList", noticeList);
		
		// 리스트 페이지로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("notice/list.jsp");
		dispatcher.forward(request, response);

		System.out.println("notice/list: " + noticeList);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
