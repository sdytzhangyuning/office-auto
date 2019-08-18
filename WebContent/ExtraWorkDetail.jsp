<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>ExtraWorkDetail.jsp</title>
		<link href="images/style.css" rel="stylesheet" type="text/css"/>
		<link href="images/editdepartstyle.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<div id="contain">
		<s:form theme="simple">
		<table>
			<caption>more info</caption>
			<tr>
				<td class="tdtitle">no</td>
				<td class="tddata"><s:property value="extrawork.employeeinfo.empId"/></td>
				<td class="tdtitle">name</td>
				<td class="tddata"><s:property value="extrawork.employeeinfo.empName"/></td>
			</tr>
			<tr>
				<td class="tdtitle">dep</td>
				<td class="tddata"><s:property value="extrawork.employeeinfo.departmentinfo.departName"/></td>
				<td  class="tdtitle">date</td>
				<td class="tddata"><s:property value="extrawork.workTime"/></td>
			</tr>
		</table>
		<fieldset>
			<legend>reason</legend>
			<s:property value="extrawork.executes"/>
		</fieldset><br>
		</s:form>
	</div>
	</body>
</html>