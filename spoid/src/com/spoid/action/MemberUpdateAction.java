package com.spoid.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberUpdateAction implements Action{
	public ActionForward excute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "member_update.jsp";
		//회원정보 수정 선행 조건
		// 로그인이 되있어야힘
		// session 이 null 이 아니면 로그인
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null) { //로그인 안됨
			url = "index.spoid";
		}else {
			url = "member_update.jsp";
		}
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		return forward;
	}
}
