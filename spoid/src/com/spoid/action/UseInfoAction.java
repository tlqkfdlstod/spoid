package com.spoid.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UseInfoAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse) throws ServletException, IOException {
		String url = "use_information.jsp";
		// 이용약관 페이지이동
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		return forward;
	}

}
