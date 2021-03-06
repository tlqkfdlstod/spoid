package com.spoid.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spoid.action.Action;
import com.spoid.action.ActionForward;
import com.spoid.action.AllMovieAction;
import com.spoid.action.BoardDeleteAction;
import com.spoid.action.BoardDetailAction;
import com.spoid.action.BoardInsertAction;
import com.spoid.action.BoardInsertPlayAction;
import com.spoid.action.BoardListAction;
import com.spoid.action.BoardLocationAction;
import com.spoid.action.BoardSearchAction;
import com.spoid.action.BoardUpdateAction;
import com.spoid.action.BoardUpdatePlayAction;
import com.spoid.action.BoardViewCntAction;
import com.spoid.action.BoxOfficeAction;
import com.spoid.action.CommentDeletePlayAction;
import com.spoid.action.CommentInsertAction;
import com.spoid.action.CommentListAction;
import com.spoid.action.CommentUpdateAction;
import com.spoid.action.ConstractAction;
import com.spoid.action.DeleteAction;
import com.spoid.action.DetailMovieAction;
import com.spoid.action.GoodCntUpdateAction;
import com.spoid.action.IdCheckAction;
import com.spoid.action.IdPwFindAction;
import com.spoid.action.IdPwFindPageAction;
import com.spoid.action.IndexAction;
import com.spoid.action.LoginAction;
import com.spoid.action.LoginOutPlayAction;
import com.spoid.action.LoginPlayAction;
import com.spoid.action.MemberDeletePlayAction;
import com.spoid.action.MemberHintPlayAction;
import com.spoid.action.MemberPageAtcion;
import com.spoid.action.MemberPlayAction;
import com.spoid.action.MemberUpdateAction;
import com.spoid.action.MemberUpdatePlayAction;
import com.spoid.action.NowMovieAction;
import com.spoid.action.PersonalInfoAction;
import com.spoid.action.PwCheckAction;
import com.spoid.action.QnaPageAction;
import com.spoid.action.QnaPlayAction;
import com.spoid.action.SearchMovieAction;
import com.spoid.action.TeamInfoAction;
import com.spoid.action.UseInfoAction;

/**
 * Servlet implementation class spoidFrontController
 */
