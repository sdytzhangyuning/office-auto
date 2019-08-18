<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
	<head>
		<title>高级链接</title>
		<link href="images/tree2style.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<div id="leftTree">
			<ul>	
				<li><a href="empAction_empDet.action?empId=${emp.empId }">info</a></li>
				<li><a href="PKaoQinSearch.jsp">query</a></li>			
				<li><a href="salaryAction_findSalList.action">salary list</a></li>	
				<li><a href="holsAction_addHolsUI.action">apply for leave</a></li>
				<li><a href="holsAction_findHolsPageList.action">vacation query</a></li>
				<li><a href="ChangePwd.jsp">change password</a></li>
			</ul>
		</div>
	</body>
</html>