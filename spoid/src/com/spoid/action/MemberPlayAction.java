package com.spoid.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spoid.dao.MemberDAO;
import com.spoid.dto.MemberDTO;

public class MemberPlayAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  request.setCharacterEncoding("UTF-8");
		  
		  String id = request.getParameter("inputid");
		  String pw = request.getParameter("inputpw");
		  String rpw = request.getParameter("inputrpw");
		  String nick = request.getParameter("inputnick");
		  String email = request.getParameter("inputemail");
		  String hint1 = "1";
		  String hint2 = "1";
		  /*String email = request.getParameter("email")+"@"+request.getParameter("email_url");*/
		  MemberDAO mDao = MemberDAO.getInstance();
		  MemberDTO mDto = new MemberDTO(id, pw, rpw, nick, email, hint1, hint2);
		  System.out.println("action단에서 이동!!!!!!!!!"+mDto.toString());
		  
		  int result = mDao.insertMember(mDto);
		  
		  System.out.println("회원가입 여부 : "+result);
		  
		  if(result>0) {
			  System.out.println("회원가입 성공");
		  }else {
			  System.out.println("회원가입 실패");
		  }
		  
		
		  List<MemberDTO> memberList = mDao.selectMember(id);
		  request.setAttribute("memberList", memberList);
		  
		return null;
	}

}
