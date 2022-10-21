package com.nft.controller.hr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/makeFile.do")
public class MakeFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 페이지로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/makeNFTFile.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
//		ProductVo pVo = new ProductVo();
//		ProductDao pDao = ProductDao.getInstance();
		
		
//		int result = -1;
		String savePath = "upload";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("저장파일 서버경로: "+uploadFilePath);
		int uploadFileSizeLimit = 5* 1024 * 1024;
		String encType = "UTF-8";
//		try {
//			
			MultipartRequest multi = new MultipartRequest(
					request,						// request 객체
					uploadFilePath,					// 서버상 실제 디렉토리
					uploadFileSizeLimit,			// 최대 업로드 파일 크기
					encType,						// 인코딩 방식
					new DefaultFileRenamePolicy()	// 정책: 동일 이름 존재시, 새로운 이름 부여
					);
			
			String nftUrl = multi.getFilesystemName("nftUrl");
			System.out.println(nftUrl);
//			
			request.setAttribute("nftUrl", nftUrl);
			//request.getParameter(nftUrl);
//			pVo.setNftUrl(nftUrl);
//		
//		} catch (Exception e) {
//			System.out.println("파일 업로드간 예외 발생: " + e);
//		}
			
		//response.sendRedirect("productList.do");	
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/makeNFT.jsp");
		dispatcher.forward(request, response);
			
	}
	

}