@WebServlet("/spoidFrontController")
public class SpoidController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException
	{
	  response.setCharacterEncoding("UTF-8");
	  
	  Action action = null;
	  ActionForward forward = null;
	  
	  String uri = request.getRequestURI();
	  String ctx = request.getContextPath();
	  // uri - ctx = 내가 원하는 Action 경로
	  String command = uri.substring(ctx.length());
	  
	  System.out.println("url : " + uri);
	  System.out.println("ctx : " + ctx);
	  System.out.println("??====>" + command);
	  try {
	  if (command.equals("/index.spoid")){ // 인덱스
	    action = new IndexAction();
	    forward = action.excute(request, response);
	  }else if (command.equals("/login.spoid")){ // 로그인페이지 이동
	    action = new LoginAction();
	  
			forward = action.excute(request, response);
	
	  }else if(command.equals("/memberplayaction.spoid")) { // 회원가입기능
		  action = new MemberPlayAction();
		   forward = action.excute(request, response);		  
	  }else if(command.equals("/loginOut.spoid")) { // 로그아웃
		  action = new LoginOutPlayAction();
		  forward = action.excute(request,response);
	  }else if(command.equals("/memberupdate.spoid")) { // 회원수정페이지 이동
		  action = new MemberUpdateAction();
		  forward = action.excute(request, response);
	  }else if(command.equals("/memberupdateplay.spoid")) { // 회원수정 기능
		  action = new MemberUpdatePlayAction();
		  forward = action.excute(request, response);		  
	  }else if(command.equals("/idCheck.spoid")) { // 아이디체크(중복방지)
		  action = new IdCheckAction();
		  forward = action.excute(request, response);
	  }else if(command.equals("/pwdCheck.spoid")) {  // 비밀번호 체크
		  action = new PwCheckAction();
		  forward = action.excute(request, response);		  
	  }else if(command.equals("/memberpage.spoid")) { // 회원가입 페이지 이동
		  action = new MemberPageAtcion();
		  forward = action.excute(request, response);
	  }else if(command.equals("/memberDelete.spoid")) { // 회원탈퇴 페이지 이동
		  action = new DeleteAction();
		  forward = action.excute(request, response);
	  }else if(command.equals("/memdeleteplayaction.spoid")) { // 회원탈퇴
		  action = new MemberDeletePlayAction();
		  forward = action.excute(request, response);
	  }else if(command.equals("/memberhintplay.spoid")) { // 회원가입시 힌트입력
		  action = new MemberHintPlayAction();
		  forward = action.excute(request, response);
	  }else if(command.equals("/LoginPlay.spoid")) { // 로그인 기능
		  action = new LoginPlayAction();
		  forward = action.excute(request, response);
	  }else if(command.equals("/boardList.spoid")) {
		  action = new BoardListAction();
		  forward = action.excute(request, response);
	  }else if(command.equals("/boardSearch.spoid")) {
		  action = new BoardSearchAction();
		  forward = action.excute(request, response);		  
	  }else if(command.equals("/boardDetail.spoid")) {
		  action = new BoardDetailAction();
		  forward = action.excute(request, response);		  
	  }else if(command.equals("/boardviewcnt.spoid")) {
		  action = new BoardViewCntAction();
		  forward = action.excute(request, response);
	  }else if(command.equals("/boardInsert.spoid")) {
		  action = new BoardInsertAction();
		  forward = action.excute(request, response);
	  }else if(command.equals("/boardInsertPlay.spoid")) {
		  action = new BoardInsertPlayAction();
		  forward = action.excute(request, response);
	  }else if(command.equals("/boarddownload.spoid")) {
		  action = new BoardLocationAction();
		  forward = action.excute(request, response);		  
	  }else if(command.equals("/boardUpdate.spoid")) {
		  action = new BoardUpdateAction();
		  forward = action.excute(request, response);
	  }else if(command.equals("/boardupdateplay.spoid")) {
		  action = new BoardUpdatePlayAction();
		  forward = action.excute(request, response);
	  }else if(command.equals("/boarddeleteplay.spoid")) {
		  action = new BoardDeleteAction();
		  forward = action.excute(request, response);		  
	  }else if(command.equals("/commentlist.spoid")) {
		  action = new CommentListAction();
		  forward = action.excute(request, response);
	  }else if(command.equals("/commentdeleteplay.spoid")) {
		  action = new CommentDeletePlayAction();
		  forward = action.excute(request, response);
	  }else if(command.equals("/commentInsert.spoid")) {
		  action = new CommentInsertAction();
		  forward = action.excute(request, response);
	  }else if(command.equals("/commentUpdate.spoid")) {
		  action = new CommentUpdateAction();
		  forward = action.excute(request, response);		  
	  }else if(command.equals("/updateGoodcnt.spoid")) {
		  action = new GoodCntUpdateAction();
		  forward = action.excute(request, response);		 		  
	  }else if(command.equals("/teaminfo.spoid")) { // 팀소개 페이지 이동
		  action = new TeamInfoAction();
		  forward = action.excute(request, response);		 		  
	  }else if(command.equals("/useinfo.spoid")) { // 이용약관 페이지 이동
		action = new UseInfoAction();
		forward = action.excute(request, response);		 		  
	  }else if(command.equals("/personalinfo.spoid")) { // 이용약관 페이지 이동
		action = new PersonalInfoAction();
		forward = action.excute(request, response);		 		  
	  }else if(command.equals("/qnapage.spoid")) { // 고객관리센터 이동
		action = new QnaPageAction();
		forward = action.excute(request, response);		 		  
	  }else if(command.equals("/qnaplay.spoid")) { // 1:1 문의 play Action단
		action = new QnaPlayAction();
		forward = action.excute(request, response);		 		  
	  }else if(command.equals("/IdPwFind.spoid")) { // ID/PW 찾기
		action = new IdPwFindAction();
		forward = action.excute(request, response);		 		
	  }else if(command.equals("/IdPwFindPage.spoid")) { // ID/PW 찾기 페이지 이동
		action = new IdPwFindPageAction();
		forward = action.excute(request, response);		 		
	  }else if(command.equals("/boxoffice.spoid")) { // 박스오피스 페이지 이동
		action = new BoxOfficeAction();
		forward = action.excute(request, response);		 		
	  }else if(command.equals("/nowmovie.spoid")) { // 현상영작 페이지 이동
		  action = new NowMovieAction();
		  forward = action.excute(request, response);		 		
	  }else if(command.equals("/allmovie.spoid")) { // 모든 영화 페이지 이동
		  action = new AllMovieAction();
		  forward = action.excute(request, response);		 		
	  }else if(command.equals("/detailmovie.spoid")) {
		  action = new DetailMovieAction();
		  forward = action.excute(request,response);
	  }else if(command.equals("/searchmovie.spoid")) {
		  action = new SearchMovieAction();
		  forward = action.excute(request, response);
		  
	  }
	} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	  
	  
	  if (forward != null) {
	    if (forward.isRedirect()){
	      response.sendRedirect(forward.getPath());
	    }
	    else{
	      RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
	      rd.forward(request, response);
	    }
	  }
	  
	  
	}
}

