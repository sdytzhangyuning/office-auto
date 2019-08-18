<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head><meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
		<title><s:text name="mainmanage.title"/></title>
		<link href="images/style.css" rel="stylesheet" type="text/css"/>
		<link href="images/qingjiadetail.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
	<div id="container">
		<table>
			<caption>leave info</caption>
			<tr>
				<td>no:</td>
				<td><s:property value="holsinfo.impId"/></td>
				<td>name:</td>
				<td><s:property value="holsinfo.impName"/></td>
			</tr>
			<tr>
				<td>apply date:</td>
				<td><s:property value="holsinfo.applyTime"/></td>
				<td>number of days:</td>
				<td><s:property value="holsinfo.holdays"/></td>
			</tr>
			<tr>
				<td>start date:</td>
				<td><s:property value="holsinfo.startTime"/></td>
				<td>end date:</td>
				<td><s:property value="holsinfo.endTime"/></td>
			</tr>
		</table>
		<fieldset>
			<legend>reason:</legend>
			<p><s:property value="holsinfo.executes"/></p>
		</fieldset>
	</div>
	</body>
</html>