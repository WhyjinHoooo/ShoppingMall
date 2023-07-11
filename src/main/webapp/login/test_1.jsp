<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
 
	ul {
		list-style-type: none;
		background-color: #ccc;
		width: 25%;
		padding: 0;
		margin:  0;
		position: fixed;
		height: 100%;
		overflow: auto;
	}
 
	li a {
		text-decoration: none;
		display: block;
		color: #000;
		padding: 8px 15px 8px 15px;
		font-weight: bold;
	}
 
	li a.job {
		background-color: tomato;
		color: #fff;
	}
 
	li a:hover:not(.job) {
		background-color: #333;
		color: #fff;
	}
 
</style>
</head>
<body>
<ul>
	<li><a class="job" href="#">직업</a></li>
	<li><a href="#">패스파인더</a></li>
	<li><a href="#">아델</a></li>
	<li><a href="#">호영</a></li>
	<li><a href="#">히어로</a></li>
</ul>
 
<div style="margin-left:25%;padding:1px 16px;height:1000px;">
  <h2>왼쪽 사이드바 메뉴를 특정 위치에 고정합니다.</h2>
  <h3>position : fixed; 태그를 사용합니다.</h3>
  <p>overflow: auto; 를 사용하여 영역을 벗어나는 부분의 스크롤 유뮤를 자동으로 합니다.</p>
  <p>화면을 스크롤해보면 왼쪽 메뉴바는 그대로 있고 오른쪽 내용만 스크롤됩니다.</p>
  <p>....</p>
  <p>....</p>
  <p>....</p>
  <p>....</p>
  <p>....</p>
 
</div>
</body>
</html>