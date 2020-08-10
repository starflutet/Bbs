<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.UserDTO"%>
<%@ page import="user.UserDAO"%>
<%@ page import ="java.io.PrintWriter" %>
<%
	request.setCharacterEncoding("UTF-8");
	String userID=null;
	String userPassword = null;
	String userName = null;
	String userGender=null;
	String userEmail=null;
	if(request.getParameter("userID")!=null){
		userID = request.getParameter("userID");
	}
	if(request.getParameter("userPassword")!=null){
		userPassword = request.getParameter("userPassword");
	}
	if(request.getParameter("userName")!=null){
		userName = request.getParameter("userName");
	}
	if(request.getParameter("userGender")!=null){
		userGender = request.getParameter("userGender");
	}
	if(request.getParameter("userEmail")!=null){
		userEmail = request.getParameter("userEmail");
	}
	if(userID.equals("") || userPassword.equals("")|| userName.equals("")|| userEmail.equals("")||userGender.equals("")){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안 된 사항이 있습니다');");
		script.println("history.back();");
		script.println("</script>");
		script.close();			
		return;
	} else{
		UserDAO userDAO = new UserDAO();
		int result = userDAO.join(new UserDTO(userID, userPassword,userName,userGender,userEmail ));
		if(result==-1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 존재하는아이디입니다.')");
			script.println("history.back()");
			script.println("</script>");
			script.close();	
		}
		else{
			session.setAttribute("userID",userID);
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href='main.jsp'");
			script.println("</script>");
			script.close();	
		}
	}
%>