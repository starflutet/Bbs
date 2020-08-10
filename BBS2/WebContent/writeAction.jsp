<%@page import="bbs.BbsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bbs.BbsDAO"%>
<%@ page import ="java.io.PrintWriter" %>

<%
	request.setCharacterEncoding("UTF-8");
	
	String userID=null;

	int bbsAvaliable=0;
	if(session.getAttribute("userID")!=null){
		userID = (String) session.getAttribute("userID");
	}
	if(userID == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 하세요.');");
		script.println("location.href = 'login.jsp';");
		script.println("</script>");
		script.close();
		return;		
	}
	String bbsTitle = null;
	String bbsContent = null;
	if(request.getParameter("bbsTitle")!=null){
		bbsTitle = request.getParameter("bbsTitle");
	}
	if(request.getParameter("bbsContent")!=null){
		bbsContent = request.getParameter("bbsContent");
	}
	if(bbsTitle.equals("")|| bbsContent.equals("")){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안 된 사항이 있습니다');");
		script.println("history.back();");
		script.println("</script>");
		script.close();			
		return;
	} else{
		BbsDAO bbsDAO = new BbsDAO();
		BbsDTO bbsDTO = new BbsDTO();
		int result = bbsDAO.write(new BbsDTO(bbsTitle,userID,bbsContent));
		if(result == -1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('게시글 등록에 실패했습니다.');");
			script.println("history.back();");
			script.println("</script>");
			script.close();	
			return;
		}else{
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'bbs.jsp'");
			script.println("</script>");
			script.close();
			return;		
		}
	}
	
%>