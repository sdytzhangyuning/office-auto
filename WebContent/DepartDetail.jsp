<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>dep info</title>
		<link href="images/style.css" rel="stylesheet" type="text/css"/>
		<link href="images/departDetail.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
	<div id="contain">
		<table>
			<caption>dep info</caption>
			<tr>
				<td class="tdtitle">dep no</td>
				<td class="tddata"><s:property value="department.departId"/></td>
				<td class="tdtitle">dep name</td>
				
				<td class="tddata"><s:property value="department.departName"/></td>
			</tr>
			<tr>
				<td class="tdtitle">count</td>
				<td class="tddata"><a href="departImp.action?departId=<s:property value="departId"/>" target="_blank" alt="点击查看详细职工信息"><s:property value="department.departNum"/></a></td>
				<td  class="tdtitle"></td>
				<td class="tddata"></td>
			</tr>
		</table>
		<fieldset>
			<legend>desc</legend>
			<p><s:property value="department.departDescrip"/></p>
		</fieldset>
	</div>
	</body>
</html>