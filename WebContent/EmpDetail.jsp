<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>info</title>
		<link href="images/style.css" rel="stylesheet" type="text/css"/>
		<link href="images/impdetail.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="images/manage.js"></script>
	</head>
	<body>
	<div id="container1">
		<div id="infohead"><s:property value="emp.empName"/>info</div>
		<div id="pic">
			<div style="height:175;width:200px;">
			<img id="personpic" src="<s:property value="emp.empPic"/>" onload="changePic('personpic');">
			</div>
			
			<span><s:property value="emp.empName"/>photo</span>
		</div>
	
		<div id="info">
			<table>
				<tr class="evenrow">
					<td>no：</td>
					<td><s:property value="emp.empId"/></td>
				</tr>
				<tr class="oddrow">
					<td>name：</td>
					<td><s:property value="emp.empName"/></td>
				</tr>
				<tr class="evenrow">
					<td>gender：</td>
					<td><s:property value="emp.empSex"/></td>
				</tr>
				<tr class="oddrow">
					<td>date of birth：</td>
					<td><s:property value="emp.empBirth"/></td>
				</tr>
				<tr class="evenrow">
					<td>email：</td>
					<td><s:property value="emp.empEmail"/></td>
				</tr>
				<tr class="oddrow">
				 	<td>phone：</td>
					<td><s:property value="emp.empTel"/></td>
				</tr>
				<tr class="evenrow">
					<td>dep：</td>
					<td><s:property value="emp.departmentinfo.departName"/></td>
				</tr>
				<tr class="oddrow">
					<td>work：</td>
					<td><s:property value="emp.empRoll"/></td>
				</tr>
				<tr class="evenrow">
					<td>salary：</td>
					<td><s:property value="emp.empSalary"/></td>
				</tr>
			</table>
		</div>
		<div style="clear:both;"></div>
		<div id="jianli">
			<fieldset>
				<legend>resume</legend>
				
				<p><s:property value="emp.empBio"/></p>
			</fieldset>
		</div>
	</div>
	</body>
</html>