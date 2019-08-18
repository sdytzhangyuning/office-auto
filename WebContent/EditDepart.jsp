<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>EditDepart.jsp</title>
<link href="images/style.css" rel="stylesheet" type="text/css" />
<link href="images/editdepartstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="images/manage.js"></script>
</head>
<body>
	<div id="contain">
		<s:form onsubmit="return editdepartcheck();" theme="simple" action="departAction_updateDep.action" method="post">
			<table>
				<caption>dep info</caption>
				<tr>
					<td class="tdtitle">dep no</td>
					<td class="tddata"><s:property value="depart.departId" /></td>
					<td class="tdtitle">dep name</td>
					<td><s:textfield name="depart.departName" id="departName" value="%{depart.departName }" /></td>
				</tr>
				<tr>
					<td class="tdtitle">count</td>
					<td class="tddata"><s:textfield name="depart.departNum" id="departName" value="%{depart.departNum }" /></td>
					<td class="tdtitle"></td>
					<td class="tddata"></td>
				</tr>
			</table>
			<fieldset>
				<legend>desc</legend>
				<s:textarea name="depart.departDesc" value="%{depart.departDesc}" cols="80" rows="19" id="departDescrip"></s:textarea>
			</fieldset>
			<br>
			<s:submit value="save" />
		</s:form>
	</div>
	<s:if test="(read==false)">
		<script type="text/javascript">
			window.onload = alertResult;

			function alertResult() {
				alert("<s:property value="result"/>");
			}
		</script>
	</s:if>
</body>
</html>