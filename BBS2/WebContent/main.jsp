<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel = "stylesheet" href="css/bootstrap.css">
<link rel = "stylesheet" href="css/custom.css">

<title>JSP 게시판 웹 사이트</title>
<style>
	.thumbnail{
		width : "100px";
		height : "100px";
	}
	
</style>
</head>
<body>
	<%
		String userID = null;
		if(session.getAttribute("userID")!=null){
			userID = (String)session.getAttribute("userID");
		}
	%>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type = "button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class = "icon-bar"></span>
				<span class = "icon-bar"></span>
				<span class = "icon-bar"></span>
			</button>			
			<a class="navbar-brand"	href="index.jsp">JSP 게시판 웹 사이트</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="main.jsp">메인</a>
				<li><a href="bbs.jsp">게시판</a>
				<li><a href="bbs.jsp">개선생 강의평가</a>
			</ul>
			<%
				if(userID==null){
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="ture"
						aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a>
					</ul>
				</li>
			</ul>
			<%
				} else{
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="ture"
						aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul>
				</li>
			</ul>
			<%
				}
			%>
		</div>
	</nav>
	<div class="jumbotron">
  	<h1>메인페이지 디자인 하기</h1>
  	<p>부트스트랩 에있는 점보트론으로 만들어본 설명창!! jsp와 mySql데이터 베이스를 이용하여 게시판을 제작했어요!!</p>
  	<p><a class="btn btn-primary btn-lg" href="bbs.jsp" role="button">게시판 으로 가기</a></p>
	</div>
	<div class="container">
		<div class="row">
  			<div class="col-sm-6 col-md-4">
    			<div class="thumbnail">
			      <img src="images/vori.jpg" alt="vori">
			      <div class="caption">
			        <h3>보리</h3>
			        <p>보리짱장</p>
			        <p><a href="https://www.naver.com" class="btn btn-default" role="button">짱보리</a></p>
			      </div>
				</div>
			</div>
			<div class="col-sm-6 col-md-4">
    			<div class="thumbnail">
			      <img src="images/naver.png" alt="naver">
			      <div class="caption">
			        <h3>네이버</h3>
			        <p>네이버</p>
			        <p><a href="https://www.naver.com" class="btn btn-default" role="button">네이버</a></p>
			      </div>
				</div>
			</div>
			<div class="col-sm-6 col-md-4">
    			<div class="thumbnail">
			      <img src="images/vori.jpg" alt="vori">
			      <div class="caption">
			        <h3>보리</h3>
			        <p>보리짱장</p>
			        <p><a href="https://www.naver.com" class="btn btn-default" role="button">짱보리</a></p>
			      </div>
				</div>
			</div>
		</div>
	</div>
	
	
	<script src = "https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src = "js/bootstrap.js"></script>	
</body>
</html>