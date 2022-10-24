package com.nft.mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nft.dao.EmailDao;

@SuppressWarnings("unused")
@WebServlet("/sendEmail.do")
public class SendEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// 포스트 방식 한글 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();		// 웹페이지 출력 처리
		
		int result;
		String e_wallet = request.getParameter("e_wallet");		
		String userid = request.getParameter("userid");		
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String phone = request.getParameter("phone");
		if(request.getParameter("idColorControll") != "") {
			int idColorControll = Integer.parseInt(request.getParameter("idColorControll"));
			System.out.println(request.getParameter("idColorControll"));
			System.out.println(idColorControll);
			if(idColorControll==1) {
				request.setAttribute("idColor", idColorControll);
			}else if(idColorControll==-1) {
				request.setAttribute("idColor", idColorControll);
			}
		}
				
		request.setAttribute("userid", userid);
		request.setAttribute("name", name);
		request.setAttribute("birth", birth);
		request.setAttribute("e_wallet", e_wallet);
		request.setAttribute("phone", phone);
		
		EmailDao eDao = EmailDao.getInstance();
		result = eDao.checkSameEmail(e_wallet);
		System.out.println(result);
		if(result == 1) {
			request.setAttribute("emailColor", -1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/signUp.jsp");
			dispatcher.forward(request, response);
		}else if(result == 0) {
			request.setAttribute("emailColor", 1);
		}
		
		
		// 먼저 아이디로 회원정보를 받아오고 가져온 데이터에서 email값을 비교하여 존재하지 않으면 인증메일 보내지 못함
		/*
		 * Member m = new MemberService().memberLogin(memberId); if(m==null ||
		 * !m.getEmail().equals(email)) { req.setAttribute("msg",
		 * "아이디나 이메일 정보가 맞지 않습니다"); req.setAttribute("loc", "/member/searchPw");
		 * req.getRequestDispatcher("/views/common/msg.jsp").forward(request, response); return;
		 * }
		 */
		// mail server 설정
		String host = "smtp.naver.com";
		String user = "bin952163@naver.com"; // 자신의 네이버 계정
		String password = "VKVQGBHC3QVW";// 자신의 네이버 패스워드

		// 메일 받을 주소
		/* String to_email = m.getEmail(); */
		String to_email = e_wallet;

		// SMTP 서버 정보를 설정한다.
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		
		
			
		// 인증 번호 생성기
		// StringBuffer : 문자열을 추가하거나 변경 할 때 주로 사용하는 자료형
		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();
		// 10개의 대소문자 + 숫자 난수를 생성하는 코드
		for (int i = 0; i < 10; i++) {
			// random 함수를 사용하여 0,1,2를 랜덤으로 생성한 후 case를 실행
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			// char 형태로 랜덤 아스키코드를 temp 변수에 추가
			case 0:
				// a-z
				temp.append((char) ((int) (rnd.nextInt(26)) + 97));
				break;
			case 1:
				// A-Z
				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 2:
				// 0-9
				temp.append((rnd.nextInt(10)));
				break;
			}
		}
		// 인증번호
		String AuthenticationKey = temp.toString();
//		System.out.println(AuthenticationKey);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
//		System.out.print("세션:");
//		System.out.println(session);
		// email 전송
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(user, "NFTiqueMarket"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));

			// 메일 제목
			msg.setSubject("안녕하세요  인증 메일입니다.");
			// 메일 내용
			msg.setText("인증 번호는 :" + temp);

			Transport.send(msg);
//			System.out.println("이메일 전송");
						
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}

		// 세션설정
		HttpSession saveKey = request.getSession();
		saveKey.setAttribute("AuthenticationKey", AuthenticationKey);
		// 세션의 시간 설정
		saveKey.setMaxInactiveInterval(5*60);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/signUp.jsp");
		dispatcher.forward(request, response);		// 페이지 이동
		
		// 패스워드 바꿀때 뭘 바꿀지 조건에 들어가는 id
		/*
		 * request.setAttribute("id", memberId);
		 * request.getRequestDispatcher("/views/login_myPage/searchPasswordEnd.jsp").forward
		 * (request, response);
		 */
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}		
		

}
