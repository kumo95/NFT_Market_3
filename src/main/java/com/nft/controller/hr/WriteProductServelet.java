package com.nft.controller.hr;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.dao.ProductDao;
import com.nft.dto.ProductVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/regist.do")
public class WriteProductServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 페이지로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/regist.jsp");
		dispatcher.forward(request, response);
				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ProductVo pVo = new ProductVo();
		ProductDao pDao = ProductDao.getInstance();
		
		int result = -1;
		String savePath = "upload";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("저장파일 서버경로: "+uploadFilePath);
		int uploadFileSizeLimit = 5* 1024 * 1024;
		String encType = "UTF-8";		
		try {
		
		MultipartRequest multi = new MultipartRequest(
				request,						// request 객체
				uploadFilePath,					// 서버상 실제 디렉토리
				uploadFileSizeLimit,			// 최대 업로드 파일 크기
				encType,						// 인코딩 방식
				new DefaultFileRenamePolicy()	// 정책: 동일 이름 존재시, 새로운 이름 부여
				);
		
		// 입력 양식을 통해 정보를 획득
//		int code = Integer.parseInt(multi.getParameter("code"));
		String creator = multi.getParameter("creator");
		String owner = multi.getParameter("owner");
		String unique_no = multi.getParameter("unique_no");
		String p_name = multi.getParameter("p_name");
		//int price = Integer.parseInt(multi.getParameter("price"));
		Double price = Double.parseDouble(multi.getParameter("price"));
		String nftUrl = multi.getFilesystemName("nftUrl");
		System.out.println(nftUrl);
		String newNftUrl = multi.getParameter("newNftUrl");
		System.out.println("확인1"+newNftUrl);
		String description = multi.getParameter("description");
		int edition = Integer.parseInt(multi.getParameter("edition"));
		Date reg_date = Date.valueOf(multi.getParameter("reg_date"));
		
//		System.out.println(code);
//		System.out.println(name);
//		System.out.println(price);
//		System.out.println(description);
//		System.out.println(pictureurl);
//		System.out.println(reg_date);
//		System.out.println(pVo);
		
//		pVo.setCode(code);
//		System.out.println(newNftUrl != null);
//		System.out.println(newNftUrl != "");
//		System.out.println(!newNftUrl.equals(""));
//		System.out.println(!newNftUrl.equals(null));
		pVo.setCreator(creator);
		pVo.setOwner(owner);
		pVo.setUnique_no(unique_no);
		pVo.setP_name(p_name);
		pVo.setPrice(price);
//		if(newNftUrl != "" || newNftUrl != null) {
		if(!newNftUrl.equals("")) {
			pVo.setNftUrl(newNftUrl);
			System.out.println("확인2"+newNftUrl);
		}else {
			pVo.setNftUrl(nftUrl);
			System.out.println(nftUrl);
		}
		pVo.setDescription(description);
		pVo.setEdition(edition);
		pVo.setReg_date(reg_date);
		
		} catch (Exception e) {
			System.out.println("파일 업로드간 예외 발생: " + e);
		}
		
		System.out.println(pVo);			// 입력된 상품 정보 디버깅
		result = pDao.insertProduct(pVo);	// 입력된 상품 정보 삽입
		
		// 정산적인 상품 등록 여부를 확인 / 정상 등록 메세지를 브라우저 출력 위해 저장
		// 상품 등록 완료 시, 메시지 출력
		if(result == 1) {
			System.out.println("상품등록 성공");
			request.setAttribute("message", "상품등록 성공했음");
		} else {
			System.out.println("상품등록 실패");
		}
		response.sendRedirect("productList.do");	// 상품 등록 후 리스트 확인 위해 페이지 이동
		
	}

}
